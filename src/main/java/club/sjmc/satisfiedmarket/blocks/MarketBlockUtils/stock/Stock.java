package club.sjmc.satisfiedmarket.blocks.MarketBlockUtils.stock;

import club.sjmc.satisfiedmarket.blocks.MarketBlockUtils.MarketBlockTileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;

/**
 * Abstract class for stocks.
 * A stock handles operations to a particular item.
 * A market block can have multiple stocks.
 */
public abstract class Stock {
    protected ItemStack singleItemStack;
    protected ItemStack[] price;
    protected MarketBlockTileEntity marketBlockTileEntity;
    protected PlayerEntity owner;
    protected Inventory revenue;

    /**
     * Creating a stock.
     * TODO: Need a function of editing existing stock.
     * @param itemStack The item to sell. NBT tags sensitive.
     * @param owner Owner.
     * @param exchangeItem Price.
     * @param marketBlockTileEntity The tile entity to which the stock belongs.
     */
    public Stock(ItemStack itemStack, PlayerEntity owner, ItemStack[] exchangeItem, MarketBlockTileEntity marketBlockTileEntity) {
        this.singleItemStack = itemStack.copy();
        this.price = exchangeItem;
        this.singleItemStack.setCount(1);
        this.marketBlockTileEntity = marketBlockTileEntity;
        this.owner = owner;
        this.revenue = new Inventory();
    }

    /**
     * Copy one saved stock to another.
     * @param savedStock Saved stock
     * @param marketBlockTileEntity Target MarkerBlock tile entity.
     */
    public Stock(Stock savedStock, MarketBlockTileEntity marketBlockTileEntity){
        this.singleItemStack = savedStock.singleItemStack.copy();
        this.price = savedStock.price;
        this.marketBlockTileEntity = marketBlockTileEntity;
    }

    /**
     * Returns whether a player can buy an item or not.
     * @param buyer Currently not used. Possibly will introduce additional permission control in the future.
     * @param exchanges A set of ItemStack containing the items to be exchanged.
     * @return Whether a player can buy an item or not
     */
    public boolean canBuy(PlayerEntity buyer, ItemStack exchanges[]) {
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

    //public abstract boolean supply(PlayerEntity player, ItemStack supplement);
    public abstract int getAvailable();
}
