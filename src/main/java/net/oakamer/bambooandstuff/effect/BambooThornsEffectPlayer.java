package net.oakamer.bambooandstuff.effect;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.oakamer.bambooandstuff.item.ModItems;

public class BambooThornsEffectPlayer extends MobEffect {
    protected BambooThornsEffectPlayer(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if(pLivingEntity.getMainHandItem().getItem() == ModItems.BAMBOO_THORNS.get())
        {
            pLivingEntity.hurt(pLivingEntity.damageSources().cactus(), 1.00f);
        }
        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event)
    {
        LivingEntity entity = event.getEntity();
        MobEffectInstance effectInstance = entity.getEffect(ModEffects.BAMBOO_MOB_HURT_EFFECT.get());
        if (entity instanceof Player) {
            Player player = (Player) entity;

            LivingEntity attacker = event.getSource().getEntity() instanceof LivingEntity ? (LivingEntity) event.getSource().getEntity() : null;
            if (attacker instanceof Mob && player.getItemBySlot(EquipmentSlot.CHEST).getItem() == ModItems.IRON_CHESTPLATE_BAMBOO.get()) {
                attacker.hurt(attacker.damageSources().cactus(), 1.0f);
            }
        }
    }


    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}