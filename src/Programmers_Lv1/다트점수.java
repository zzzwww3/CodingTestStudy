package Programmers_Lv1;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 점수 ( 81.3 / 100 )
public class 다트점수 {
//    https://school.programmers.co.kr/learn/courses/30/lessons/17682
    public static void main(String[] args) {
        System.out.println("다트 점수 : " + DartSolution("1S2D*3T"));
        System.out.println("다트 점수 : " + DartSolution("1D2S#10S"));
        System.out.println("다트 점수 : " + DartSolution("1D2S0T"));
        System.out.println("다트 점수 : " + DartSolution("1S*2T*3S"));
        System.out.println("다트 점수 : " + DartSolution("1D#2S*3S"));
        System.out.println("다트 점수 : " + DartSolution("1T2D3D#"));
        System.out.println("다트 점수 : " + DartSolution("1D2S3T*"));
    }

    public static int DartSolution(String dartResult) {
        int answer = 0, tempNum = 0, tempIndex = 0;
        Pattern numPattern = Pattern.compile("\\d");
        Pattern wordPattern = Pattern.compile("[A-Z]");
        Pattern optionPattern = Pattern.compile("[*#]");
        Matcher numMatcher, wordMatcher, optionMatcher;
        boolean flag = false;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        String tempString = "";
        for (int i = 0; i < dartResult.length(); i++) {
            numMatcher = numPattern.matcher(String.valueOf(dartResult.charAt(i)));
            wordMatcher = wordPattern.matcher(String.valueOf(dartResult.charAt(i)));
            optionMatcher = optionPattern.matcher(String.valueOf(dartResult.charAt(i)));
            if (optionMatcher.find()) {
                if (optionMatcher.group().equals("#")) {
                    answer -= tempNum;
                } else if (optionMatcher.group().equals("*")) {
                    if (tempIndex > 2) { //3번째 부턴 바로 전 과 지금의 제곱
                        answer = (hashMap.get(tempIndex - 2) + (hashMap.get(tempIndex - 1) * 2) + (hashMap.get(tempIndex) * 2));
                    } else {
                        answer = (answer * 2) + (tempNum * 2);
                    }
                }
                tempNum = 0;
            } else {
                if (flag) { //문자를 찾은 후 옵션 값이 없을 때
                    answer += tempNum;
                    tempNum = -1;
                    flag = false;
                }
            }
            if (numMatcher.find()) {
                tempNum = Integer.parseInt(numMatcher.group());
                tempString += numMatcher.group();
                flag = false;
            } else if (wordMatcher.find()) {
                tempNum = Integer.parseInt(tempString); // 10 예외처리
                tempIndex++;
                tempString = "";
                flag = true;
                if (wordMatcher.group().equals("D")) {
                    if (tempNum != 0) {
                        tempNum = (tempNum * tempNum);
                    } else {
                        tempNum = answer * answer;
                    }
                } else if (wordMatcher.group().equals("T")) {
                    if (tempNum != 0) {
                        tempNum = (tempNum * tempNum * tempNum);
                    }
                }
                hashMap.put(tempIndex, tempNum);
                if (i == dartResult.length() - 1) {
                    //마지막 옵션 없을 경우
                    answer += tempNum;
                }
            }
        }
        return answer;
    }

}






