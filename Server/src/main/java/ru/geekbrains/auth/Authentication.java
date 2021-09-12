package ru.geekbrains.auth;

import java.sql.*;

public class Authentication {

    private static PreparedStatement psGetNickname;
    private static Connection connection;
    private static final String bdAddress = "D:/Trash/Network_Storage/Server/users.db";

    public static boolean connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + bdAddress);
            psGetNickname = connection.prepareStatement("SELECT nickname FROM users_data WHERE login = ? AND password = ?;");
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String getNicknameByLoginAndPassword(String login, String password) {
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

    public static void disconnect(){
        try {
            psGetNickname.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
