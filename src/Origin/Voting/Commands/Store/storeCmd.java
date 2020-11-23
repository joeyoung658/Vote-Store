package Origin.Voting.Commands.Store;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class storeCmd implements StoreCommandInterface
{

    //The command should be automatically created.
    @Override
    public boolean onCommand(CommandSender sender, Command cmd,
                             String commandLabel, String[] args) {
        Player player = (Player) sender;
        player.sendMessage(ChatColor.AQUA + "-=-=-=-=-=-=-=-=-=-" + ChatColor.RED + "AllAce Store" + ChatColor.AQUA + "-=-=-=-=-=-=-=-=-=-=-=-");
        player.sendMessage(ChatColor.GOLD + "Type " + ChatColor.RED  + "/buy "  + ChatColor.GOLD + "if you're looking to buy a rank or more chips!"  );
        player.sendMessage(ChatColor.RED +  "Type /store [help] for all the goodies you're able to buy with your chips!");
        player.sendMessage("Did you know that by typing " + ChatColor.GREEN + "/vote" + ChatColor.RESET + " and following the links, you can earn chips?"  );
        player.sendMessage(ChatColor.AQUA + "-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-");
        return false;
    }

}
