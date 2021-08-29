package ru.geekbrains;

import java.sql.*;

public class Authentication {

    private static PreparedStatement psGetNickname;

    public static boolean connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:users.db");
            psGetNickname = connection.prepareStatement("SELECT nickname FROM users_data WHERE login = ? AND password = ?;");
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getNicknameByLoginAndPassword(String login, String password) {
        String nick = null;
        try {
            psGetNickname.setString(1, login);
            psGetNickname.setString(2, password);
            ResultSet resultSet = psGetNickname.executeQuery();
            if (resultSet.next()) {
                nick = resultSet.getString(1);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nick;
    }
}
