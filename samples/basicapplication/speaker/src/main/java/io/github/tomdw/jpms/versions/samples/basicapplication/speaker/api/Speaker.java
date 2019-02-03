package io.github.tomdw.jpms.versions.samples.basicapplication.speaker.api;

import java.util.ServiceLoader;

import io.github.tomdw.jpms.versions.samples.basicapplication.microphone.api.Microphone;

public class Speaker {

	public static void speak(String message) {
		ServiceLoader.load(Microphone.class).findFirst().get().broadcast("SPEAKER: " + message);
	}
}
