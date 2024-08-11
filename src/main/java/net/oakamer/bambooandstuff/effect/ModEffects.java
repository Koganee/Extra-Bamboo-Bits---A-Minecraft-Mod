package net.oakamer.bambooandstuff.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.oakamer.bambooandstuff.BambooAndBits;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, BambooAndBits.MOD_ID);

    public static final RegistryObject<MobEffect> BAMBOO_PLAYER_HURT_EFFECT = MOB_EFFECTS.register("bamboo_player_hurt_effect",
            () -> new BambooThornsEffectPlayer(MobEffectCategory.NEUTRAL, 0x36ebab));
    public static final RegistryObject<MobEffect> BAMBOO_MOB_HURT_EFFECT = MOB_EFFECTS.register("bamboo_mob_hurt_effect",
            () -> new BambooThornsEffectPlayer(MobEffectCategory.NEUTRAL, 0x36ebab));

    public static void register(IEventBus eventBus)
    {
        MOB_EFFECTS.register(eventBus);
    }
}
