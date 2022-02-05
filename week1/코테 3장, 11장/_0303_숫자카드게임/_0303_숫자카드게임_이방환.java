package _0303_숫자카드게임;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int M = scanner.nextInt(),    //Column
          N = scanner.nextInt();  //Row
    List<List<Integer>> cardList = new ArrayList<>();
    for(int i = 0; i < N; i++) {
      List<Integer> row = new ArrayList<>();
      for(int j=0;j<M;j++) {
        row.add(scanner.nextInt());
      }
      cardList.add(row);
    }

    int result = 0;
    for(int i=0;i< cardList.size();i++) {
      int rowMin = 10001;
      for(int j=0;j<cardList.get(i).size();j++) {
        if(cardList.get(i).get(j) < rowMin) {
          rowMin = cardList.get(i).get(j);
        }
      }
      if(rowMin > result) {
        result = rowMin;
      }
    }

    System.out.println(result);
  }
}

//소요시간 : 19분