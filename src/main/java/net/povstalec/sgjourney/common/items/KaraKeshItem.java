package net.povstalec.sgjourney.common.items;

import java.util.List;
import java.util.Random;

import net.minecraft.core.component.DataComponents;
import net.povstalec.sgjourney.common.init.DataComponentInit;
import org.jetbrains.annotations.Nullable;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.povstalec.sgjourney.common.config.CommonTechConfig;
import net.povstalec.sgjourney.common.tech.GoauldTech;

public class KaraKeshItem extends Item implements GoauldTech
{
	private boolean terrorModeOn = false;
	private CompoundTag itemTag = new CompoundTag();
	private Random random = new Random();
	
	public KaraKeshItem(Properties properties)
	{
		super(properties);
	}
	
	@Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand)
	{
		if(level.isClientSide())
			return super.use(level, player, usedHand);
		
		if(canUseGoauldTech(CommonTechConfig.disable_kara_kesh_requirements.get(), player) && player.isShiftKeyDown())
		{
			ItemStack stack = player.getItemInHand(usedHand);

			if(stack.get(DataComponentInit.TERROR_MODE) != null || !stack.get(DataComponentInit.TERROR_MODE))
			{
				stack.set(DataComponentInit.TERROR_MODE, true);
				player.displayClientMessage(Component.translatable("tooltip.sgjourney.kara_kesh.terror").withStyle(ChatFormatting.RED), true);
			}
			else
			{
				stack.set(DataComponentInit.TERROR_MODE, false);
				player.displayClientMessage(Component.translatable("tooltip.sgjourney.kara_kesh.knockback").withStyle(ChatFormatting.GOLD), true);
			}
		}
        return super.use(level, player, usedHand);
    }
	
	public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity target, InteractionHand hand)
	{
		if(!player.getCooldowns().isOnCooldown(this) && !player.isShiftKeyDown())
		{
			if(stack.get(DataComponentInit.TERROR_MODE) != null || !stack.get(DataComponentInit.TERROR_MODE))
			{
				target.knockback(2.0F, player.getX() - target.getX(), player.getZ() - target.getZ());
				player.getCooldowns().addCooldown(this, 50);
			}
			else
			{
				target.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 200, 1));
				target.addEffect(new MobEffectInstance(MobEffects.WITHER, 200, 1));
				target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 255));
				player.getCooldowns().addCooldown(this, 200);
			}
			target.playSound(SoundEvents.BLAZE_SHOOT, 0.5F, random.nextFloat() * 0.4F + 0.8F);
			return InteractionResult.PASS;
		}
		return InteractionResult.FAIL;
	}
	
	@Override
	public boolean canAttackBlock(BlockState state, Level world, BlockPos position, Player player)
	{
		return !player.isCreative();
	}

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag)
    {
		if(stack.get(DataComponentInit.TERROR_MODE) != null && stack.get(DataComponentInit.TERROR_MODE))
			tooltipComponents.add(Component.translatable("tooltip.sgjourney.kara_kesh.terror").withStyle(ChatFormatting.RED));
		else
			tooltipComponents.add(Component.translatable("tooltip.sgjourney.kara_kesh.knockback").withStyle(ChatFormatting.GOLD));
    	
		tooltipComponents.add(Component.translatable("tooltip.sgjourney.kara_kesh.terror_knockback").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
		tooltipComponents.add(Component.translatable("tooltip.sgjourney.kara_kesh.use").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

}
