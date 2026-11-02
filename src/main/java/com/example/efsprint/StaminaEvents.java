package com.example.efsprint;

import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import yesman.epicfight.world.capabilities.EpicFightCapabilities;
import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;

@EventBusSubscriber(modid = EfSprint.MODID)
public class StaminaEvents {

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        if (!(event.getEntity() instanceof ServerPlayer player)) return;
        if (!player.isSprinting()) return;

        ServerPlayerPatch patch = EpicFightCapabilities.getEntityPatch(player, ServerPlayerPatch.class);
        if (patch == null) return;

        float stamina = patch.getStamina();
        if (stamina < Config.MIN_STAMINA_TO_SPRINT.get().floatValue()) {
            player.setSprinting(false);
            return;
        }
        float cost = Config.SPRINT_COST_PER_TICK.get().floatValue();
        patch.setStamina(Math.max(0.0F, stamina - cost));
    }

    @SubscribeEvent
    public static void onJump(LivingEvent.LivingJumpEvent event) {
        if (!(event.getEntity() instanceof ServerPlayer player)) return;

        ServerPlayerPatch patch = EpicFightCapabilities.getEntityPatch(player, ServerPlayerPatch.class);
        if (patch == null) return;

        float cost = Config.JUMP_COST.get().floatValue();
        patch.setStamina(Math.max(0.0F, patch.getStamina() - cost));
    }
}
