package club.sjmc.satisfiedmarket.blocks.MarketBlockUtils;

import club.sjmc.satisfiedmarket.blocks.ContainerTypeRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MarketBlockGUIContainer extends Container {
    public MarketBlockGUIContainer(int id, PlayerInventory playerInventory, BlockPos pos, World world) {
        super(ContainerTypeRegistry.marketBlockGUIContainer.get(), id);
        //this.intArray = intArray;
        //trackIntArray(this.intArray);
        MarketBlockTileEntity marketBlockTileEntity = (MarketBlockTileEntity) world.getTileEntity(pos);
        this.addSlot(new Slot(marketBlockTileEntity.getInventory(), 0, 80, 32));
        layoutPlayerInventorySlots(playerInventory, 8, 84);
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return true;
    }
}
