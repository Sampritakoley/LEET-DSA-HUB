class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n=candies.length;
        boolean[] visited = new boolean[n]; 
        boolean[] gotKey = new boolean[n]; 
        boolean[] presentInQueue = new boolean[n];
        int totalCandy=0;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> availableBoxes = new HashSet<>();

        for(int i=0;i<initialBoxes.length;i++){
                availableBoxes.add(initialBoxes[i]);
                  if(status[initialBoxes[i]]==1){
                    queue.add(initialBoxes[i]);
                    presentInQueue[initialBoxes[i]]=true;
                  }
        }

        while(!queue.isEmpty()){
            int box=queue.poll();
            if(visited[box]==true){
                continue;
            }
            visited[box]=true;

            totalCandy+=candies[box];
            int[] keyofBox=keys[box];

            for(int i=0;i<keyofBox.length;i++){
                gotKey[keyofBox[i]]=true;
                if(availableBoxes.contains(keyofBox[i]) && presentInQueue[keyofBox[i]]==false){
                    presentInQueue[keyofBox[i]]=true;
                    queue.add(keyofBox[i]);
                }
            }

            int[] contained=containedBoxes[box];
            for(int i=0;i<contained.length;i++){
                if(!availableBoxes.contains(contained[i])){
                    availableBoxes.add(contained[i]);
                    if(status[contained[i]]==1 || gotKey[contained[i]]==true && !presentInQueue[contained[i]] ){
                         presentInQueue[contained[i]]=true;
                         queue.add(contained[i]);
                    }
                }
            }

        }
        return totalCandy;

    }
}