package ru.mor.iv.mineblocker.config;

import java.io.File;

import ru.mor.iv.mineblocker.MineBlockerPlugin;

public abstract class ConfigData implements Config{
	
	protected MineBlockerPlugin plugin = MineBlockerPlugin.getInstance();
	protected static ConfigManager manager;
	protected String configName;
	protected File configFile;
	protected FileHolder config;
	
	public ConfigData(String configName) {
		plugin = MineBlockerPlugin.getInstance();
		if(manager == null)
			manager = new ConfigManager(plugin);
		this.configName = configName;
		this.configFile = manager.getConfigFile(configName);
	}

	public void save() {
		config.saveConfig();
	}

}
