package net.oakamer.bambooandstuff.datagen;

import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;
import net.oakamer.bambooandstuff.BambooAndBits;
import net.oakamer.bambooandstuff.item.ModItems;
import net.oakamer.bambooandstuff.loot.AddItemModifier;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output) {
        super(output, BambooAndBits.MOD_ID);
    }

    @Override
    protected void start() {
        add("bamboo_thorns_from_bamboo", new AddItemModifier(new LootItemCondition[] {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.BAMBOO).build(),
                LootItemRandomChanceCondition.randomChance(0.35f).build() }, ModItems.BAMBOO_THORNS.get()));
    }
}

