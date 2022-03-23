package com.sekwah.naturalgen.mixin.common;

import com.sekwah.naturalgen.block.blockstate.NaturalBlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Block.class)
public class PlacedByMixin {

    @Inject(method = "setPlacedBy", at = @At("HEAD"))
    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, LivingEntity pPlacer, ItemStack pStack, CallbackInfo ci) {
        if(pState.hasProperty(NaturalBlockStateProperties.IS_NATURAL)) {
            pState.setValue(NaturalBlockStateProperties.IS_NATURAL, false);
        }
    }

}
