class Solution {
public:
    string removeDuplicateLetters(string s) {
        int n = s.length();
        string stk = "";
        array<int, 26> last{};
        bitset<26> vised = 0;
        for(int i=0;i<n;i++){
            last[s[i] - 'a'] = i;
        }

        for(int i=0;i<n;i++){
            char b = s[i];
            if(vised[b-'a'])continue;
            while(!stk.empty() && stk.back()>b && i<last[stk.back()-'a']){
                vised[stk.back()-'a'] = 0;
                stk.pop_back();
            }
            stk.push_back(b);
            vised[b-'a'] = 1;
        }
        return stk;
    }
};