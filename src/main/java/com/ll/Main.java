package com.ll;

// Java 프로그램을 만들기 위해 필요한 Scanner라는 도구를 가져옴
import java.util.Scanner;

// 프로그램의 시작점(Main 클래스) 선언
public class Main {
    // 프로그램이 시작되면 실행되는 메인 메서드
    public static void main(String[] args) {
        // App이라는 클래스의 객체(인스턴스)를 만듦
        App app = new App();
        // App 클래스에 있는 run()이라는 기능(메서드)을 실행함
        app.run();
    }
}

// 실제로 앱의 동작을 정의하는 클래스(App 클래스) 선언
class App {
    // 앱의 핵심 기능을 실행하는 메서드(run) 정의
    public void run() {
        // "명언 앱"이라는 문구를 화면에 출력
        System.out.println("명언 앱");

        // 사용자 입력을 받기 위한 Scanner 도구를 준비
        Scanner scanner = new Scanner(System.in);

        // 무한 반복문을 시작
        while (true) {
            // 사용자에게 "명령 :"이라는 문구를 보여줌
            System.out.print("명령 :");

            // 사용자가 입력한 문장을 읽어와 cmd라는 변수에 저장
            String cmd = scanner.nextLine();

            // 사용자가 입력한 값(cmd)이 "종료"라면 반복문을 멈춤
            if (cmd.equals("종료")) break;
        }

        // 더 이상 입력을 받지 않을 것이므로 Scanner를 닫음
        scanner.close();
    }
}