package me.HolyMakkaroni79.trophies.commands;

import me.HolyMakkaroni79.trophies.SpecialTrophies.CommandTrophies.HalloweenTrophy;
import me.HolyMakkaroni79.trophies.Trophies;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class getTrophy implements CommandExecutor {

    HalloweenTrophy halloweenTrophy = new HalloweenTrophy();

    List<String> trophy = new ArrayList<>();

    public void test() {
        trophy.add("wow");
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        boolean foundPlayer = false;
        Player player;
        if (commandSender.hasPermission("trophy_mod")) {
            if (command.getName().equalsIgnoreCase("getTrophy")) {
                if (strings.length == 2) {
                    for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                        if (onlinePlayer.getName().equals(strings[0])) {
                            foundPlayer = true;
                            player = Bukkit.getServer().getPlayer(strings[0]);
                            if (foundPlayer == true) {
                                if (strings[1].equalsIgnoreCase("Halloween")) {
                                    halloweenTrophy.getTrophy(player);
                                    return true;
                                }
                            } else {
                                commandSender.sendMessage(ChatColor.RED + "Found no player");
                                return false;
                            }
                        }
                    }

                }
            }
        }
        return false;
    }
}
