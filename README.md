# java-modules-versions

Different modules can be compiled packaged at different moments in time. When composing an application the different module jars put on the module-path were not necessarily all compiled against each other. Different versions might be combined and there is no way to detect if they are compatible.

The code in this repository aims to apply semantic version checking to modules that include their version in the module-info.class file and for requires clauses also including that information.

The [Semantic Versions in Java 9 Modules as a Safety-net](https://devcreativity.wordpress.com/2017/12/29/semantic-versions-in-java-9-modules-as-a-safety-net/) blog post describes the approach in detail. 

## Include version info in module-info.class

Make sure semantic version is added to your compiled module.

Use the `--module-version 1.0.0` command line option for the `jar` tool. Then the `Module.getDescriptor().version()` will return a non-emtpy value.

## Incude version info in requires clause of module-info.class

Make sure the requiring modules are compiled against a versioned explicit module

When you compile a module against modules including their version in the jar, then the `Requires.compiledVersion()` will include that version.

Note: this **only happens when the required module is an `explicit` module**. For automatic modules including their version this is not added by the compiler.

## Listing version information

Use `VersionInfo.print()` to output version information available in the deployed modules.

## Validating semantic version compatibility

Use `VersionInfo.validateCompatibility()` to check for modules requiring a specific version if the available module is semantically compatible.

Note: there is the assumption that all versions present are semantic versions which is not necessarily the case.

## Sample application

This code base also includes a sample basicapplication. 

### Running the compatible module path

Execute the following command in the `compatiblemodulepath` directory:

```
mvn toolchains:toolchain exec:exec
```

All version information will be printed to the console and validation of compatibility will succeed.

### Running the incompatible module path

Execute the following command in the `incompatiblemodulepath` directory:

```
mvn toolchains:toolchain exec:exec
```

All version information will be printed to the console and validation of compatibility will fail because module `microphone` of version 2.0.0 is deployed while 1.0.0 is required.

### Multiple versions of `microphone` to try out

In the `microphone` module 3 versions are available as jar files and will be installed in your local maven repository when building:

- 2.0.0-SNAPSHOT a breaking version
- 1.1.0-SNAPSHOT a feature version
- 1.0.1-SNAPSHOT a bugfix version

By changing the version number in the dependencies of `compatiblemodulepath` or `incompatiblemodulepath` and re-running other versions can be tried out. All but the breaking version should result in a compatible run. 