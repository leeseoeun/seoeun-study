## **switch 문**<br>
처리할 경우의가 많은 경우에는 if 문보다 `switch 문`으로 작성하는 것이 좋음<br>

<br>

### **1. switch 문의 흐름**<br>
1. 조건 식을 계산<br>
2. 조건 식의 결과와 일치하는 case 문으로 이동<br>
3. 이후의 문장들을 수행<br>
4. break 문이나 switch 문의 끝을 만나면 switch 문 전체를 빠져나감<br>

<br>

```java
switch (조건식) {
    case 값1 :
        ... //조건 식의 결과가 값1과 같을 경우 수행될 문장들
        break;  //swith 문을 벗어남
    case 값2 :
        ...
        break;
    case 값3 :
        ...
        break;
    default:
        ... //조건 식의 결과와 일치하는 case 문이 없을 때 수행될 문장들
}
```

<br>

### **2. swith 문의 제약 조건**<br>
1. switch 문의 조건 식 결과는 정수 또는 문자(열)이어야 함<br>
2. case 문의 값은 정수 상수만 가능하고, 중복되지 않아야 함<br>
