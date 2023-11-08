package model;

import lombok.Getter;
import lombok.Setter;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class CountryBot extends TelegramLongPollingBot {
    @Getter
    @Setter
    private String botName;
    @Getter
    @Setter
    private String botToken;
    @Override
    public String getBotUsername() {
        return this.botName;
    }
    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            Long chatId = update.getMessage().getChatId();
            String userFirstName = update.getMessage().getChat().getFirstName();

            switch(messageText) {
                case "/start":
                    startCommandReceived(chatId, userFirstName);
                    break;
                default:
                    sendResponseMessage(chatId, "Sorry, command not recognized");
            }
        }
    }

    private void startCommandReceived(long chatId, String userName) {
        System.out.println("Hi, " + userName + "!\nI can give you basic information\nabout any country in the world.\nJust send me a country name in English (like Ukraine)");
    }

    private void sendResponseMessage(long chatId, String messageText) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(messageText);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}
