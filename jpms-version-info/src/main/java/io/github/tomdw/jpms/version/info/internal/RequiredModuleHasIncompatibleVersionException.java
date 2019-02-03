package io.github.tomdw.jpms.version.info.internal;

import io.github.tomdw.jpms.version.info.internal.module.ModuleVersion;
import io.github.tomdw.jpms.version.info.internal.requires.ModuleRequiresVersion;

public class RequiredModuleHasIncompatibleVersionException extends RuntimeException {
	public RequiredModuleHasIncompatibleVersionException(ModuleVersion availableModule, ModuleRequiresVersion moduleRequiresVersion) {
		super(availableModule + " is not compatible with required version " + moduleRequiresVersion.getRequiredVersionAsString());
	}
}
