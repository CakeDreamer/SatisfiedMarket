package club.sjmc.satisfiedmarket.blocks.MarketBlockUtils.stock;

import club.sjmc.satisfiedmarket.blocks.MarketBlockUtils.MarketBlockTileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public class LimitedStock extends Stock {
    private int available;

    public LimitedStock(ItemStack itemStack, PlayerEntity owner, ItemStack exchangeItem[], MarketBlockTileEntity marketBlockTileEntity){
        super(itemStack, owner, exchangeItem, marketBlockTileEntity);
        available = 0;
    }

    public LimitedStock(Stock savedStock, MarketBlockTileEntity marketBlockTileEntity){
        super(savedStock, marketBlockTileEntity);
        available = 0;
    }

    /**
     * To supply an existing limited stock.
     * TODO: maybe changing return type to enum or else is better to handle exceptions.
     * @param player
     * @param supplement
     * @return
     */
    public boolean supply(PlayerEntity player, ItemStack supplement) {
        if (player.isEntityEqual(owner)) {
            if (supplement.isItemEqual(this.singleItemStack)) {
                available += supplement.getCount();
                supplement.setCount(0);
                return true;
            }
        }
        return false;
    }

    public int getAvailable() {
        return available;
    }

    public boolean canBuy(PlayerEntity buyer, ItemStack exchanges[]){
        if(super.canBuy(buyer, exchanges)) {
            available--;
        } else {
            return false;
        }
        return true;
    }

}
