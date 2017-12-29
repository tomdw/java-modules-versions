package be.tomdewolf.jpms.version.info.api;

import be.tomdewolf.jpms.version.info.internal.ModuleCompatibilityValidator;
import be.tomdewolf.jpms.version.info.internal.requires.ModuleRequiresVersionInfoCollector;
import be.tomdewolf.jpms.version.info.internal.module.ModuleVersionInfoCollector;

public class VersionInfo {

	public static void printFor(ModuleLayer moduleLayer) {
		System.out.println("");
		System.out.println("--------------------------------------------------------------");
		System.out.println("Version information for modules in layer '" + moduleLayer + "'");
		System.out.println("--------------------------------------------------------------");
		ModuleVersionInfoCollector.list(moduleLayer).stream()
				.forEach(moduleVersion -> System.out.println(moduleVersion));

		System.out.println("---------------------------------------------------------------");
		System.out.println("Version information for requires in layer '" + moduleLayer + "'");
		System.out.println("---------------------------------------------------------------");
		moduleLayer.modules().stream().forEach(module ->
				ModuleRequiresVersionInfoCollector.list(module).stream()
						.forEach(moduleRequiresVersion -> System.out.println(moduleRequiresVersion))
		);
		System.out.println("---------------------------------------------------------------");
		System.out.println("");
	}

	public static void print() {
		printFor(ModuleLayer.boot());
	}

	public static void validateCompatibility(ModuleLayer moduleLayer) {
		System.out.println("");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("Validating module compatibility for modules in layer " + moduleLayer);
		System.out.println("-------------------------------------------------------------------");
		ModuleCompatibilityValidator.validate(moduleLayer);
		System.out.println("Validated that modules are compatible");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("");
	}

	public static void validateCompatibility() {
		validateCompatibility(ModuleLayer.boot());
	}
}
