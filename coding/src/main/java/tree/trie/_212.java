package tree.trie;
import java.util.*;
public class _212 {
    TrieNode root;
    boolean[][] visited;
    char[][] board;
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res=new LinkedList<>();
        root=new TrieNode();
        this.board=board;
        visited=new boolean[board.length][board[0].length];
        // max length of words, determining the height of the trie tree
        int maxLen=0;
        for(String word:words){
            maxLen=Math.max(maxLen,word.length());
        }
        // build trie tree from every position
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++){
                buildTrie(root,i,j,maxLen);
            }
        }

        for(String word:words){
            if(findInTrie(word)){
                res.add(word);
            }
        }
        return res;
    }

    private void buildTrie(TrieNode node,int i,int j,int k){
        if(i<0||j<0||i>=board.length||j>=board[0].length||visited[i][j]||k<0){
            return;
        }
        if(node.next[board[i][j]-'a']==null){
            node.next[board[i][j]-'a']=new TrieNode();
        }
        // tag the position to avoid duplicate addition
        visited[i][j]=true;
        // length-1 after adding a new node to trie
        buildTrie(node.next[board[i][j]-'a'],i-1,j,k-1 );
        buildTrie(node.next[board[i][j]-'a'],i+1,j,k-1 );
        buildTrie(node.next[board[i][j]-'a'],i,j-1,k-1 );
        buildTrie(node.next[board[i][j]-'a'],i,j+1,k-1 );
        // restore the position
        visited[i][j]=false;
    }

    private boolean findInTrie(String word){
        TrieNode node=root;
        for(char c:word.toCharArray()){
            if(node.next[c-'a']==null){
                return false;
            }
            node=node.next[c-'a'];
        }
        return true;
    }


    class TrieNode{
        int level=0;
        TrieNode[] next=new TrieNode[26];
    }
}
