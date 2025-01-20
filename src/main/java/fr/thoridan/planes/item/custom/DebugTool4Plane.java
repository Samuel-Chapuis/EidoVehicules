package fr.thoridan.planes.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import org.joml.Quaternionf;

public class DebugTool4Plane extends Item {
    public DebugTool4Plane(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(pContext.getLevel().isClientSide()){
            Player player = pContext.getPlayer();
//            player.sendSystemMessage(Component.nullToEmpty("You are using the Debug Tool 4 Plane :"));
        }

        return InteractionResult.SUCCESS; // Using for viewing the item beiing used
    }
}
