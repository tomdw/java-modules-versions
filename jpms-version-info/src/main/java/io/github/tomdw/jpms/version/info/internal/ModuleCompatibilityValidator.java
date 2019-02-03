package io.github.tomdw.jpms.version.info.internal;

import io.github.tomdw.jpms.version.info.internal.module.ModuleVersion;
import io.github.tomdw.jpms.version.info.internal.requires.ModuleRequiresVersionInfoCollector;

public class ModuleCompatibilityValidator {

	public static void validate(ModuleLayer moduleLayer) {
		moduleLayer.modules().forEach(module -> {
			ModuleRequiresVersionInfoCollector.list(module).stream().forEach(moduleRequiresVersion -> {
				System.out.println("Validating " + moduleRequiresVersion);
				moduleLayer.findModule(moduleRequiresVersion.getRequiredModuleName()).ifPresentOrElse(
						availableModule -> {
							if (ModuleVersion.hasVersion(availableModule)) {
								if (!moduleRequiresVersion.isSatifiedWith(ModuleVersion.of(availableModule))) {
									System.out.println("Module " + ModuleVersion.of(availableModule) + " is NOT compatible with required version " + moduleRequiresVersion.getRequiredVersionAsString());
									throw new RequiredModuleHasIncompatibleVersionException(ModuleVersion.of(availableModule), moduleRequiresVersion);
								} else {
									System.out.println("Module " + ModuleVersion.of(availableModule) + " is compatible with required version " + moduleRequiresVersion.getRequiredVersionAsString());
								}
							} else {
								System.out.println("WARNING required " + moduleRequiresVersion + " is using matching module without a version, no guarantees on compatibility");
							}
							},
						() -> {
							throw new RequiredModuleNotAvailableException(moduleRequiresVersion.getRequiredModuleName());
						}
				);
			});
		});
	}
}
