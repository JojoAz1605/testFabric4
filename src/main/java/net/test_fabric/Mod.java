package net.test_fabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.test_fabric.blocks.BlockInit;
import net.test_fabric.items.ItemInit;
import net.test_fabric.lootTable.LootTableInit;
import net.test_fabric.soundEvents.SoundEventInit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Mod implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("test_fabric");  // pour écrire des pitites choses !

	public static final ItemGroup MON_GROUPE = FabricItemGroupBuilder.create(
					new Identifier("test_fabric", "groupe_pour_mes_items"))
			.icon(() -> new ItemStack(Items.TNT))
			.build();

	@Override
	public void onInitialize() {
		LOGGER.info("Hello world!");  // parce que

		ItemInit.register();
		BlockInit.register();
		SoundEventInit.register();
		LootTableInit.register();
	}
}
