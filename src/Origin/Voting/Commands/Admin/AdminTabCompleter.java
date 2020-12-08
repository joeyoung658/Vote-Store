package Origin.Voting.Commands.Admin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.List;

public class AdminTabCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String s, String[] args) {

        if (cmd.getName().equalsIgnoreCase("avote")){
            if ((sender instanceof Player) && (args.length == 1)){
                AdminCommandHandler StoreCommands = new AdminCommandHandler();
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
