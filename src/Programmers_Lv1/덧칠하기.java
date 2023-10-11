package Programmers_Lv1;

import java.util.Arrays;

// 점수 ( 100 / 100 )
public class 덧칠하기 {
    //    https://school.programmers.co.kr/learn/courses/30/lessons/161989
    public static void main(String[] args) {
        System.out.println("Paint : " + PaintSolution(8, 4, new int[]{2, 3, 6}));
        System.out.println("Paint : " + PaintSolution(5, 4, new int[]{1, 3}));
        System.out.println("Paint : " + PaintSolution(4, 1, new int[]{1, 2, 3, 4}));
    }

    public static int PaintSolution(int n, int m, int[] section) {
        // n 벽 갯수, m 페인트 칠 한번의 길이, section 칠해야 하는 곳
        int answer = 0, move = 0, i = 0;
        move = section[0] + m;
        answer++;
        if (move > section[section.length - 1]) { //한번에 페인트 가능
            return answer;
        }
        while (move <= section[section.length - 1]) { // 칠해야 하는 곳을 넘어갈 때까지
            if (section[i] < move) i++;
            if (section[i] >= move) { //다음 칠할 곳
                move = section[i] + m;
                answer++;
            }
        }
        return answer;
    }


}






