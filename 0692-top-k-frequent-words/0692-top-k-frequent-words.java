class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<words.length;i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }

        PriorityQueue<String> minHeap=new PriorityQueue<>((a,b)->{
            if(map.get(a).equals(map.get(b))){
                return b.compareTo(a);
            }
            return map.get(a)-map.get(b);
        });
        for(String str: map.keySet()){
             minHeap.offer(str);
             if(minHeap.size()>k){
                minHeap.poll();
             }
        }
         List<String> res = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            res.add("");
        }

        for (int i = k - 1; i >= 0; i--) {
            res.set(i, minHeap.poll());
        }

        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna