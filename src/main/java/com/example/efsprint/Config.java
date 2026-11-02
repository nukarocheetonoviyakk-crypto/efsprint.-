package com.example.efsprint;

import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {
    private static final ModConfigSpec.Builder B = new ModConfigSpec.Builder();

    public static final ModConfigSpec.DoubleValue SPRINT_COST_PER_TICK = B
            .comment("Stamina spent every tick while sprinting (20 ticks = 1 second).")
            .defineInRange("sprintCostPerTick", 0.05, 0.0, 10.0);

    public static final ModConfigSpec.DoubleValue JUMP_COST = B
            .comment("Stamina spent per jump.")
            .defineInRange("jumpCost", 0.5, 0.0, 100.0);

    public static final ModConfigSpec.DoubleValue MIN_STAMINA_TO_SPRINT = B
            .comment("Sprinting is cancelled when stamina drops below this value.")
            .defineInRange("minStaminaToSprint", 1.0, 0.0, 100.0);

    public static final ModConfigSpec SPEC = B.build();
}
