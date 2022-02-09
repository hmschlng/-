package _1210_자물쇠와열쇠.myCode;

import java.util.*;

class Point {
  Integer x;
  Integer y;

  public Point(Integer x, Integer y) {
    this.x = x;
    this.y = y;
  }
}

class Solution {
  public static ArrayList<int[][]> rotatedKeyList = new ArrayList<>();

  public boolean solution(int[][] key, int[][] lock) {
    for (int i = 0; i < 360; i += 90) {
      rotatedKeyList.add(rotateKey(key,i));
    }

    //생성한 4개의 키의 면적을 최소화
    for (int i = 0; i < rotatedKeyList.size(); i++) {
      int[][] trimmed = setKeyBoundary(rotatedKeyList.remove(0));
      if(trimmed != null) {
        rotatedKeyList.add(trimmed);
      }
    }

    //각 키에 대해서 일치하면 true 리턴
    for (int[][] rotated : rotatedKeyList) {
      if(isMatch(rotated, lock))
        return true;
    }

    //모든 키가 일치하지 않으면 false 리턴
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

  private int[][] setKeyBoundary(int[][] thing) {
    Point min = new Point(21, 21);
    Point max = new Point(0,0);

    for (int i = 0; i < thing.length; i++) {
      for (int j = 0; j < thing[0].length; j++) {
        if(thing[i][j] == 1) {
          if(min.x > i) min.x = i;
          if(min.y > j) min.y = j;
          if(max.x < i) max.x = i;
          if(max.y < j) max.y = j;
        }
      }
    }

    //열쇠의 돌기가 없거나 자물쇠의 홈이 없는 경우 빈 배열 리턴
    if(max.x - min.x < 0 || max.y - min.y < 0) {
      return new int[1][1];
    }

    int[][] result = new int[max.x - min.x + 1][max.y - min.y + 1];
    for (int i = min.x; i <= max.x; i++) {
      for (int j = min.y; j <= max.y; j++) {
        result[i - min.x][j - min.y] = thing[i][j];
      }
    }

    return result;
  }

  private boolean isMatch(int[][] key, int[][] lock) {
    Point keyLimit = new Point(key.length-1, key[0].length-1);
    Point lockLimit = new Point(lock.length-1, lock[0].length-1);

    //비교를 위한 2차원 평면공간 생성
    int[][] space2D = new int[keyLimit.x*2 + lockLimit.x + 1][keyLimit.y * 2 + lockLimit.y + 1];

    // key 의 (0,0)이 space2D의 어디부터 시작하는지를 알려주는 좌표
    // key 의 (0,0)은 space2D의 (startPos.x , startPos.y)에 대입된다.
    Point startPos = new Point(0,0);

    for (startPos.x = 0; startPos.x <= keyLimit.x + lockLimit.x; startPos.x++) {
      for (startPos.y = 0; startPos.y <= keyLimit.y + lockLimit.y ; startPos.y++) {

        //자물쇠를 평면공간 정가운데에 세팅
        for (int i = keyLimit.x; i <= keyLimit.x + lockLimit.x; i++) {
          for (int j = keyLimit.y; j <= keyLimit.y + lockLimit.y; j++) {
            space2D[i][j] = lock[i - keyLimit.x][j - keyLimit.y];
          }
        }

        //열쇠 끼워보기
        for (int i = 0; i <= keyLimit.x; i++) {
          for (int j = 0; j <= keyLimit.y; j++) {
            space2D[i + startPos.x][j + startPos.y] += key[i][j];
          }
        }

        // 일치하는지 확인
        boolean match = true;
        for (int i = keyLimit.x; i <= keyLimit.x + lockLimit.x; i++) {
          for (int j = keyLimit.y; j <= keyLimit.y + lockLimit.y; j++) {
            if(space2D[i][j] != 1) {
              match = false;
              break;
            }
          } if(!match) break;
        }

        //일치한다면 그자리에서 true 리턴
        if(match) {
          return true;
        }
        //일치하지 않으면
        else {
          //space2D 에 key 를 대입한 자리를 1로 다시 초기화
          for (int i = 0; i <= keyLimit.x; i++) {
            for (int j = 0; j <= keyLimit.y; j++) {
              space2D[i + startPos.x][j + startPos.y] = 1;
            }
          }
        }

      } // loop(scope.y)
    } // loop(scope.x)

    // 맞는 경우가 없었다면 false
    return false;
  }
}

//---------------------------------------------------------------------------------------------//

class Main {
  public static void main(String[] args) {
    int[][] lock = {
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
            {1,0,1,0,1,1},
            {1,1,0,0,1,1},
            {1,1,1,1,1,1},
            {1,1,1,1,1,1}
/*            {1,1,1},
            {1,1,0},
            {1,0,1}*/
    };
    int[][] key = {
            {0,1,1,0},
            {0,0,1,0},
            {0,1,0,0},
            {0,0,0,0}
/*            {0,0,0},
            {1,0,0},
            {0,1,1}*/
    };

    Solution s = new Solution();
    System.out.println(s.solution(key, lock));
  }
}
