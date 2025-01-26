package fr.thoridan.planes.item.custom;

import fr.thoridan.planes.entity.ModEntities;
import fr.thoridan.planes.entity.custom.models.YellowPlane;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.InteractionHand;

public class PlaneSpawnItem extends Item {

    public PlaneSpawnItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide) {
            // Example: spawn plane in front of the player
            Vec3 lookVector = player.getLookAngle().normalize().scale(3.0D);
            double spawnX = player.getX() + lookVector.x;
            double spawnY = player.getY() + 1.0D;
            double spawnZ = player.getZ() + lookVector.z;

            // Use the EntityType from ModEntities to create a new plane instance
            YellowPlane plane = new YellowPlane(ModEntities.YELLOW_PLANE.get(), level);
            plane.setPos(spawnX, spawnY, spawnZ);
            plane.setYRot(player.getYRot());  // face the direction of the player

            level.addFreshEntity(plane);
        }
        return InteractionResultHolder.success(player.getItemInHand(hand));
    }
}
