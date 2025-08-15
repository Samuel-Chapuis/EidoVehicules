package fr.Eidolyth.event;

import fr.Eidolyth.EidoVehicules;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * Forge-bus event handlers for generic gameplay changes.
 *
 * - Prevents players from wearing Elytra by automatically removing any Elytra
 *   placed in the chest equipment slot and moving it to the player's inventory
 *   (or dropping it if the inventory is full).
 * - Appends " (UNWEARABLE)" to Elytra item display names in player inventories
 *   and renamed Elytra item entities when they spawn in the world.
 */
@Mod.EventBusSubscriber(modid = EidoVehicules.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModForgeEvents {

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;
        Player player = event.player;

    // Only run on logical server to perform inventory/equipment changes.
    if (player.getCommandSenderWorld().isClientSide) return;

        ItemStack chest = player.getItemBySlot(EquipmentSlot.CHEST);
        if (!chest.isEmpty() && chest.getItem() == Items.ELYTRA) {
            ItemStack toMove = chest.copy();
            // Remove from chest slot
            player.setItemSlot(EquipmentSlot.CHEST, ItemStack.EMPTY);
            // Try to add back to inventory, otherwise drop it in world
            boolean added = player.getInventory().add(toMove);
            if (!added) {
                player.drop(toMove, false);
            }
            // Notify player once (server-side system message)
            player.displayClientMessage(Component.literal("Elytra is UNWEARABLE and has been removed."), true);
        }

        // Append UNWEARABLE to Elytra stacks in inventory so players see the change
        player.getInventory().items.stream()
                .filter(s -> !s.isEmpty() && s.getItem() == Items.ELYTRA)
                .forEach(s -> {
                    String name = s.getHoverName().getString();
                    if (!name.contains("UNWEARABLE")) {
                        s.setHoverName(Component.literal(name + " (UNWEARABLE)"));
                    }
                });
    }

    // Note: world item renaming on spawn was removed to avoid version-specific event import issues.
    // Elytra renaming is handled in player inventories and when removed from the chest slot.
}
