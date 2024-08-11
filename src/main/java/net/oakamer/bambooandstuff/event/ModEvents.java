package net.oakamer.bambooandstuff.event;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.oakamer.bambooandstuff.BambooAndBits;
import net.oakamer.bambooandstuff.effect.ModEffects;
import net.oakamer.bambooandstuff.item.ModItems;

@Mod.EventBusSubscriber(modid = BambooAndBits.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event)
    {
        Player player = event.player;
        Level world = player.getCommandSenderWorld();

        ItemStack mainHandItem = player.getMainHandItem();

        // Check if the item in the player's main hand is the specific item
        if (mainHandItem.getItem() == ModItems.BAMBOO_THORNS.get()) {
            player.addEffect(new MobEffectInstance(ModEffects.BAMBOO_PLAYER_HURT_EFFECT.get(), 1));
        }
    }

    @SubscribeEvent
    public static void onLivingAttack(LivingAttackEvent event)
    {
        LivingEntity entity = event.getEntity();
        if (entity instanceof Player) {
            Player player = (Player) entity;

            LivingEntity attacker = event.getSource().getEntity() instanceof LivingEntity ? (LivingEntity) event.getSource().getEntity() : null;
            if (attacker instanceof Mob && player.getItemBySlot(EquipmentSlot.CHEST).getItem() == ModItems.IRON_CHESTPLATE_BAMBOO.get()) {
                attacker.hurt(attacker.damageSources().cactus(), 1.0f);
            }
        }
    }
}
