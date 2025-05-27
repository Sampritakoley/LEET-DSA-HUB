class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res=new ArrayList<>();
        HashMap<String,ArrayList<String>> map=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String s=strs[i];
            char[] ch=s.toCharArray();
            Arrays.sort(ch);
            String str = new String(ch);
            if(!map.containsKey(str)){
                map.put(str, new ArrayList<>());
            }
            ArrayList<String> resss=map.get(str);
            resss.add(s);
            map.put(str, resss);
        }

        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }
}