package com.resliv;


import com.resliv.service.TelegramService;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;


public class Application {
    public static void main(String[] args) {
        ApiContextInitializer.init();

        TelegramService telegramService = new TelegramService();

        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();

        try {
            telegramBotsApi.registerBot(telegramService);
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }
}
