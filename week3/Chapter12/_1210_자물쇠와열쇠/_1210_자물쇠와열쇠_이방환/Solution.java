package _1210_자물쇠와열쇠._1210_자물쇠와열쇠_이방환;


import java.util.*;

public class Solution {
  public boolean solution(int[][] key, int[][] lock) {

    // 기존 열쇠와 열쇠를 90도, 180도, 270도씩 회전시킨 버전을 준비
    List<int[][]> keys = new ArrayList<>();
    keys.add(key);
    keys.add(rotateKey(key, 90));
    keys.add(rotateKey(key, 180));
    keys.add(rotateKey(key, 270));


    // 열쇠를 회전시켜가며 자물쇠와 비교
    for (int[][] k : keys) {
      // 자물쇠 홈의 직경과 열쇠의 직경 계산
      // 여기서 직경은 자물쇠외 홈이나 열쇠의 돌기를 감싸는 직사각형의 최소 범위이다.
      int[] lockHole = getDiameter(lock, "lock");
      int[] keySize = getDiameter(k, "key");

      // 회전된 열쇠들을 자물쇠와 비교해, 일치하면 true
      if(isMatch(k, lock, lockHole, keySize)) {
        return true;
      }

    }
    // 모든 경우에 일치하지 않는 경우 false
    return false;
  }


  private int[][] rotateKey(int[][] key, int degree) {
    int numOfRotates = 0;

    switch(degree) {
      case 90:  numOfRotates = 1; break;
      case 180: numOfRotates = 2; break;
      case 270: numOfRotates = 3; break;
      default:  return key;
    }

    while(numOfRotates > 0) {
      int[][] rotated = new int[key.length][key.length];
      int keyX = 0, keyY = 0;

      for (int i = 0; i < key.length; i++) {
        keyY = 0;
        for (int j = key.length - 1; j >= 0; j--) {
          rotated[keyX][keyY] = key[j][i];
          keyY++;
        }
        keyX++;
      }
      key = rotated;
      numOfRotates--;
    }
    return key;
  }


  private int[] getDiameter(int[][] thing, String type) {
    // diameter[0] = 열쇠의 돌기나 자물쇠의 홈이 나오는 직사각형 직경의 최소 행
    // diameter[1] = 최소 열
    // diameter[2] = 최대 행
    // diameter[3] = 최대 열
    int[] diameter = {21,21,0,0};

    // thing이 자물쇠인지 열쇠인지 판단
    int hit = 0;
    if(type.equals("lock")) {
      hit = 0;
    }
    else if(type.equals("key")) {
      hit = 1;
    }

    // hit(열쇠의 경우 돌기, 자물쇠의 경우 홈)이 등장하는 좌표의 최대값, 최소값을 구한다.
    for (int i = 0; i < thing.length; i++) {
      for (int j = 0; j < thing.length; j++) {
        if(thing[i][j] == hit && i <= diameter[0]) {
          diameter[0] = i;
        }
        if(thing[i][j] == hit && j <= diameter[1]) {
          diameter[1] = j;
        }
        if(thing[i][j] == hit && i >= diameter[2]) {
          diameter[2] = i;
        }
        if(thing[i][j] == hit && j >= diameter[3]) {
          diameter[3] = j;
        }
      }
    }
    return diameter;
  }


  private boolean isMatch(int[][] key, int[][] lock, int[] lockHole, int[] keySize) {
    boolean match = true;

    int lock_W = lockHole[3] - lockHole[1] + 1; //자물쇠구멍 가로
    int lock_H = lockHole[2] - lockHole[0] + 1; //자물쇠구멍 세로
    int key_W = keySize[3] - keySize[1] + 1; //열쇠 가로
    int key_H = keySize[2] - keySize[0] + 1; //열쇠 세로

    // 자물쇠의 직경이 열쇠의 직경보다 큰 경우 false
    if(lock_W > key_W && lock_H > key_H) {
      return false;
    }

    // 열쇠와 자물쇠의 칸들을 비교하며 맞지 않으면 false
    // 불일치 조건 1. 둘 다 홈일 경우
    //            2. 둘 다 돌기일 경우
    int[] keyPos = keySize.clone();

    for (int i = lockHole[0]; i <= lockHole[2]; i++) {
      keyPos[1] = keySize[1];
      for (int j = lockHole[1]; j <= lockHole[3]; j++) {
        int keyPart = key[keyPos[0]][keyPos[1]];
        int lockPart = lock[i][j];

        //두 값이 같은 경우가 하나라도 있으면
        if(keyPart == lockPart) {
          match = false;
          break;
        }
        keyPos[1]++;
      }

      if(!match) break;
      keyPos[0]++;
    } //모든 칸에서 홈과 돌기가 맞물렸다면 true

    return match;
  }
}
// 풀이 시간 : 2시간 20분