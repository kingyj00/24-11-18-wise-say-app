package com.ll;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
    App app = new App();
    app.run();
    }
}

class App {
    public void run() {
        System.out.println("명언앱");
        Scanner scanner = new Scanner(System.in);
        int lastId = 0;
        ArrayList<String> wiseSayings = new ArrayList<>();

        while (true) {
            System.out.print("명령 : ");
            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                String content = scanner.nextLine();
                System.out.print("작가 : ");
                String author = scanner.nextLine();
                int id = ++lastId;
                System.out.println("%d번에 명언이 등록되었습니다.".formatted(id));
            } else if (cmd.equals("목록")) {
                    System.out.println(" 번호 / 작가 / 명언");
                    System.out.println("====================");
                    for (int i = wiseSayings.size() - 1; i >= 0; i--) {
                        System.out.println(wiseSayings.get(i));
                    }
                }
            }
            scanner.close();
        }
    }
