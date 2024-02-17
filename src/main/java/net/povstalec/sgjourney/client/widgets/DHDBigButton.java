package net.povstalec.sgjourney.client.widgets;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.povstalec.sgjourney.StargateJourney;

public class DHDBigButton extends DHDButton
{
	public ResourceLocation WIDGETS_LOCATION;

	private static final int RADIUS = 27;
	private static final int DIAMETER = RADIUS * 2;
	private static final int RADIUS_2 = RADIUS * RADIUS;
	
    public DHDBigButton(int x, int y, OnPress press, ResourceLocation widgets)
	{
		super(x, y, DIAMETER, DIAMETER, Component.empty(), press);
		WIDGETS_LOCATION = widgets;
	}
    
    @Override
    protected int getYImage(boolean isHovering)
    {
    	int i = 0;
    	
    	if(isHovering)
    		i = 1;
	
    	return i;
    }
    
	@Override
	public void renderButton(PoseStack poseStack, int mouseX, int mouseY, float partialTick)
	{
		Minecraft minecraft = Minecraft.getInstance();
		Font font = minecraft.font;
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderTexture(0, WIDGETS_LOCATION);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, this.alpha);
		int yOffset = this.getYImage(this.isHoveredOrFocused());
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		this.blit(poseStack, this.getX(), this.getY(), 0, yOffset * DIAMETER, this.width, this.height);
		this.blit(poseStack, this.getX() + this.width / 2, this.getY(), 200 - this.width / 2, 46 + yOffset * 20, this.width / 2, this.height);
		this.renderBg(poseStack, minecraft, mouseX, mouseY);
		int j = getFGColor();
		drawCenteredString(poseStack, font, this.getMessage(), this.getX() + this.width / 2, this.getY() + (this.height - 8) / 2, j | Mth.ceil(this.alpha * 255.0F) << 24);
	}
	
	@Override
	public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTick)
	{
		if(this.visible)
		{
			this.isHovered = ((Math.pow(mouseX - (this.getX() + RADIUS), 2) + Math.pow(mouseY - (this.getY() + RADIUS), 2)) <= RADIUS_2);
			
			this.renderButton(poseStack, mouseX, mouseY, partialTick);
			//this.updateTooltip();
		}
	}
	
	@Override
	public boolean isMouseOver(double mouseX, double mouseY)
	{
		return this.active && this.visible &&
				((Math.pow(mouseX - (this.getX() + RADIUS), 2) + Math.pow(mouseY - (this.getY() + RADIUS), 2)) <= RADIUS_2);
	}

	@Override
	protected boolean clicked(double mouseX, double mouseY)
	{
		return this.active && this.visible &&
				((Math.pow(mouseX - (this.getX() + RADIUS), 2) + Math.pow(mouseY - (this.getY() + RADIUS), 2)) <= RADIUS_2);
	}
	
	public static final class MilkyWay extends DHDBigButton
	{
		public MilkyWay(int x, int y, OnPress press)
		{
			super(x, y, press, new ResourceLocation(StargateJourney.MODID, "textures/gui/dhd/milky_way_dhd_widgets.png"));
		}
	}
}
