/**
 * Implement Trie (Prefix Tree)
 * @see <a>https://leetcode.com/problems/implement-trie-prefix-tree/</a>
 */
class TrieNode {
    protected TrieNode[] children = new TrieNode[26];
    protected char data;
    protected boolean endOfWord;
    protected boolean isLeaf = true;

    // Initialize your data structure here.
    public TrieNode(Character data, boolean endOfWord) {
        this.data = data;
        this.endOfWord = endOfWord;
    }

    public TrieNode addChild(char data, boolean endOfWord) {
        TrieNode child = children[data - 'a'];
        if (child == null) {
            child = new TrieNode(data, endOfWord);
            children[data - 'a'] = child;
        } else {
            if (endOfWord && !child.endOfWord) {
                child.endOfWord = true;
            }
        }
        this.isLeaf = false;
        return child;
    }

    public TrieNode getChild(Character data) {
        return children[data - 'a'];
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode('\0', true);
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("hello");
        trie.insert("world");
        trie.insert("in");
        trie.insert("inn");
        System.out.println(trie.search("hello"));
        System.out.println((trie.startsWith("in")));
        System.out.println((trie.search("in")));
        System.out.println((trie.search("inn")));
        System.out.println(trie.search("i"));
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode trieNode = root;
        if (word != null) {
            int len = word.length();
            for (int i = 0; i < len; i++) {
                trieNode = trieNode.addChild(word.charAt(i), (i == len - 1));
            }
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if (word == null) {
            return false;
        }
        int len = word.length();
        TrieNode node = root;
        for (int i = 0; i < len; i++) {
            node = node.getChild(word.charAt(i));
            if (node == null) {
                return false;
            }
        }
        if (node.endOfWord) {
            return true;
        } else {
            return false;
        }
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (prefix == null) {
            return false;
        }
        int len = prefix.length();
        TrieNode node = root;
        for (int i = 0; i < len; i++) {
            node = node.getChild(prefix.charAt(i));
            if (node == null) {
                return false;
            }
        }
        return node.data != '\0';
    }
}
