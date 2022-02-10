package Chapter12;

public class LockNKey_1210 {

	// total배열에 key를 넣어보고 맞는지 check하는 함수 + key를 넣을 시작점을 매개변수로 받기
	// 따로 함수를 만드는 이유는, total배열이 바뀌지 않게 하기 위함.
	public static boolean isOpend(int[][] total, int[][] key, int x, int y, int lockLen) {
		int keyLen = key.length;
		// total에 key를 추가 (대입이 아니고, 추가임 주의)
		for(int i = 0 ; i < keyLen ; i++)
			for(int j = 0 ; j < keyLen ; j++) 
				total[i+x][j+y] += key[i][j]; 
		// key가 추가된 total에 가운데가 다 1이상인지 확인
		for(int i = keyLen ; i < keyLen+lockLen ; i++)
			for(int j = keyLen ; j < keyLen+lockLen ; j++) 
				if(total[i][j] < 1)
					return false;
		return true;
	}
	
	// 왼쪽으로 90도 돌리기
	public static int[][] turnLeft(int[][] key){
		int len = key.length;
		int[][] left = new int[len][len];
		for(int x = 0 ; x < len ; x++)
			for(int y = 0 ; y < len ; y++) 
				left[len-y-1][x] = key[x][y];
		return left;
	}
	
	public static boolean solution(int[][] key, int[][] lock) {
		int keyLen = key.length;		// 3일때 (index : 0~2)
		int lockLen = lock.length;		// 3일때
		int totalLen = lockLen + (keyLen * 2) - 2;		// 7 (index : 0~6)
		int[][] total = new int[totalLen][totalLen];	// 7 x 7
		for(int i = keyLen-1 ; i < keyLen-1+lockLen ; i++) 	// index2~4를 가운데로 지정하고 lock의 원소들로 채우기
			for(int j = keyLen-1 ; j < keyLen-1+lockLen ; j++) 
				total[i][j] = lock[i-keyLen+1][i-keyLen+1]; 
		// key의 배열로 왼쪽 위 기준, 0,0 부터 4,4까지 total에 다 채워보고 하나씩 맞는지 check해보기
		// 넣어본 후, 가운데 대입한 lock에서 모두 1이상인지 확인후, 맞으면 true
		for(int i = 0 ; i < keyLen+lockLen-1 ; i++) {
			for(int j = 0 ; j < keyLen+lockLen-1 ; j++) {
				for(int k = 0 ; k < 4 ; k++) {
					if(isOpend(total, key, i, j, lockLen))
						return true;
					key = turnLeft(key);
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] key = { {0,0,0},{1,0,0},{0,1,1}	};
		int[][] lock = { {1,1,1},{1,1,0},{1,0,1} };
		if(solution(key, lock))
			System.out.println("true");
		else 
			System.out.println("false");
//		int len = arr.length;
//		for(int x = 0 ; x < len ; x++) {
//			for(int y = 0 ; y < len ; y++) 
//				System.out.print(arr[x][y] + " ");
//			System.out.println();
//		}
//		System.out.println();
//		arr = turnLeft(arr);
//		for(int x = 0 ; x < len ; x++) {
//			for(int y = 0 ; y < len ; y++) 
//				System.out.print(arr[x][y] + " ");
//			System.out.println();
//		}
	}

}
