package Programmers_Lv1;

import java.util.Arrays;
import java.util.HashMap;

// 점수 ( 100 / 100 )
public class 대충만든자판 {
//    https://school.programmers.co.kr/learn/courses/30/lessons/160586
    public static void main(String[] args) {
        System.out.println("대충 만든 자판 : "+ Arrays.toString(KeyMapsolution(new String[]{"ABACD", "BCEFD"},new String[]{"ABCD", "AABB"})));
        System.out.println("대충 만든 자판 : "+Arrays.toString(KeyMapsolution(new String[]{"AA"},new String[]{"B"})));
        System.out.println("대충 만든 자판 : "+Arrays.toString(KeyMapsolution(new String[]{"AGZ", "BSSS"},new String[]{"ASA", "BGZ"})));
        System.out.println("대충 만든 자판 : "+Arrays.toString(KeyMapsolution(new String[]{"AA","BSSS"},new String[]{"B","D","F"})));
    }
    public static int[] KeyMapsolution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int tempCount = 0; //총 몇번 눌러야 하는지 체크
        HashMap<Character, Integer> key = new HashMap<>();
        int index = 1; // key 누른 횟수라 1부터 시작
        for (String _keymap : keymap) {
            index = 1;
            for (char c : _keymap.toCharArray()) {
                if (key.get(c) == null) key.put(c, index);
                else if (key.get(c) > index) key.put(c, index); // 가까운 인덱스 넣기
                index++;
            }
        }
        index = 0; // answer배열의 index라 0으로 초기화
        for (String target : targets) {
            tempCount = 0;
            for (char c : target.toCharArray()) {
                if (key.get(c) != null) tempCount += key.get(c);
                else { // 일치하는 문자가 없다면
                    tempCount = 0;
                    break;
                }
            }
            if (tempCount == 0) answer[index] = -1; // 일치하는 문자가 없다면
            else answer[index] = tempCount;
            index++;
        }

        return answer;
    }

}






