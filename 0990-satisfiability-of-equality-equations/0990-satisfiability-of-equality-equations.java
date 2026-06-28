class Solution {
    public boolean equationsPossible(String[] equations) {

        UnionFind uf = new UnionFind();

        for (String eq : equations) {

            if (eq.charAt(1) == '=') {

                int u = eq.charAt(0) - 'a';
                int v = eq.charAt(3) - 'a';

                uf.union(u, v);
            }
        }

        for (String eq : equations) {

            if (eq.charAt(1) == '!') {

                int u = eq.charAt(0) - 'a';
                int v = eq.charAt(3) - 'a';

                if (uf.findParent(u) == uf.findParent(v))
                    return false;
            }
        }

        return true;
    }

}
public class UnionFind{
    int[] parent;
    int[] rank;
    public UnionFind(){
        parent=new int[26];
        rank=new int[26];

        for(int i=0;i<26;i++){
            parent[i]=i;
            rank[i]=0;
        }
    }
    public int findParent(int u){
        if(parent[u]!=u){
            parent[u]=findParent(parent[u]);
        }
        return parent[u];
    }
    public boolean union(int u,int v){
        int pv=findParent(v);
        int pu=findParent(u);

        if(pv==pu){
            return true;
        }

        if(rank[pv]==rank[pu]){
            parent[pv]=pu;
            rank[pu]++;
        }else if(rank[pv]<rank[pu]){
            parent[pv]=pu;
        }else{
           parent[pu]=pv; 
        }
        return false;
    }
}