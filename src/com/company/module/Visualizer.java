package com.company.module;

/**
 * Ответные команды
 */
public class Visualizer {

    public static final String TRADE_EXIT = "\nДля выхода:/exit";

    public static final String MENU_EXIT = "Возвращайтесь еще!\n/start - начать махинации.\n/information - получить информацию о работе бота.\n/addMoney-пополнить банк\n/getBank - показать банк\n/exchange - обмен валют";

    public static final String MENU_HELP =
            """
                    Опции:
                      /getRates - посмотреть курс
                      /getBank - посмотреть сбережения.
                      /addMoney - пополнить сбережения.
                      /exchange - обмен валют
                      /information - получить информацию о работе бота.
                    """;

    public static final String INFORMATION = "Трейд Бот включает в себя возможности: \nОбменять валюту \nПосмотреть курс валют";

    public static final String GREETING_BOT = "Вас приветствует трейд бот!\nНапиши команду /information чтобы узнать возможности\nНапишите /help, чтоб увидеть команды";

    public static final String DOLLAR_COST = "1$ = ";

    public static final String AMOUNT_RU = "Рубли: ";

    public static final String AMOUNT_USD = "\nДоллары: ";

    public static final String INCORRECT_INPUT = "Колличество введено не корректно. Введите число еще раз.";

    public static final String NO_MANY = "У вас не хватает денег. Введите число еще раз.";

    public static final String GOOD = "Хорошо!";

    public static final String WRITE_NUM = "Введите число!";

    public static final String NOT_ROUND = "Можно обменять только на целое число долларов.";

    public static final String AMOUNT = "Сколько?";

    public static final String NOT_CURRENCY = "Это не валюта";

    public static final String TYPE_CURRENCY_EX = "Какую валюту обменять? ru или usd";

    public static final String TYPE_CURRENCY_ADD = "Какую валюту добавить? ru или usd";

}
