package net.test_fabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.*;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.test_fabric.blocks.UnBlocQuiALaClasse;
import net.test_fabric.items.UnItemAvecClassCustom;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.system.CallbackI;

public class Mod implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("test_fabric");  // pour écrire des pitites choses !

	public static final ItemGroup MON_GROUPE = FabricItemGroupBuilder.create(
			new Identifier("test_fabric", "groupe_pour_mes_items"))
			.icon(() -> new ItemStack(Items.TNT))
			.build();

	public static final Item UN_PREMIER_ITEM = new Item(new FabricItemSettings().group(Mod.MON_GROUPE));  // création d'un item
	public static final UnItemAvecClassCustom UN_ITEM_AVEC_CLASS_CUSTOM = new UnItemAvecClassCustom(new FabricItemSettings().group(Mod.MON_GROUPE).maxCount(99));  // instancie un item avec class custom
	// pour maxCount, si int > 64, en se le givant, ça va bien donner le nb, mais ce sera pas fonctionnel

	public static final Block UN_PREMIER_BLOC = new Block(FabricBlockSettings.of(Material.GLASS).strength(1.5f));  // créé un block
	public static final Block UN_BLOC_QUI_A_LA_CLASSE = new UnBlocQuiALaClasse(FabricBlockSettings.of(Material.STONE).hardness(3.0f));  // instancie un block avec class custom

	private static final Identifier ID_LOOT_TABLE_MINERAI_CHARBON = Blocks.COAL_ORE.getLootTableId();

	@Override
	public void onInitialize() {
		LOGGER.info("Hello world!");  // parce que

		Registry.register(Registry.ITEM, new Identifier("test_fabric", "premier_item"), Mod.UN_PREMIER_ITEM);  // enregistrement d'un item
		Registry.register(Registry.ITEM, new Identifier("test_fabric", "un_item_avec_class_custom"), Mod.UN_ITEM_AVEC_CLASS_CUSTOM);

		Registry.register(Registry.BLOCK, new Identifier("test_fabric", "un_premier_bloc"), Mod.UN_PREMIER_BLOC);  // enregistre le block
		Registry.register(Registry.ITEM, new Identifier("test_fabric", "un_premier_bloc"), new BlockItem(Mod.UN_PREMIER_BLOC, new FabricItemSettings().group(Mod.MON_GROUPE)));  // enregistre aussi le bloc en tant qu'item
		Registry.register(Registry.BLOCK, new Identifier("test_fabric", "un_bloc_qui_a_la_classe"), Mod.UN_BLOC_QUI_A_LA_CLASSE);
		Registry.register(Registry.ITEM, new Identifier("test_fabric", "un_bloc_qui_a_la_classe"), new BlockItem(Mod.UN_BLOC_QUI_A_LA_CLASSE, new FabricItemSettings().group(Mod.MON_GROUPE)));

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
