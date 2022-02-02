#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>

int visited[300001];

int main()
{
	int N, M, K, X;
	int a, b;
	std::cin >> N >> M >> K >> X;
	std::vector<std::vector<int>> arr(N + 1);
	std::queue<std::pair<int, int>> q;
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
		for (int i = 0; i < (signed)arr[x].size(); i++)
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

	if (result.empty())
	{
		std::cout << -1;
		return 0;
	}

	std::sort(result.begin(), result.end());

	for (auto i : result)std::cout << i << "\n";
	return 0;
}
