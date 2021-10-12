package net.test_fabric.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.test_fabric.Mod;

public class ItemInit {
    public static final Item UN_PREMIER_ITEM = new Item(new FabricItemSettings().group(Mod.MON_GROUPE));  // création d'un item
    public static final UnItemAvecClassCustom UN_ITEM_AVEC_CLASS_CUSTOM = new UnItemAvecClassCustom(new FabricItemSettings().group(Mod.MON_GROUPE).maxCount(99));  // instancie un item avec class custom
    // pour maxCount, si int > 64, en se le givant, ça va bien donner le nb, mais ce sera pas fonctionnel

    public static void register() {
        Registry.register(Registry.ITEM, new Identifier("test_fabric", "premier_item"), UN_PREMIER_ITEM);  // enregistrement d'un item
        Registry.register(Registry.ITEM, new Identifier("test_fabric", "un_item_avec_class_custom"), UN_ITEM_AVEC_CLASS_CUSTOM);
    }
}
