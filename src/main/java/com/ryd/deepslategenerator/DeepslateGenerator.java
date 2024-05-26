package com.ryd.deepslategenerator;

import com.ryd.deepslategenerator.events.GeneratorListener;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class DeepslateGenerator extends JavaPlugin {
    FileConfiguration config = getConfig();

    @Override
    public void onEnable() {
        config.addDefault("y-level", 15);
        config.options().copyDefaults(true);
        saveConfig();

        getServer().getPluginManager().registerEvents(new GeneratorListener(config), this);
    }
}
