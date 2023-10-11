package Programmers_Lv1;

// 점수 ( 0 / 100 )
public class 둘만의암호 {
//    https://school.programmers.co.kr/learn/courses/30/lessons/155652
    public static void main(String[] args) {
        System.out.println("둘만의 암호 : "+Secretsolution("aukks", "wbqd", 5));
    }
    public static String Secretsolution(String s, String skip, int index) {
        //테스트 케이스는 통과 하지만 0점...
        StringBuilder answer = new StringBuilder();
        //ASCII CODE a 97 ~ z 122
        int tempIndex = 0, num = 0;
        for (char c : s.toCharArray()) {
            for (char skip_c : skip.toCharArray()) {
                if ((int) c < (int) skip_c && (int) skip_c < (c + index)) tempIndex++;
            }
            num = (c + index + tempIndex);
            if (num >= 123) num = (num - 123 + 97); // z(122)넘어갈 때 a(97)로 시작
            tempIndex = 0;
            answer.append((char) num);
        }

        /*ArrayList<Integer> skipArray = new ArrayList<>();
        for (char skip_c : skip.toCharArray()) {
            skipArray.add((int)skip_c);
        }
        for (char c : s.toCharArray()) {
            for(int i:skipArray){
                if((int)c<i && i<(c+index))tempIndex++;
            }
            num=(c+index+tempIndex);
            if (num >= 123) num = (num - 123 + 97); // z(122)넘어갈 때 a(97)로 시작
            tempIndex=0;
            answer.append((char)num);
        }
        System.out.println(answer);*/


        return answer.toString();
    }

}






