package net.oakamer.bambooandstuff.client.renderer.entity;

import net.minecraft.client.model.PolarBearModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.oakamer.bambooandstuff.BambooAndBits;
import net.oakamer.bambooandstuff.world.entity.CustomPolarBear;

public class CustomPolarBearRenderer extends MobRenderer<CustomPolarBear, PolarBearModel<CustomPolarBear>> {

    private static final ResourceLocation DEFAULT_TEXTURE = new ResourceLocation("textures/entity/bear/polarbear.png");
    private static final ResourceLocation CUSTOM_TEXTURE = new ResourceLocation(BambooAndBits.MOD_ID, "textures/entity/polar_bear_bamboo.png");

    public CustomPolarBearRenderer(EntityRendererProvider.Context context) {
        super(context, new PolarBearModel<>(context.bakeLayer(ModelLayers.POLAR_BEAR)), 0.9F);
    }

    @Override
    public ResourceLocation getTextureLocation(CustomPolarBear entity) {
        return entity.hasCustomTexture() ? CUSTOM_TEXTURE : DEFAULT_TEXTURE;
    }


}
