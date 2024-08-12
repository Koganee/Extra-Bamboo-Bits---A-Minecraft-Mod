package net.oakamer.bambooandstuff.client.renderer.entity;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.oakamer.bambooandstuff.BambooAndBits;
import net.oakamer.bambooandstuff.world.entity.projectile.BambooArrow;

@OnlyIn(Dist.CLIENT)
public class BambooArrowRenderer extends ArrowRenderer<BambooArrow> {
    public BambooArrowRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
    }

    @Override
    public ResourceLocation getTextureLocation(BambooArrow pEntity) {
        Item referenceItem = pEntity.getPickupItem().getItem();
        ResourceLocation itemRegistryName = BuiltInRegistries.ITEM.getKey(referenceItem);
        return new ResourceLocation(BambooAndBits.MOD_ID, "textures/entity/projectiles" + itemRegistryName.getPath() + ".png");
    }
}
