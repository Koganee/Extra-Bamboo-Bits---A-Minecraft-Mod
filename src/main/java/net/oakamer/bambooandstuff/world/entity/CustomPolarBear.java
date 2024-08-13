package net.oakamer.bambooandstuff.world.entity;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.PolarBear;
import net.minecraft.world.level.Level;

public class CustomPolarBear extends PolarBear {
    private static final EntityDataAccessor<Boolean> CUSTOM_TEXTURE = SynchedEntityData.defineId(CustomPolarBear.class, EntityDataSerializers.BOOLEAN);

    public CustomPolarBear(EntityType<? extends PolarBear> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return PolarBear.createAttributes()
                .add(Attributes.ATTACK_DAMAGE, 0.0D); // Set attack damage to 0
    }

    @Override
    public AttributeMap getAttributes() {
        return new AttributeMap(createAttributes().build()); // Ensure attributes are correctly built
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(CUSTOM_TEXTURE, false);
    }

    public boolean hasCustomTexture() {
        return this.entityData.get(CUSTOM_TEXTURE);
    }

    public void setCustomTexture(boolean customTexture) {
        this.entityData.set(CUSTOM_TEXTURE, customTexture);
    }
}
