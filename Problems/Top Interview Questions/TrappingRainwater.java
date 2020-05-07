class TrappingRainwater {
    public int trap(int[] height) {
        
        int rainWater = 0;
        int maxSeenSoFar = 0;
        int maxSeenLeft = 0;
        int[] maxSeenRight = new int[height.length];

        for (int i=height.length - 1; i>=0; i--) {
            if (height[i] > maxSeenSoFar) {
                maxSeenSoFar = height[i];
            }

            maxSeenRight[i] = maxSeenSoFar;
        }

        for (int i=0; i<height.length; i++) {
            rainWater += Math.max(Math.min(maxSeenLeft, maxSeenRight[i]) - height[i], 0);
            if (height[i] > maxSeenLeft) {
                maxSeenLeft = height[i];
            }
        }

        return rainWater;
    }
}