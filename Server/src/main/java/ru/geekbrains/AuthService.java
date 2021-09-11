package ru.geekbrains;

public interface AuthService {
    String getNicknameByLoginAndPassword(String login, String password);
}
