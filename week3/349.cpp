// 백준 14888번 문제입니다.
#include <iostream>

int oper[12]; // 숫자
int op[12]; // 연산자
int pmmd[4]; // 연산자 개수
int arr[100]; // f 함수에서 사용할 배열
int min = 2147483600, max = -2147483600; // 최솟값과 최댓값 : 이 문제의 답으로 출력할 두 변수

bool find(int arr[], int idx, int v) // 배열에 포함되어 있는지 확인하는 함수
{
	for (int i = 0; i < idx; i++)
	{
		if (arr[i] == v)return true;
	}
	return false;
}

void f(int arr[], int idx, int n, int k, int N) // 순열을 만드는 함수
{
	if (idx == n)
	{
		int value = oper[0]; // 첫 번째 숫자를 받아온다.
		int iter = 0;

		for (int i = 1; i < N; i++) // 순열로 된 배열을 가지고 for문을 돌린다.
		{
			int x = op[arr[iter]]; // 연산자들을 받아온다.
			if (x == 0) // 더하기
			{
				value += oper[i];
			}
			else if (x == 1) // 빼기
			{
				value -= oper[i];
			}
			else if (x == 2) // 곱하기
			{
				value *= oper[i];
			}
			else if (x == 3) // 나누기
			{
				value /= oper[i];
			}
			++iter; //다음 연산자를 위해서 증가
		}
		if (value > max)max = value; // 최솟값을 찾는다.
		if (value < min)min = value; // 최대값을 찾는다.
		return;
	}
	for (int i = 0; i < k; i++) 
	{
		if (!find(arr, idx, i)) //순열을 만드는 함수 -> 이게 없으면 중복조합이 된다.
		{
			arr[idx] = i;
			f(arr, idx + 1, n, k, N); 
		}
		else
			continue;
	}
	return;
}

int main()
{
	int N;

	std::cin >> N; // 수의 개수 N개
	for (int i = 0; i < N; i++)std::cin >> oper[i]; // N개의 숫자들을 입력받는다.
	for (int i = 0; i < 4; i++)std::cin >> pmmd[i]; // 더하기, 빼기, 곱하기, 나누기(plus, minus, multiply, divide)
	int count = 0;
	for (int i = 0; i < 4; i++) // 더하기, 뺴기, 곱하기, 나누기를 한 배열로 바꾸는 과정
	{
		if (pmmd[i] == 0)continue;
		else
		{
			for (int j = 0; j < pmmd[i]; j++)op[count++] = i; // 2 1 1 1 의 경우 [0 0 1 2 3]이 되고, 0 0 1 1의 경우 [2 3]이 됩니다.
		}
		if (count == N - 1)break;
	}
	f(arr, 0, N-1, N-1, N); // 답을 구해주는 함수
	std::cout << max << "\n" << min;
	return 0;
}
