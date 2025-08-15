package fr.Eidolyth.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import org.joml.Quaternionf;

/**
 * Represents the Debug Tool for Plane-related debugging tasks.
 * Provides developers with functionalities to inspect and debug plane entities within the game.
 */
public class DebugTool4Plane extends Item {

    /**
     * Constructs a new DebugTool4Plane item with the specified properties.
     *
     * @param properties Item properties such as creative tab, durability, etc.
     */
    public DebugTool4Plane(Properties properties) {
        super(properties);
    }

    /**
     * Handles the action when the Debug Tool is used on a block or entity.
     * This method is called when the player right-clicks with the Debug Tool in hand.
     *
     * @param context The context of the use action, containing information like the player, world, and position.
     * @return The result of the interaction, indicating whether the action was successful.
     */
    @Override
    public InteractionResult useOn(UseOnContext context) {
        // Check if the code is running on the client side to prevent server-side processing
        if (context.getLevel().isClientSide()) {
            // Retrieve the player who is using the Debug Tool
            Player player = context.getPlayer();

            // Ensure the player is not null to avoid potential NullPointerExceptions
            if (player != null) {
                // Send a system message to the player indicating that the Debug Tool is being used
                // Uncomment the line below to enable the debug message
                // player.sendSystemMessage(Component.literal("You are using the Debug Tool for Plane:"));

                // Additional debug functionalities can be implemented here
                // For example, displaying information about the plane the player is interacting with
            }
        }

        // Return SUCCESS to indicate that the interaction was handled
        // This prevents further processing of the interaction by other handlers
        return InteractionResult.SUCCESS;
    }
}
