package org.to2mbn.jmccc.launch;

/**
 * Builder for {@link Launcher} instances.
 * 
 * @author yushijinhun
 */
public class LauncherBuilder {

	/**
	 * Creates a <code>LauncherBuilder</code>.
	 * 
	 * @return a <code>LauncherBuilder</code> object
	 */
	public static LauncherBuilder create() {
		return new LauncherBuilder();
	}

	private boolean nativeFastCheck = false;

	protected LauncherBuilder() {
	}

	/**
	 * Sets whether to do a fast check on natives.
	 * <p>
	 * By default, this feature is off. In this case, when decompressing natives,
	 * jmccc will fully compare the existing natives and the natives in jars. If, and only if,
	 * a existing native is modified, jmccc will replace it. Because replacing a native in use
	 * may cause the running JVM to crash.<br>
	 * If the feature is on, jmccc won't compare the full content of natives.
	 * Jmccc only compares the sizes. This can improve the launching speed.
	 * But we cannot ensure the content of the natives are correct.
	 * 
	 * @param nativeFastCheck true to let jmccc do a fast check on natives
	 * @return the builder itself
	 */
	public LauncherBuilder setNativeFastCheck(boolean nativeFastCheck) {
		this.nativeFastCheck = nativeFastCheck;
		return this;
	}

	/**
	 * Creates a Launcher object according to the configurations.
	 * 
	 * @return a Launcher object
	 */
	public Launcher build() {
		Jmccc launcher = new Jmccc();
		launcher.setNativeFastCheck(nativeFastCheck);
		return launcher;
	}

}
