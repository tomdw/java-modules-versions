package be.tomdewolf.jpms.version.info.internal;

import be.tomdewolf.jpms.version.info.internal.module.ModuleVersion;
import be.tomdewolf.jpms.version.info.internal.requires.ModuleRequiresVersion;

public class RequiredModuleHasIncompatibleVersionException extends RuntimeException {
	public RequiredModuleHasIncompatibleVersionException(ModuleVersion availableModule, ModuleRequiresVersion moduleRequiresVersion) {
		super(availableModule + " is not compatible with required version " + moduleRequiresVersion.getRequiredVersionAsString());
	}
}
