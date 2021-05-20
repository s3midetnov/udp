package com.company;

import java.net.*;
import java.io.*;
import java.util.*;


public class Client2 {
    static int port = 2345; // Порт, такой же, как у сервера
    static String address = "127.0.0.1"; // Адрес сервера

    public static void main(String[] args) {
        try {
            // Преобразуем адрес из строки во внутреннее представление
            InetAddress addr = InetAddress.getByName(address);

            // Создаём сокет и подключаем его к серверу
            System.out.println("Поключаемся к " + address + ":" + port + "...");
            Socket socket = new Socket(addr, port);

            // Потоки ввода/вывода
            // BufferedReader позволяет читать вход по строкам
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // PrintWriter позволяет использовать println
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
            // Создаем объект для чтения строк с клавиатуры
            Scanner scan = new Scanner(System.in, "UTF-8");

            // Читаем данные с клавиатуры и отправляем серверу
            // Запрашиваем строку
            System.out.print("[Запрос]:");
            String line = scan.nextLine();

            // Отправляем строку серверу
            out.println(line);
            out.flush(); 	// принудительная отправка

            // Получаем ответ
            line = in.readLine(); // ждем пока сервер отошлет строку текста.
            System.out.println("[Ответ]:" + line);

            // Закрываем соединение
            socket.close();
        } catch (IOException x) {
            System.out.println("Ошибка ввода/вывода");
            x.printStackTrace();
        }
    }
}