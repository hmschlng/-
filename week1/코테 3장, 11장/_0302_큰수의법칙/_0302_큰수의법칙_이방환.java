package _0302_큰수의법칙;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    int n, m, k;
    Scanner scanner = new Scanner(System.in);
    n = scanner.nextInt();
    m = scanner.nextInt();
    k = scanner.nextInt();
    List<Integer> nList = new ArrayList<>();

    for(int i = 0; i < n; i++) {
      nList.add(scanner.nextInt());
    }

    nList.sort(Comparator.comparingInt(x -> x));

    int x = nList.get(n-1),
        y = nList.get(n-2);

    int result = (m/(k+1) * (x*k)) +
            (m/(k+1) * y) +
            (m%(k+1) * x);

    System.out.println(result);
  }
}
