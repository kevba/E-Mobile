package tonius.emobile.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import tonius.emobile.item.ItemCellphone;
import cpw.mods.fml.common.network.IGuiHandler;

public class EMGuiHandler implements IGuiHandler {
    
    public static final int CELLPHONE = 0;
    
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
        case CELLPHONE:
            ItemStack cellphone = player.getCurrentEquippedItem();
            if (cellphone != null && cellphone.getItem() instanceof ItemCellphone) {
                return new ContainerCellphone(new InventoryCellphone(cellphone), player.inventory);
            }
        }
        return null;
    }
    
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
        case CELLPHONE:
            ItemStack cellphone = player.getCurrentEquippedItem();
            if (cellphone != null && cellphone.getItem() instanceof ItemCellphone) {
                return new GuiCellphone(new ContainerCellphone(new InventoryCellphone(cellphone), player.inventory));
            }
        }
        return null;
    }
    
}