package __Ex02_시각;

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int count = 0;
    //Hour
    for (int i = 0; i <= N; i++) {
      //Minute
      for (int j = 0; j < 60; j++) {
        //Second
        for (int k = 0; k < 60; k++) {
          //3이 포함
          if(i%10 == 3 || j%10==3 || j/10 == 3 || k%10==3 || k/10==3) {
            count++;
          }
        }
      }
    }
    System.out.println(count);
  }
}
