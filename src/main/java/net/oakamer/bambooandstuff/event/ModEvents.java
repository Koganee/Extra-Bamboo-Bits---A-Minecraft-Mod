package net.oakamer.bambooandstuff.event;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.PolarBear;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.oakamer.bambooandstuff.BambooAndBits;
import net.oakamer.bambooandstuff.effect.ModEffects;
import net.oakamer.bambooandstuff.entity.ModEntities;
import net.oakamer.bambooandstuff.item.ModItems;
import net.oakamer.bambooandstuff.world.entity.CustomPolarBear;

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
            if (attacker instanceof Mob && player.getItemBySlot(EquipmentSlot.CHEST).getItem() == ModItems.GOLD_CHESTPLATE_BAMBOO.get()) {
                attacker.hurt(attacker.damageSources().cactus(), 1.0f);
            }
            if (attacker instanceof Mob && player.getItemBySlot(EquipmentSlot.CHEST).getItem() == ModItems.DIAMOND_CHESTPLATE_BAMBOO.get()) {
                attacker.hurt(attacker.damageSources().cactus(), 1.0f);
            }
            if (attacker instanceof Mob && player.getItemBySlot(EquipmentSlot.CHEST).getItem() == ModItems.NETHERITE_CHESTPLATE_BAMBOO.get()) {
                attacker.hurt(attacker.damageSources().cactus(), 1.0f);
            }
        }
    }

    @SubscribeEvent
    public static void onBambooUse(PlayerInteractEvent.EntityInteract event)
    {
        LivingEntity entity = event.getEntity();
        Player player = (Player) entity;
        Level level = event.getLevel();
        LivingEntity targetEntity = (LivingEntity) event.getTarget();
        ItemStack itemStack = event.getItemStack();

        if (itemStack.getItem() == Items.BAMBOO) {
            if (player.level() instanceof ServerLevel serverLevel) {
                if (targetEntity instanceof PolarBear polarBear) {

                    // Save the polar bear's current data
                    double health = polarBear.getHealth();
                    BlockPos position = polarBear.blockPosition();
                    float yaw = polarBear.getYRot();
                    float pitch = polarBear.getXRot();

                    // Remove the original polar bear
                    polarBear.discard();

                    // Spawn the custom polar bear at the same location
                    EntityType<CustomPolarBear> entityType = ModEntities.POLAR_BEAR_BAMBOO.get();


                    CustomPolarBear customPolarBear = entityType.create(serverLevel);

                    customPolarBear.moveTo(position.getX(), position.getY(), position.getZ(), yaw, pitch);
                    customPolarBear.setHealth((float) health);
                    customPolarBear.setCustomTexture(true); // Set the custom texture
                    customPolarBear.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(0.0D); // Set attack damage to 0

                    serverLevel.addFreshEntity(customPolarBear);
                    BambooAndBits.LOGGER.info("CustomPolarBear spawned at " + position.toString());
                    itemStack.shrink(1);

                }
            }
        }
    }
}
