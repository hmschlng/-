#include <iostream>
#include <vector>
#include <algorithm>

bool BinarySearch(int key, std::vector<int>& arr) {
	int start = 0;
	int end = arr.size() - 1;
	int mid;

	while (end - start >= 0) {
		mid = (start + end) / 2;    //중앙 값

		if (arr[mid] == key) {    //key값을 찾았을때
			return true;

		}
		else if (arr[mid] > key) {   //key값이 mid의 값보다 작을때 (왼쪽으로)
			end = mid - 1;

		}
		else {  //key값이 mid의 값보다 클때 (오른쪽으로)
			start = mid + 1;

		}
	}
	return false;
}
int main()
{
	int N, M, n;
	std::cin >> N;
	std::vector<int> v;
	for (int i = 0; i < N; i++)
	{
		std::cin >> n;
		v.push_back(n);
	}
	std::sort(v.begin(), v.end());
	std::cin >> M;
	for (int j = 0; j < M; j++)
	{
		std::cin >> n;
		if (BinarySearch(n, v))std::cout << "yes ";
		else std::cout << "no ";
	}
	return 0;
}