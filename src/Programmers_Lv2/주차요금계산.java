package Programmers_Lv2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

// 점수 ( 75 / 100 ) 런타임 에러(-25)
public class 주차요금계산 {
//    https://school.programmers.co.kr/learn/courses/30/lessons/92341
    public static void main(String[] args) {
        System.out.println("주차 요금 계산 : " + Arrays.toString(ParkingFeeSolution(new int[]{180,5000,10,600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"}))); // [14600, 34400, 5000]
        System.out.println("주차 요금 계산 : " + Arrays.toString(ParkingFeeSolution(new int[]{120,0,60,591}, new String[]{"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"}))); // [0, 591]
        System.out.println("주차 요금 계산 : " + Arrays.toString(ParkingFeeSolution(new int[]{1,461,1,10}, new String[]{"00:00 1234 IN"}))); // [14841]
    }

    public static int[] ParkingFeeSolution(int[] fees, String[] records) {
        /**
         기본 시간(분)	기본 요금(원)	단위 시간(분)	단위 요금(원)
         기본요금 + [(시간 - 기본시간)/단위 시간(분)] * 단위 요금
         180	5000	10	600
         번호 낮은순으로 정렬
         */
        Set<String> carNumbers=new HashSet<>();
        ArrayList<String> sortCarNums=new ArrayList<>();
        HashMap<String,String> inMap = new HashMap<>(),outMap=new HashMap<>(),resultMap=new HashMap<>();
        for(String record:records){
            if(record.contains("IN")){
                if(inMap.getOrDefault(record.split(" ")[1],"-1").equals("-1")){// 입차가 처음인 경우
                    inMap.put(record.split(" ")[1],record.split(" ")[0]);
                }else{ //입차가 여러번 있을 때 ,로 추가
                    inMap.put(record.split(" ")[1],inMap.get(record.split(" ")[1])+","+record.split(" ")[0]);
                }
            }else if(record.contains("OUT")){
                if(outMap.getOrDefault(record.split(" ")[1],"-1").equals("-1")){// 출차가 처음인 경우
                    outMap.put(record.split(" ")[1],record.split(" ")[0]);
                }else{ //출차가 여러번 있을 때 ,로 추가
                    outMap.put(record.split(" ")[1],outMap.get(record.split(" ")[1])+","+record.split(" ")[0]);
                }
            }
            carNumbers.add(record.split(" ")[1]);
        }
        sortCarNums=new ArrayList<>(carNumbers);
        Collections.sort(sortCarNums);
//        System.out.println(" sortCarNums : "+sortCarNums+" // "+inMap+" // "+outMap);
        SimpleDateFormat format=new SimpleDateFormat("HH:mm",Locale.KOREA);
        for(String carNum:sortCarNums){
            long diffTime=0;
            try {
                if(inMap.get(carNum).contains(",")){ // 입차시간이 여러번 일 때
                    for(int i=0;i<inMap.get(carNum).split(",").length;i++){
                        if(outMap.getOrDefault(carNum,"23:59").contains(",")){ //출차시간이 여러번 일 때
                            Date endTime = format.parse(outMap.getOrDefault(carNum,"23:59").split(",")[i]);
                            Date startTime = format.parse(inMap.get(carNum).split(",")[i]);
                            diffTime+=(Math.abs(endTime.getTime()-startTime.getTime()))/60000;
//                            System.out.println("diffTime : outMap , "+diffTime);
                        }else{ // 입차시간은 여러번이지만 출차시간은 한번일 때
                            Date endTime = format.parse(outMap.getOrDefault(carNum,"23:59"));
                            if(i!=0) endTime=format.parse("23:59");
                            Date startTime = format.parse(inMap.get(carNum).split(",")[i]);
                            diffTime+=(Math.abs(endTime.getTime()-startTime.getTime()))/60000;
//                            System.out.println("diffTime : outMap "+diffTime+" // "+startTime+" // " +endTime);
                        }
                    }
                }else{ // 입차시간이 한번 일 때
                    Date endTime= format.parse(outMap.getOrDefault(carNum,"23:59"));
                    Date startTime= format.parse(inMap.get(carNum));
                    if(endTime.getTime()<startTime.getTime()) endTime=format.parse("23:59");
                    diffTime=(Math.abs(endTime.getTime()-startTime.getTime()))/60000;
                }
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            if(diffTime-fees[0]<=0){ //기본요금
//                System.out.println("carNum : "+carNum+" 기본 요금 : "+fees[1]);
                resultMap.put(carNum,String.valueOf(fees[1]));
            }else{ //추가 요금
                int tempValue= (int) ((diffTime - fees[0])/fees[2])==0?1:(int) Math.ceil((double)(diffTime - fees[0])/fees[2]); //추가시간 계산 0일때 1로 초기화 , 소수점 올림
//                System.out.println("carNum : "+carNum+" 추가 요금 "+fees[1]+" // 추가 시간"+diffTime+" // "+tempValue+" // "+(fees[1]+(tempValue*fees[3])));
                resultMap.put(carNum,String.valueOf(fees[1]+(tempValue*fees[3])));
            }
        }
        int[] answer = new int[resultMap.size()];

        for(int i=0;i<resultMap.size();i++){
            answer[i]=Integer.parseInt(resultMap.get(sortCarNums.get(i)));
        }

        return answer;
    }
}






