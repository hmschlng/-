package _0602_위에서아래로;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class _0602_위에서아래로_이방환 {
  static void reverseSort_implemented(Integer[] src) {
    // Insertion Sort 사용
    for (int i = 1; i < src.length; i++) {
      for (int j = i; j > 0 ; j++) {
        if(src[j] > src[j - 1]) {
          swap(src, j, j-1);
        } else break;
      }
    }
  }
  static void swap(Integer[] src, int idx1, int idx2) {
    int temp = src[idx1];
    src[idx1] = src[idx2];
    src[idx2] = temp;
  }

  static void reverseSort_useLibrary(Integer[] src) {
    // Dual-Pivot Quick Sort 사용
    Arrays.sort(src, Collections.reverseOrder());
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    Integer[] arr1 = new Integer[N];
    for (int i = 0; i < arr1.length; i++) {
      arr1[i] = sc.nextInt();
    }
    Integer[] arr2 = arr1.clone();

    reverseSort_implemented(arr1);
    reverseSort_useLibrary(arr2);

    System.out.println(Arrays.toString(arr1) + " -> 직접 구현 : Insertion Sort");
    System.out.println(Arrays.toString(arr2) + " -> 라이브러리(Arrays.sort) : Dual-Pivot Quick Sort");
  }
}
