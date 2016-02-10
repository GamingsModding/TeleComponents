package com.gamingsmod.telecomponents.client.gui.inventory;

import com.gamingsmod.telecomponents.common.gui.container.ContainerTeleBlock;
import com.gamingsmod.telecomponents.common.tileentity.TileEntityTeleBlock;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiTeleBlock extends GuiContainer
{
    private IInventory playerInv;
    private TileEntityTeleBlock te;

    public GuiTeleBlock(IInventory player, TileEntityTeleBlock te)
    {
        super(new ContainerTeleBlock(player, te));

        this.playerInv = player;
        this.te = te;
        this.xSize = 176;
        this.ySize = 166;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        this.mc.getTextureManager().bindTexture(new ResourceLocation("telecomponents:textures/gui/teleBlock.png"));
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
    }

    // Code adapted from BedrockMiner
    // @source http://bedrockminer.jimdo.com/modding-tutorials/advanced-modding/tile-entity-with-inventory-and-gui/
    @Override
    protected void drawGuiContainerForegroundLayer(int mousex, int mousey)
    {
        String s = this.te.getDisplayName().getUnformattedText();
        this.fontRendererObj.drawString(s, 88 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);            //#404040
        this.fontRendererObj.drawString("Inventory", 8, 72, 4210752);      //#404040
    }
}
