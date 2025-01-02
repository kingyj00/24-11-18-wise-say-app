package com.ll;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}

class App {
    public void run() {
        System.out.println("명언앱");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("입력 : ");
            String cmd =scanner.nextLine();

            if (cmd.equals("종료")) break;
        }
        scanner.close();
    }
}