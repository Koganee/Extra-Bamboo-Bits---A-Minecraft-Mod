package net.oakamer.bambooandstuff.world.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.oakamer.bambooandstuff.BambooAndBits;
import net.oakamer.bambooandstuff.world.entity.projectile.BambooArrow;

public class ModEntityType {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, BambooAndBits.MOD_ID);

    public static final RegistryObject<EntityType<BambooArrow>> BAMBOO_ARROW = ENTITIES.register("bamboo_arrow", () -> EntityType.Builder.<BambooArrow>of(BambooArrow::new, MobCategory.MISC).sized(0.5f,0.5f).clientTrackingRange(4).updateInterval(20).build(new ResourceLocation(BambooAndBits.MOD_ID, "bamboo_arrow").toString()));

    public static void register(IEventBus eventBus)
    {
        ENTITIES.register(eventBus);
    }
}
