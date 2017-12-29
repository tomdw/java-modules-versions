import be.tomdewolf.jpms.versions.samples.basicapplication.microphone.api.Microphone;
import be.tomdewolf.jpms.versions.samples.basicapplication.microphone.internal.SimpleMicrophone;

module be.tomdewolf.jpms.versions.samples.basicapplication.microphone {
	exports be.tomdewolf.jpms.versions.samples.basicapplication.microphone.api;

	provides Microphone with SimpleMicrophone;
}