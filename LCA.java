import java.util.*;
import java.io.*;

class Node {
  Node left;
  Node right;
  int data;

  Node(int data) {
    this.data = data;
    left = null;
    right = null;
  }
}

class Solution {

  /*
   * class Node
   * int data;
   * Node left;
   * Node right;
   */
  public static Node lca(Node root, int v1, int v2) {
    while (true) {
      if (root.data < Math.min(v1, v2)) {
        root = root.right;
      } else if (root.data > Math.max(v1, v2)) {
        root = root.left;
      } else {
        break;
      }
    }
    return root;

  }

  public static Node insert(Node root, int data) {
    if (root == null) {
      return new Node(data);
    } else {
      Node cur;
      if (data <= root.data) {
        cur = insert(root.left, data);
        root.left = cur;
      } else {
        cur = insert(root.right, data);
        root.right = cur;
      }
      return root;
    }
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    Node root = null;
    while (t-- > 0) {
      int data = scan.nextInt();
      root = insert(root, data);
    }
    int v1 = scan.nextInt();
    int v2 = scan.nextInt();
    scan.close();
    Node ans = lca(root, v1, v2);
    System.out.println(ans.data);
  }
}
