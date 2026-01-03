class Solution {
public:
    void helper(vector<string> &ans,int i,string s,string st,int size){
        if(i > size-1) return;
        int temp = 3;
        if(s[i]=='9' || s[i] == '7') temp = 4;
        char val = 'a';
        int dif = (s[i]-'0')-2;
        val += (dif*3);
        if((s[i]-'0') > 7) val++;
        while(temp--){
            st = st + val;
            helper(ans,i+1,s,st,size);
            if(i == size-1) ans.push_back(st);
            st.pop_back();
            val++;
        }
    }
    vector<string> letterCombinations(string digits) {
        vector<string> ans;
        string st ="";
        int size = digits.length();
        helper(ans,0,digits,st,size);
        return ans;
    }
};