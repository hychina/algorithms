package utils;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Map;

public class BST<Key extends Comparable<Key>, Value> {
    public static void main(String[] args) {
        BST<Integer, String> bst = new BST<>();
        int[] keys = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] values = {"a", "b", "c", "d", "e",
                      "f", "g", "h", "i", "j", };
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < keys.length; i++) {
            map.put(keys[i], values[i]);
        }
        ArrayList<Map.Entry<Integer, String>> items = new ArrayList<>(map.entrySet());
        Collections.shuffle(items);
        for (Map.Entry<Integer, String> item : items) {
        	System.out.println(item.getKey());
        	bst.put(item.getKey(), item.getValue());
        }
        bst.display();
        System.out.println(bst.height());
    }

    private Node root;
    
    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        return x.N;
    }

    public Value get(Key key) {
        return get(key, root);
    }

    private Value get(Key key, Node x) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x.val;
        else if (cmp > 0) return get(key, x.right);
        else return get(key, x.left);
    }

    public void put(Key key, Value val) {
        this.root = put(key, val, root);
    }

    // reset value if contains key
    // add to left or right link, update count
    private Node put(Key key, Value val, Node x) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = put(key, val, x.left);
        else if (cmp > 0)
            x.right = put(key, val, x.right);
        else x.val = val;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Key min() {
        if (this.root == null) return null;
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    public Key max() {
        if (this.root == null) return null;
        return max(root).key;
    }

    public Node max(Node x) {
        if (x.right == null) return x;
        return max(x.right);
    }

    public Key floor(Key key) {
        Node x = floor(key, this.root);
        return x == null ? null : x.key;
    }

    private Node floor(Key key, Node x) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) return floor(key, x.left);
        Node n = floor(key, x.right);
        if (n == null) return x; // smaller than all nodes in right subtree
        else return n;
    }

    public Key ceiling(Key key) {
        Node x = ceiling(key, root);
        return x == null ? null : x.key;
    }

    private Node ceiling(Key key, Node x) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp > 0) ceiling(key, x.right);
        Node n = ceiling(key, x.left);
        if (n == null) return x;
        else return n;
    }

    public Key select(int k) {
        Node x = select(k, this.root);
        return x == null ? null : x.key;
    }

    private Node select(int k, Node x) {
        if (x == null) return null;
        int s = size(x.left); // size(x.left) instead of size(x)
        if (k == s) return x;
        else if (k < s) return select(k, x.left);
        else return select(k - s - 1, x.right);
    }

    public int rank(Key key) {
        return rank(key, this.root);
    }

    private int rank(Key key, Node x) { 
        if (x == null) return -1;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return size(x.left);
        else if (cmp < 0) return rank(key, x.left);
        int r = rank(key, x.right);
        if (r == -1) return -1;
        else return  r + 1 + size(x.left);
    }

    public void deleteMin() {
        this.root = deleteMin(this.root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void deleteMax() {
        this.root = deleteMax(this.root);
    }

    private Node deleteMax(Node x) {
        if (x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(Key key) {
        delete(key, this.root);
    }

    private Node delete(Key key, Node x) {
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            if (x.right == null) return x.left;
            else {
                Node n = min(x.right);
                n.left = x.left;
                n.right = deleteMin(x.right);
                return n;
            }
        }
        else if (cmp < 0)
            x.left = delete(key, x.left);
        else
            x.right = delete(key, x.right);
        return x;
    }

    public void print() {
        printInorder(this.root);
    }

    private void printInorder(Node x) { 
        if (x == null) return;
        printInorder(x.left);
        System.out.println(x.key);
        printInorder(x.right);
    }

    public void display() {
        displayBFS(this.root);
    }

    private void displayBFS(Node x) {
        LinkedList<Node> list = new LinkedList<>();
        LinkedList<Integer> position = new LinkedList<>();
        list.add(x);
        list.add(null);
        position.add(size(x.left) + 1);
        int lastPos = 0;
        while (!list.isEmpty()) {
            x = list.remove(0);
            if (x == null) {
                if (!list.isEmpty()) list.add(null);
                System.out.println();
                lastPos = 0;
                continue;
            }
            int pos = position.remove(0);
            for (int i = 0; i < pos - 1 - lastPos; i++) { 
                System.out.print("   ");
            }
            System.out.print(" " + x.key + " ");
            
            if (x.left != null) {
            	list.add(x.left);
            	position.add(pos - size(x.left.right) - 1);
            }
            if (x.right != null) {
            	list.add(x.right);
            	position.add(pos + size(x.right.left) + 1);
            }
            lastPos = pos;
        } 
    }

    public Iterable<Key> keys(Key lo, Key hi) { 
        ArrayList<Key> list = new ArrayList<>();
        keys(lo, hi, list, this.root);
        return list;
    }

    private void keys(Key lo, Key hi, ArrayList<Key> list, Node x) { 
        if (x == null) return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);

        if (cmplo < 0) 
            keys(lo, hi, list, x.left);
        if (cmplo <= 0 && cmphi >= 0)
            list.add(x.key);
        if (cmphi > 0)
            keys(lo, hi, list, x.right);
    }

    public int height() {
        return height(this.root);
    }

    private int height(Node x) { 
        if (x == null) return 0;
        int l = height(x.left);
        int r = height(x.right);
        int h = l >= r ? l : r;
        h = h + 1;
        return h;
    }

    public boolean isBalanced(Node x) {
        
    }

    private class Node {
        private Key key;
        private Value val;
        private int N;
        private Node left;
        private Node right;

        public Node(Key key, Value val, int N) { 
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }
}
