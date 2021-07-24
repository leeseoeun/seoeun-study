## **알고리즘 테스트01**<br>
**출처: codefights.com**<br>

<br><br>

주어진 숫자에 짝수가 몇 개인지 세라<br>
예) 123 => 1<br>

<br>

```java
public class Test {

  static int countEvenNumber(int value) {
    int n = value;  //주어진 숫자
    int count = 0;  //짝수의 개수 카운트

    while (n != 0) {
      if ((n % 2) == 0) {   //짝수는 2로 나눴을 때 나머지가 0이니까
        count++;
      }

      n /= 10;  //10으로 나누면서 끝의 한자리씩 판단
    }

    return count;
  }

  public static void main(String[] args) {
    System.out.println(countEvenNumber(123789456));
  }

}
```
