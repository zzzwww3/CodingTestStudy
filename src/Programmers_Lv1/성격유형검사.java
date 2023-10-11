package Programmers_Lv1;

import java.util.HashMap;

// 점수 ( 100 / 100 )
public class 성격유형검사 {
    //    https://school.programmers.co.kr/learn/courses/30/lessons/118666
    public static void main(String[] args) {
        System.out.println("성격 유형 검사 : " + SurveySolution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5}));
        System.out.println("성격 유형 검사 : " + SurveySolution(new String[]{"TR", "RT", "TR"}, new int[]{7, 1, 3}));
    }

    public static String SurveySolution(String[] survey, int[] choices) {
        String answer = "";
        HashMap<String, Integer> surveyCount = new HashMap<String, Integer>() {{
            put("R", 0);
            put("T", 0);
            put("C", 0);
            put("F", 0);
            put("J", 0);
            put("M", 0);
            put("A", 0);
            put("N", 0);
        }};
        int index = 0;
        for (String _survey : survey) {
            int choice = choices[index];
            switch (choice) {
                case 1:
                    surveyCount.put(_survey.substring(0, 1), surveyCount.get(_survey.substring(0, 1)) + 3);
                    break;
                case 2:
                    surveyCount.put(_survey.substring(0, 1), surveyCount.get(_survey.substring(0, 1)) + 2);
                    break;
                case 3:
                    surveyCount.put(_survey.substring(0, 1), surveyCount.get(_survey.substring(0, 1)) + 1);
                    break;
                case 5:
                    surveyCount.put(_survey.substring(1, 2), surveyCount.get(_survey.substring(1, 2)) + 1);
                    break;
                case 6:
                    surveyCount.put(_survey.substring(1, 2), surveyCount.get(_survey.substring(1, 2)) + 2);
                    break;
                case 7:
                    surveyCount.put(_survey.substring(1, 2), surveyCount.get(_survey.substring(1, 2)) + 3);
                    break;
            }
            index++;
        }
        answer += (surveyCount.get("R") >= surveyCount.get("T")) ? "R" : "T";
        answer += (surveyCount.get("C") >= surveyCount.get("F")) ? "C" : "F";
        answer += (surveyCount.get("J") >= surveyCount.get("M")) ? "J" : "M";
        answer += (surveyCount.get("A") >= surveyCount.get("N")) ? "A" : "N";
        return answer;
    }


}






