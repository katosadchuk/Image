import java.util.List;
import java.util.ArrayList;

public class Solution {
    
	public static ArrayList<Integer> solution(double[] prices) {
       double trueSum = 0.0;
       int roundedSum2 = 0;
       ArrayList<Integer> roundedVal = new ArrayList<Integer>();
       for(double x : prices){
           trueSum = trueSum + x; 
           int y = (int) Math.round(x);
           roundedVal.add(y);
           roundedSum2 = roundedSum2 + y;
       }
       Integer roundedSum = (int) Math.round(trueSum);
       if(roundedSum.equals(roundedSum2)){
    	   return roundedVal;
       } else {
    	   while(!roundedSum.equals(roundedSum2)){
    		   int diff = roundedSum - roundedSum2;
    		   int i = 0;
        	   if(diff > 0){
        		   int z = roundedVal.get(i);
        		   z = z + 1;
        		   roundedVal.add(i, z);
        		   i++;
        	   } else {
        		   int z = roundedVal.get(i);
        		   z = z - 1;
        		   roundedVal.add(i, z);
        		   i++;
        	   }
    	   }
    	   return roundedVal;
    	   
       }
       
       
      
        
       
    }
    
    public static void main(String args[]){
    	double[] prices = {5.4, 3.3, 5.0};
    	System.out.println("hi");
    	
    }
}

