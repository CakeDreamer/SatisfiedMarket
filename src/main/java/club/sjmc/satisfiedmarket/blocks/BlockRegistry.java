package club.sjmc.satisfiedmarket.blocks;

import club.sjmc.satisfiedmarket.Utils;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.block.Block;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Utils.MOD_ID);
    public static final RegistryObject<Block> marketBlock = BLOCKS.register("market_block", MarketBlock::new);
    //public static final RegistryObject<Block> opMarketBlock = BLOCKS.register("op_market_block", OpMarketBlock::new);
}
