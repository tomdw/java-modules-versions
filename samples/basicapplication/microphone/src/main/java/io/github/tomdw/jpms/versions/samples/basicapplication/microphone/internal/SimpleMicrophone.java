package io.github.tomdw.jpms.versions.samples.basicapplication.microphone.internal;

import io.github.tomdw.jpms.versions.samples.basicapplication.microphone.api.Microphone;

public class SimpleMicrophone implements Microphone {
	@Override
	public void broadcast(String spokenText) {
		System.out.println("Simple Mic --> " + spokenText);
	}
}
