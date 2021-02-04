package com.resliv.service;

import com.resliv.entity.City;
import com.resliv.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Optional;


@Component
public class TelegramService extends TelegramLongPollingBot {
    @Value("${bot.name}")
    private String botUserName;

    @Value("${bot.token}")
    private String botToken;

    private final CityRepository cityRepository;

    @Autowired
    public TelegramService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

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
            String message = buildMessage(update.getMessage().getText());
            try {
                execute(new SendMessage(String.valueOf(chatId), message));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

        }
    }


    private String buildMessage(String cityName) {
        StringBuilder message = new StringBuilder();
        Optional<City> city = Optional.ofNullable(cityRepository.getCityByName(cityName));
        if (!city.isPresent() || city.get().getCityInfos().isEmpty()) {
            return "Sorry we don't have info about city with name: " + cityName;
        }
        city.get().getCityInfos().forEach(cityInfo -> message.append(cityInfo.getInfo()).append("\n"));
        return message.toString();
    }


}
