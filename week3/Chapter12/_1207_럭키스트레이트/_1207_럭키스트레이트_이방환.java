package _1207_럭키스트레이트;

import java.util.*;
import java.util.stream.Stream;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String score = sc.nextLine();
    int[] left
            = Stream.of(score.substring(0, score.length()/2).split(""))
            .mapToInt(Integer::parseInt)
            .toArray();

    int[] right
            = Stream.of(score.substring(score.length()/2).split(""))
            .mapToInt(Integer::parseInt)
            .toArray();

    int leftSum = Arrays.stream(left)
            .reduce(0,(a,b)->  a + b);

    int rightSum = Arrays.stream(right)
            .reduce(0,(a,b)->  a + b);

    if(leftSum == rightSum) {
      System.out.println("LUCKY");
    }
    else {
      System.out.println("READY");
    }
  }
}