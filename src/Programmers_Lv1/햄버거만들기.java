package Programmers_Lv1;

import java.util.Arrays;

// 점수 ( 88.9  / 100 )
public class 햄버거만들기 {
//    https://school.programmers.co.kr/learn/courses/30/lessons/133502
    public static void main(String[] args) {
        System.out.println("햄버거 만들기 : "+Hambugersolution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1}));
        System.out.println("햄버거 만들기 : "+Hambugersolution(new int[]{1, 3, 2, 1, 2, 1, 3, 1, 2}));
    }
    public static int Hambugersolution(int[] ingredient) {
        int answer = 0;
        String start, end;
        String temp = Arrays.toString(ingredient).replace(",", "").replace(" ", "");
        while (temp.indexOf("1231") != -1) {  //1231이 없을 때 까지
            start = temp.substring(0, temp.indexOf("1231")); //1231 앞 부분
            end = temp.substring(temp.indexOf("1231") + 4); // 1231 뒷 부분
            answer++;
            temp = start + end;
        }
//        System.out.printf("남은 재료 : " + temp + " // 햄버거가 만들어진 갯수 : " + answer);
        return answer;
    }
}






