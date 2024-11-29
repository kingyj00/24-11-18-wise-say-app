package com.ll;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        App app = new App();
        app.run();
    }
}

class App {
    public void run() {
        System.out.println("명언등록기");
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.print(" 명령 : ");
            String a = scanner.nextLine();

            if (a.equals("종료")) {
                break;
            } else if (a.equals("등록")){
                System.out.print("명언 :");
                String content = scanner.nextLine();
                System.out.print("작가 :");
                String author = scanner.nextLine();
            }
        }
        scanner.close();
    }
}