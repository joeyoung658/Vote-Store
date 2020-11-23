package Origin.Voting.Data.Votes;

import Origin.Voting.Main;

import java.util.HashMap;
import java.util.Set;

public class votesToHash {
    public static void votesToHash(){
        Main.votec = new HashMap<String, Integer>(); //reset the vote
        Main.instance.saveConfig();
        if(Main.instance.getConfig().getConfigurationSection("votec") != null ) {  // runs if the votes have been saved before.
            Set<String> set = Main.instance.getConfig().getConfigurationSection("votec").getKeys(true);
            for(String vote : set) {
                int value = Main.instance.getConfig().getConfigurationSection("votec").getInt(vote);
                Main.votec.put(vote, value);
            }
        }
    }
}