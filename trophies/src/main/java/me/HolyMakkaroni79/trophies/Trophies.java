package me.HolyMakkaroni79.trophies;

import me.HolyMakkaroni79.trophies.commands.InventoryOpener;
import me.HolyMakkaroni79.trophies.inventory.CustomInventory;
import me.HolyMakkaroni79.trophies.items.RewardSystem;
import me.HolyMakkaroni79.trophies.listeners.advancementListener.LodeStoneListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Trophies extends JavaPlugin {

    private CustomInventory customInventory;
    private RewardSystem rewardSystem;

    @Override
    public void onEnable() {
        customInventory = new CustomInventory(this);
        getServer().getPluginManager().registerEvents(customInventory, this);

        rewardSystem = new RewardSystem(this);

        getCommand("trophy").setExecutor(new InventoryOpener(this));
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public CustomInventory getCustomInventory() {
        return customInventory;
    }

    public RewardSystem getRewardSystem(){
        return rewardSystem;
    }
}
