package Origin.Voting.Runnables;

import Origin.Voting.Main;
import org.bukkit.scheduler.BukkitRunnable;

import static Origin.Voting.Data.Votes.saveVotes.saveVotes;

public class saveVotes extends BukkitRunnable {

    Main plugin;
    public saveVotes(Main plugin){
        this.plugin = plugin;
    }

    @Override
    public void run() {
        saveVotes();
    }
}
