package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message) {
        try {
            for (Map.Entry<String, Connection> nextConnection : connectionMap.entrySet()) {
                nextConnection.getValue().send(message);
            }
        } catch (IOException e) {
            System.out.println("Ошибка при отправке сообщения");
        }
    }

    public static void main(String[] args) {
        ConsoleHelper.writeMessage("Введите порт сервера");
        int port = ConsoleHelper.readInt();
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            ConsoleHelper.writeMessage("Чат запущен");
            while (true) {
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
            }
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Ошибка в работе сервера");
        }
    }

    private static class Handler extends Thread {

        Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            ConsoleHelper.writeMessage("Установлено новое соединение с адресом " + socket.getRemoteSocketAddress());
            try (Connection connection = new Connection(socket)) {
                String userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                notifyUsers(connection, userName);
                serverMainLoop(connection, userName);
                if (userName != null) {
                    connectionMap.remove(userName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                }
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным сервером");
            }
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            String userName = null;

            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST, "Введите имя пользователя"));
                Message newMessage = connection.receive();
                if (newMessage.getType() != MessageType.USER_NAME) continue;
                else if (newMessage.getType() == MessageType.USER_NAME
                        && newMessage.getData() != null
                        && !newMessage.getData().equals("")
                        && !connectionMap.containsKey(newMessage.getData())) {
                    userName = newMessage.getData();
                    connectionMap.put(userName, connection);
                    connection.send(new Message(MessageType.NAME_ACCEPTED, "Новый пользователь добавлен"));
                    break;
                }
            }

            return userName;
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> nextConnection : connectionMap.entrySet()) {
                if (!nextConnection.getKey().equals(userName))
                    connection.send(new Message(MessageType.USER_ADDED, nextConnection.getKey()));
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message newMessage = connection.receive();
                if (newMessage.getType() == MessageType.TEXT) {
                    String message = userName + ": " + newMessage.getData();
                    sendBroadcastMessage(new Message(MessageType.TEXT, message));
                } else {
                    ConsoleHelper.writeMessage("Ошибка при отправке сообщения");
                }
            }
        }
    }
}
