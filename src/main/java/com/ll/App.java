package com.ll;

import java.util.Scanner;

public class App {
    private Scanner scanner;
    private int lastId;
    private WiseSaying[] wiseSayings;
    private int wiseSayingSize;

    public App(){
        scanner = new Scanner(System.in);
        lastId = 0;
        wiseSayings = new WiseSaying[10];
        wiseSayingSize = 0;
    }

    public void run() {
        System.out.println("== 명언 앱 ==");

        addWiseSaying("나의 죽음을 알리지 마라.", "이순신");
        addWiseSaying("악법도 법이다.", "소크라테스");

        while (true) {
            System.out.print("명령 : ");
            String cmd = scanner.nextLine();
            if (cmd.equals("종료")) break;
            else if (cmd.equals("등록")) {
                actionAdd() ;
            } else if (cmd.equals("목록")) {
                actionList();
            }
        }
        scanner.close();
    }

    private WiseSaying addWiseSaying(String content, String author){
        int id = ++lastId;

        WiseSaying wiseSaying = new WiseSaying(id, content, author);

        wiseSayings[wiseSayingSize] = wiseSaying;
        wiseSayingSize++;

        return wiseSaying;
    }

    private void actionAdd() {
        System.out.println("명언 : ");
        String content = scanner.nextLine();
        System.out.println("작가 : ");
        String author = scanner.nextLine();

        WiseSaying wiseSaying = addWiseSaying(content, author);

        //System.out.println(Arrays.toString(wiseSayings)); // 그냥외우기 배열을 오버라이드하는법

        System.out.println("%d번 명언이 등록되었습니다.".formatted(wiseSaying.id));
    }

    private void actionList(){
        System.out.println("번호/ 작가 / 명언");
        System.out.println("-----------------------");

        for (WiseSaying wiseSaying : wiseSayings) {
            if ( wiseSaying == null) break;
            System.out.println("%d / %s / %s".formatted(wiseSaying.id, wiseSaying.author, wiseSaying.content));
            //while과 for는 같은 반복문이다. for를 쓰는 이유는 가독성이 좋아서.
        }
    }
}
