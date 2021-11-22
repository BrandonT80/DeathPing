package bct.loadupstudios.DeathPing;


import org.bukkit.configuration.file.FileConfiguration;

import org.bukkit.plugin.java.JavaPlugin;


public class DeathPing extends JavaPlugin 
{
	FileConfiguration config = this.getConfig();
	MyListener eventManager = new MyListener(config);
	
	@Override
    public void onEnable() 
    {
		 // TODO Insert logic to be performed when the plugin is enabled
    	//System.out.println("MineTracker: Enabling...");
		saveDefaultConfig();
		getServer().getPluginManager().registerEvents(eventManager, this);
    }
	
	public void onDisable() 
    {
        // TODO Insert logic to be performed when the plugin is disabled
		//saveConfig();
		//System.out.println("[DeathPing] Disabling...");
		//System.out.println("[DeathPing] Removing Player Data...");
    }
	
}
