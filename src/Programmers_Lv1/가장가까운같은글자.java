package Programmers_Lv1;

import java.util.Arrays;

// 점수 ( 100 / 100 )
public class 가장가까운같은글자 {
    //    https://school.programmers.co.kr/learn/courses/30/lessons/142086
    public static void main(String[] args) {
        System.out.println("가장 가까운 같은 글자 : " + Arrays.toString(CloseNumSolution("banana")));
        System.out.println("가장 가까운 같은 글자 : " + Arrays.toString(CloseNumSolution("foobar")));
    }

    public static int[] CloseNumSolution(String s) {
        int[] answer = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) answer[i] = -1; //첫번 째 -1
            else {
                if (s.substring(0, i).lastIndexOf(s.charAt(i)) != -1) { // 같은 글자가 있다면
                    answer[i] = i - s.substring(0, i).lastIndexOf(s.charAt(i)); // 가장 가까운 글자와 거리
                } else {
                    answer[i] = -1; // 같은 글자가 없다면 -1
                }
            }
        }
        return answer;
    }


}






