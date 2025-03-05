public class majorityormooresvoting {

    public static int bruteforceapprach(int[] nums){
        int maxNumEle=0;
        for (int i = 0; i < nums.length; i++) {
            int freq=0;
            for (int j = 0; j < nums.length; j++) {
                if(nums[i]==nums[j]){
                    freq++;
                };

                if(freq > nums.length/2){ 
                    return nums[i];
                }
                
            }
        }
        return -1; //as the question says the number needs to be returned only if a element count is more than half of the length of the array
    }

    //! Approach 2 optimised when sort the array with built in function and then count the frequency of each element and as it is full sorted we dont need to check for same element in the array again
    //! Then we keep counting for the frequency and set frequency to 1 as soon as the number changes and keep checking if freq>n/2 and if its true then return the number elce return -1 if there is no such number
    //! that is no number is repeadted more than n/2 times

    static int higherAlgorithm(int[] nums){
        //? Name of this algorith is Moore's voting algorithm and it rely's on the fundation of voting and de-voting i.e decrementing the count of of already voted member
        //? So, in this algorithm we vote for a ans(number) and if its vote becomes zero then we vote for other number i.e last number that has devoted the previous ans's vote
        //? So in this case if a number has higher count than n/2 times eventurally it will be in the vote again and in the end it will stand as  the answer
        //? So eventually we will have either maximum freq number or something equal to maximum frequency
        int freq=0;
        int ans=0;
        for (int i = 0; i < nums.length; i++) {
            if(freq==0){
                ans=nums[i];
            }
            if(ans==nums[i]){
                freq++;
            }else{
                freq--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[]={2,3,3,2,1,1,1,3,3,3,2,2,3,3,3,3};
        int result = bruteforceapprach(nums); // ✅ No error
        System.out.println("max element: "+result);
        System.out.println(higherAlgorithm(nums));
    }
}
