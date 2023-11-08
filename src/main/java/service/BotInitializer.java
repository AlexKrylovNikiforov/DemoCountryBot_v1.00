package service;

import builder.BotBuilder;
import model.CountryBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;


public class BotInitializer {

    CountryBot demoBot = new BotBuilder().name().token().build();

    public void showBot() {
        System.out.println(demoBot.getBotName());
        System.out.println(demoBot.getBotToken());
    }

    public void initBot () throws TelegramApiException {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(demoBot);
            System.out.println("Bot has been started.");
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
