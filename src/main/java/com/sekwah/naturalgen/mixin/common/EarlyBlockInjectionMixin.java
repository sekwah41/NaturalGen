package com.sekwah.naturalgen.mixin.common;

import com.sekwah.naturalgen.block.BlockStateModifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.InfestedRotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// If this method
@Mixin(InfestedRotatedPillarBlock.class)
public class EarlyBlockInjectionMixin {

    @Inject(method = "<init>", at = @At("RETURN"))
    public void init(Block p_153438_, BlockBehaviour.Properties p_153439_, CallbackInfo ci) {
        BlockStateModifier.replaceStateDefinition();
    }
}
