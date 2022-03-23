package com.sekwah.naturalgen.mixin.common;

import com.mojang.datafixers.util.Pair;
import com.sekwah.naturalgen.block.blockstate.NaturalBlockStateProperties;
import com.sekwah.naturalgen.extension.ForceNaturalBlockState;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Map;
import java.util.stream.Collectors;

@Mixin(Block.class)
public abstract class BlockMixin implements ForceNaturalBlockState {

    @Shadow protected abstract void registerDefaultState(BlockState pState);

    @Mutable
    @Shadow @Final protected StateDefinition<Block, BlockState> stateDefinition;

    @Shadow protected abstract void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder);

    @Shadow private BlockState defaultBlockState;

    @Override
    public void forceAddIsNatural() {
        StateDefinition.Builder<Block, BlockState> builder = new StateDefinition.Builder<>((Block) (Object)this);
        builder.add(NaturalBlockStateProperties.IS_NATURAL);
        Map<? extends Property<?>, ? extends Comparable> oldProperties = this.defaultBlockState.getProperties().stream().map(property -> Pair.of(property, this.defaultBlockState.getValue(property))).collect(Collectors.toMap(Pair::getFirst, Pair::getSecond));
        this.createBlockStateDefinition(builder);
        stateDefinition = builder.create(Block::defaultBlockState, BlockState::new);
        BlockState currentState = stateDefinition.any();
        for (Map.Entry<? extends Property<?>, ? extends Comparable> entry : oldProperties.entrySet()) {
            currentState = this.addValueToBlockState(currentState, entry.getKey(), entry.getValue());
        }
        this.registerDefaultState(currentState);
    }

    public <T extends Comparable<T>, V extends T> BlockState addValueToBlockState(BlockState state, Property<?> property, Comparable<?> value) {
        return state.setValue((Property<T>) property, (V) value);
    }
}
