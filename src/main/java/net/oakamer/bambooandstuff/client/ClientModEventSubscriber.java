package net.oakamer.bambooandstuff.client;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.oakamer.bambooandstuff.BambooAndBits;
import net.oakamer.bambooandstuff.client.renderer.entity.BambooArrowRenderer;
import net.oakamer.bambooandstuff.world.entity.ModEntityType;

@Mod.EventBusSubscriber(modid = BambooAndBits.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEventSubscriber {

    @SubscribeEvent
    public static void onClientSetup(EntityRenderersEvent.RegisterRenderers event)
    {
        event.registerEntityRenderer(ModEntityType.BAMBOO_ARROW.get(), BambooArrowRenderer::new);
    }

}
