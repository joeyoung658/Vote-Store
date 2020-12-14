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

public class landCmd implements StoreCommandInterface {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {



        if(args.length > 1) return false;
        Player p = (Player) sender;
        BigDecimal cost = new BigDecimal(100);
        Boolean funds = balance.reduceToBal(p, cost);
        if (funds){
            String command = "acb " + p.getName() +  " 1000";
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
            p.sendMessage(ChatColor.AQUA + "You've purchased a 1000 land for" + ChatColor.DARK_RED +  "100 chips");
        } else {
            BigDecimal bal = TNE.instance().api().getAccount(p.getUniqueId()).getHoldings();
            p.sendMessage(ChatColor.RED + "You have insufficient chip balance of " + bal.toString()+ "!");
        }



        return false;
    }
}
