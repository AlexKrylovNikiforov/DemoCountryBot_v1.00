package builder;

import config.BotConfig;
import model.CountryBot;

public class BotBuilder implements Builder{

    private CountryBot bot = new CountryBot();

    public CountryBot build() {
        return bot;
    }

    public BotBuilder name () {
        bot.setBotName(BotConfig.botName);
        return this;
    }

    public BotBuilder token () {
        bot.setBotToken(BotConfig.botToken);
        return this;
    }
}
