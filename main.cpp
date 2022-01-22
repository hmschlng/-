#include <iostream>
#include <vector>
#include <algorithm>
#include <numeric>

// 최단 작업 우선 스케줄링

// 알고리즘 : 그리디 알고리즘

namespace Algo1
{
	template <typename T>
	auto compute_waiting_times(std::vector<T>& service_times)
	{
		std::vector<T> W(service_times.size());
		W[0] = 0;

		for (auto i = 1; i < service_times.size(); i++)
			W[i] = W[i - 1] + service_times[i - 1];

		return W;
	}

	template<typename T>
	void print_vector(std::vector<T>& V)
	{
		for (auto& i : V)
		{
			std::cout.width(2);
			std::cout << i << " ";
		}
		std::cout << std::endl;
	}

	template<typename T>
	void compute_and_print_waiting_times(std::vector<T>& service_times)
	{
		auto waiting_times = compute_waiting_times<int>(service_times);

		std::cout << "- 처리 시간 : ";
		print_vector<T>(service_times);

		std::cout << "- 대기 시간 : ";
		print_vector<T>(waiting_times);

		auto ave_waiting_times = std::accumulate(waiting_times.begin(), waiting_times.end(), 0.0) / waiting_times.size();
		std::cout << " - 평균 대기 시간 : " << ave_waiting_times;

		std::cout << std::endl;
	}
}

// 분할 가능 배낭 문제

namespace Algo2
{
	struct Object
	{
		int id;
		int weight;
		double value;
		double value_per_weight;

		Object(int i, int w, double v) :id(i), weight(w), value(v), value_per_weight(v / w) {}

		inline bool operator<(const Object& obj) const
		{
			return this->value_per_weight < obj.value_per_weight;
		}

		friend std::ostream& operator<<(std::ostream& os, const Object& obj);
	};

	std::ostream& operator<<(std::ostream& os, const Object& obj)
	{
		os << "[" << obj.id << "] 가격 : " << obj.value << " \t무게 : " << obj.weight << " kg\t단위 무게 당 가격 : " << obj.value_per_weight;
		return os;
	}

	auto fill_knapsack(std::vector<Object>& objects, int knapsack_capacity)
	{
		std::vector<Object> knapsack_contents;
		knapsack_contents.reserve(objects.size());

		std::sort(objects.begin(), objects.end());
		std::reverse(objects.begin(), objects.end());

		auto current_object = objects.begin();
		int current_total_weight = 0;
		while (current_total_weight < knapsack_capacity && current_object != objects.end())
		{
			knapsack_contents.push_back(*current_object);

			current_total_weight += current_object->weight;
			current_object++;
		}

		int weight_of_last_obj_to_remove = current_total_weight - knapsack_capacity;
		Object& last_object = knapsack_contents.back();
		if (weight_of_last_obj_to_remove > 0)
		{
			last_object.weight -= weight_of_last_obj_to_remove;
			last_object.value -= last_object.value_per_weight * weight_of_last_obj_to_remove;
		}

		return knapsack_contents;
	}
}

// 크루스칼 MST 알고리즘

#include <map>
#include <queue>

namespace Algo3
{
	class SimpleDisjointSet
	{
	private:
		struct Node
		{
			unsigned id;
			unsigned rank;
			unsigned parent;

			Node(unsigned _id) : id(_id), rank(0), parent(_id) {}

			bool operator != (const Node& n) const
			{
				return this->id != n.id;
			}
		};

		std::vector<Node> nodes;
	public:
		SimpleDisjointSet(unsigned N)
		{
			nodes.reserve(N);
		}

		void make_set(const unsigned& x)
		{
			nodes.emplace_back(x);
		}

		unsigned find(unsigned x)
		{
			auto node_it = find_if(nodes.begin(), nodes.end(), [x](auto n) {return n.id == x; });
			unsigned node_id = (*node_it).id;

			while (node_id != nodes[node_id].parent)
			{
				node_id = nodes[node_id].parent;
			}
			return node_id;
		}

		void union_sets(unsigned x, unsigned y)
		{
			auto root_x = find(x);
			auto root_y = find(y);

			if (root_x == root_y)return;

			if (nodes[root_x].rank > nodes[root_y].rank)std::swap(root_x, root_y);

			nodes[root_x].parent = nodes[root_y].parent;
			nodes[root_y].rank++;
		}
	};
}

int main(int argc, char* argv[])
{
	/*std::vector<int> service_times{ 8,1,2,4,9,2,3,5 };

	std::cout << "[처음 일 처리 시간 & 대기 시간]" << std::endl;
	Algo1::compute_and_print_waiting_times<int>(service_times);

	std::sort(service_times.begin(), service_times.end());

	std::cout << std::endl;
	std::cout << "[정렬 후 일 처리 시간 & 대기 시간]" << std::endl;
	Algo1::compute_and_print_waiting_times<int>(service_times);*/

	
	/*std::vector<Algo2::Object> objects;
	objects.reserve(7);

	std::vector<int> weights{ 1,2,5,9,2,3,4 };
	std::vector<double> values{ 10, 7, 15, 10, 12, 11,5 };
	for (auto i = 0; i < 7; i++)
	{
		objects.push_back(Algo2::Object(i + 1, weights[i], values[i]));
	}

	std::cout << "[사용할 수 있는 물건 정보]" << std::endl;
	for (auto& o : objects)
		std::cout << o << std::endl;
	std::cout << std::endl;

	int knapsack_capacity = 7;
	auto solution = fill_knapsack(objects, knapsack_capacity);

	std::cout << "[배낭에 넣을 물건들 ( 최대 용량 = " << knapsack_capacity << ")]" << std::endl;
	for (auto& o : solution)
		std::cout << o << std::endl;
	std::cout << std::endl;*/
}
