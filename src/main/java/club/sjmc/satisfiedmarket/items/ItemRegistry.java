package club.sjmc.satisfiedmarket.items;

import club.sjmc.satisfiedmarket.Utils;
import club.sjmc.satisfiedmarket.blocks.BlockRegistry;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.RegistryObject;
import net.minecraft.item.ItemGroup;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Utils.MOD_ID);
    public static final RegistryObject<Item> marketBlock = ITEMS.register("market_block", () -> new BlockItem(BlockRegistry.marketBlock.get(), new Item.Properties().group(ItemGroup.MISC)));
    //public static final RegistryObject<Item> opMarketBlock = ITEMS.register("op_market_block", () -> new BlockItem(BlockRegistry.opMarketBlock.get(), new Item.Properties().group(ItemGroup.MISC)));
}
