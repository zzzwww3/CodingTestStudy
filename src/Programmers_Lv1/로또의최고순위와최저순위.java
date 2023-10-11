package Programmers_Lv1;


import java.util.ArrayList;
import java.util.Arrays;

// 점수 ( 100 / 100 )
public class 로또의최고순위와최저순위 {
//    https://school.programmers.co.kr/learn/courses/30/lessons/77484
    public static void main(String[] args) {
        System.out.println("로또 최고 최저 : " + Arrays.toString(LottoSolution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19})));
        System.out.println("로또 최고 최저 : " + Arrays.toString(LottoSolution(new int[]{0, 0, 0, 0, 0, 0}, new int[]{38, 19, 20, 40, 15, 25})));
        System.out.println("로또 최고 최저 : " + Arrays.toString(LottoSolution(new int[]{45, 4, 35, 20, 3, 9}, new int[]{20, 9, 3, 45, 4, 35})));
    }
    public static int[] LottoSolution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int rank = 0, count = 0, joker = 0; // 0은 될수도 있고 안 될수도 있음.
        ArrayList<Integer> winNumList = new ArrayList<>();
        for (int i : win_nums) {
            winNumList.add(i);
        }

        for (int lotto : lottos) {
            if (winNumList.contains(lotto)) count++;
            if (lotto == 0) joker++;
        }
        switch (count) {
            case 2:
                rank = 5;
                break;
            case 3:
                rank = 4;
                break;
            case 4:
                rank = 3;
                break;
            case 5:
                rank = 2;
                break;
            case 6:
                rank = 1;
                break;
            default:
                rank = 6;
                break;
        }
        answer[1] = rank;
        answer[0] = (rank - joker < 1) ? 1 : rank - joker;
//        System.out.println(count + " // " + rank + " joker : " + joker);
        return answer;
    }

}






