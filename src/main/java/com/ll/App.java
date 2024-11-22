package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private final Scanner scanner;
    private int lastId;
    private final List<WiseSaying> wiseSayings;
    private int wiseSayingSize;

    public App(){
        scanner = new Scanner(System.in);
        lastId = 0;
        wiseSayings = new ArrayList<>();
    }

    public void run() {
        System.out.println("== 명언 앱 ==");

       makeSampleData();

        while (true) {
            System.out.print("명령 : ");
            final String cmd = scanner.nextLine();
            if (cmd.equals("종료")) break;
            else if (cmd.equals("등록")) {
                actionAdd() ;
            } else if (cmd.equals("목록")) {
                actionList();
            }
        }
        scanner.close();
    }

    private void makeSampleData() {
        addWiseSaying("나의 죽음을 알리지 마라.", "이순신");
        addWiseSaying("악법도 법이다.", "소크라테스");
    }

    private WiseSaying addWiseSaying(String content, String author){
        int id = ++lastId;

        WiseSaying wiseSaying = new WiseSaying(id, content, author);

        wiseSayings.add(wiseSaying);

        return wiseSaying;
    }

    private void actionAdd() {
        System.out.println("명언 : ");
        String content = scanner.nextLine();
        System.out.println("작가 : ");
        String author = scanner.nextLine();

        WiseSaying wiseSaying = addWiseSaying(content, author);

        //System.out.println(Arrays.toString(wiseSayings)); // 그냥외우기 배열을 오버라이드하는법

        System.out.println("%d번 명언이 등록되었습니다.".formatted(wiseSaying.getId()));
    }

    private void actionList(){
        System.out.println("번호/ 작가 / 명언");
        System.out.println("-----------------------");

        for ( int i = wiseSayings.size() - 1; i >=0; i--){
            WiseSaying wiseSaying = wiseSayings.get(i);

            System.out.println("%d. %s / %s".formatted(wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent()));
        }
    }
}
