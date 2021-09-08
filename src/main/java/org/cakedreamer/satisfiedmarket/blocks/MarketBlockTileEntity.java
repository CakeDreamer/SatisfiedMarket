package org.cakedreamer.satisfiedmarket.blocks;

import org.cakedreamer.satisfiedmarket.blocks.MarketBlockUtils.Stock;
import net.minecraft.tileentity.TileEntity;

enum MarketType{
    LIMITED_PER_PLAYER,
    LIMITED_AMOUNT,
    UNLIMITED,
    NEEDS_SUPPLY
}

public class MarketBlockTileEntity extends TileEntity {
    public Stock goods[];


    public MarketBlockTileEntity() {
        super(TileEntityTypeRegistry.marketBlockTileEntity.get());
    }

}
