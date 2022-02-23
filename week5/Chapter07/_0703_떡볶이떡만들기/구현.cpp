#include <iostream>
#include <vector>
#include <algorithm>

int g(int key, std::vector<int>& s)
{
	int sum = 0, value;
	for (auto i : s)
	{
		value = i - key;
		if (value >= 0)sum += value;
	}
	return sum;
}

int f(int M, std::vector<int>& s)
{
	int max = s[s.size() - 1];
	int min = 0;
	int mid;

	while (min <= max)
	{
		mid = (min + max) / 2;
		if (g(mid, s) == M)return mid;
		else if (g(mid, s) > M)min = mid + 1;
		else max = mid - 1;
	}
	return -1;
}

int main()
{
	int N, M, n;
	std::vector<int> v;
	std::cin >> N >> M;
	for (int i = 0; i < N; i++)
	{
		std::cin >> n;
		v.push_back(n);
	}
	std::sort(v.begin(), v.end());
	std::cout << f(M, v);
}