package net.test_fabric.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.HashSet;
import java.util.Random;

public class UnBlocQuiALaClasse extends Block {
    HashSet<String> listeDeTrucsADire = new HashSet<>();

    public UnBlocQuiALaClasse(Settings settings) {
        super(settings);
        this.listeDeTrucsADire.add("Salut!");
        this.listeDeTrucsADire.add("Bonjour");
        this.listeDeTrucsADire.add("J'ai rien à dire");
        this.listeDeTrucsADire.add("Oui?");
        this.listeDeTrucsADire.add("Qu'est-ce que tu me veux?!");
        this.listeDeTrucsADire.add("177013");
        this.listeDeTrucsADire.add("228922");
    }

    private String donneUnTrucADire() {
        int numTrucADire = new Random().nextInt(this.listeDeTrucsADire.size()-1);
        int i = 0;
        String trucADire = null;
        for (String uneString: this.listeDeTrucsADire) {
            if (i == numTrucADire) {
                trucADire = uneString;
                break;
            }
            i++;
        }
        return trucADire;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos blockPos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            world.playSound(
                    null,
                    blockPos,
                    SoundEvents.ENTITY_VILLAGER_AMBIENT,
                    SoundCategory.BLOCKS,
                    100.0f,
                    0.1f
            );
            player.sendMessage(new LiteralText(this.donneUnTrucADire()), false);
        }
        return ActionResult.SUCCESS;
    }
}
