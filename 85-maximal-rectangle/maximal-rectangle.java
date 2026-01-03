class Solution {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        Stack<Integer> stack = new Stack<>();
        int ans = Integer.MIN_VALUE;
        for(int i =0;i<n;i++){
            int val = heights[i];

            while(!stack.isEmpty() && val < heights[stack.peek()]){
                int weights = heights[stack.pop()];
                if(stack.isEmpty()) ans = Math.max(ans , weights * i); 
                else ans = Math.max(ans, (weights * (i - stack.peek() - 1)));
            }
            stack.push(i);
        }

         while(!stack.isEmpty())
         {
                int weight = heights[stack.pop()];
                if(stack.isEmpty()) ans = Math.max(ans , weight * n); 
                else ans = Math.max(ans, (weight * (n - stack.peek() - 1)));
        }
        return ans;
    }

    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int arr[] = new int[m];
        for(int i=0;i<m;i++) arr[i] = 0;
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j =0;j<m;j++){
               if(matrix[i][j] != '0') arr[j]++;
               else arr[j] = 0;
            }
           ans = Math.max(ans, largestRectangleArea(arr));
        }
        return ans;
    }
}