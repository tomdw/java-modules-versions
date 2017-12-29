package be.tomdewolf.jpms.version.info.internal.requires;

import java.lang.module.ModuleDescriptor.Requires;
import java.lang.module.ModuleDescriptor.Version;

import be.tomdewolf.jpms.version.info.internal.module.ModuleVersion;

public class ModuleRequiresVersion {

	private final String requiringModuleName;
	private final String requiredModuleName;
	private final Version requiredVersion;

	private ModuleRequiresVersion(String requiringModuleName, String requiredModuleName, Version requiredVersion) {
		assert requiringModuleName != null;
		assert requiredModuleName != null;
		assert requiredVersion != null;
		this.requiringModuleName = requiringModuleName;
		this.requiredModuleName = requiredModuleName;
		this.requiredVersion = requiredVersion;
	}

	static boolean hasVersion(Requires requires) {
		return requires.compiledVersion().isPresent();
	}

	static ModuleRequiresVersion of(Module module, Requires requires) {
		if (hasVersion(requires)) {
			return new ModuleRequiresVersion(module.getName(), requires.name(), requires.compiledVersion().get());
		} else {
			throw new ModuleRequiresVersionRequiresVersionedModuleRequiresException(module, requires);
		}
	}

	public String getRequiredModuleName() {
		return requiredModuleName;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "[requiringModule=" + requiringModuleName + ", requiredModule=" + requiredModuleName + ", version=" + requiredVersion + "]";
	}

	public boolean isSatifiedWith(ModuleVersion moduleVersion) {
		return SemanticVersion.of(moduleVersion).isBackwardsCompatibleWith(SemanticVersion.of(this));
	}

	public String getRequiredVersionAsString() {
		return requiredVersion.toString();
	}
}
