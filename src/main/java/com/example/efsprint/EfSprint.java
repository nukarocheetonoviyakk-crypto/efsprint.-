package com.example.efsprint;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;

@Mod(EfSprint.MODID)
public class EfSprint {
    public static final String MODID = "efsprint";

    public EfSprint(IEventBus modBus, ModContainer container) {
        container.registerConfig(ModConfig.Type.SERVER, Config.SPEC);
    }
}
