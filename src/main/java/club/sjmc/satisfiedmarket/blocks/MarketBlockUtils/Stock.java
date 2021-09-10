package club.sjmc.satisfiedmarket.blocks.MarketBlockUtils;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public abstract class Stock {
    protected ItemStack singleItemStack;
    protected ItemStack[] price;
    protected MarketBlockTileEntity marketBlockTileEntity;

    public Stock(ItemStack itemStack, ItemStack[] exchangeItem, MarketBlockTileEntity marketBlockTileEntity) {
        this.singleItemStack = itemStack.copy();
        this.price = exchangeItem;
        this.singleItemStack.setCount(1);
        this.marketBlockTileEntity = marketBlockTileEntity;
    }

    public Stock(Stock savedStock, MarketBlockTileEntity marketBlockTileEntity){
        this.singleItemStack = savedStock.singleItemStack.copy();
        this.price = savedStock.price;
        this.marketBlockTileEntity = marketBlockTileEntity;
    }

    public boolean purchase(PlayerEntity buyer, ItemStack exchanges[]) {
        for (int i = 0; i < exchanges.length; ++i) {
            if (price[i].hasTag()){
                if (exchanges[i].isItemEqual(price[i]) && exchanges[i].getTag().equals(price[i].getTag())){
                    return false;
                }
            } else {
                if (!exchanges[i].isItemEqual(price[i])){
                    return false;
                }
            }
        }
        buyer.inventory.addItemStackToInventory(singleItemStack);
        return true;
    }

    public ItemStack getItem() {
        return singleItemStack;
    };

    public void setItem(ItemStack itemStack) {
        singleItemStack = itemStack;
    };

    public ItemStack[] getPrice() {
        return price;
    };

    public void setPrice(ItemStack[] newPrice) {
        price = newPrice;
    };

    public abstract boolean supply();
    public abstract int getAvailable();
}
