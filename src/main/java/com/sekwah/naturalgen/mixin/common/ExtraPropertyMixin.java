package com.sekwah.naturalgen.mixin.common;

import com.sekwah.naturalgen.block.blockstate.NaturalBlockStateProperties;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.SpreadingSnowyDirtBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(GrassBlock.class)
public class ExtraPropertyMixin extends SpreadingSnowyDirtBlock {

    protected ExtraPropertyMixin(Properties p_56817_) {
        super(p_56817_);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(NaturalBlockStateProperties.IS_NATURAL);
    }
}
