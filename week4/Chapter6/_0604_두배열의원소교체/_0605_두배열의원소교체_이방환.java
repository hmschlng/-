package _0604_두배열의원소교체;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class _0605_두배열의원소교체_이방환 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(),
        K = sc.nextInt();
    sc.nextLine();

    ArrayList<Integer> A = new ArrayList<>(
            Arrays.stream(sc.nextLine().split(" "))
            .mapToInt(Integer::parseInt)
            .boxed()
            .toList()
    );
    ArrayList<Integer> B = new ArrayList<>(
            Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .toList()
    );

    Collections.sort(A);
    Collections.sort(B, Collections.reverseOrder());

    for (int i = 0; i < K; i++) {
      A.remove(0);
      A.add(B.remove(0));
    }

    int sum = A.stream().mapToInt(Integer::intValue).sum();
    System.out.println(sum);
  }
}
