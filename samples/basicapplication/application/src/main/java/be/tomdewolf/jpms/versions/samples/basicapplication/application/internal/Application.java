package be.tomdewolf.jpms.versions.samples.basicapplication.application.internal;

import be.tomdewolf.jpms.version.info.api.VersionInfo;
import be.tomdewolf.jpms.versions.samples.basicapplication.speaker.api.Speaker;

public class Application {

	public static final void main(String... args) {
		VersionInfo.print();
		VersionInfo.validateCompatibility();
		System.out.println("MODULEPATH IS COMPATIBLE, STARTING APPLICATION LOGIC ...");
		System.out.println("--------------------------------------------------------");
		System.out.println("");
		Speaker.speak("My versioned application");
	}
}
