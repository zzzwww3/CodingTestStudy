package Programmers_Lv2;

import java.util.LinkedList;
import java.util.Queue;
// 점수 ( 76.7 / 100 )
public class 두큐합같게만들기 {
//    https://school.programmers.co.kr/learn/courses/30/lessons/118667
    public static void main(String[] args) {
        System.out.println("두 큐 합 같게 만들기 : " + QueueSameSolution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1})); // 2
        System.out.println("두 큐 합 같게 만들기 : " + QueueSameSolution(new int[]{1, 2, 1, 2}, new int[]{1, 10, 1, 2})); // 7
        System.out.println("두 큐 합 같게 만들기 : " + QueueSameSolution(new int[]{1, 1}, new int[]{1, 5})); // -1
    }

    public static int QueueSameSolution(int[] queue1, int[] queue2) {
        int answer = 0;
        int tempGoal = 0;//중간값
        int tempSum1 = 0; //큐1의 합
        int tempSum2 = 0; //큐2의 합
        int temp = 0;

        Queue<Integer> _queue1 = new LinkedList<>(), _queue2 = new LinkedList<>();
        for (int i : queue1) {
            _queue1.offer(i);
        }
        for (int i : queue2) {
            _queue2.offer(i);
        }
        tempSum1 = _queue1.stream().mapToInt(Integer::intValue).sum();
        tempSum2 = _queue2.stream().mapToInt(Integer::intValue).sum();
        tempGoal = (tempSum1+tempSum2) / 2;
        for (int i = 0; i < 300000; i++) {
            if (tempGoal > tempSum1) {//큐2 빼고 큐1로 추가
                temp = _queue2.poll();
                _queue1.offer(temp);
                tempSum1 += temp;
                tempSum2 -= temp;
            } else if (tempGoal < tempSum1) {//큐1 빼고 큐2로 추가
                temp = _queue1.poll();
                tempSum1 -= temp;
                tempSum2 += temp;
                _queue2.offer(temp);
            } else if (tempGoal == tempSum1) {//큐1 완성
                if (tempGoal == tempSum2) break;
                else return -1;
            }
            answer++;
        }
        if(tempGoal!=tempSum1 || tempGoal!=tempSum2) return -1;
//        System.out.println("큐1 : " + _queue1.stream().mapToInt(Integer::intValue).sum() + " // 큐2 : " + _queue2.stream().mapToInt(Integer::intValue).sum() + " // " + tempSum);
        return answer;
    }


}






