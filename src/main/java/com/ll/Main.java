package com.ll;

import java.util.*; // 자바에서 제공하는 유용한 도구(리스트, 맵, 스캐너 등)를 사용하기 위해 import

public class Main {
    // 명언 데이터를 저장하기 위한 클래스 (명언과 작가 정보를 하나의 객체로 관리)
    static class Quote {
        String text; // 명언 내용
        String author; // 명언의 작가

        // 생성자: 새 명언을 만들 때 명언 내용과 작가를 저장
        public Quote(String text, String author) {
            this.text = text;
            this.author = author;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // 사용자 입력을 받기 위한 도구
        List<Quote> quotes = new ArrayList<>();  // 명언을 저장하는 리스트 (순서대로 관리)

        while (true) { // 무한 반복: 사용자가 "종료" 명령을 입력할 때까지 계속 실행
            System.out.print("명령) "); // 사용자에게 명령 입력을 요청
            String command = scanner.nextLine(); // 사용자가 입력한 명령을 저장

            if (command.startsWith("등록")) { // 명령이 "등록"으로 시작하면
                System.out.print("명언: "); // 명언 내용을 요청
                String text = scanner.nextLine(); // 사용자가 입력한 명언을 저장
                System.out.print("작가: "); // 작가 이름을 요청
                String author = scanner.nextLine(); // 사용자가 입력한 작가 이름을 저장

                // 리스트에 새 명언 추가
                quotes.add(new Quote(text, author));
                System.out.println(quotes.size() + "번 명언이 등록되었습니다."); // 현재 리스트 크기를 ID로 출력

            } else if (command.equals("목록")) { // 명령이 "목록"일 경우
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");

                // 최신 등록순(역순)으로 명언을 출력
                for (int i = quotes.size() - 1; i >= 0; i--) {
                    Quote quote = quotes.get(i); // 리스트에서 명언 가져오기
                    System.out.println((i + 1) + " / " + quote.author + " / " + quote.text); // 번호와 함께 출력
                }

            } else if (command.startsWith("삭제?id=")) { // 명령이 "삭제?id="로 시작하면
                // id 값을 "=" 뒤에서 추출
                int id = Integer.parseInt(command.split("=")[1]);

                // 입력된 id가 리스트 범위 내인지 확인
                if (id >= 1 && id <= quotes.size()) {
                    quotes.remove(id - 1); // 리스트에서 해당 ID의 명언 삭제
                    System.out.println(id + "번 명언이 삭제되었습니다.");
                } else {
                    System.out.println(id + "번 명언은 존재하지 않습니다."); // 없는 ID일 경우
                }

            } else if (command.startsWith("수정?id=")) { // 명령이 "수정?id="로 시작하면
                // id 값을 "=" 뒤에서 추출
                int id = Integer.parseInt(command.split("=")[1]);

                // 입력된 id가 리스트 범위 내인지 확인
                if (id >= 1 && id <= quotes.size()) {
                    Quote quote = quotes.get(id - 1); // 리스트에서 해당 ID의 명언 가져오기

                    // 기존 명언 내용과 작가를 보여주고 새 값을 입력받음
                    System.out.println("명언(기존): " + quote.text);
                    System.out.print("명언: ");
                    String newText = scanner.nextLine(); // 새로운 명언 내용 입력
                    System.out.println("작가(기존): " + quote.author);
                    System.out.print("작가: ");
                    String newAuthor = scanner.nextLine(); // 새로운 작가 이름 입력

                    // 기존 명언을 새 값으로 수정
                    quote.text = newText;
                    quote.author = newAuthor;
                    System.out.println(id + "번 명언이 수정되었습니다.");
                } else {
                    System.out.println(id + "번 명언은 존재하지 않습니다."); // 없는 ID일 경우
                }

            } else if (command.equals("종료")) { // 명령이 "종료"일 경우
                System.out.println("프로그램을 종료합니다.");
                break; // 반복문 종료, 프로그램 종료

            } else { // 위 조건에 해당하지 않는 명령일 경우
                System.out.println("알 수 없는 명령입니다.");
            }
        }

        scanner.close(); // 사용자 입력 도구 닫기
    }
}