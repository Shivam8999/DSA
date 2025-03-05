


class KadanesAlogo{
    //common apprach also a brute force approach and it is called as sliding window aproach
    static int calMaxSumOldWay(int[] arr){

        int lenofarr = arr.length;
        int maxSum = 0;
        int maxsubarrayStart =0 ;
        int maxsubarrayEnd =0 ;

        

        for (int i = 0; i < lenofarr; i++) {
            int currentSum=0;
            for (int j = i; j < lenofarr; j++) {
                currentSum += arr[j];
                
                int maxSumTmp = Math.max(maxSum, currentSum); 
                if(maxSum != maxSumTmp){//this checking is just an enhancement to keep track of where did this maxsumsbarray starts and ends else just ```maxSum= Math.max(maxSum, currentSum);``` works well 
                    maxSum = maxSumTmp;
                    maxsubarrayEnd=j;
                    maxsubarrayStart=i;
                };
                // System.out.println("start of array : "+i+" End of array : "+j+" Current sum is : "+currentSum+" max Sum is : "+maxSum);
            };
            
        };
        // System.out.println("Max sum array starts from index : "+maxsubarrayStart+" and ends at index : "+maxsubarrayEnd);
        return maxSum;
    }

    static int calcMAxSumAlgorthAppraoch(int[] arr){

        int maxSum=0;
        int currentSum=0;
        for (int i = 0; i < arr.length; i++) {
            currentSum+=arr[i];
            maxSum = Math.max(maxSum, currentSum);
            if(currentSum<0){ //we will only set this to 0 only after checking the max, for the edge case of all negatiove number it is clear for now but may not be clear in the future
                currentSum=0;
            }
            // System.out.println(currentSum);
            
        }
        return maxSum;
    }

    public static void main(String[] args){
        int arr[] = {1,20,-2,-25,-20,-1,5,-25,10,2,1,5}; 
       

        System.out.println("Max Sum from old approach: "+calMaxSumOldWay(arr));
        System.out.println("Max Sum from Kadane's approach: "+calcMAxSumAlgorthAppraoch(arr));

            
    }
}

