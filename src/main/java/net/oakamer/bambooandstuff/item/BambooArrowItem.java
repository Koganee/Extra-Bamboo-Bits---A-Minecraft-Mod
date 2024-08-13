package net.oakamer.bambooandstuff.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.oakamer.bambooandstuff.world.entity.projectile.BambooArrow;

public class BambooArrowItem extends ArrowItem {
    private final float damage;

    public BambooArrowItem(Properties pProperties, float damage) {
        super(pProperties);
        this.damage = damage;
    }


    public AbstractArrow createArrow(Level pLevel, ItemStack pStack, LivingEntity pShooter) {
        AbstractArrow arrow = new BambooArrow(pLevel, pShooter);
        arrow.setBaseDamage(this.damage);
        return arrow;
    }

    @Override
    public boolean isInfinite(ItemStack stack, ItemStack bow, Player player) {
        int enchant = net.minecraft.world.item.enchantment.EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, bow);
        return enchant <= 0 ? false : this.getClass() == BambooArrowItem.class;
    }
}
