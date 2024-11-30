package com.ll; // 프로그램의 묶음을 나타내는 패키지 선언. 여기서는 "com.ll"이라는 이름의 패키지를 사용.

import java.util.Scanner; // 사용자 입력을 받기 위해 Scanner 클래스를 가져옴.

// 프로그램의 시작점
public class Main {
    public static void main(String[] args) {
        App app = new App(); // App이라는 객체(애플리케이션의 핵심 부분)를 만듦.
        app.run(); // App 객체의 run 메서드를 실행해서 프로그램을 시작.
    }
}

// 애플리케이션의 주요 기능을 담당하는 클래스
class App {
    private Scanner scanner; // 사용자 입력을 받는 도구
    private int lastId; // 마지막으로 등록된 명언의 고유 번호를 저장하는 변수
    private WiseSaying[] wiseSayings; // WiseSaying 객체를 저장하는 배열 (명언들을 저장)
    private int wiseSayingSize; // 현재 저장된 명언의 개수

    // App 클래스 생성자: 프로그램 실행에 필요한 준비 작업을 함
    public App(){
        scanner = new Scanner(System.in); // 사용자 입력을 받을 준비
        lastId = 0; // 처음에는 등록된 명언이 없으므로 0으로 시작
        wiseSayings = new WiseSaying[10]; // 명언을 최대 10개까지 저장할 수 있는 배열 생성
        wiseSayingSize = 0; // 현재 등록된 명언 개수는 0
    }

    // 프로그램의 실행 흐름을 관리하는 메서드
    public void run() {
        System.out.println("== 명언 앱 =="); // 프로그램 시작 메시지 출력

        // 초기 명언을 등록
        addWiseSaying("나의 죽음을 알리지 마라.", "이순신");
        addWiseSaying("악법도 법이다.", "소크라테스");

        // 사용자가 종료를 입력하기 전까지 명령을 계속 받음
        while (true) {
            System.out.print("명령 : "); // 사용자에게 명령 입력 요청
            String cmd = scanner.nextLine(); // 사용자로부터 명령 입력받기
            if (cmd.equals("종료")) break; // "종료"를 입력하면 반복문 종료
            else if (cmd.equals("등록")) {
                actionAdd(); // 명언 등록 기능 실행
            } else if (cmd.equals("목록")) {
                actionList(); // 명언 목록 보기 기능 실행
            }
        }
        scanner.close(); // 사용이 끝난 Scanner를 닫음
    }

    // 새로운 명언을 배열에 추가하고 반환하는 메서드
    private WiseSaying addWiseSaying(String content, String author){
        int id = ++lastId; // 명언의 고유 번호를 증가시킴

        // 새로운 WiseSaying 객체 생성
        WiseSaying wiseSaying = new WiseSaying(id, content, author);

        wiseSayings[wiseSayingSize] = wiseSaying; // 배열에 새로운 명언 추가
        wiseSayingSize++; // 등록된 명언 개수 증가

        return wiseSaying; // 새로 추가된 명언 반환
    }

    // 사용자가 새로운 명언을 입력하도록 하는 메서드
    private void actionAdd() {
        System.out.println("명언 : "); // 명언 입력 요청
        String content = scanner.nextLine(); // 명언 입력 받기
        System.out.println("작가 : "); // 작가 입력 요청
        String author = scanner.nextLine(); // 작가 입력 받기

        // 입력받은 내용을 새로운 명언으로 추가
        WiseSaying wiseSaying = addWiseSaying(content, author);

        System.out.println("%d번 명언이 등록되었습니다.".formatted(wiseSaying.id)); // 등록된 명언 정보 출력
    }

    // 저장된 모든 명언을 목록으로 출력하는 메서드
    private void actionList(){
        System.out.println("번호 / 작가 / 명언"); // 목록의 제목 출력
        System.out.println("-----------------------");

        // 배열에 저장된 모든 명언 출력
        for (WiseSaying wiseSaying : wiseSayings) {
            if (wiseSaying == null) break; // 빈 칸(등록되지 않은 공간)이 나오면 종료
            System.out.println("%d / %s / %s".formatted(wiseSaying.id, wiseSaying.author, wiseSaying.content));
        }
    }
}

// 명언 하나를 저장하는 클래스
class WiseSaying {
    int id; // 명언의 고유 번호
    String content; // 명언의 내용
    String author; // 명언을 만든 사람

    // WiseSaying 객체를 생성하는 생성자
    WiseSaying(int id, String content, String author) {
        this.id = id; // 고유 번호 저장
        this.content = content; // 명언 내용 저장
        this.author = author; // 작가 이름 저장
    }

    // 객체의 정보를 보기 쉽게 문자열로 변환
    @Override
    public String toString() {
        return "WiseSaying (id=%d, content=%s, author=%s)".formatted(id, content, author);
    }
}