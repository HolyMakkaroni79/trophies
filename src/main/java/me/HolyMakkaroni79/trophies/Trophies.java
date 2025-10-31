package me.HolyMakkaroni79.trophies;

import me.HolyMakkaroni79.trophies.commands.TabCompleter;
import me.HolyMakkaroni79.trophies.commands.getTrophy;
import me.HolyMakkaroni79.trophies.listeners.advancementListener.ElytraListener;
import me.HolyMakkaroni79.trophies.listeners.advancementListener.FreeTheEndListener;
import me.HolyMakkaroni79.trophies.listeners.advancementListener.GateWayListener;
import me.HolyMakkaroni79.trophies.listeners.advancementListener.LodeStoneListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Trophies extends JavaPlugin {

    private static Trophies instance;
    @Override
    public void onEnable() {
        // Plugin startup logic
        PluginManager pluginManager = Bukkit.getPluginManager();
        //pluginManager.registerEvents(new LodeStoneListener(), this);
        pluginManager.registerEvents(new FreeTheEndListener(), this);
        pluginManager.registerEvents(new GateWayListener(), this);
        pluginManager.registerEvents(new ElytraListener(), this);

        getCommand("getTrophy").setExecutor(new getTrophy());
        getCommand("getTrophy").setTabCompleter(new TabCompleter());

        instance = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Trophies getInstance(){
        return instance;
    }
}
