package fr.thoridan.planes.event;

import com.mojang.blaze3d.platform.InputConstants;
import fr.thoridan.planes.Globals;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(modid = "forplanes", bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class KeyInputHandler {

    // Define the key binding
    public static final KeyMapping J_KEY_BINDING = new KeyMapping(
            "key.forplanes.j_key", // Translation key
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_J, // The key code for 'J'
            "category.forplanes.custom_keys" // The category in controls menu
    );

    public static final KeyMapping K_KEY_BINDING = new KeyMapping(
            "key.forplanes.k_key", // Translation key
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_K, // The key code for 'K'
            "category.forplanes.custom_keys" // The category in controls menu
    );

    public static final KeyMapping L_KEY_BINDING = new KeyMapping(
            "key.forplanes.l_key", // Translation key
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_L, // The key code for 'L'
            "category.forplanes.custom_keys" // The category in controls menu
    );

    // Register the key binding
    @SubscribeEvent
    public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
        event.register(J_KEY_BINDING);
        event.register(K_KEY_BINDING);
        event.register(L_KEY_BINDING);
    }

    // Handle key press events
    @Mod.EventBusSubscriber(modid = "forplanes", bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
    public static class ClientEvents {

        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {
            if (J_KEY_BINDING.matches(event.getKey(), event.getScanCode())) {
                if (event.getAction() == GLFW.GLFW_PRESS) {
                    Globals.global1 = Globals.global1 + 0.2f;
                    System.out.println("J key pressed: " + Globals.global1);
                }
                if (event.getAction() == GLFW.GLFW_RELEASE) {
                    System.out.println("J key released");
                }
            }

            if (K_KEY_BINDING.matches(event.getKey(), event.getScanCode())) {
                if (event.getAction() == GLFW.GLFW_PRESS) {
                    Globals.global2 = Globals.global2 + 0.2f;
                    System.out.println("K key pressed: " + Globals.global2);
                }
                if (event.getAction() == GLFW.GLFW_RELEASE) {
                    System.out.println("K key released");
                }
            }

            if (L_KEY_BINDING.matches(event.getKey(), event.getScanCode())) {
                if (event.getAction() == GLFW.GLFW_PRESS) {
                    Globals.global3 = Globals.global3 + 0.2f;
                    System.out.println("L key pressed: " + Globals.global3);
                }
                if (event.getAction() == GLFW.GLFW_RELEASE) {
                    System.out.println("L key released");
                }
            }
        }
    }
}
