package io.github.slazurin.slplayerteleportation.commands;

import io.github.slazurin.slplayerteleportation.SLPlayerTeleportation;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.awt.*;

public class PlayerTeleportationCommands implements CommandExecutor {

    // private SLPlayerTeleportation plugin;

    public PlayerTeleportationCommands(SLPlayerTeleportation plugin) {
        // this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("Only players may use this command!");
            return true;
        }

        switch(command.getName()) {
            case "pp":
                return pp(commandSender, s, args);
            default:
                commandSender.sendMessage(Color.RED + "PlayerTeleportation: Command mismatch!");
                return true;
        }
    }

    private boolean pp(CommandSender commandSender, String s, String[] args) {
        if (args.length != 1) {
            // commandSender.sendMessage("PlayerTeleportation: Requires 1 player name only.");
            // Return false will display the command usage in plugin.yml
            return false;
        }
        Player destinationPlayer = Bukkit.getServer().getPlayer(args[0]);
        if (destinationPlayer == null || !(destinationPlayer.isOnline())) {
            commandSender.sendMessage(ChatColor.RED + args[0] + " is not online.");
            return true;
        }
        Player sourcePlayer = (Player) commandSender;
        if (!sourcePlayer.hasPermission("playerteleportation.pp")) {
            commandSender.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
            return true;
        }
        sourcePlayer.teleport(destinationPlayer.getLocation());
        return true;
    }
}
