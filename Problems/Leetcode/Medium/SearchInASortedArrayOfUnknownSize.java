class SearchInASortedArrayOfUnknownSize {

    public int search(ArrayReader reader, int target) {
        int start = 0;
        int end = 1;

        while(reader.get(end) < target) {
            end = end * 2;
        }
        
        while (start <= end) {
            int mid = (start + end) / 2;
            if (reader.get(mid) == target) {
                return mid;
            } else if (reader.get(mid) > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
}