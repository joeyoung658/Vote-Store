package Origin.Voting.Commands;

import net.tnemc.core.TNE;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class myChips implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
        Player player = (Player) sender;
        if (alias.equalsIgnoreCase("chips")) {
            player.sendMessage(ChatColor.AQUA + "You have " + ChatColor.GREEN + TNE.instance().api().getAccount(player.getUniqueId()).getHoldings().toString() + ChatColor.AQUA  + " chips!");
        }
        return true;
    }

}
