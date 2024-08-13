package net.oakamer.bambooandstuff.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.oakamer.bambooandstuff.BambooAndBits;
import net.oakamer.bambooandstuff.world.entity.CustomPolarBear;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, BambooAndBits.MOD_ID);

    // Register your custom polar bear entity
    public static final RegistryObject<EntityType<CustomPolarBear>> POLAR_BEAR_BAMBOO = ENTITY_TYPES.register("polar_bear_bamboo",
            () -> EntityType.Builder.of(CustomPolarBear::new, MobCategory.CREATURE)
                    .sized(1.4F, 1.4F) // Size of the polar bear
                    .build(new ResourceLocation(BambooAndBits.MOD_ID, "polar_bear_bamboo").toString())
    );

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
