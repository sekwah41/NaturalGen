package com.sekwah.naturalgen.mixin.common;

import com.sekwah.naturalgen.block.blockstate.NaturalBlockStateProperties;
import com.sekwah.naturalgen.extension.ForceNaturalBlockState;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Block.class)
public abstract class BlockMixin implements ForceNaturalBlockState {

    @Shadow protected abstract void registerDefaultState(BlockState pState);

    @Mutable
    @Shadow @Final protected StateDefinition<Block, BlockState> stateDefinition;

    @Shadow protected abstract void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder);

    @Override
    public void forceAddIsNatural() {
        StateDefinition.Builder<Block, BlockState> builder = new StateDefinition.Builder<>((Block) (Object)this);
        builder.add(NaturalBlockStateProperties.IS_NATURAL);
        this.createBlockStateDefinition(builder);
        stateDefinition = builder.create(Block::defaultBlockState, BlockState::new);
        this.registerDefaultState(stateDefinition.any());
    }
}
