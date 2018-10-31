import java.util.LinkedList;
import java.util.Queue;

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

  public void insert(int value) {
    root = recursiveInsert(root, value);
  }

  private Node recursiveInsert(Node parent, int value) {
    if (parent == null) {
      return new Node(value);
    }
    if (value < parent.value) {
      parent.left = recursiveInsert(parent.left, value);
    } else {
      parent.right = recursiveInsert(parent.right, value);
    }
    parent.height = 1 + Math.max(height(parent.left), height(parent.right));

    int balance = getBalance(parent);
    if (balance > 1 && parent.left.value > value) {
      // left-left case
      return rightRotate(parent);
    }
    if (balance > 1 && parent.left.value < value) {
      // left-right case
      parent.left = leftRotate(parent.left);
      return rightRotate(parent);
    }
    if (balance < -1 && parent.right.value > value) {
      // right-left case
      parent.right = rightRotate(parent.right);
      return leftRotate(parent);
    }
    if (balance < -1 && parent.right.value < value) {
      // right-right case
      return leftRotate(parent);
    }
    return parent;
  }

  private Node rightRotate(Node z) {
    Node y = z.left;
    z.left = y.right;
    y.right = z;

    z.height = 1 + Math.max(height(z.left), height(z.right));
    y.height = 1 + Math.max(height(y.left), height(y.right));
    return y;
  }

  private Node leftRotate(Node y) {
    Node x = y.right;
    y.right = x.left;
    x.left = y;

    y.height = 1 + Math.max(height(y.left), height(y.right));
    x.height = 1 + Math.max(height(x.left), height(x.right));
    return x;
  }

  private int height(Node node) {
    if (node == null) return 0;
    return node.height;
  }

  private int getBalance(Node node) {
    return height(node.left) - height(node.right);
  }

  private void preOrder(Node node) { 
    if (node != null) { 
      System.out.print(node.value + " "); 
      preOrder(node.left); 
      preOrder(node.right); 
    } 
  }

  private void bfsPrint(Node node) {
    if (node == null) return;
    Queue<Node> queue = new LinkedList<>();
    queue.offer(node);
    int height = node.height;
    while(queue.peek() != null) {
      Node n = queue.poll();
      if (height != n.height) {
        height = n.height;
        System.out.println();
      }
      System.out.print(n.value + "\t");
      if (n.left != null) queue.offer(n.left);
      if (n.right != null) queue.offer(n.right);
    }
  }

  public static void main(String[] args) { 
    AVLTree tree = new AVLTree(); 

    /* Constructing tree given in the above figure */
    tree.insert(10); 
    tree.insert(20); 
    tree.insert(30); 
    tree.insert(40); 
    tree.insert(50); 
    tree.insert(25); 

    /* The constructed AVL Tree would be 
         30 
        /  \ 
      20   40 
     /  \     \ 
    10  25    50 
    */
    System.out.println("Preorder traversalof constructed tree is : "); 
    tree.preOrder(tree.root);
    System.out.println("\n");
    tree.bfsPrint(tree.root);
  } 
}