import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
  private static class Node {
    private int ele;
    private Node parent;
    private Node left;
    private Node right;

    public Node(int e) {
      this.ele = e;
      this.parent = null;
      this.left = null;
      this.right = null;
    }

    public int getElement() {
      return ele;
    }

    public Node getParent() {
      return parent;
    }

    public Node getLeft() {
      return left;
    }

    public Node getRight() {
      return right;
    }

    public void setParent(Node n) {
      this.parent = n;
    }

    public void setLeft(Node n) {
      this.left = n;
    }

    public void setRight(Node n) {
      this.right = n;
    }
  }

  private Node root;

  public BinarySearchTree(Node n) {
    this.root = n;
  }

  public Node getRoot() {
    return this.root;
  }

  public void setRoot(int n) {
    this.root = new Node(n);
  }

  public void preOrder(Node n) {
    if (n == null)
      return;
    System.out.print(n.getElement());
    preOrder(n.getLeft());
    preOrder(n.getRight());
  }

  public void postOrder(Node n) {
    if (n == null)
      return;
    postOrder(n.getLeft());
    postOrder(n.getRight());
    System.out.print(n.getElement());

  }

  public void inOrder(Node n) {
    if (n == null)
      return;
    inOrder(n.getLeft());
    System.out.println(n.getElement());
    inOrder(n.getRight());
  }

  public void levelOrder(Node n) {
    if (n == null)
      return;
    Queue<Node> queue = new LinkedList<>();
    queue.offer(n);

    while (!queue.isEmpty()) {
      Node current = queue.poll();
      System.out.println(current.getElement());
      if (current.getLeft() != null) {
        queue.offer(n.getLeft());
      }
      if (current.getRight() != null) {
        queue.offer(n.getRight());
      }
    }
  }

  public boolean search(Node node, int n) {
    if (node == null)
      return false;
    if (node.getElement() == n)
      return true;

    if (node.getLeft() != null) {
      return search(node.getLeft(), n);
    } else if (node.getRight() != null) {
      return search(node.getRight(), n);
    }

    return false;
  }

  public boolean searchFromRoot(int n) {
    return search(root, n);
  }

  public Node insertNodes(Node root, int l) {
    if (root == null) {
      root = new Node(l);
    }

    if (l > root.getElement()) {
      insertNodes(root.getRight(), l);
    } else if (l < root.getElement()) {
      insertNodes(root.getRight(), l);
    }

    return root;
  }

}