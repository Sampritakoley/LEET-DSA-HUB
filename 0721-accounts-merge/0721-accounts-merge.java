class Solution {
    int[] parent;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String,String> emailToName=new HashMap<>();
        HashMap<String,Integer> emailToId=new HashMap<>();
        int id=0;
        for(List<String> list:accounts){
            String name=list.get(0);
            for(int i=1;i<list.size();i++){
                if(!emailToId.containsKey(list.get(i))){
                    emailToId.put(list.get(i),id);
                    emailToName.put(list.get(i),name);
                    id++;
                }
            }
        }
        parent=new int[id];
        for(int i=0;i<id;i++){
            parent[i]=i;
        }
        for(List<String> list:accounts){
             String firstEmail=list.get(1);
             int firstId=emailToId.get(firstEmail);
             for(int i=2;i<list.size();i++){
                  int mailId=emailToId.get(list.get(i));
                  union(firstId,mailId);
             }
        }

        HashMap<Integer,List<String>> graph=new HashMap<>();
        for(String mail:emailToId.keySet()){
            int parentId=findParent(emailToId.get(mail));
            graph.computeIfAbsent(parentId,k->new ArrayList<>()).add(mail);
        }

        List<List<String>> result=new ArrayList<>();
        for(List<String> list:graph.values()){
            String personName=emailToName.get(list.get(0));
            List<String> answer=new ArrayList<>();
            answer.add(personName);
            Collections.sort(list);
            answer.addAll(list);
            result.add(answer);
        }
        return result;
    }
    private void union(int u, int v){
        int parent_v=findParent(v);
        int parent_u=findParent(u);
        if(parent_v!=parent_u){
            parent[parent_v]=parent_u;
        }
    }

    private int findParent(int u){
          if(parent[u]!=u){
               parent[u]=findParent(parent[u]);
          }
          return parent[u];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna