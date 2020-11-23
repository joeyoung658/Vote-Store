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

public class backCmd implements StoreCommandInterface
{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd,
                             String commandLabel, String[] args) {
        Player player = (Player) sender;
        if(args.length > 1) return false;
        String commandName = "back";
        String permission = "<FP>.back";
        StorePurchase storePurchase = new StorePurchase();
        storePurchase.purchaseCommand(player,commandName,permission);
        return false;
    }

}
