package click.dozer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by agorajnov on 16.10.2017.
 */
class Config {
    private static final String CONFIGURATION_BOT_FILE = "./config/bot.properties";
    private static final String CONFIGURATION_DB_FILE = "./config/db.properties";

    static String BOT_NAME;
    static String BOT_TOKEN;

    static String DB_URL;
    static String DB_USER;
    static String DB_PSW;

    static void load(){

        Properties botSetting = new Properties();

        try (InputStream is = new FileInputStream(new File(CONFIGURATION_BOT_FILE))){
            botSetting.load(is);
            System.out.println("Bot config load successfully");
        }catch (IOException e) {
            System.out.println("Error loading bot setting");
        }

        Properties dbSetting = new Properties();
        try (InputStream is = new FileInputStream(new File(CONFIGURATION_DB_FILE))){
            botSetting.load(is);
            System.out.println("DB config load successfully");
        }catch (IOException e) {
            System.out.println("Error loading DB setting");
        }

        BOT_NAME = botSetting.getProperty("BotName", "BehterevaMskBot");
        BOT_TOKEN = botSetting.getProperty("BotToken", "455563688:AAEolV7o_xq7Dg6kYPvXrpGVitRTKbxLuZA");
        DB_URL = dbSetting.getProperty("dbURL", "jdbc:sqlite:./main/resources/db_ankil.db");
        DB_USER = dbSetting.getProperty("dbUser", "dozer");
        DB_PSW = dbSetting.getProperty("dbPSW", "root");
    }



}
