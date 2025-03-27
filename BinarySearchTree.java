/**
 * The `BinarySearchTree` class implements a binary search tree data structure in Java.
 */
// BinarySearchTree.java
public class BinarySearchTree<K extends Comparable<K>, V> {
    private class Node {
        K key;
        V value;
        Node left, right;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node root;

    public void insert(K key, V value) {
        root = insertRec(root, key, value);
    }

    private Node insertRec(Node node, K key, V value) {
        if (node == null) {
            return new Node(key, value);
        }
        if (key.compareTo(node.key) < 0) {
            node.left = insertRec(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = insertRec(node.right, key, value);
        }
        return node;
    }

    public V search(K key) {
        Node node = searchRec(root, key);
        return node != null ? node.value : null;
    }

    private Node searchRec(Node node, K key) {
        if (node == null || key.equals(node.key)) {
            return node;
        }
        if (key.compareTo(node.key) < 0) {
            return searchRec(node.left, key);
        }
        return searchRec(node.right, key);
    }

    public void inOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(Node node) {
        if (node != null) {
            inOrderRec(node.left);
            System.out.println(node.value);
            inOrderRec(node.right);
        }
    }
} 