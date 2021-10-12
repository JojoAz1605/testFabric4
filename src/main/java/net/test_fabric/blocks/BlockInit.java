package net.test_fabric.blocks;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.test_fabric.Mod;

public class BlockInit {
    public static final Block UN_PREMIER_BLOC = new Block(FabricBlockSettings.of(Material.GLASS).strength(1.5f));  // créé un block
    public static final Block UN_BLOC_QUI_A_LA_CLASSE = new UnBlocQuiALaClasse(FabricBlockSettings.of(Material.STONE).hardness(3.0f));  // instancie un block avec class custom
    public static final Block A_SUIVRE = new ASuivre(FabricBlockSettings.of(Material.WOOD).hardness(1f));

    public static void register() {
        Registry.register(Registry.BLOCK, new Identifier("test_fabric", "un_premier_bloc"), UN_PREMIER_BLOC);  // enregistre le block
        Registry.register(Registry.ITEM, new Identifier("test_fabric", "un_premier_bloc"), new BlockItem(UN_PREMIER_BLOC, new FabricItemSettings().group(Mod.MON_GROUPE)));  // enregistre aussi le bloc en tant qu'item
        Registry.register(Registry.BLOCK, new Identifier("test_fabric", "un_bloc_qui_a_la_classe"), UN_BLOC_QUI_A_LA_CLASSE);
        Registry.register(Registry.ITEM, new Identifier("test_fabric", "un_bloc_qui_a_la_classe"), new BlockItem(UN_BLOC_QUI_A_LA_CLASSE, new FabricItemSettings().group(Mod.MON_GROUPE)));
        Registry.register(Registry.BLOCK, new Identifier("test_fabric", "a_suivre"), A_SUIVRE);
        Registry.register(Registry.ITEM, new Identifier("test_fabric", "a_suivre"), new BlockItem(A_SUIVRE, new FabricItemSettings().group(Mod.MON_GROUPE)));
    }
}
