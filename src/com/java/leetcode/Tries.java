//import java.util.ArrayList;
//import java.util.List;
//
//class TrieNode {
//    TrieNode[] children = new TrieNode[26];
//    boolean isEnd = false;
//}
//
//class Trie {
//    private final TrieNode root = new TrieNode();
//
//    // Insert concatenated word into Trie
//    public void insert(String word) {
//        TrieNode node = root;
//        for (char ch : word.toCharArray()) {
//            int idx = ch - 'a';
//            if (node.children[idx] == null)
//                node.children[idx] = new TrieNode();
//            node = node.children[idx];
//        }
//        node.isEnd = true;
//    }
//
//    // Search if the word exists in Trie
//    public boolean search(String word) {
//        TrieNode node = root;
//        for (char ch : word.toCharArray()) {
//            int idx = ch - 'a';
//            if (node.children[idx] == null) return false;
//            node = node.children[idx];
//        }
//        return node.isEnd;
//    }
//}
//
//public class TriePermutationConcatenation {
//
//    // Generate all permutations and insert into Trie
//    public static void buildTrieFromPermutations(String[] words, Trie trie) {
//        boolean[] used = new boolean[words.length];
//        backtrack(words, used, new StringBuilder(), trie);
//    }
//
//    private static void backtrack(String[] words, boolean[] used, StringBuilder current, Trie trie) {
//        if (current.length() == totalLength(words)) {
//            trie.insert(current.toString());
//            return;
//        }
//
//        for (int i = 0; i < words.length; i++) {
//            if (!used[i]) {
//                used[i] = true;
//                int before = current.length();
//                current.append(words[i]);
//                backtrack(words, used, current, trie);
//                current.setLength(before); // backtrack
//                used[i] = false;
//            }
//        }
//    }
//
//    private static int totalLength(String[] words) {
//        int len = 0;
//        for (String w : words) len += w.length();
//        return len;
//    }
//}
//
//class Solution {
//    private static int totalLength(String[] words) {
//        int len = 0;
//        for (String w : words) len += w.length();
//        return len;
//    }
//
//    public List<Integer> findSubstring(String s, String[] words) {
//        Trie trie = new Trie();
//
//        List<Integer> res = new ArrayList<>();
//        // Step 1: Insert all permutations into Trie
//        TriePermutationConcatenation.buildTrieFromPermutations(words, trie);
//        int len = totalLength(words);
//
//        for (int i = 0; i < s.length(); ++i) {
//            if (trie.search(s.substring(i, len + 1))) res.add(i);
//        }
//        return res;
//    }
//}