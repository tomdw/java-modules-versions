package be.tomdewolf.jpms.version.info.internal.requires;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import be.tomdewolf.jpms.version.info.internal.module.ModuleVersion;

class SemanticVersion {

	private static final String SEMANTIC_VERSION_PATTERN = "(\\d+)\\.(\\d+)\\.(\\d+)";
	private static Pattern SEMANTIC_VERSION_COMPILED_PATTERN = Pattern.compile(SEMANTIC_VERSION_PATTERN);

	private Integer major;
	private Integer minor;
	private Integer patch;

	private SemanticVersion() {
	}

	private SemanticVersion(Integer major, Integer minor, Integer patch) {
		this.major = major;
		this.minor = minor;
		this.patch = patch;
	}

	private SemanticVersion(String version) {
		String versionToParse = enrichAndClean(version);
		if (!version.equals(versionToParse)) {
			System.out.println("WARNING adapted version " + version + " to " + versionToParse + " for semantic compatibility checking");
		}
		Matcher matcher = SEMANTIC_VERSION_COMPILED_PATTERN.matcher(versionToParse);
		if (!matcher.find()) {
			throw new IllegalArgumentException("Version " + versionToParse + " does not match pattern");
		}

		this.major = Integer.parseInt(matcher.group(1));
		this.minor = Integer.parseInt(matcher.group(2));
		this.patch = Integer.parseInt(matcher.group(3));
	}

	private String enrichAndClean(String version) {
		version = version.replaceFirst("-RELEASE", "");
		version = version.replaceFirst(".RELEASE", "");
		return enrich(version);
	}

	private String enrich(String version) {
		int dotIndex = version.indexOf(".");
		if (dotIndex <= 0) {
			return version + ".0.0";
		} else {
			if (version.indexOf(".", dotIndex + 1) <= 0) {
				return version + ".0";
			} else {
				return version;
			}
		}
	}

	Integer getMajor() {
		return major;
	}

	Integer getMinor() {
		return minor;
	}

	Integer getPatch() {
		return patch;
	}

	boolean isBackwardsCompatibleWith(SemanticVersion expectedVersion) {
		return major == expectedVersion.getMajor() && minor >= expectedVersion.getMinor();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof SemanticVersion))
			return false;
		SemanticVersion that = (SemanticVersion) o;
		return Objects.equals(major, that.major) &&
				Objects.equals(minor, that.minor) &&
				Objects.equals(patch, that.patch);
	}

	@Override
	public int hashCode() {
		return Objects.hash(major, minor, patch);
	}

	@Override
	public String toString() {
		return major + "." + minor + "." + patch;
	}

	static SemanticVersion of(ModuleVersion moduleVersion) {
		return new SemanticVersion(moduleVersion.getVersionAsString());
	}

	static SemanticVersion of(ModuleRequiresVersion moduleRequiresVersion) {
		return new SemanticVersion(moduleRequiresVersion.getRequiredVersionAsString());
	}
}