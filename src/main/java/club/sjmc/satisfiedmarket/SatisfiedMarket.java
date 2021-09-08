package club.sjmc.satisfiedmarket;

import club.sjmc.satisfiedmarket.blocks.BlockRegistry;
import club.sjmc.satisfiedmarket.blocks.TileEntityTypeRegistry;
import club.sjmc.satisfiedmarket.items.ItemRegistry;
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
