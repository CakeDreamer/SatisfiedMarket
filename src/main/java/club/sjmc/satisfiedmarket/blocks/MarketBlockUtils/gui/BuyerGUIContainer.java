package club.sjmc.satisfiedmarket.blocks.MarketBlockUtils.gui;

import club.sjmc.satisfiedmarket.blocks.ContainerTypeRegistry;
import club.sjmc.satisfiedmarket.blocks.MarketBlockUtils.MarketBlockTileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Buyer GUI Container.
 * TODO
 */
public class BuyerGUIContainer extends Container {
    public BuyerGUIContainer(int id, PlayerInventory playerInventory, BlockPos pos, World world) {
        super(ContainerTypeRegistry.marketBlockGUIContainer.get(), id);
        //this.intArray = intArray;
        //trackIntArray(this.intArray);
        MarketBlockTileEntity marketBlockTileEntity = (MarketBlockTileEntity) world.getTileEntity(pos);
        //this.addSlot(new Slot(marketBlockTileEntity.getInventory(), 0, 80, 32));
        //this.addSlot(new Slot(marketBlockTileEntity.getInventory(), 1, 81, 32));
        //this.addSlot(new Slot(marketBlockTileEntity.getInventory(), 2, 82, 32));
        layoutPlayerInventorySlots(playerInventory, 8, 84);
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return true;
    }

    @Override
    public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
        return ItemStack.EMPTY;
    }

    private int addSlotRange(IInventory inventory, int index, int x, int y, int amount, int dx) {
        for (int i = 0; i < amount; i++) {
            addSlot(new Slot(inventory, index, x, y));
            x += dx;
            index++;
        }
        return index;
    }

    private int addSlotBox(IInventory inventory, int index, int x, int y, int horAmount, int dx, int verAmount, int dy) {
        for (int j = 0; j < verAmount; j++) {
            index = addSlotRange(inventory, index, x, y, horAmount, dx);
            y += dy;
        }
        return index;
    }

    private void layoutPlayerInventorySlots(IInventory inventory, int leftCol, int topRow) {
        // Player inventory
        addSlotBox(inventory, 9, leftCol, topRow, 9, 18, 3, 18);

        // Hotbar
        topRow += 58;
        addSlotRange(inventory, 0, leftCol, topRow, 9, 18);
    }
}
