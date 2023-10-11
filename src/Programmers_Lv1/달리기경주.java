package Programmers_Lv1;

import java.util.*;

// 점수 ( 100 / 100 )
public class 달리기경주 {
//    https://school.programmers.co.kr/learn/courses/30/lessons/178871
    public static void main(String[] args) {
        System.out.println("달리기 경주 : "+Arrays.asList(RunSolution(new String[]{"mumu", "soe", "poe", "kai", "mine"},new String[]{"kai", "kai", "mine", "mine"})));
    }

    public static String[] RunSolution(String[] players, String[] callings) {

        String[] answer = {};
        HashMap<String, Integer> playerMap = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            playerMap.put(players[i], i);
        }
        for (int i = 0; i < callings.length; i++) {
            if (playerMap.containsKey(callings[i])) {
                int tempIndex = playerMap.get(callings[i]);
                if (tempIndex != 0) {
                    String temp = players[tempIndex - 1];
                    players[tempIndex - 1] = players[tempIndex];
                    players[tempIndex] = temp;
                    playerMap.put(callings[i], tempIndex - 1);
                    playerMap.put(temp, tempIndex);
                }
            }
        }
        answer = players;
        return answer;
    }

}






