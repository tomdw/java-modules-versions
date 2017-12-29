package be.tomdewolf.jpms.versions.samples.basicapplication.microphone.internal;

import be.tomdewolf.jpms.versions.samples.basicapplication.microphone.api.Microphone;

public class SimpleMicrophone implements Microphone {
	@Override
	public void broadcast(String spokenText) {
		System.out.println("Simple Mic --> " + spokenText);
	}
}
