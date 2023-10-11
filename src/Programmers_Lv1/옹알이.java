package Programmers_Lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// 점수 ( 55 / 100 )
public class 옹알이 {
    //    https://school.programmers.co.kr/learn/courses/30/lessons/133499
    public static void main(String[] args) {
        System.out.println("옹알이 : " + Babblingsolution(new String[]{"aya", "yee", "u", "maa"}));
        System.out.println("옹알이 : " + Babblingsolution(new String[]{"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"}));
        System.out.println("옹알이 : " + Babblingsolution(new String[]{"abc", "def", "ghi"}));
        System.out.println("옹알이 : " + Babblingsolution(new String[]{"aya", "ye", "woo", "ma"}));
        System.out.println("옹알이 : " + Babblingsolution(new String[]{"ayaye", "ayaye", "uuuma", "ye", "yemawoo", "ayaa"}));
    }

    public static int Babblingsolution(String[] babbling) {
        int answer = 0;
        // 가능한 발음 "aya", "ye", "woo", "ma"
        HashMap<String, Integer> talkMap = new HashMap<String, Integer>() {{
            put("aya", 1);
            put("ye", 1);
            put("woo", 1);
            put("ma", 1);
        }};
        for (String _babbling : babbling) {
            if (talkMap.getOrDefault(_babbling, 0) == 1) answer++;
            else {
                answer += Search(_babbling, talkMap);
            }
            talkMap = new HashMap<String, Integer>() {{
                put("aya", 1);
                put("ye", 1);
                put("woo", 1);
                put("ma", 1);
            }};
        }
        return answer;
    }

    public static int Search(String _babbling, HashMap<String, Integer> talk) {
        //조합 가능한지 검색
        int count = 0;
        for (String s : talk.keySet()) {
            if (_babbling.contains(s)) {
                if (talk.get(s) == 1) { // 1 처음 발견 0 중복
                    talk.put(s, 0);
                    _babbling = _babbling.replaceFirst(s, "");
                    if (_babbling.isEmpty()) count = 1;
                    else if (!_babbling.isEmpty()) count = Search(_babbling, talk);
                    return count;
                }
            }
        }
        return count;
    }



}






