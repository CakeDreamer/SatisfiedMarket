package club.sjmc.satisfiedmarket.blocks.MarketBlockUtils;

import club.sjmc.satisfiedmarket.blocks.MarketBlockTileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public abstract class Stock {
    public ItemStack singleItemStack;
    public ItemStack[] exchangeItem;
    public MarketBlockTileEntity marketBlockTileEntity;

    public Stock(ItemStack itemStack, ItemStack[] exchangeItem, MarketBlockTileEntity marketBlockTileEntity) {
        this.singleItemStack = itemStack.copy();
        this.exchangeItem = exchangeItem;
        this.singleItemStack.setCount(1);
        this.marketBlockTileEntity = marketBlockTileEntity;
    }

    public Stock(Stock savedStock, MarketBlockTileEntity marketBlockTileEntity){
        this.singleItemStack = savedStock.singleItemStack.copy();
        this.exchangeItem = savedStock.exchangeItem;
        this.marketBlockTileEntity = marketBlockTileEntity;
    }

    public boolean purchase(PlayerEntity buyer, ItemStack exchanges[]) {
        for (int i = 0; i < exchanges.length; ++i) {
            if (exchangeItem[i].hasTag()){
                if (exchanges[i].isItemEqual(exchangeItem[i]) && exchanges[i].getTag().equals(exchangeItem[i].getTag())){
                    return false;
                }
            } else {
                if (!exchanges[i].isItemEqual(exchangeItem[i])){
                    return false;
                }
            }
        }
        buyer.inventory.addItemStackToInventory(singleItemStack);
        return true;
    }
}
