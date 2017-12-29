import be.tomdewolf.jpms.versions.samples.basicapplication.microphone.api.Microphone;

module be.tomdewolf.jpms.versions.samples.basicapplication.speaker {
	exports be.tomdewolf.jpms.versions.samples.basicapplication.speaker.api;
	requires be.tomdewolf.jpms.versions.samples.basicapplication.microphone;
	uses Microphone;
}