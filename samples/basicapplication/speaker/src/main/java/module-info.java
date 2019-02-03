import io.github.tomdw.jpms.versions.samples.basicapplication.microphone.api.Microphone;

module io.github.tomdw.jpms.versions.samples.basicapplication.speaker {
	exports io.github.tomdw.jpms.versions.samples.basicapplication.speaker.api;
	requires io.github.tomdw.jpms.versions.samples.basicapplication.microphone;
	uses Microphone;
}