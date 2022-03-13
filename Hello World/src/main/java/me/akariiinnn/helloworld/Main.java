package me.akariiinnn.helloworld;
import me.akariiinnn.helloworld.commands.*;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable(){
    new HelloCommand(this);
    new BurnCommand(this);
    new FlyCommand(this);
    new CraftCommand(this);
    new HorseCommand(this);
    }
}