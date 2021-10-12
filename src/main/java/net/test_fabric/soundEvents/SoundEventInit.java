package net.test_fabric.soundEvents;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class SoundEventInit{
    public static final Identifier TO_BE_CONTINUED = new Identifier("test_fabric:to_be_continued");
    public static final SoundEvent TO_BE_CONTINUED_SOUND_EVENT = new SoundEvent(TO_BE_CONTINUED);

    public static void register() {
        Registry.register(Registry.SOUND_EVENT, TO_BE_CONTINUED, TO_BE_CONTINUED_SOUND_EVENT);
    }
}
