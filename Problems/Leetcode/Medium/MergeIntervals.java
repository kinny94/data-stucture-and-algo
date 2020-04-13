class MergeIntervals {
	public int[][] merge(int[][] intervals) {
        
		int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        
        ArrayList<int[]> res = new ArrayList<int[]>();
        
        for(int i=0; i<n; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        int l=0;
        int r=1;
        
        while(r<=n){
            if(r==n || start[r]>end[r-1]){
                int[] sol = new int[]{start[l], end[r-1]};
                res.add(sol);
                l=r;
            }
            r++;
        }
        return res.toArray(new int[res.size()][]);
	}
}