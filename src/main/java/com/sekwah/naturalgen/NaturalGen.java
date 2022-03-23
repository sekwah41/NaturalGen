package com.sekwah.naturalgen;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

@Mod(NaturalGen.MOD_ID)
public class NaturalGen {
    public static final String MOD_ID = "naturalgen";

    public static final String PROTOCOL_VERSION = "1";

    public NaturalGen() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        SimpleChannel SYNC_CHANNEL = NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(NaturalGen.MOD_ID, "server_check"))
                .networkProtocolVersion(() -> PROTOCOL_VERSION)
                .clientAcceptedVersions(PROTOCOL_VERSION::equals)
                .serverAcceptedVersions(PROTOCOL_VERSION::equals)
                .simpleChannel();
    }
}
