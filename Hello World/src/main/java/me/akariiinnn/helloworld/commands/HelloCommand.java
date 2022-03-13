package me.akariiinnn.helloworld.commands;

import me.akariiinnn.helloworld.Main;
import me.akariiinnn.helloworld.libs.Library;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelloCommand implements CommandExecutor {

    private Main plugin;

    public HelloCommand(Main plugin){
        this.plugin = plugin;
        plugin.getCommand("hello").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage(Library.consolerestraint);
            return true;
        }

        Player p = (Player) sender;

        if(p.hasPermission("hello.use")){
            p.sendMessage("Hi !");
            return true;
        } else {
            p.sendMessage(Library.playerperms);
        }
        return false;
    }
}
