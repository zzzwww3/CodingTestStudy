package Programmers_Lv1;

import java.util.ArrayList;
import java.util.Arrays;

// 점수 ( 100 / 100 )
public class 없는숫자더하기 {
    //    https://school.programmers.co.kr/learn/courses/30/lessons/86051
    public static void main(String[] args) {
                System.out.println("없는 숫자 더하기 : "+Numbersolution(new int[]{1, 2, 3, 4, 6, 7, 8, 0}));
    }

    public static int Numbersolution(int[] numbers) {
        /*배열에 없는 숫자 더하기 배열 범위 (0 ~ 9) */
        int answer = 0;
        ArrayList<Integer> tempList = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        for (int number : numbers) {
            tempList.remove((Object) number);
        }
        for (int i : tempList) {
            answer += i;
        }
        return answer;
    }



}






