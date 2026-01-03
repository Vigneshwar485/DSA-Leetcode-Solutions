class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public void backtrack(int[]candidates,int target,ArrayList<Integer> temp,int sum,int idx){
        if(sum>target) return;
        if(sum==target){
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int i=idx;i<candidates.length;i++){
            temp.add(candidates[i]);
            backtrack(candidates,target,temp,sum+candidates[i],i);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<Integer> temp=new ArrayList<>();
        backtrack(candidates,target,temp,0,0);
        return res;
    }
}