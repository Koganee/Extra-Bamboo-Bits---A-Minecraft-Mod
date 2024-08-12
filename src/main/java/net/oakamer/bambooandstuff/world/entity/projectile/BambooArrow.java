package net.oakamer.bambooandstuff.world.entity.projectile;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.oakamer.bambooandstuff.item.ModItems;
import net.oakamer.bambooandstuff.world.entity.ModEntityType;

public class BambooArrow extends AbstractArrow {
    private final Item referenceItem;
    public BambooArrow(EntityType<? extends AbstractArrow> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.referenceItem = ModItems.BAMBOO_ARROW.get();
    }

    public BambooArrow(Level pLevel, LivingEntity pShooter) {
        super(ModEntityType.BAMBOO_ARROW.get(), pShooter, pLevel);
        this.referenceItem = ModItems.BAMBOO_ARROW.get();
    }

    @Override
    public ItemStack getPickupItem() {
        return new ItemStack(this.referenceItem);
    }
}
