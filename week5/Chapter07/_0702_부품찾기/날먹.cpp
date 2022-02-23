#include <iostream>
#include <vector>
#include <set>

int main()
{
	int N, M, n;
	std::set<int> s;
	std::vector<int> v;
	std::cin >> N;
	for (int i = 0; i < N; i++)
	{
		std::cin >> n;
		s.insert(n);
	}
	std::cin >> M;
	for (int j = 0; j < M; j++)
	{
		std::cin >> n;
		if (s.find(n) == s.end())std::cout << "no ";
		else std::cout << "yes ";
	}
}