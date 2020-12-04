package Origin.Voting.Commands.Store.Commands;

import Origin.Voting.Commands.Store.StoreCommandInterface;
import Origin.Voting.TNE.balance;
import net.tnemc.core.TNE;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.math.BigDecimal;

public class homeCmd implements StoreCommandInterface
{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd,
                             String commandLabel, String[] args) {


        //We don't have to check if the args length is equal to one, but you will have to check if it is greater than 1.
        if(args.length > 1) return false;

        Player p = (Player) sender;
        BigDecimal cost = new BigDecimal(10);
        Boolean funds = balance.reduceToBal(p, cost);
        if (funds){
            String command = "ahome increase " + p.getName() +  " 1";
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
            p.sendMessage(ChatColor.AQUA + "You've purchased a home for" + ChatColor.DARK_RED +  "10 eCoins");
        } else {
            BigDecimal bal = TNE.instance().api().getAccount(p.getUniqueId()).getHoldings();
            p.sendMessage(ChatColor.RED + "You have insufficient eCoin balance of " + bal.toString()+ "!");
        }
        return false;
    }

}
