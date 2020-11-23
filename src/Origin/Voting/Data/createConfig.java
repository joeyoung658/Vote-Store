package Origin.Voting.Data;

import Origin.Voting.Main;

import java.io.File;

import static net.tnemc.core.ConfigurationManager.getDataFolder;


public class createConfig {
        public static void createConfig() { //Creates a config file
            try {
                if (!Main.instance.getDataFolder().exists()) {
                    Main.instance.getDataFolder().mkdirs();
                }
                File file = new File(getDataFolder(), "config.yml");
                if (!file.exists()) {
                    Main.instance.getLogger().info("Config.yml not found, creating!");
                    Main.instance.saveDefaultConfig();

                } else {
                    Main.instance.getLogger().info("Config.yml found, loading!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
