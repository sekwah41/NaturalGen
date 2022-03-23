package com.sekwah.naturalgen;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(NaturalGen.MOD_ID)
public class NaturalGen {
    public static final String MOD_ID = "naturalgen";

    public NaturalGen() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
    }
}
