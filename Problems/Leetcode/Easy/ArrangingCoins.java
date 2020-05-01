class ArrangingCoins {

    public int arrangeCoins(int n) {
        long low=1; long high=n; int target=n;
        while(low<=high){
            long mid=low+(high-low)/2;
            long value=(mid*mid+mid)/2;
            if(value==target){
                return (int)mid;
            }
            else if(value>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return (int)low-1;
    }
}