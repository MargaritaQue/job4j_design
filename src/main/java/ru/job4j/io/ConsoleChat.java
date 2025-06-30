package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> log = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        List<String> phrases = readPhrases();
        String answer;
        Random rand = new Random();
        boolean flag = true;

        while (flag) {
            System.out.print("Введите что-нибудь: ");
            String userInput = scanner.nextLine();
            log.add(userInput);
            switch (userInput) {
                case STOP -> {
                    while (!CONTINUE.equals(userInput)) {
                        userInput = scanner.nextLine();
                        log.add(userInput);
                        if (OUT.equals(userInput)) {
                            flag =  false;
                        }
                    }
                    int randomIndex = rand.nextInt(phrases.size());
                    answer = phrases.get(randomIndex);
                    System.out.println(answer);
                    log.add(answer);
                }
                case OUT ->
                    flag = false;

                default -> {
                    int randomIndex = rand.nextInt(phrases.size());
                    answer = phrases.get(randomIndex);
                    System.out.println(answer);
                    log.add(answer);
                }
            }
        }
        scanner.close();
        saveLog(log);
    }

    private List<String> readPhrases() {
        List<String> list = new ArrayList<>();
        try (BufferedReader input = new BufferedReader(new FileReader(botAnswers))) {
            list = input.lines().toList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter output = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(path)
                ))) {
            for (String l : log) {
                output.println(l);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat consoleChat = new ConsoleChat("data/chat.txt", "data/phrases");
        consoleChat.run();
    }
}