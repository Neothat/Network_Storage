package ru.geekbrains.auth;

public class AuthServiceImpl implements AuthService{
    @Override
    public String getNicknameByLoginAndPassword(String login, String password) {
        return Authentication.getNicknameByLoginAndPassword(login, password);
    }
}
