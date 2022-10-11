class Solution {
    public int lastStoneWeight(int[] stones) {
        // PQ to store heaviest stones in front
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        // add all stones
        for(int i : stones){
            pq.offer(i);
        }
        // take out top 2 stones and insert their difference
        while(pq.size() > 1){
            pq.offer(pq.poll()-pq.poll());
        }
        return pq.poll();
    }
}