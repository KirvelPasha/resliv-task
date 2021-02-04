package com.resliv.service;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class TelegramService extends TelegramLongPollingBot {

    private static final String botUserName = "CityHelperResliv_bot";

    private static final String botToken = "";

    @Override
    public String getBotUsername() {
        return botUserName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update != null && update.getMessage().hasText()) {
            long chatId = update.getMessage().getChatId();
            String message = update.getMessage().getText();
            try {
                execute(new SendMessage(String.valueOf(chatId), "HELLo"));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

        }
    }


}
