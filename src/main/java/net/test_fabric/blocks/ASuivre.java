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
import net.test_fabric.Mod;

public class ASuivre extends Block {
    public ASuivre(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos blockPos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            world.playSound(
                    null,
                    blockPos,
                    Mod.TO_BE_CONTINUED_SOUND_EVENT,
                    SoundCategory.BLOCKS,
                    1f,
                    1f
            );
        }
        return ActionResult.SUCCESS;
    }
}
