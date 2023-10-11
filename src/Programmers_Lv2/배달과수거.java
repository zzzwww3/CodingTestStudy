package Programmers_Lv2;


import java.util.HashMap;

// 점수 ( 30 / 100 )
public class 배달과수거 {
//    https://school.programmers.co.kr/learn/courses/30/lessons/12906
    public static void main(String[] args) {
        System.out.println("배달과 수거 : " + DeliverySolution(4, 5, new int[]{1, 0, 3, 1, 2}, new int[]{0, 3, 0, 4, 0}));
        System.out.println("배달과 수거 : " + DeliverySolution(2, 7, new int[]{1, 0, 2,0,1,0,2}, new int[]{0,2,0,1,0,2,0}));
    }

    public static long DeliverySolution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int tempCap = 0, tempN = n, lastIndex = 0;
        //cap 택배 한번에 실을 수 있는 최대 개수 , n 집(거리), deliveries 배달상자, pickups 수거상자
        HashMap<Integer, Integer> deliveryMap = new HashMap<>();
        HashMap<Integer, Integer> pickupMap = new HashMap<>();
        for (int i = 0; i < deliveries.length; i++) {
            deliveryMap.put(i, deliveries[i]);
        }
        for (int i = 0; i < pickups.length; i++) {
            pickupMap.put(i, pickups[i]);
        }

        int tempCycle = 1;
        while (true) {
            tempN = (deliveryMap.size() > pickupMap.size()) ? deliveryMap.size() : pickupMap.size(); // 배달, 수거 리스트중 가장 먼 곳
            answer += tempN; //끝까지 이동
//            System.out.println("배달 중 : " + tempCycle + " // " + answer + " // " + n + "//" + tempN);

            lastIndex = deliveryMap.size() - 1; //배열 마지막
            tempCap = cap; //배달 상자 준비
//            System.out.println("배달 전 : " + deliveryMap + " cap : " + cap);
            //배달 하기
            while (true) { //모두 배달할 때 까지
                if (deliveryMap.size() == 0) break;
                if (tempCap - deliveryMap.get(lastIndex) < 0) { // 부분 배달
                    deliveryMap.put(lastIndex, deliveryMap.get(lastIndex) - tempCap);
                    break;
                } else if (tempCap - deliveryMap.get(lastIndex) >= 0) { // 한 집 모두 배달
                    tempCap -= deliveryMap.get(lastIndex);
                    deliveryMap.remove(lastIndex);
                    if (lastIndex > 0) lastIndex--;
                    if (deliveryMap.size() != 0 && deliveryMap.get(lastIndex) != 0 && tempCap == 0) break;
                }
            }
//            System.out.println("배달 후 : " + deliveryMap + " cap : " + cap);

            lastIndex = pickupMap.size() - 1; //배열 마지막
            //수거 하기
//            System.out.println("수거 전 : " + pickupMap + " cap : " + cap);
            tempCap = 0; //수거 상자 준비
            while (true) { //모두 수거할 때 까지
                if (pickupMap.size() == 0) break;
                if (tempCap + pickupMap.get(lastIndex) > cap) { //부분 수거
                    pickupMap.put(lastIndex, pickupMap.get(lastIndex) - tempCap);
                    break;
                } else if (tempCap + pickupMap.get(lastIndex) <= cap) { //한 집 모두 수거
                    tempCap += pickupMap.get(lastIndex);
                    pickupMap.remove(lastIndex);
                    if (lastIndex > 0) lastIndex--;
                    if (pickupMap.size() != 0 && pickupMap.get(lastIndex) != 0 && tempCap == cap) break;
                }
            }
//            System.out.println("수거 후 : " + pickupMap + " cap : " + cap);
            tempCycle++;
            answer += tempN; //처음으로 이동
            if (deliveryMap.size() == 0 && pickupMap.size() == 0) break; // 배달종료
        }
        return answer;
    }



}






