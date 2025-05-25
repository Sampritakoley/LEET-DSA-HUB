class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int x=0;
        int size=(nums1.length+nums2.length);
        int mid=size%2==0?size/2:(size+1)/2;
        int n1=0; int n2=0;
        double res=0;int val=0;
        while(n1<nums1.length &&  n2<nums2.length){

            if(x==mid && size%2==1){
              res=val;
              return res;
            }

            if(x==mid && size%2==0){
              res=val;
              if(nums1[n1]<=nums2[n2]){
                val=nums1[n1];
                res+=val;
              }else{
                val=nums2[n2];
                res+=val;
              }
              return res/2;
            }

            if(nums1[n1]<=nums2[n2]){
                val=nums1[n1];
                n1++;
                x++;
            }

            else if(nums1[n1]>nums2[n2]){
                 val=nums2[n2];
                n2++;
                x++;
            }
        }
         
        while(n1<nums1.length && x<mid){
             val=nums1[n1];
                n1++;
                x++;
        }

        while(n2<nums2.length && x<mid){
             val=nums2[n2];
                n2++;
                x++;
        }


        res=val;
        if(size%2==0){
            if(n1<nums1.length && n2<nums2.length){
              if(nums1[n1]<=nums2[n2]){
                val=nums1[n1];
                res+=val;
              }else{
                val=nums2[n2];
                res+=val;
              }
            }

            else if(n1<nums1.length){
                 val=nums1[n1];
                res+=val;
            }else{
                 val=nums2[n2];
                res+=val;
            }
            return res/2;
        }

        return res;
        
    }
}