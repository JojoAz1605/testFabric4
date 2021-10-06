package net.test_fabric.amors;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;

public class UnMaterielPourArmure implements ArmorMaterial {
    private static final int[] BASE_DURABILITY = new int[] {10, 10, 10, 10};
    private static final int[] PROTECTION_VALUES = new int[] {15, 15, 15, 15};

    @Override
    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * X;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return PROTECTION_VALUES[slot.getEntitySlotId()]
    }
}
