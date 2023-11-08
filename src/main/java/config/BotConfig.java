package config;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//TODO: уточнить у братана, нужно ли делать класс неизменяемым, если я правильно понял аннотацию
@Data
public class BotConfig {

    private final static String PARENT_DIR_PATH = "src/main/resources/";
    public final static String botName;
    public final static String botToken;
    private static final Properties properties = new Properties();
    static {
        try (FileInputStream input = new FileInputStream(PARENT_DIR_PATH + "application.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        botName = properties.getProperty("botname");
        botToken = properties.getProperty("bottoken");
    }
}
