package Programmers_Lv1;

import java.util.Arrays;

// 점수 ( 100 / 100 )
public class 공원산책 {
//    https://school.programmers.co.kr/learn/courses/30/lessons/172928
    public static void main(String[] args) {
        System.out.println("공원산책 : " + Arrays.toString(parkSolution(new String[]{"SOO", "OOO", "OOO"}, new String[]{"E 2", "S 2", "W 1"})));
        System.out.println("공원산책 : " + Arrays.toString(parkSolution(new String[]{"OSO", "OOO", "OXO", "OOO"}, new String[]{"E 2", "S 3", "W 1"})));
    }
    public static int[] parkSolution(String[] park, String[] routes) {
        int[] answer = new int[2]; //세로, 가로
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') { //시작위치 저장
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        boolean isX = false;
        int distance = 0;
        for (int i = 0; i < routes.length; i++) {
            isX = false;
            distance = Character.getNumericValue(routes[i].charAt(2)); // routes 숫자
            if (routes[i].charAt(0) == 'E') { // 오른쪽 이동
                if (answer[1] + distance >= park[answer[0]].length()) continue; // 공원 이탈
                for (int j = 1; j <= distance; j++) { // 몇칸 이동
                    if (park[answer[0]].charAt(answer[1] + j) == 'X') { // 이동중에 X가 있을 때
                        isX = true;
                        break;
                    }
                }
                if (isX) continue;
                answer[1] += distance;
            } else if (routes[i].charAt(0) == 'W') { // 왼쪽 이동
                if (answer[1] - distance < 0) continue; // 공원 이탈
                for (int j = 1; j <= distance; j++) { // 몇칸 이동
                    if (park[answer[0]].charAt(answer[1] - j) == 'X') { // 이동중에 X가 있을 때
                        isX = true;
                        break;
                    }
                }
                if (isX) continue;
                answer[1] -= distance;
            } else if (routes[i].charAt(0) == 'N') { // 위로 이동
                if (answer[0] - distance < 0) continue; // 공원 이탈
                for (int j = 1; j <= distance; j++) {// 몇칸 이동
                    if (park[answer[0] - j].charAt(answer[1]) == 'X') { // 이동중에 X가 있을 때
                        isX = true;
                        break;
                    }
                }
                if (isX) continue;
                answer[0] -= distance;

            } else if (routes[i].charAt(0) == 'S') { // 아래로 이동
                if (answer[0] + distance >= park.length) continue; // 공원 이탈
                for (int j = 1; j <= distance; j++) {// 몇칸 이동
                    if (park[answer[0] + j].charAt(answer[1]) == 'X') { // 이동중에 X가 있을 때
                        isX = true;
                        break;
                    }
                }
                if (isX) continue;
                answer[0] += distance;
            }
        }
//        System.out.println(answer[0] + "," + answer[1]);

        return answer;
    }

}






