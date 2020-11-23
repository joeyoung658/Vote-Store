package Origin.Voting.Data;

import Origin.Voting.Main;

import java.io.File;
import java.util.logging.Level;

public class createDataFolder {
    public static void createDataFolder(String foldername){
        File folder = new File(Main.instance.getDataFolder() + File.separator + foldername);
        if (!folder.exists()) {
            Main.instance.getLogger().log(Level.INFO, "Creating " +foldername + " Folder!");
            try {
                folder.mkdir();
            } catch (SecurityException e) {
                Main.instance.getLogger().log(Level.SEVERE, "Could not create new " + foldername + " folder");
                e.printStackTrace();
            }
        }
        return;
    }
}