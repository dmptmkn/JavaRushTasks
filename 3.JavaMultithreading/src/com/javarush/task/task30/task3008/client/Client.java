package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;

public class Client {

    protected Connection connection;
    private volatile boolean clientConnected = false;

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

    public void run() {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        synchronized (this) {
            try {
                wait();
                notify();
            } catch (InterruptedException e) {
                ConsoleHelper.writeMessage("Произошла ошибка.");
                return;
            }
        }
        if (clientConnected) {
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
        } else {
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
        }

        String message = null;
        while (clientConnected) {
            message = ConsoleHelper.readString();
            if (message.equals("exit")) break;
            if (shouldSendTextFromConsole()) sendTextMessage(message);
        }
    }

    protected String getServerAddress() {
        ConsoleHelper.writeMessage("Введите адрес сервера:");
        return ConsoleHelper.readString();
    }

    protected int getServerPort() {
        ConsoleHelper.writeMessage("Введите номера порта сервера:");
        return ConsoleHelper.readInt();
    }

    protected String getUserName() {
        ConsoleHelper.writeMessage("Введите имя пользователя:");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Во время отправки сообщения произошла ошибка!");
            clientConnected = false;
        }
    }

    public class SocketThread extends Thread {

        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage("Участник " + userName + " присоединился к чату.");
        }

        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage("Участник " + userName + " покинул чат.");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this) {
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException {
            String userName = null;
            Message newMessage = null;

            while (true) {
                newMessage = connection.receive();
                if (newMessage.getType() == MessageType.NAME_REQUEST) {
                    userName = getUserName();
                    connection.send(new Message(MessageType.USER_NAME, userName));
                } else if (newMessage.getType() == MessageType.NAME_ACCEPTED) {
                    notifyConnectionStatusChanged(true);
                    break;
                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            Message newMessage = null;

            while (true) {
                newMessage = connection.receive();
                if (newMessage.getType() == MessageType.TEXT) {
                    processIncomingMessage(newMessage.getData());
                } else if (newMessage.getType() == MessageType.USER_ADDED) {
                    informAboutAddingNewUser(newMessage.getData());
                } else if (newMessage.getType() == MessageType.USER_REMOVED) {
                    informAboutDeletingNewUser(newMessage.getData());
                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }
    }
}
