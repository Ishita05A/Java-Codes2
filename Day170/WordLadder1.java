package Day170;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class WordLadder1 {
    static class Pair{
        String word;
        int level;
        Pair(String word,int level){
            this.word = word;
            this.level = level;
        }
    }
    static int wordLadderLength(String[] wordList,String begin, String end){
            HashSet<String> mp = new HashSet<>();
            for(int i = 0;i<wordList.length;i++){
                mp.add(wordList[i]);
            }
            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(begin, 1));
            while(!q.isEmpty()){
                Pair top = q.poll();
                String word = top.word;
                int level = top.level;
                if(word.equals(end)) return level;
                for(int i = 0;i<word.length();i++){
                    for(char ch = 'a';ch<='z';ch++){
                        char[] charArr = word.toCharArray();
                        charArr[i] = ch;
                        String replaced_word = new String(charArr);
                        if(mp.contains(replaced_word)){
                            q.add(new Pair(replaced_word, level+1));
                            mp.remove(replaced_word);
                        }
                    }
                }
            }
            return 0;


    }
    public static void main(String[] args) {
        
        String[] wordList = {"des","der","dfr","dgt","dfs"};
        System.out.println(wordLadderLength(wordList, "der", "dfs"));
    }
    
    
}
