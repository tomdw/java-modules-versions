package io.github.tomdw.jpms.version.info.internal.module;

import java.lang.module.ModuleDescriptor.Version;

public final class ModuleVersion {

	private final String moduleName;
	private final Version moduleVersion;

	private ModuleVersion(String moduleName, Version version) {
		assert moduleName != null;
		assert version != null;
		this.moduleName = moduleName;
		this.moduleVersion = version;
	}

	public static boolean hasVersion(Module module) {
		return module.getDescriptor().version().isPresent();
	}
	public static ModuleVersion of(Module module) {
		if (hasVersion(module)) {
			return new ModuleVersion(module.getName(), module.getDescriptor().version().get());
		} else {
			throw new ModuleVersionRequiresVersionedModuleException(module);
		}
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "[name=" + moduleName + ", version=" + moduleVersion + "]";
	}

	public String getVersionAsString() {
		return moduleVersion.toString();
	}
}
