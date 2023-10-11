package Programmers_Lv1;

// 점수 ( 83.3 / 100 )
public class 문자열나누기 {
    //    https://school.programmers.co.kr/learn/courses/30/lessons/140108
    public static void main(String[] args) {
        System.out.println("문자열 나누기 : "+Splitsolution("abracadabra"));
    }
    public static int Splitsolution(String s) {
        int answer = 0;
        int sameCount = 0, anotherCount = 0, indexCount = 0;
        char nowChar = 0;
        for (char c : s.toCharArray()) {
            if (nowChar == 0) { // 처음 or 분리 후
                nowChar = c;
                sameCount++;
                if (indexCount == s.toCharArray().length - 1) answer++; // 마지막에 분리 후 혼자 있는 값 추가
            } else { // 중간
                if (nowChar != c) {
                    anotherCount++;
                } else {
                    sameCount++;
                }
                if (sameCount == anotherCount) { //카운트 같을 때 분리하기
                    answer++;
                    sameCount = 0;
                    anotherCount = 0;
                    nowChar = 0;
                }
            }
            indexCount++;
        }
        return answer;
    }

}






