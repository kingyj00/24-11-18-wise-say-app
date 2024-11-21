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
        System.out.println("== 명언 앱 ==");

        Scanner scanner = new Scanner(System.in);
        int lastId = 0;

        WiseSaying[] wiseSayings = new WiseSaying[10];
        int wiseSayingSize = 0;

        while (true) {
            System.out.print("명령 : ");
            String cmd = scanner.nextLine();
            if (cmd.equals("종료")) break;
            else if (cmd.equals("등록")) {
                System.out.println("명언 : ");
                String content = scanner.nextLine();
                System.out.println("작가 : ");
                String author = scanner.nextLine();
                int id = ++lastId;

                WiseSaying wiseSaying = new WiseSaying(id, content, author);

                wiseSayings[wiseSayingSize] = wiseSaying;
                wiseSayingSize++;

                //System.out.println(Arrays.toString(wiseSayings)); // 그냥외우기 배열을 오버라이드하는법

                System.out.println("%d번 명언이 등록되었습니다.".formatted(id));
            } else if (cmd.equals("목록")) {
                System.out.println("번호/ 작가 / 명언");
                System.out.println("-----------------------");

                for ( int i = 0; i < wiseSayingSize; i++ ) {
                    WiseSaying wiseSaying = wiseSayings[i];
                    System.out.println("%d / %s / %s".formatted(wiseSaying.id, wiseSaying.author, wiseSaying.content));

                    //while과 for는 같은 반복문이다. for를 쓰는 이유는 가독성이 좋아서.
                }
            }
        }
        scanner.close();
    }
}

class WiseSaying {
    int id;
    String content;
    String author;

    WiseSaying(int id, String content, String author) {
        this.id=id;
        this.content=content;
        this.author=author;
    }

    @Override
    public String toString() {
        return "WiseSaying (id=%d, content=%s, author=%s)".formatted(id, content, author);
    }
}