package Origin.Voting.Commands.Store.Commands;

import Origin.Voting.Commands.Store.StoreCommandInterface;
import Origin.Voting.Commands.Store.StorePurchase;
import Origin.Voting.TNE.balance;
import net.tnemc.core.TNE;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.math.BigDecimal;

public class togglekeepinvenCmd  implements StoreCommandInterface
{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd,
                             String commandLabel, String[] args) {
        Player p = (Player) sender;

        //We don't have to check if the args length is equal to one, but you will have to check if it is greater than 1.
        if(args.length > 1) return false;
        String commandName = "togglekeepinven";
        String permission = "<FP>.keepinven";
        StorePurchase storePurchase = new StorePurchase();
        storePurchase.purchaseCommand(p,commandName,permission);
        return false;
    }

}
