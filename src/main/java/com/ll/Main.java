package com.ll;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main( String[] args){
        App app = new App();
        app.run();
    }
}

class App {
    public void run() {
        System.out.println(" 명 언 앱 을 켰 구 만");
        Scanner scanner = new Scanner(System.in);
        int lastId = 0;
        ArrayList<String> wiseSayings = new ArrayList<>();

        while (true) {
            System.out.print(" 입력 : ");
            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                System.out.print(" 명언 : ");
                String content = scanner.nextLine();
                System.out.print(" 작가 : ");
                String author = scanner.nextLine();
                int id = ++lastId;
                wiseSayings.add(id + "/" + author + "/" + content);
                System.out.println(" %d번에 명언이 등록되었습니다.".formatted(id));
            } else if (cmd.equals("목록")){
                System.out.println("번호 / 작가 / 명언");
                System.out.println("===================");
                for (int i = wiseSayings.size() - 1; i >=0; i--) {
                    System.out.println(wiseSayings.get(i));
                }
            } else if (cmd.equals("삭제")) {
                System.out.println("삭제할 번호 : ");
                int deleteId = Integer.parseInt(scanner.nextLine());
                boolean found = false;
                for (int i = 0; i < wiseSayings.size(); i++) {
                    if (wiseSayings.get(i).startsWith(deleteId + "/")){
                        wiseSayings.remove(i);
                        System.out.println("%d번 명언이 삭제되었습니다.".formatted(deleteId));
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("해당 번호에 명언이 없는디?");
                }
            }
        }
        scanner.close();
    }
}