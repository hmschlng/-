// 백준 18352번
// 파이썬한테 매우 유리한 문제
#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>

int visited[300001]; // 방문한 거리

int main() 
{
	int N, M, K, X;
	int a, b;
	std::cin >> N >> M >> K >> X;
	std::vector<std::vector<int>> arr(N + 1); // 2차원 배열을 크기에 상관없이 만들 수 있다. 
	std::queue<std::pair<int, int>> q; // 큐에 좌표를 저장한다.
	std::vector<int> result;
	for (int i = 0; i < M; i++)
	{
		std::cin >> a >> b;
		arr[a].push_back(b);
	}

	visited[X] = 1;
	q.push(std::pair<int, int>(X, 0));

	while (!q.empty())
	{
		int x = q.front().first;
		int y = q.front().second;
		q.pop();

		if (y == K) //거리 정보가 같으면
		{
			result.push_back(x);
		}
		for (int i = 0; i < (signed)arr[x].size(); i++) // (signed)를 붙이지 않으면 에러가 나온다.
		{
			int z = arr[x][i];
			if (visited[z] == 0)
			{
				// 방문한 적이 없으면
				visited[z] = 1;
				q.push(std::pair<int, int>(z, y + 1));
			}
		}
	}

	if (result.empty()) // 거리가 같은 경우가 없었다면
	{
		std::cout << -1; // -1을 출력합니다.
		return 0;
	}

	std::sort(result.begin(), result.end()); // 한 줄에 하나씩 오름차순으로 정렬

	for (auto i : result)std::cout << i << "\n"; // 출력
	return 0; 
}
