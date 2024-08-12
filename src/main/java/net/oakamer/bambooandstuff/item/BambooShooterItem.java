package net.oakamer.bambooandstuff.item;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.entity.projectile.AbstractArrow;

import java.util.function.Predicate;

public class BambooShooterItem extends BowItem {

    public BambooShooterItem(Properties properties) {
        super(properties);
    }


    public void releaseUsing(ItemStack stack, Level level, Player player, int timeLeft) {
        // Similar to BowItem releaseUsing, but with custom arrow shooting logic
        boolean infiniteAmmo = player.getAbilities().instabuild || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, stack) > 0;
        ItemStack ammoStack = player.getProjectile(stack);

        if (!ammoStack.isEmpty() || infiniteAmmo) {
            if (ammoStack.isEmpty()) {
                ammoStack = new ItemStack(ModItems.BAMBOO_ARROW.get()); // Use your custom bamboo arrow
            }

            boolean isInfinite = player.getAbilities().instabuild || (ammoStack.getItem() instanceof BambooArrowItem && ((BambooArrowItem)ammoStack.getItem()).isInfinite(ammoStack, stack, player));
            if (!level.isClientSide) {
                ArrowItem arrowitem = (ArrowItem)(ammoStack.getItem() instanceof BambooArrowItem ? ammoStack.getItem() : Items.ARROW);
                AbstractArrow abstractarrow = arrowitem.createArrow(level, ammoStack, player);
                abstractarrow = customArrow(abstractarrow);
                abstractarrow.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 3.0F, 1.0F);

                stack.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(player.getUsedItemHand()));
                if (isInfinite || player.getAbilities().instabuild && (ammoStack.getItem() == Items.ARROW || ammoStack.getItem() == ModItems.BAMBOO_ARROW.get())) {
                    abstractarrow.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                }

                level.addFreshEntity(abstractarrow);
            }

            level.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (level.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
            if (!isInfinite && !player.getAbilities().instabuild) {
                ammoStack.shrink(1);
                if (ammoStack.isEmpty()) {
                    player.getInventory().removeItem(ammoStack);
                }
            }

            player.awardStat(Stats.ITEM_USED.get(this));
        }
    }

    @Override
    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return (stack) -> stack.getItem() instanceof BambooArrowItem;
    }
}