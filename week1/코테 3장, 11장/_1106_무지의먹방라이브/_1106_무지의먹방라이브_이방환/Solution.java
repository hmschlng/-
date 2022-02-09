package _1106_무지의먹방라이브.myCode;

import java.util.*;

class Food {
  Integer time;
  Integer index;

  public Food(Integer time, Integer index) {
    this.time = time;
    this.index = index;
  }

  public int compareToTime(Food o) {
    return Integer.compare(this.time, o.time);
  }

  public int compareToIndex(Food o) {
    return Integer.compare(this.index, o.index);
  }
}

class Solution {
  public int solution(int[] food_times, long k) {
    long total = Arrays.stream(food_times)
            .mapToLong(i -> {
              return Integer.valueOf(i).longValue();
            }).sum();

    if (total <= k) return -1;

    PriorityQueue<Food> priorityQueue = new PriorityQueue<>(Food::compareToTime);

    for (int i = 0; i < food_times.length; i++) {
      priorityQueue.offer(new Food(food_times[i], i + 1));
    }

    Long prev = 0L;
    while (priorityQueue.size() * (priorityQueue.peek().time - prev) <= k) {
      k -= priorityQueue.size() * (priorityQueue.peek().time - prev);
      prev = priorityQueue.poll().time.longValue();
    }

    ArrayList<Food> foods = new ArrayList<>(priorityQueue);

    Collections.sort(foods, Food::compareToIndex);

    return foods.get((int)(k % foods.size())).index;
  }
}

class Main {
  public static void main(String[] args) {
    int[] food_times = {3,1,2};
    long k = 5;
    System.out.println(new Solution().solution(food_times, k));
  }
}