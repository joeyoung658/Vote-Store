package Origin.Voting.Commands.Admin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class adminCmd implements AdminCommandInterface
{

    //The command should be automatically created.
    @Override
    public boolean onCommand(CommandSender sender, Command cmd,
                             String commandLabel, String[] args) {
       sender.sendMessage(ChatColor.AQUA + "-=-=-=-=-=-=-=-=-=-" + ChatColor.RED + "AllAce Admin Store" + ChatColor.AQUA + "-=-=-=-=-=-=-=-=-=-=-=-");
       sender.sendMessage(ChatColor.AQUA + "Admin Vote commands - Please note this will not change eCoin Balance");
       sender.sendMessage(ChatColor.LIGHT_PURPLE + "/avote - View help for vote rewards");
       sender.sendMessage(ChatColor.LIGHT_PURPLE + "/avote fakevote [PlayerName]  - Sends a fake vote to the user");
       sender.sendMessage(ChatColor.LIGHT_PURPLE + "/avote check [playername ]- Checks a players vote count");
       sender.sendMessage(ChatColor.LIGHT_PURPLE + "/avote edit [PlayerName] [Vote count] - Edits users votes");
       sender.sendMessage(ChatColor.LIGHT_PURPLE + "/avote offedit [PlayerName] [Vote count] - Edits a user not in the database votes");
       sender.sendMessage(ChatColor.LIGHT_PURPLE + "/avote clear - Clears all votes within database");
       sender.sendMessage(ChatColor.AQUA + "-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-");
        return false;



    }

}
