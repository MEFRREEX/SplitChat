package theoni.splitchat;

import cn.nukkit.command.Command;
import cn.nukkit.event.Listener;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.plugin.PluginManager;
import theoni.splitchat.listener.*;
import theoni.splitchat.commands.*;

public class Main extends PluginBase implements Listener {

    public void onEnable() {
        this.saveDefaultConfig();
        this.saveResource("messages.yml");

        this.getServer().getPluginManager().registerEvents((Listener)new EventListener(this), (Main)this);
        this.checkChatPlugin();
    }

    public void checkChatPlugin() {
        PluginManager mgr = this.getServer().getPluginManager();
        if (mgr.getPlugin("LuckChat") != null) {
            this.getServer().getLogger().warning("If you are using LuckChat for the chat format for the plugin to work properly, go to config.yml and change the ChatAsync parameter to false");
            this.getServer().getCommandMap().register("help", (Command) new LocalSpyCommand(this));
        }
    }
}
