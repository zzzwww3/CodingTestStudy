package Programmers_Lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

// 점수 ( 100 / 100 )
public class 같은숫자는싫어 {
    //    https://school.programmers.co.kr/learn/courses/30/lessons/12906
    public static void main(String[] args) {
        System.out.println("같은 숫자는 싫어 : "+Arrays.toString(NumberSolution(new int[]{1, 1, 3, 3, 0, 1, 1})));
        System.out.println("같은 숫자는 싫어 : "+Arrays.toString(NumberSolution(new int[]{4,4,4,3,3})));
    }

    public static int[] NumberSolution(int[] arr) {
        Stack stack = new Stack();
        for (int i : arr) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                if (stack.peek() != (Object) i) {
                    stack.push(i);
                }
            }
        }
        int[] answer = new int[stack.size()];

        for (int i = 0; i < stack.size(); i++) {
            answer[i] = (int) stack.get(i);
        }
        return answer;
    }




}






