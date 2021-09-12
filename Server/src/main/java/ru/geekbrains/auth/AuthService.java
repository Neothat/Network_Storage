package ru.geekbrains.auth;

public interface AuthService {
    String getNicknameByLoginAndPassword(String login, String password);
}
