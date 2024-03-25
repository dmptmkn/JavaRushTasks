package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BotClient extends Client {

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        int x = (int) (Math.random() * 100);
        return "date_bot_" + x;
    }

    public class BotSocketThread extends Client.SocketThread {

        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            if (!message.contains(":")) return;

            String userName = message.split(": ")[0];
            String data = message.replaceFirst(userName + ": ", "");
            if (data.equals("дата")) {
                sendTextMessage("Информация для " + userName + ": " + new SimpleDateFormat("d.MM.YYYY").format(Calendar.getInstance().getTime()));
            } else if (data.equals("день")) {
                sendTextMessage("Информация для " + userName + ": " + new SimpleDateFormat("d").format(Calendar.getInstance().getTime()));
            } else if (data.equals("месяц")) {
                sendTextMessage("Информация для " + userName + ": " + new SimpleDateFormat("MMMM").format(Calendar.getInstance().getTime()));
            } else if (data.equals("год")) {
                sendTextMessage("Информация для " + userName + ": " + new SimpleDateFormat("YYYY").format(Calendar.getInstance().getTime()));
            } else if (data.equals("время")) {
                sendTextMessage("Информация для " + userName + ": " + new SimpleDateFormat("H:mm:ss").format(Calendar.getInstance().getTime()));
            } else if (data.equals("час")) {
                sendTextMessage("Информация для " + userName + ": " + new SimpleDateFormat("H").format(Calendar.getInstance().getTime()));
            } else if (data.equals("минуты")) {
                sendTextMessage("Информация для " + userName + ": " + new SimpleDateFormat("m").format(Calendar.getInstance().getTime()));
            } else if (data.equals("секунды")) {
                sendTextMessage("Информация для " + userName + ": " + new SimpleDateFormat("s").format(Calendar.getInstance().getTime()));
            }
        }
    }
}
