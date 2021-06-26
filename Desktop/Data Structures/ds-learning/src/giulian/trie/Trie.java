package giulian.trie;

public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
        System.out.println("The Trie has been created");
    }

    public void insert(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            //get first character
            char ch = word.charAt(i);
            //get value of this char from this map that we created inside (TrieNode.java)
            TrieNode node = current.children.get(ch);

            // means we dont have any value for this ch so we have to create
            // a new node and insert it to this children
            if (node == null) {
                node = new TrieNode();
                // we are adding this char to the trie and we are creating an empty child node
                current.children.put(ch, node);
            }
            // continue to next node
            current = node;
        }
        // after inserting all of the elements to this trie we have to set endOfString to TRUE
        // so we can identify this string is a complete string
        current.endOfString = true;
        System.out.println("Successfully inserted "+ word+" in Trie");
    }
}
