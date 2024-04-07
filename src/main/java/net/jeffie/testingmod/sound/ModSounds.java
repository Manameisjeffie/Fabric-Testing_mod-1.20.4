package net.jeffie.testingmod.sound;

import net.jeffie.testingmod.TestingMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds
{
    public static final SoundEvent ORE_DETECTOR_FOUND_ORE = registerSoundEvent();

    private static SoundEvent registerSoundEvent() {
        Identifier id = new Identifier(TestingMod.MOD_ID, "ore_detector_found_ore");
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        TestingMod.LOGGER.info("Registering Sounds for " + TestingMod.MOD_ID);
    }
}
