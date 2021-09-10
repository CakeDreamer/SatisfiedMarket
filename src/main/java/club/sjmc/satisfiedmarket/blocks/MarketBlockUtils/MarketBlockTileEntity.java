package club.sjmc.satisfiedmarket.blocks.MarketBlockUtils;

import club.sjmc.satisfiedmarket.Utils;
import club.sjmc.satisfiedmarket.blocks.MarketBlockUtils.MarketBlockGUIContainer;
import club.sjmc.satisfiedmarket.blocks.MarketBlockUtils.Stock;
import club.sjmc.satisfiedmarket.blocks.TileEntityTypeRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import javax.annotation.Nullable;

enum MarketType{
    LIMITED_PER_PLAYER,
    LIMITED_AMOUNT,
    UNLIMITED,
    NEEDS_SUPPLY
}

public class MarketBlockTileEntity extends TileEntity implements INamedContainerProvider
{
    public Stock goods[];
    private Inventory inventory = new Inventory(4);
    public int capacity;



    public MarketBlockTileEntity() {
        super(TileEntityTypeRegistry.marketBlockTileEntity.get());
    }

    @Override
    public ITextComponent getDisplayName() {
        return new TranslationTextComponent("gui." + Utils.MOD_ID + ".first_container");
    }

    @Nullable
    @Override
    public Container createMenu(int sycID, PlayerInventory inventory, PlayerEntity player) {
        return new MarketBlockGUIContainer(sycID, inventory, this.pos, this.world);
    }

    @Nullable
    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
        //return new SUpdateTileEntityPacket(pos, 1, getUpdateTag());
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
        //handleUpdateTag(world.getBlockState(pkt.getPos()), pkt.getNbtCompound());
    }

    public Inventory getInventory() {
        return inventory;
    }
}
