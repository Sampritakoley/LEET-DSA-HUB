class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length+nums2.length;
        int ind2=n/2;
        int ind1=ind2-1;
        int e1=0;int e2=0;
        int i=0;int j=0;
        int cnt=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<=nums2[j]){
                if(cnt==ind1){
                    e1=nums1[i];
                } if(cnt==ind2){
                    e2=nums1[i];
                }
                cnt++;
                i++;
            }else{
                if(cnt==ind1){
                    e1=nums2[j];
                } if(cnt==ind2){
                    e2=nums2[j];
                }
                cnt++;
                j++;
            }
        }
        while(i<nums1.length){
             if(cnt==ind1){
                    e1=nums1[i];
                } if(cnt==ind2){
                    e2=nums1[i];
                }
                cnt++;
                i++;
        }
        while(j<nums2.length){
            if(cnt==ind1){
                    e1=nums2[j];
                } if(cnt==ind2){
                    e2=nums2[j];
                }
                cnt++;
                j++;
        }

        if(n%2!=0){
            return e2;
        }
        return ((double)(e1+e2))/2.0;
    }
}