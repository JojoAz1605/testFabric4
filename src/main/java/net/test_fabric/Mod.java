package net.test_fabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Mod implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("test_fabric");  // pour écrire des pitites choses !

	public static final Item UN_PREMIER_ITEM = new Item(new FabricItemSettings().group(ItemGroup.MISC));  // création d'un item

	@Override
	public void onInitialize() {
		LOGGER.info("Hello world!");  // parce que

		Registry.register(Registry.ITEM, new Identifier("test_fabric", "premier_item"), UN_PREMIER_ITEM);  // enregistrement d'un item
	}
}
