package ru.mor.iv.mineblocker.permission;

import java.io.File;

import ru.mor.iv.mineblocker.MineBlockerPlugin;
import ru.mor.iv.mineblocker.config.Config;
import ru.mor.iv.mineblocker.config.ConfigManager;

public class PermissionsFolder implements Config {

	private MineBlockerPlugin plugin;

	private File folder = new File(plugin.getDataFolder(), "permissions");
	private PermissionsFile[] permissionsFiles;

	public PermissionsFolder() {
		plugin = MineBlockerPlugin.getInstance();
	}

	@Override
	public void load() {
		File[] folderFiles = folder.listFiles();
		PermissionsFile[] array = new PermissionsFile[folderFiles.length];
		int z = 0;
		for (int i = 0; i < folderFiles.length; i++) {
			PermissionsFile file = new PermissionsFile("permissions/" + folderFiles[i].getName());
			if(file.required()) {
				array[i] = file;
				z++;
			}
		}
		permissionsFiles = new PermissionsFile[z];
		int x = 0;
		for (int i = 0; i < array.length; i++) {
			if(array[i] != null) {
				permissionsFiles[x] = array[i];
				x++;
			}
		}
	}

	@Override
	public boolean hasEverything() {
		return !folder.exists() || folder.listFiles().length == 0;
	}

	@Override
	public void createDefault() {
		if (!folder.exists()) {
			folder.mkdirs();
		}
		ConfigManager manager = new ConfigManager(plugin);
		manager.prepareFile("permissions/default-permissions-list.yml");
	}

	@Override
	public void reload() {
		permissionsFiles = null;
		load();
	}

	@Override
	public void save() {
		for (int i = 0; i < permissionsFiles.length; i++) {
			permissionsFiles[i].save();
		}
	}
}
