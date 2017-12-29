package be.tomdewolf.jpms.version.info.internal.module;

import java.util.List;
import java.util.stream.Collectors;

public class ModuleVersionInfoCollector {

	public static List<ModuleVersion> list(ModuleLayer layer) {
		return layer.modules().stream()
				.filter(ModuleVersion::hasVersion)
				.map(module -> ModuleVersion.of(module))
				.collect(Collectors.toList());
	}
}
