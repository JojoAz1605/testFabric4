package net.test_fabric.amors;

import net.fabricmc.fabric.api.client.networking.v1.C2SPlayChannelEvents;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.registry.Registry;
import net.test_fabric.Mod;

public class UnMaterielPourArmure implements ArmorMaterial {
    private static final int[] BASE_DURABILITY = new int[] {10, 10, 10, 10};
    private static final int[] PROTECTION_VALUES = new int[] {15, 15, 15, 15};

    @Override
    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * 30;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return PROTECTION_VALUES[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return 20;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ENTITY_VILLAGER_AMBIENT;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Mod.UN_ITEM_AVEC_CLASS_CUSTOM);
    }

    @Override
    public String getName() {
        return "ouah";
    }

    @Override
    public float getToughness() {
        return 2.0f;
    }

    @Override
    public float getKnockbackResistance() {
        return 1f;
    }
}
