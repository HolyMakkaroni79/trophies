package me.HolyMakkaroni79.trophies.commands;

import me.HolyMakkaroni79.trophies.Trophies;
import me.HolyMakkaroni79.trophies.inventory.CustomInventory;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class InventoryOpener implements CommandExecutor {

    private final Trophies plugin;
    public InventoryOpener (Trophies plugin){
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
            Player player = (Player) commandSender;
            plugin.getCustomInventory().openInventory(player);
        }
        else{
            commandSender.sendMessage(ChatColor.RED + "You have to be a player!");
        }
        return false;
    }
}
