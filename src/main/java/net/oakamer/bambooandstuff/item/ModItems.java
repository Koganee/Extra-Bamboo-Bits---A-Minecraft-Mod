package net.oakamer.bambooandstuff.item;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.oakamer.bambooandstuff.BambooAndBits;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BambooAndBits.MOD_ID);

    public static final RegistryObject<Item> BAMBOO_THORNS = ITEMS.register("bamboo_thorns",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> IRON_CHESTPLATE_BAMBOO = ITEMS.register("iron_chestplate_bamboo",
            () -> new ArmorItem(ModArmorMaterials.IRON_BAMBOO, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
