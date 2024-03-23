/**
 * LCR 183. 望远镜中最高的海拔
*/
#include <vector>
#include <deque>
#define INT_MIN -2147483648
using namespace std;

class Solution {
public:
    deque<int> record;
    void push(int next, int limit, int outNum) {
        if (!record.empty() && record.front() == outNum) {
            record.pop_front();
        }
        while (!record.empty() && record.back() < next) {
            record.pop_back();
        }
        record.push_back(next);
    }
    vector<int> maxAltitude(vector<int>& heights, int limit) {
        vector<int> result;
        if (heights.size() == 0 || limit == 0) {
            return result;
        }
        for (int i = 0; i < limit; i++) {
            push(heights[i], limit, INT_MIN);
        }
        result.push_back(record.front());
        for (int i = limit; i < heights.size(); i++) {
            push(heights[i], limit, heights[i - limit]);
            result.push_back(record.front());
        }
        return result;
    }
};