package net.oakamer.bambooandstuff.datagen;

import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.FinishedRecipe;
import net.oakamer.bambooandstuff.item.ModItems;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput)
    {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.IRON_CHESTPLATE_BAMBOO.get())
                .pattern("AAA")
                .pattern("AXA")
                .pattern("AAA")
                .define('A', ModItems.BAMBOO_THORNS.get())
                .define('X', Items.IRON_CHESTPLATE)
                .unlockedBy("has_bamboo_thorns", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.BAMBOO_THORNS.get()).build()))
                .save(pWriter);
    }
}