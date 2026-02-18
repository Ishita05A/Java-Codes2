package Day180;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class WordLadder{
    static class Pair{
        String word;
        int level;
        Pair(String word,int level){
            this.word = word;
            this.level = level;
        }
    }
    static int lengthofTransformation(String[] arr,String st,String target){
        HashSet<String> mp = new HashSet<>();
        for(String word : arr){
            mp.add(word);
        }
        mp.remove(st);
        int ans = 0;
        Queue<Pair> q = new LinkedList<>(); 
        q.add(new Pair(st, 1));
        while(!q.isEmpty()){
            Pair top = q.poll();
            String word = top.word;
            int level = top.level;
            if(word.equals(target)){
                ans = level;
            } 
            char[] wordArr = word.toCharArray();
            for(int i = 0;i<wordArr.length;i++){
                char original = wordArr[i];
                for(char ch = 'a'; ch<='z';ch++){
                    wordArr[i] = ch;
                    String formed = new String(wordArr);
                    if(mp.contains(formed)){
                        q.add(new Pair(formed, level+1));
                        mp.remove(formed);
                    }
                }
                wordArr[i] = original;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String[] wordList = {"geek", "gefk"};
        System.out.println(lengthofTransformation(wordList, "gefk", "geek"));
    }
    
}