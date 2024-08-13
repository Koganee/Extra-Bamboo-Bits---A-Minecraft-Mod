package net.oakamer.bambooandstuff;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.oakamer.bambooandstuff.effect.ModEffects;
import net.oakamer.bambooandstuff.entity.ModEntities;
import net.oakamer.bambooandstuff.item.ModItemProperties;
import net.oakamer.bambooandstuff.item.ModItems;
import net.oakamer.bambooandstuff.loot.ModLootModifiers;
import net.oakamer.bambooandstuff.world.entity.ModEntityType;
import org.slf4j.Logger;
import net.oakamer.bambooandstuff.client.renderer.entity.CustomPolarBearRenderer;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(BambooAndBits.MOD_ID)
public class BambooAndBits
{
    public static final String MOD_ID = "bambooandstuff";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MOD_ID);

    public BambooAndBits()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModEffects.register(modEventBus);
        ModLootModifiers.register(modEventBus);
        ModEntityType.register(modEventBus);
        ModEntities.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);

    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES)
            event.accept(ModItems.BAMBOO_THORNS);
            event.accept(ModItems.IRON_CHESTPLATE_BAMBOO);
            event.accept(ModItems.GOLD_CHESTPLATE_BAMBOO);
            event.accept(ModItems.DIAMOND_CHESTPLATE_BAMBOO);
            event.accept(ModItems.NETHERITE_CHESTPLATE_BAMBOO);
            event.accept(ModItems.BAMBOO_SHOOTER);
            event.accept(ModItems.BAMBOO_ARROW);
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            //ModItemProperties.addCustomItemProperties();

            EntityRenderers.register(ModEntities.POLAR_BEAR_BAMBOO.get(), CustomPolarBearRenderer::new);
        }
    }
}
