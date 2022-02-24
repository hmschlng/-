package _0702_부품찾기;

import com.sun.source.tree.BinaryTree;

import java.util.*;

class _0702_부품찾기_이방환 {
  public static ArrayList<Integer> parts = new ArrayList<>(); // 매장에 있는 부품들
  public static ArrayList<Integer> buyList = new ArrayList<>(); // 손님이 구매할 부품들

  // 이진탐색을 하여 콘솔에 메시지를 출력하는 함수
  public static void binarySearch(int start, int end, int target) {
    // 탐색이 끝났는데도 매장에서 부품을 찾지 못했다면 "no " 출력 후 return
    if(start > end) {
      System.out.print("no ");
      return;
    }

    // start 와 end 의 중간점
    int mid = (int) (Math.floor((start+end)/2));

    // target 과 parts.get(mid)의 비교결과
    int comp = Objects.compare(target, parts.get(mid), Integer::compareTo);

    // 비교 결과에 따라 이진탐색 scope 를 변경해서 재귀 호출
    // 만약 부품을 찾으면 "yes " 출력
    if(comp == 0) System.out.print("yes ");
    else if(comp < 0) binarySearch(start, mid-1, target);
    else binarySearch(mid+1, end, target);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // 입력값 저장
    int N = sc.nextInt();
    for (int i = 0; i < N; i++) parts.add(sc.nextInt());
    int M = sc.nextInt();
    for (int i = 0; i < M; i++) buyList.add(sc.nextInt());

    // 이진탐색을 위해 parts 를 오름차순으로 정렬
    Collections.sort(parts);

    // buyList 의 원소들을 하나씩 이진탐색 -> 콘솔에 출력
    for (Integer item : buyList) {
      binarySearch(0, parts.size()-1, item); // scope : (매장 내 전체 부품들)
    }
  }
}

