package Origin.Voting.Listeners;

import net.tnemc.core.TNE;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

import java.math.BigDecimal;


public class playerJoinVote implements Listener {
    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) { //Sends message to user when they join the serve
        BigDecimal bigDecimalBal = TNE.instance().api().getAccount(event.getPlayer().getUniqueId()).getHoldings();
        String stringBal = bigDecimalBal.toString();
        event.getPlayer().sendMessage(ChatColor.AQUA + "-=-=-=-=-=-=-=-=-=-" + ChatColor.RED + "All Ace" + ChatColor.AQUA + "-=-=-=-=-=-=-=-=-=-=-");
        event.getPlayer().sendMessage(ChatColor.GOLD + "Welcome! Voting rewards Chips!");
        event.getPlayer().sendMessage("Type " + ChatColor.GREEN + "/vote" + ChatColor.RESET + " and follow the links.");
        event.getPlayer().sendMessage("Your Chip Balance is " + ChatColor.RESET + stringBal);
        event.getPlayer().sendMessage(ChatColor.AQUA + "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    }
}