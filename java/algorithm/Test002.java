package com.eomcs.algorithm.quiz;

//알고리즘 테스트02
//출처: codefights.com

//숫자 배열에서 각 이웃하는 숫자 간의 차가 가장 큰 것을 알아내기

public class Test002 {

  static int maxDiff(int[] values) {
    int diff = 0; //숫자 간의 차

    for (int i=0; i<values.length-1; i++) {
      if (Math.abs(values[i] - values[i+1]) > diff) {    //마이너스가 나올 수 있으니까 절댓값
        diff = Math.abs(values[i] - values[i+1]);

        //int result = Math.abs(values[i] - values[i+1]); 을 해도 좋음
        //if (result > diff) {
        //  diff = result;
        //}
      }
    }

    return diff;
  }

  public static void main(String[] args) {
    System.out.println(maxDiff(new int[]{1, 3, 2, 5}));
  }

}
