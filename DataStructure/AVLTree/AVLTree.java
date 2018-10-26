//
// Created by Joshua.cao, 2018/10/24
//
// https://www.geeksforgeeks.org/avl-tree-set-1-insertion/
//

class Node {
  int value, height;
  Node left, right;
  Node(int value) {
    height = 1;
    this.value = value;
  }
}

public class AVLTree {
  public Node root;

  public Node insert(Node parent, int value) {
    if (parent == null) {
      return new Node(value);
    }

    if (value < root.value) {
      parent.left = insert(parent.left, value);
    } else {
      parent.right = insert(parent.right, value);
    }
    return parent;
  }

  public void preorder(Node node) {
    if (node == null) return;
    System.out.print(node.value + "\t");
    preorder(node.left);
    preorder(node.right);
  }

  public static void main(String[] args) {
    AVLTree tree = new AVLTree();
    int[] input = {10, 20, 30, 40, 50, 25};
    for (int i = 0; i < input.length; i++) {
      tree.root = tree.insert(tree.root, input[i]);
    }
    tree.preorder(tree.root);
  }
}