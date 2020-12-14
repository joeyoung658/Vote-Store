package Origin.Voting.Commands.Store.Commands;

import Origin.Voting.Commands.Store.StoreCommandInterface;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class helpCmd implements StoreCommandInterface {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd,
                             String commandLabel, String[] args) {
        Player player = (Player) sender;


        if(args.length > 1) return false;

        player.sendMessage(ChatColor.GREEN + "          All Ace Store commands");
        player.sendMessage(ChatColor.RED + "-------------------------------------------------");
        player.sendMessage(ChatColor.AQUA + "> " + ChatColor.LIGHT_PURPLE + "/store home - 10 Chips");
        player.sendMessage(ChatColor.AQUA + "> " + ChatColor.LIGHT_PURPLE +  "/store land - 100 Chips");
        player.sendMessage(ChatColor.AQUA + "> " + ChatColor.LIGHT_PURPLE +  "/store craftingtable - 25 Chips");
        player.sendMessage(ChatColor.AQUA + "> " + ChatColor.LIGHT_PURPLE +  "/store nickname - 25 Chips");
        player.sendMessage(ChatColor.AQUA + "> " + ChatColor.LIGHT_PURPLE +  "/store hat - 25 Chips");
        player.sendMessage(ChatColor.AQUA + "> " + ChatColor.LIGHT_PURPLE +  "/store prefix - 25 Chips");
        player.sendMessage(ChatColor.AQUA + "> " + ChatColor.LIGHT_PURPLE +  "/store tpskip - 100 Chips");
        player.sendMessage(ChatColor.AQUA + "> " + ChatColor.LIGHT_PURPLE +  "/store togglekeepexp - 150 Chips");
        player.sendMessage(ChatColor.AQUA + "> " + ChatColor.LIGHT_PURPLE +  "/store togglekeepinven - 500 Chips");
        player.sendMessage(ChatColor.AQUA + "> " + ChatColor.LIGHT_PURPLE +  "/store colours - 25 Chips");
        player.sendMessage(ChatColor.AQUA + "> " + ChatColor.LIGHT_PURPLE +  "/store enderchest - 300 Chips");
        player.sendMessage(ChatColor.AQUA + "> " + ChatColor.LIGHT_PURPLE +  "/store back - 500 Chips");
        player.sendMessage(ChatColor.GREEN + "For more information go to here - ");
        player.sendMessage(ChatColor.RED + "-------------------------------------------------");
        return false;
    }
}
