package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        passwordValidate("wy_re", "rtiu", "rtiu");

    }
    static String pattern = "[A-Za-z0-9]*_?[A-Za-z0-9]*";
    /*
    Создать статический метод который принимает на вход три параметра: login, password и confirmPassword.
    Login должен содержать только латинские буквы, цифры и знак подчеркивания.
    Длина login должна быть меньше 20 символов. Если login не соответствует этим требованиям, необходимо выбросить WrongLoginException.
    Password должен содержать только латинские буквы, цифры и знак подчеркивания. Длина password должна быть меньше 20 символов. Также password и confirmPassword должны быть равны. Если password не соответствует этим требованиям, необходимо выбросить WrongPasswordException.
    WrongPasswordException и WrongLoginException - пользовательские классы исключения с двумя конструкторами – один по умолчанию, второй принимает сообщение исключения и передает его в конструктор класса Exception.
    Обработка исключений проводится внутри метода.
    Используем multi-catch block.
    Метод возвращает true, если значения верны или false в другом случае.
    */
    public static boolean passwordValidate(String login, String password, String confirmPassword) {
        Pattern myPattern = Pattern.compile(pattern);
        Matcher loginMatcher = myPattern.matcher(login);
        Matcher passwordMatcher = myPattern.matcher(password);
        try {
                if (!loginMatcher.matches()) {
                    throw new WrongLoginException("Логин содержит недопустимые символы");
                }
                if (login.length() > 19) {
                    throw new WrongLoginException("Логин слишком длинный");
                }
                if (!passwordMatcher.matches()) {
                    throw new WrongPasswordException("Пароль содержит недопустимые символы");
                }
                if (password.length() > 19) {
                    throw new WrongPasswordException("Пароль слишком длинный");
                }
                if (!password.equals(confirmPassword)) {
                    throw new WrongPasswordException("Пароль и подтверждение не совпадают");
                }
            } catch (WrongPasswordException | WrongLoginException exception) {
                System.out.println(exception.getMessage());
                return false;
            }
            return true;
        }
}