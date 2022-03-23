package com.sekwah.naturalgen.mixin.common;
import com.sekwah.naturalgen.block.BlocksToInject;
import com.sekwah.naturalgen.extension.ForceNaturalBlockState;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Arrays;
import java.util.List;

// If this method
@Mixin(Blocks.class)
public class EarlyBlockInjectionMixin {

    @Inject(method = "register", at = @At("RETURN"))
    private static void register(String pKey, Block pBlock, CallbackInfoReturnable<Block> cir) {
        if(BlocksToInject.addNaturalTag.contains(pKey)) {
            if(pBlock instanceof ForceNaturalBlockState forceNaturalBlockState) {
                forceNaturalBlockState.forceAddIsNatural();
            }
        }
    }
}
