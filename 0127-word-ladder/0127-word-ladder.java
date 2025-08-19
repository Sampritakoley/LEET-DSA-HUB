class Solution {
    public static class Pair{
        String w;
        int seq;
        public Pair(String w, int seq){
            this.w=w;
            this.seq=seq;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(beginWord,1));
        Set<String> set=new HashSet<>();
        for(int i=0;i<wordList.size();i++){
            set.add(wordList.get(i));
        }
        while(q.size()>0){
            Pair p=q.poll();
            String word=p.w;
            for(int i=0;i<word.length();i++){
                char ch=word.charAt(i);
                for(int j=0;j<26;j++){
                    char newChar = (char)('a' + j);
                    String newStr = word.substring(0, i) + newChar + word.substring(i+1);
                    if(newStr.equals(endWord) && set.contains(newStr)){
                        return p.seq+1;
                    }
                    if(set.contains(newStr)){
                        q.add(new Pair(newStr,p.seq+1));
                        set.remove(newStr);
                    }
                }
            }
        }
        return 0;
    }
}