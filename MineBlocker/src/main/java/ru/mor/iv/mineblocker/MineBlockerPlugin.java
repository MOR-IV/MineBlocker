package ru.mor.iv.mineblocker;

import org.bukkit.plugin.java.JavaPlugin;

public class MineBlockerPlugin extends JavaPlugin{
	private static MineBlockerPlugin instance;
	
	public MineBlockerPlugin() {
		instance = this;
	}
	
	@Override
	public void onLoad() {
		
	}
	
	@Override
	public void onEnable() {
		
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public static MineBlockerPlugin getInstance() {
		return instance;
	}
	
}
