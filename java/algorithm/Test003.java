package com.eomcs.algorithm.quiz;

//알고리즘 테스트03
//출처: codefights.com

//배열의 전체 길이를 L이라고 하자
//배열을 절반(L/2)으로 나눌 때, 앞쪽 부분과 뒤쪽 부분의 위치를 바꿔라

public class Test003 {

  static void changeValuePosition(int[] values) {

    int length = values.length / 2; //배열의 절반 길이

    for (int i=0; i<length; i++) {
      int temp; //임시로 배열을 저장할 변수
      if (values.length % 2 == 0) { //배열의 길이가 짝수라면
        temp = values[i];
        values[i] = values[i+length];
        values[i+length] = temp;
      } else if (values.length % 2 != 0) {  //배열의 길이가 홀수라면
        temp = values[i];
        values[i] = values[i+length+1]; //중간 인덱스는 고정이니까 +1
        values[i+length+1] = temp;
      }
    }

  }

  public static void main(String[] args) {
    int[] values = {1, 3, 5, 7, 2, 4, 6, 8};
    changeValuePosition(values);

    for (int v : values) {
      System.out.print(v + ",");
    }
  }

}
