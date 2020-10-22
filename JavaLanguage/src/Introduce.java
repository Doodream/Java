import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.util.Scanner;

public class Introduce {

    public static void main(String[] args) {
//
//        try{
//            // 오류를 발생 시킬 수 있는 코드
//        } catch (NullPointerException e) {
//            // 오류가 발생한 경우 처리 할 코드
//        } catch (IndexOutOfBoundsException e){
//            // 오류가 발생한 경우 처리 할 코드
//        } catch (IllegalArgumentException e){
//            // 오류가 발생한 경우 처리 할 코드
//        } catch (NoSuchFieldException e){
//            // 오류가 발생한 경우 처리 할 코드
//        } catch (NumberFormatException e) {
//            // 오류가 발생한 경우 처리 할 코드
//        } catch (ArithmeticException e) {
//            // 오류가 발생한 경우 처리 할 코드
//        }


        while (true) {
            System.out.println("(I)ntro (C)ourses (E)xit");
            Scanner sc = new Scanner(System.in);
            String spell = sc.nextLine();

            switch (spell) {
                case "E":
                case "e": {
                    System.out.println("안녕히 가세요.");
                    break;
                }
                case "I":
                case "i": {
                    System.out.println("안녕하세요! 우리는 코드잇입니다.\n" +
                            "함께 공부합시다!");
                }
                case "C":
                case "c": {
                    System.out.println("코드잇 수업을 소개합니다.\n" +
                            "(P)ython (J)ava (i)OS (B)ack");
                    String spell2 = sc.nextLine();
                    switch (spell2) {
                        case "P":
                        case "p": {
                            System.out.println("Python 언어를 통해 컴퓨터 사이언스의 기초를 배웁니다.\n" +
                                    "강사: 강영훈\n" +
                                    "추천 선수과목: 없음");
                        }
                        case "J":
                        case "j": {
                            System.out.println("Java의 기본 문법과 객체지향적 프로그래밍을 배웁니다.\n" +
                                    "강사: 김신의\n" +
                                    "추천 선수과목: Python");
                        }
                        case "i":
                        case "I": {
                            System.out.println("최신 Swift 언어를 통해 iOS 개발을 시작할 수 있습니다.\n" +
                                    "강사: 성태호\n" +
                                    "추천 선수과목: Python, Java");
                        }
                        case "B":
                        case "b": {
                            break;
                        }

                    }
                }

            }
        }
    }
}