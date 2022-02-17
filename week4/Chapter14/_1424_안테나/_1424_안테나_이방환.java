package _1424_안테나;

import java.util.*;

public class _1424_안테나_이방환 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    sc.nextLine();

    ArrayList<Integer> houses = new ArrayList<>(
            Arrays.asList(
                    Arrays.stream(sc.nextLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .boxed()
                            .toArray(Integer[]::new)
            )
    );

    Collections.sort(houses);

    System.out.println(houses.get((houses.size()-1)/2));
  }
}
