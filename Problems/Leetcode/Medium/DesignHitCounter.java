import java.util.*;

class HitCounter {

    private Map<Integer, Integer> map;
    /** Initialize your data structure here. */
    public HitCounter() {
        this.map = new HashMap<Integer, Integer>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if (this.map.containsKey(timestamp)) {
            this.map.put(timestamp, this.map.get(timestamp) + 1);
        } else {
            this.map.put(timestamp, 1);
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int hits = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (timestamp - entry.getKey() < 300) {
                hits += entry.getValue();
            }
        }
        
        return hits;
    }