package tree.trie;

public class _677 {
    TrieNode root;

    public _677() {
        root=new TrieNode();
    }

    public void insert(String key, int val) {
        TrieNode node=root;
        // get previous val of key
        int preVal=val(key);
        // compute the updated value
        val-=preVal;
        for(char c:key.toCharArray()){
            // update sum
            node.sum+=val;
            // create node if child does not exist
            if(node.next[c-'a']==null){
                node.next[c-'a']=new TrieNode();
            }
            // go to child
            node=node.next[c-'a'];
        }
        // update sum
        node.sum+=val;
        // update val;
        node.val+=val;
    }

    public int sum(String prefix) {
        TrieNode node=root;
        for(char c:prefix.toCharArray()){
            node=node.next[c-'a'];
            if(node==null){
                return 0;
            }
        }
        return node.sum;
    }

    /**
     * get value of given key
     * @param key
     * @return
     */
    private int val(String key){
        TrieNode node=root;
        for(char c:key.toCharArray()){
            // go to the child
            node=node.next[c-'a'];
            // return 0 if child is null
            if(node==null){
                return 0;
            }
        }
        return node.val;
    }

    class TrieNode{
        // next arr to record children
        TrieNode[] next=new TrieNode[26];
        // current value of key
        int val=0;
        // sum value of key as prefix
        int sum=0;
    }

    public static void main(String[] args) {
        _677 test=new _677();
        test.insert("apple",3);
        test.insert("app",2);
        System.out.println(test.sum("a"));
        test.insert("apple",2);
        System.out.println(test.sum("ap"));
    }
}
