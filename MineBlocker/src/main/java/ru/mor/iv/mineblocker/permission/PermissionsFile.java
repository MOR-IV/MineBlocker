package ru.mor.iv.mineblocker.permission;

import org.bukkit.configuration.file.YamlConfiguration;

import ru.mor.iv.mineblocker.config.ConfigData;

public class PermissionsFile extends ConfigData {
	
	public PermissionsFile(String configName) {
		super(configName);
	}

	@Override
	public void load() {
	}

	@Override
	public boolean hasEverything() {
		return false;
	}

	@Override
	public void createDefault() {
	}

	@Override
	public void reload() {
	}

	public boolean required() {
		if(!configName.endsWith(".yml")) {
			return false;
		}
		YamlConfiguration config = new YamlConfiguration();
		try {
			config.load(configFile);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	

}
