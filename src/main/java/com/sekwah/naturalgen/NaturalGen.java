package com.sekwah.naturalgen;

import com.sekwah.naturalgen.block.BlocksToInject;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.NetworkRegistry;

@Mod(NaturalGen.MOD_ID)
public class NaturalGen {
    public static final String MOD_ID = "naturalgen";

    public static final String PROTOCOL_VERSION = BlocksToInject.addNaturalTag.toString();

    public NaturalGen() {
        NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(NaturalGen.MOD_ID, "server_check"))
                .networkProtocolVersion(() -> PROTOCOL_VERSION)
                .clientAcceptedVersions(PROTOCOL_VERSION::equals)
                .serverAcceptedVersions(PROTOCOL_VERSION::equals)
                .simpleChannel();
    }
}
