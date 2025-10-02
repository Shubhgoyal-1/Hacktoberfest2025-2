class Solution {
    public static void main(String[] args){
      int[] heights = {2,1,5,6,2,3};
      System.out.println(largestRectangleAres(heights));
      }
     public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int nse=n;
        int pse=-1;
        int element;
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i <n;i++)
        {
            while(!stack.empty() && heights[stack.peek()] > heights[i])
            {
                element=heights[stack.peek()];
                stack.pop();
                nse =i;
                pse = stack.empty()?-1:stack.peek();
                max=Math.max(max,(nse-pse-1)*element);
            }
            stack.push(i);
        }
        while(!stack.empty())
        {
            nse=n;
            element = heights[stack.peek()];
            stack.pop();
            pse = stack.empty()?-1:stack.peek();
            max=Math.max(max,(nse-pse-1)*element);
        }
        return max;
    }
}
