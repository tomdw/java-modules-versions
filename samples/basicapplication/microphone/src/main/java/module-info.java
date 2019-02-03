import io.github.tomdw.jpms.versions.samples.basicapplication.microphone.api.Microphone;
import io.github.tomdw.jpms.versions.samples.basicapplication.microphone.internal.SimpleMicrophone;

module io.github.tomdw.jpms.versions.samples.basicapplication.microphone {
	exports io.github.tomdw.jpms.versions.samples.basicapplication.microphone.api;

	provides Microphone with SimpleMicrophone;
}