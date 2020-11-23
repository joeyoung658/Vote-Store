package Origin.Voting.Data.Votes;

import Origin.Voting.Main;

public class saveVotes {
    public static void saveVotes() {
        for(String vote : Main.votec.keySet()) {
            int value = Main.votec.get(vote);
            Main.instance.getConfig().set("votec." + vote, value);
        }
        Main.instance.getConfig();
        Main.instance.getLogger().info("Votes saved to file");

    }
}
