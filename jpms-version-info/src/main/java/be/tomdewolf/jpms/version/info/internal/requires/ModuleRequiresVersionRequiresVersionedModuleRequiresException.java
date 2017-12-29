package be.tomdewolf.jpms.version.info.internal.requires;

import java.lang.module.ModuleDescriptor;

public class ModuleRequiresVersionRequiresVersionedModuleRequiresException extends RuntimeException {
	public ModuleRequiresVersionRequiresVersionedModuleRequiresException(Module module, ModuleDescriptor.Requires requires) {
		super("module " + module.getName() + " requires " + requires.name() + " without a version");
	}
}
