package me.HolyMakkaroni79.trophies;

import me.HolyMakkaroni79.trophies.listeners.advancementListener.LodeStoneListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Trophies extends JavaPlugin {


    @Override
    public void onEnable() {
        // Plugin startup logic
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new LodeStoneListener(), this);    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
