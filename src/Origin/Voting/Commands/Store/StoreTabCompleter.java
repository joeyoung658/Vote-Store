package Origin.Voting.Commands.Store;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.List;



//todo https://bukkit.org/threads/easy-no-api-setting-up-custom-tab-completion.299956/


public class StoreTabCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String s, String[] args) {

        if (cmd.getName().equalsIgnoreCase("store")){
            if ((sender instanceof Player) && (args.length == 1)){
                StoreCommandHandler StoreCommands = new StoreCommandHandler();
                List<String> newList = StoreCommands.getCommands();
                if (newList.isEmpty()){
                    return null;
                } else {
                    return newList;
                }
            }
        }
        return null;
    }
}
