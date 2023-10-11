package Programmers_Lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// 점수 ( 20 / 100 )
public class 롤케이크자르기 {
    //https://school.programmers.co.kr/learn/courses/30/lessons/132265
    public static void main(String[] args) {
        System.out.println("롤케이크 자르기 : " + RollcakeSolution(new int[]{1,2,1,3,1,4,1,2})); //2
        System.out.println("롤케이크 자르기 : " + RollcakeSolution(new int[]{1,2,3,1,4})); // 0
    }

    public static int RollcakeSolution(int[] topping) {
        int answer = 0;
        //크기, 토핑 개수 상관없이 조각에 동일한 가짓수의 토핑이 올라가면 공평한 걸로 본다.
        int[] cut1,cut2;

        for(int i=0;i< topping.length;i++){
//            if(Math.abs(topping.length/2-i)>2) continue; //중간 값만 계산하기 위해 사용한 코드인데 실패로 나옴...

            cut1= Arrays.stream(Arrays.copyOfRange(topping,0,i)).distinct().toArray();
            cut2=Arrays.stream(Arrays.copyOfRange(topping,i,topping.length)).distinct().toArray();

            if(cut1.length==cut2.length) answer++;
        }
        return answer;
    }

}






