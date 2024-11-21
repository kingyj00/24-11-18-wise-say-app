package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}

class App {
    // 명언을 저장할 리스트
    private List<WiseSaying> wiseSayings = new ArrayList<>();

    public void run() {
        System.out.println("== 명언 앱 ==");

        Scanner scanner = new Scanner(System.in);
        int lastId = 0;

        while (true) {
            System.out.print("명령 : ");
            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                String content = scanner.nextLine();
                System.out.print("작가 : ");
                String author = scanner.nextLine();
                int id = ++lastId;

                // 새로운 명언 객체 생성 및 저장
                WiseSaying wiseSaying = new WiseSaying(id, content, author);
                wiseSayings.add(wiseSaying);

                System.out.println("%d번 명언이 등록되었습니다.".formatted(id));

            } else if (cmd.equals("목록")) {
                if (wiseSayings.isEmpty()) {
                    System.out.println("등록된 명언이 없습니다.");
                } else {
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("----------------------");
                    // 리스트에 저장된 명언 출력
                    for (int i = wiseSayings.size() - 1; i >= 0; i--) {
                        WiseSaying wiseSaying = wiseSayings.get(i);
                        System.out.println("%d / %s / %s".formatted(wiseSaying.id, wiseSaying.author, wiseSaying.content));
                    }
                }
            } else {
                System.out.println("알 수 없는 명령어입니다. 다시 입력해주세요.");
            }
        }
        scanner.close();
    }
}

// 명언 객체를 나타내는 클래스
class WiseSaying {
    int id;
    String content;
    String author;

    // 생성자
    public WiseSaying(int id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }
}