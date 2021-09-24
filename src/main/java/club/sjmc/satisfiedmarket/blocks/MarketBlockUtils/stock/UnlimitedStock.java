package club.sjmc.satisfiedmarket.blocks.MarketBlockUtils.stock;

import club.sjmc.satisfiedmarket.blocks.MarketBlockUtils.MarketBlockTileEntity;
import club.sjmc.satisfiedmarket.blocks.MarketBlockUtils.stock.Stock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public class UnlimitedStock extends Stock {

    public UnlimitedStock(ItemStack itemStack, PlayerEntity owner, ItemStack[] exchangeItem, MarketBlockTileEntity marketBlockTileEntity) {
        super(itemStack, owner, exchangeItem, marketBlockTileEntity);
    }

    public int getAvailable(){
        return -1;
    }

}
