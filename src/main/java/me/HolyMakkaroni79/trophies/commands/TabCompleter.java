package me.HolyMakkaroni79.trophies.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TabCompleter implements org.bukkit.command.TabCompleter {
    private final List<String> aktionen = List.of("Halloween");

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] args) {
        // /meincommand <tab>
        if (args.length == 1) {
            List<String> completions = new ArrayList<>();

            // 1. Online-Spieler
            completions.addAll(Bukkit.getOnlinePlayers().stream()
                    .map(Player::getName)
                    .filter(name -> name.toLowerCase().startsWith(args[0].toLowerCase()))
                    .toList());

            // 2. Mojang Target Selektoren
            List<String> selectors = List.of("@a", "@p", "@r", "@s", "@e");
            selectors.stream()
                    .filter(sel -> sel.startsWith(args[0].toLowerCase()))
                    .forEach(completions::add);

            return completions;
        }

        // /meincommand <spieler oder @a> <aktion>
        if (args.length == 2) {
            return aktionen.stream()
                    .filter(a -> a.toLowerCase().startsWith(args[1].toLowerCase()))
                    .toList();
        }

        return List.of();
    }
}
