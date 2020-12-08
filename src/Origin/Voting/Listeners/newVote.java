package Origin.Voting.Listeners;

import Origin.Voting.Main;
import com.vexsoftware.votifier.model.Vote;
import com.vexsoftware.votifier.model.VotifierEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;

import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;

import static Origin.Voting.TNE.balance.addToBal;

public class newVote {

    @EventHandler(priority= EventPriority.NORMAL)
    public void onVotifierEvent(VotifierEvent event) {
        Vote v = event.getVote();
        Player player = Bukkit.getServer().getPlayer(v.getUsername()); //sets player as the voter
        Player target = Bukkit.getPlayerExact(v.getUsername()); //sets player as target

        if (!(target == null)) { //Checks if player is online
            Bukkit.broadcastMessage(target.getDisplayName() + ChatColor.RED + " has voted @ " + ChatColor.GREEN + v.getServiceName()
                    + ChatColor.RED + " Type " + ChatColor.GREEN + "/vote " + ChatColor.RED + "to find out how to vote!");

            BigDecimal voteReward = new BigDecimal(1);
            addToBal(player,voteReward);
            coinRewardMessage(target, 1);
            luckyVote(target);

        } else { //If player is not online
            Main.instance.getLogger().info(v.getUsername() + " was not online so no rewards were given.");
        }
    }

    private void luckyVote (Player player){
        Integer coins = 0;
        if (ThreadLocalRandom.current().nextInt(100) == 5) {
            coins = 50;
        }
        if (ThreadLocalRandom.current().nextInt(500) == 5) {
            coins = 100;
        }
        if (ThreadLocalRandom.current().nextInt(1000) == 5) {
            coins = 1000;
        }
        if (coins == 0) {
            return;
        } else {
            Bukkit.broadcastMessage(player.getDisplayName() + ChatColor.GOLD + " was extra lucky and received " + ChatColor.GREEN +  coins.toString()   +
                    " chips!");
            BigDecimal luckyVoteReward = new BigDecimal(coins);

            addToBal(player,luckyVoteReward);

            coinRewardMessage(player, coins);
            return;
        }
    }

    public static void coinRewardMessage(Player player, Integer coins) {
        player.sendMessage(ChatColor.DARK_RED + "You have received " + ChatColor.AQUA + coins.toString() + " chips"+ ChatColor.DARK_RED + ", which can be spent on in game perks!");
        return;
    }

}
