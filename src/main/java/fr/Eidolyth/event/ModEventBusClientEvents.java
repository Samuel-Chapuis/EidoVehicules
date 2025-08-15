package fr.Eidolyth.event;

import fr.Eidolyth.Globals;
import fr.Eidolyth.item.ModItems;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.*;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.entity.player.Player;

import static fr.Eidolyth.event.vehicule.VehiculeLogicUtility.doCustomPlayerRender;

/**
 * Handles client-side events for the ForPlanes mod.
 * This class listens to various Forge events to manage custom rendering and camera adjustments
 * when players interact with plane entities.
 */
@Mod.EventBusSubscriber(modid = "eidovehicules", bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModEventBusClientEvents {


    /* --------------------- */
    /* --- FOR DEBUGGING --- */
    /* --------------------- */

    /**
     * Applies custom rendering logic before the living entity (player) is rendered.
     * If the player is holding the Debug Tool for Plane, it cancels the default rendering
     * and applies custom transformations.
     *
     * @param event The Pre render event containing rendering information.
     */
    @SubscribeEvent
    public static void onRenderLivingPre(RenderLivingEvent.Pre<?, ?> event) {
        // Check if the entity being rendered is a Player
        if (event.getEntity() instanceof Player player) {
            // Check if the player is holding the Debug Tool for Plane in either hand
            if (isHoldingItem(player, ModItems.DEBUG_TOOL_4PLANE.get())) {
                // Cancel the default rendering of the player model
                event.setCanceled(true);

                // Define desired rotation angles (in degrees) from global variables
                float rotX = Globals.global1;   // Rotation around X-axis
                float rotY = Globals.global2;   // Rotation around Y-axis
                float rotZ = Globals.global3;   // Rotation around Z-axis

                // Define positional offsets for rendering the player model
                double posX = 0.0D; // Translation along X-axis
                double posY = 0.0D; // Translation along Y-axis
                double posZ = 0.0D; // Translation along Z-axis

                // Invoke custom rendering method with transformation parameters
                doCustomPlayerRender(player, event, rotX, rotY, rotZ, posX, posY, posZ, 0);
            }
        }
    }

    /* --------------------- */
    /* --- Utility Methods -- */
    /* --------------------- */


    /**
     * Checks if the player is holding a specific item in either their main hand or offhand.
     *
     * @param player The player entity to check.
     * @param item   The item to verify if the player is holding.
     * @return True if the player is holding the specified item, false otherwise.
     */
    private static boolean isHoldingItem(Player player, Item item) {
        return player.getMainHandItem().getItem() == item ||
                player.getOffhandItem().getItem() == item;
    }


}
