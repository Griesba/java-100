package com.griesba.java100;


public class Node {
    private Node left;
    private Node right;
    private Long key;
    private Node root;

    public Node() {
    }

    public Node(Long key) {
        this.key = key;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Long getKey() {
        return key;
    }

    public void inOrderPrint() {
        if (getLeft() != null) {
            getLeft().inOrderPrint();
        }
        printNode();
        if (getRight() != null) {
            getRight().inOrderPrint();
        }
    }

    public Node find(Long value) {
        if (this.root == null) {
            throw new IllegalStateException("Uninitialized three");
        }
        Node current = root;
        while (current != null) {
            if (current.getKey().equals(value)) {
                return current;
            }
            current = value > current.getKey() ? current.getRight() : current.getLeft();
        }
        return null;
    }

    public Node add(Long key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        Node current = root;
        Node preceding = root;
        while (current != null) {
            preceding = current;
            current = key > current.getKey() ? current.getRight() : current.getLeft();
        }

        current = new Node(key);
        if (key > preceding.getKey()) {
            preceding.setRight(current);
        } else {
            preceding.setLeft(current);
        }
        return current;
    }

    public void  print () {
        if (root != null) {
            root.inOrderPrint();
        }
    }

    private void printNode() {
        System.out.print(this);
    }

    @Override
    public String toString() {
        return "(" + key + ')';
    }
}
