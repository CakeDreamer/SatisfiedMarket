package club.sjmc.satisfiedmarket.blocks.MarketBlockUtils;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public class NonOPStock extends Stock {
    public int available;

    public NonOPStock(ItemStack itemStack, ItemStack exchangeItem[], MarketBlockTileEntity marketBlockTileEntity){
        super(itemStack, exchangeItem, marketBlockTileEntity);
        available = 0;
    }

    public boolean supply(ItemStack supplement) {
        if (supplement.isItemEqual(this.singleItemStack)) {
            available += supplement.getCount();
            supplement.setCount(0);
            return true;
        }
        return false;
    }

    public boolean purchase(PlayerEntity buyer, ItemStack exchanges[]){
        if(super.purchase(buyer, exchanges)) {
            available--;
        } else {
            return false;
        }
        return true;
    }
}
