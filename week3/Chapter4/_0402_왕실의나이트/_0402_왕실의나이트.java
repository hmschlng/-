package _0402_왕실의나이트;

import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    //나이트의 좌표 입력받기
    String[] location = sc.nextLine().split("");

    int row = Integer.parseInt(location[1]);  //String은 Integer로 파싱
    String col = location[0];
    int result;

    //각 위치에 따른 결과를 분류
    if( row==1 || row==8 ) {
      if(col.equals("a") || col.equals("h")) result = 2;
      else if(col.equals("b") || col.equals("g")) result = 3;
      else result = 4;
    }
    else if(row==2 || row==7) {
      if(col.equals("a") || col.equals("h")) result = 3;
      else if(col.equals("b") || col.equals("g")) result = 4;
      else result = 6;
    }
    else {
      if(col.equals("a") || col.equals("h")) result = 4;
      else if(col.equals("b") || col.equals("g")) result = 6;
      else result = 8;
    }

    System.out.println(result);
  }
}

