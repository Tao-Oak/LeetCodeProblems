//
// Created by Joshua.cao, 2018/10/26
//
// https://www.geeksforgeeks.org/binary-search-tree-data-structure/
// https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
// https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/
//

class Node {
  int value;
  Node left, right;
  Node(int value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }
}

public class BinarySearchTree {
  Node root;

  public BinarySearchTree() {
    root = null;
  }

  public Node search(int value) {
    return recursiveSearch(root, value);
  }

  public void insert(int value) {
    root = recursiveInsert(root, value);
  }

  public void delete(int value) {
    root = recursiveDelete(root, value);
  }

  public void inorder() {
    recursiveInorder(root);
  }

  private Node recursiveSearch(Node parent, int value) {
    if (parent == null || parent.value == value) {
      return parent;
    }
    if (value < parent.value) {
      return recursiveSearch(parent.left, value);
    } else {
      return recursiveSearch(parent.right, value);
    }
  }

  private Node recursiveInsert(Node parent, int value) {
    if (parent == null) {
      return new Node(value);
    }
    if (value <= parent.value) {
      parent.left = recursiveInsert(parent.left, value);
    } else {
      parent.right = recursiveInsert(parent.right, value);
    }
    return parent;
  }

  /*
   * When we delete a node, three possibilities arise.
   *  1. Node to be deleted is leaf: Simply remove from the tree.
   * 
   *  2. Node to be deleted has only one child: Copy the child to the node and 
   *     delete the child
   * 
   *  3. Node to be deleted has two children: Find inorder successor of the 
   *     node. Copy contents of the inorder successor to the node and delete 
   *     the inorder successor. Note that inorder predecessor can also be used.
   * 
   * The important thing to note is, inorder successor is needed only when 
   * right child is not empty. In this particular case, inorder successor can 
   * be obtained by finding the minimum value in right child of the node.
   */
  private Node recursiveDelete(Node parent, int value) {
    if (parent == null) return null;
    if (value < parent.value) {
      parent.left = recursiveDelete(parent.left, value);
      return parent;
    } else if (value > parent.value) {
      parent.right = recursiveDelete(parent.right, value);
      return parent;
    } else {
      if (parent.left == null) {
        return parent.right;
      } else if (parent.right == null) {
        return parent.left;
      }
      // parent.value = minValue(parent.right);
      // parent.right = recursiveDelete(parent.right, parent.value);
      // return parent;

      if (parent.right.left == null) {
        parent.value = parent.right.value;
        parent.right = parent.right.right;
        return parent;
      }
  
      Node succParent = parent.right;
      Node succ = parent.right.left;
      do {
        if (succ.left == null) {
          parent.value = succ.value;
          succParent.left = succ.right;
          return parent;
        }
        succParent = succ;
        succ = succ.left;
      } while(succ.left != null || succ.right != null);
  
      parent.value = succ.value;
      succParent.left = null;
      return parent;
    }
  }

  public int minValue(Node parent) {
    if (parent.left == null) return parent.value;
    return minValue(parent.left);
  }

  private void recursiveInorder(Node parent) {
    if (parent == null) return;
    recursiveInorder(parent.left);
    System.out.print(parent.value + "\t");
    recursiveInorder(parent.right);
  }

  public static void main(String[] args) {
    BinarySearchTree tree = new BinarySearchTree();
    tree.insert(50); 
    tree.insert(30); 
    tree.insert(20); 
    tree.insert(40); 
    tree.insert(70); 
    // tree.insert(60); 
    tree.insert(80);

    System.out.println("Inorder traversal of the given tree"); 
    tree.inorder();

    // System.out.println("\nDelete 20");
    // tree.delete(20);
    // System.out.println("Inorder traversal of the modified tree"); 
    // tree.inorder();

    // System.out.println("\nDelete 30"); 
    // tree.delete(30); 
    // System.out.println("Inorder traversal of the modified tree"); 
    // tree.inorder(); 

    System.out.println("\nDelete 50"); 
    tree.delete(50); 
    System.out.println("Inorder traversal of the modified tree"); 
    tree.inorder();
  }
}