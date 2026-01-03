class Solution {
public:
    int romanToInt(string s) {
        int curr = 0;
        int prev = 0;
        int total=0;
        for(char c: s){
            switch(c){
            case 'I': curr=1; break;
            case 'V': curr=5; break;
            case 'X': curr=10; break;
            case 'L': curr=50; break;
            case 'C': curr=100; break;
            case 'D': curr=500; break;
            case 'M': curr=1000; break;
            default: curr=0;
        }
        if(prev>=curr){
            total+=curr;
        }else{
            total+=curr-prev-prev;
        }
        prev=curr;
        }
        return total;
       
    }
};