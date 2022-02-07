package _1210_자물쇠와열쇠._1210_자물쇠와열쇠_이방환;

public class Main {
  public static void main(String[] args) {
    int[][] lock = {
/*            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
            {1,0,1,0,1,1},
            {1,1,0,0,1,1},
            {1,1,1,1,1,1}*/
            {1,1,1},
            {1,1,0},
            {1,0,1}
    };
    int[][] key = {
/*            {0,1,1,0},
            {0,0,1,0},
            {0,1,0,0},
            {0,0,0,0}*/
            {0,0,0},
            {1,0,0},
            {0,1,1}
    };

    System.out.println(new Solution().solution(key, lock));
  }
}
