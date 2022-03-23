package com.sekwah.naturalgen.block;

import com.sekwah.naturalgen.extension.ForceNaturalBlockState;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class BlockStateModifier {

    private static final Block[] blocks = {
            Blocks.GRASS_BLOCK
    };

    private static boolean hasInjected = false;

    public static void replaceStateDefinition() {
        if(hasInjected) {
            return;
        }
        hasInjected = true;
        for(Block block : blocks) {
            if(block instanceof ForceNaturalBlockState forceNaturalBlockState) {
                forceNaturalBlockState.forceAddIsNatural();
            }
        }
    }
}
