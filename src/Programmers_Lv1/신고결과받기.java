package Programmers_Lv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

// 점수 ( 83.3 / 100 )
public class 신고결과받기 {
    //    https://school.programmers.co.kr/learn/courses/30/lessons/92334
    public static void main(String[] args) {
        System.out.println("신고 결과 받기: " + Arrays.toString(ReportSolution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2)));
        System.out.println("신고 결과 받기: " + Arrays.toString(ReportSolution(new String[]{"con", "ryan"}, new String[]{"ryan con", "ryan con", "ryan con", "ryan con"}, 2)));
    }

    public static int[] ReportSolution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        //다른 사람에게 k번 신고 당하면 신고한 사람들에게 이메일을 보내야 한다.
        //한 사람의 신고 누적은 1번으로 카운트.
        HashMap<String, Integer> emailCountList = new HashMap<String, Integer>(); // 이름, 이메일 받을 횟수
        for (String id : id_list) {
            emailCountList.put(id, 0);
        }
        Set<String> reportArray = new HashSet<>(); // 같은 사람이 한 사람을 여러번 신고한 내용 제거
        for (String _report : report) {
            reportArray.add(_report);
        }
        HashMap<String, String> emailArray = new HashMap<>(); // 신고 당한 사람 , 신고한 사람
        for (String _report : reportArray) { //중복 제거 한 배열 탐색
            if (emailArray.get(_report.split(" ")[1]) == null) {//없으면 추가
                emailArray.put(_report.split(" ")[1], _report.split(" ")[0]);
            } else {//있으면 ,로 Concat
                emailArray.put(_report.split(" ")[1], emailArray.get(_report.split(" ")[1]) + "," + _report.split(" ")[0]);
            }
        }
        for (String recipientEmail : emailArray.values()) { // 이메일 받을 사람
            if (recipientEmail.contains(",")) { // 2개 이상 체크
                if (recipientEmail.split(",").length >= k) { // 신고 누적 k개 이상일 때만
                    for (String id : recipientEmail.split(",")) {
                        emailCountList.put(id, emailCountList.get(id) + 1); //이메일 받을 횟수 추가
                    }
                }
            }
        }
//        System.out.println(" 신고 당한 사람/신고 한 사람 : " + emailArray);
        int index = 0;
        for (String id : id_list) {
            answer[index] = emailCountList.get(id);
            index++;
        }
        return answer;
    }

}






