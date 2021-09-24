package club.sjmc.satisfiedmarket.blocks.MarketBlockUtils.gui;

import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.IContainerListener;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

/**
 * Buyer GUI container listener.
 * TODO
 */
public class BuyerIContainerListener implements IContainerListener {

    @Override
    public void sendAllContents(Container containerToSend, NonNullList<ItemStack> itemsList) {

    }

    @Override
    public void sendSlotContents(Container containerToSend, int slotInd, ItemStack stack) {
        containerToSend.getInventory().get(0);
    }

    @Override
    public void sendWindowProperty(Container containerIn, int varToUpdate, int newValue) {

    }
}
