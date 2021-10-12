package net.test_fabric.lootTable;

import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.util.Identifier;

public class LootTableInit {
    private static final Identifier ID_LOOT_TABLE_MINERAI_CHARBON = Blocks.COAL_ORE.getLootTableId();

    public static void register() {
        // TODO comprendre
        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, table, setter) -> {
            if (ID_LOOT_TABLE_MINERAI_CHARBON.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(2)) // Same as "rolls": 1 in the loot table json
                        .with(ItemEntry.builder(Items.EGG));

                table.pool(poolBuilder);
            }
        });
    }
}
