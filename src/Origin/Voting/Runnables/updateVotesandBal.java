package Origin.Voting.Runnables;

import Origin.Voting.Main;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.math.BigDecimal;

import static Origin.Voting.TNE.balance.addToBal;

public class updateVotesandBal extends BukkitRunnable {

    Main plugin;
    Player player;
    BigDecimal voteCoinReward;
    int vote;
    public updateVotesandBal(Main plugin, Player player, BigDecimal voteReward, int vote){
        this.plugin = plugin;
        this.player = player;
        this.voteCoinReward = voteReward;
        this.vote = vote;
    }

    @Override
    public void run() {
        //Updates Balance in TNE
        addToBal(player, voteCoinReward);

        if (Main.votec.containsKey(player.getUniqueId())){
            Main.votec.put(player.getUniqueId(), Main.votec.get(player.getUniqueId()) + vote);
        } else {
            Main.votec.put(player.getUniqueId(), vote);
        }
    }
}
