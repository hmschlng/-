package _0603_성적이낮은순서로학생출력하기;

import java.util.*;

class _0603_성적이낮은순서로학생출력하기_이방환 {

  static void sort_useLibrary(ArrayList<Student> src) {
    // 내부적으로 Time Sort 사용
    Collections.sort(src);
  }
  static void sort_implemented(Student[] src, int start, int end) {
    if(start >= end) return;

    int pivot = start;
    int left = start + 1;
    int right = end;

    while(left <= right) {
      while(left <= end && src[left].score >= src[pivot].score) left++;
      while(right > start && src[right].score <= src[pivot].score) right--;
      if(left > right) {
        swap(src, left, right);
      } else {
        swap(src, pivot, right);
      }
    }
    sort_implemented(src, start, right-1);
    sort_implemented(src, right+1, end);
  }

  static void swap(Student[] src, int idx1, int idx2) {
    Student temp = src[idx1];
    src[idx1] = src[idx2];
    src[idx2] = temp;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    sc.nextLine();
    Student[] students1 = new Student[N];

    for (int i = 0; i < N; i++) {
      String[] line = sc.nextLine().split(" ");
      students1[i] = new Student(line[0], Integer.parseInt(line[1]));
    }

    ArrayList<Student> students2 = new ArrayList<>(Arrays.stream(students1).toList());

    sort_implemented(students1, 0, students1.length-1);
    sort_useLibrary(students2);

    for (Student s : students1) {
      System.out.print(s + " ");
    }
    System.out.print("-> 직접 구현 : Quick Sort\n");

    for (Student s : students2) {
      System.out.print(s + " ");
    }
    System.out.print("-> 라이브러리 사용(Collections.sort) : Time Sort");
  }
}

class Student implements Comparable<Student> {
  String name;
  Integer score;

  public Student(String name, Integer score) {
    this.name = name;
    this.score = score;
  }

  @Override
  public int compareTo(Student other) {
    return Integer.compare(this.score, other.score);
  }

  public String toString() {
    return this.name;
  }
}