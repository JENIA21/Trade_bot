package com.company.telegram;

import com.company.database.IDataSource;
import com.company.module.User;
import com.company.telegram.command_impl.CommandStates;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Работа с телеграмом
 */
public class TelegramBot extends TelegramLongPollingBot {

    private final IDataSource dataSource;

    private final StateMachine stateMachine = new StateMachine();

    public TelegramBot(IDataSource iDataSource) {
        dataSource = iDataSource;
    }

    public void sendMsg(Message message, String text) {

        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(text);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void onUpdateReceived(Update update) {

        if (update.hasMessage()) {
            Message message = update.getMessage();
            if (message.hasText()) {
                User user = dataSource.getUser(message.getChatId().toString());
                if (user == null) {
                    user = new User(message.getChatId().toString(), 0, CommandStates.GREETING.addCode, 0, CommandStates.GREETING_EX.addCode);
                    try {
                        dataSource.saveUser(user);
                    } catch (Exception e) {
                        sendMsg(message, "Произошла ошибка при сохранении, попробуйте еще раз");
                        try {
                            dataSource.close();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        return;
                    }
                }
                String command = message.getText();
                sendMsg(message, stateMachine.doCommand(command, user));
                dataSource.saveUser(user);
            }
        }
    }

    public String getBotUsername() {
        return "TradeOOP_bot";
    }

    public String getBotToken() {

        String contents = null;

        String file = "token.txt";

        try {
            contents = readFile(file);
            return contents;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    private String readFile(String file) throws IOException {

        String contents;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            contents = reader.readLine();
            return contents;
        }


    }

}

