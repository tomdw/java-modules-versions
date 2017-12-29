package be.tomdewolf.jpms.version.info.internal.requires;

import java.util.List;
import java.util.stream.Collectors;

public class ModuleRequiresVersionInfoCollector {

	public static List<ModuleRequiresVersion> list(Module module) {
		return module.getDescriptor().requires().stream()
				.filter(ModuleRequiresVersion::hasVersion)
				.map(requires -> ModuleRequiresVersion.of(module, requires))
				.collect(Collectors.toList());
	}

}
