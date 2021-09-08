package org.cakedreamer.satisfiedmarket;

import org.cakedreamer.satisfiedmarket.blocks.BlockRegistry;
import org.cakedreamer.satisfiedmarket.blocks.TileEntityTypeRegistry;
import org.cakedreamer.satisfiedmarket.items.ItemRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Utils.MOD_ID)
public class SatisfiedMarket {
    public SatisfiedMarket() {
        ItemRegistry.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BlockRegistry.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        TileEntityTypeRegistry.TILE_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
