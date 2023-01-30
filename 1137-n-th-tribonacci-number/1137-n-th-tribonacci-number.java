class Solution {
    int count=0;
    public int tribonacci(int n) {
        int first=0;
        int second=0;
        int third=1;
        
      for(int i=0; i<n; i++){
          int sum=first+second+third;
          first=second;
          second=third;
          third=sum;
      }
        
        return second;
    }
    
}