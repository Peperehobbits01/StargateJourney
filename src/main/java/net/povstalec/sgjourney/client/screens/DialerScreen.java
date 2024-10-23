package net.povstalec.sgjourney.client.screens;

import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.povstalec.sgjourney.StargateJourney;

public class DialerScreen extends Screen
{
	private static final ResourceLocation TEXTURE = StargateJourney.sgjourneyLocation("textures/gui/dhd/dhd_background.png");

	protected int imageWidth = 192;
	protected int imageHeight = 192;
	
	public DialerScreen()
	{
		super(Component.empty());
	}
	
	@Override
	public boolean isPauseScreen() 
	{
		return false;
	}

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float delta)
    {
    	RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
		int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
        
        graphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight + 1);
    }
}
