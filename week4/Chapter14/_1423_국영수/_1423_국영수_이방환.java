package _1423_국영수;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

class _1423_국영수_이방환 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    sc.nextLine();

    ArrayList<Student> stuList = new ArrayList<>(N);

    for (int i = 0; i < N; i++) {
      String[] line = sc.nextLine().split(" ");
      stuList.add(new Student(line[0],
              Integer.parseInt(line[1]),
              Integer.parseInt(line[2]),
              Integer.parseInt(line[3])));
    }

    stuList.sort(Student::compareTo);

    for (Student s : stuList) {
      System.out.println(s.toString());
    }
  }
}

class Student implements Comparable<Student> {
  String name;
  Integer Kor;
  Integer Eng;
  Integer Math;

  public Student(String name, Integer Kor, Integer Eng, Integer Math) {
    this.name = name;
    this.Kor = Kor;
    this.Eng = Eng;
    this.Math = Math;
  }

  @Override
  public int compareTo(Student o) {
    return (Objects.equals(this.Kor, o.Kor)) ? (
              (Objects.equals(this.Eng, o.Eng)) ? (
                (Objects.equals(this.Math, o.Math)) ? (
                  (this.name.equals(o.name)) ? 0 : this.name.compareTo(o.name)
                ) : Integer.compare(o.Math, this.Math)
              ) : Integer.compare(this.Eng, o.Eng)
            ) : Integer.compare(o.Kor, this.Kor);
  }

  public String toString() {
    return this.name;
  }
}
