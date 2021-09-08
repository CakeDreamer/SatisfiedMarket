package org.cakedreamer.satisfiedmarket.blocks.MarketBlockUtils;

import org.cakedreamer.satisfiedmarket.blocks.MarketBlock;
import org.cakedreamer.satisfiedmarket.blocks.MarketBlockTileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public class NonOPStock extends Stock {
    public int available;

    public NonOPStock(ItemStack itemStack, ItemStack exchangeItem[], MarketBlockTileEntity marketBlockTileEntity){
        super(itemStack, exchangeItem, marketBlockTileEntity);
        available = 0;
    }

    public boolean supply() {
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
