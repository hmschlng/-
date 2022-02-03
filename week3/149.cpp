// 음료수 얼려 먹기
// 0이 뭉쳐있는 것을 구하는 문제
#include <iostream>
#include <deque>

int arr[100][100];

int count = 0;

void find(int i, int j, int n, int m, bool check)
{
	bool bcheck = check;
	std::deque<int> de;
	if (i < 0 || j < 0 || i >= n || j >= m )return;
	if (arr[i][j] == 0)
	{
		if (bcheck)
		{
			count++;
			bcheck = false;
		}
		arr[i][j] = 1;
		find(i - 1, j, n, m, bcheck);
		find(i + 1, j, n, m, bcheck);
		find(i, j - 1, n, m, bcheck);
		find(i, j + 1, n, m, bcheck);
	}
	return;
}

int main()
{
	int n, m;
	char c;
	std::cin >> n >> m;
	std::cout << n << m;
	for (int i = 0; i < n; i++) // 0이 뭉쳐있는 경우만 찾는 것이면 for문이 훨씬 빠르다.
	{
		for (int j = 0; j < m; j++)
		{
			std::cin >> c;
			arr[i][j] = int(c - 48);
		}
	}
	for (int i = 0; i < n; i++) // 0이 뭉쳐있는 경우만 찾는 것이면 for문이 훨씬 빠르다.
	{
		for (int j = 0; j < m; j++)find(i, j, n, m, true);
	}
	std::cout << count << std::endl;
}

//15 14
//00000111100000
//11111101111110
//11011101101110
//11011101100000
//11011111111111
//11011111111100
//11000000011111
//01111111111111
//00000000011111
//01111111111000
//01111111111000
//00000001111000
//11111111110011
//11100011111111
//11100011111111