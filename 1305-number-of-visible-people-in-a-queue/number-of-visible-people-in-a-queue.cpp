class Solution {
public:
    vector<int> canSeePersonsCount(vector<int>& heights) {
        const int n = heights.size();
        vector<int> res(n, 0), st;
        for (int i = n - 1; i >= 0; --i) {
            int cnt = 0, curr = heights[i];
            while (!st.empty() && st.back() < curr) {
                st.pop_back(); ++cnt;
            }
            if (!st.empty()) ++cnt;
            res[i] = cnt;
            st.push_back(curr);
        }
        return res;
    }
};