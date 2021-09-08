package club.sjmc.satisfiedmarket.blocks;

import club.sjmc.satisfiedmarket.Utils;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityTypeRegistry {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Utils.MOD_ID);
    public static final RegistryObject<TileEntityType<MarketBlockTileEntity>> marketBlockTileEntity = TILE_ENTITIES.register("obsidian_counter_tileentity", () -> TileEntityType.Builder.create(MarketBlockTileEntity::new, BlockRegistry.marketBlock.get()).build(null));
}