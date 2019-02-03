package io.github.tomdw.jpms.version.info.internal.module;

public class ModuleVersionRequiresVersionedModuleException extends RuntimeException {

	public ModuleVersionRequiresVersionedModuleException(Module module) {
		super(module.getName() + " has no version");
	}
}
