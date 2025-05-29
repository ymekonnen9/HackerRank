import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

  private static class Node {
    private int data;
    private Node parent;
    private Node left;
    private Node right;

    public Node(int t) {
      this.data = t;
      this.parent = null;
      this.left = null;
      this.right = null;
    }

    public int getData() {
      return data;
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

    public void setParent(Node p) {
      this.parent = p;
    }

    public void setLeft(Node l) {
      this.left = l;
    }

    public void setRight(Node r) {
      this.right = r;
    }
  }

  private Node root;

  public BinarySearchTree() {
    root = null;
  }

  public void setRoot(Integer t) {
    root = new Node(t);
  }

  public Node getRoot() {
    return root;
  }

  public void preOrder(Node node) {
    if (node == null) {
      return;
    }
    System.out.print(node.getData() + " ");
    preOrder(node.getLeft());
    preOrder(node.getRight());
  }

  public void postOrder(Node node) {
    if (node == null) {
      return;
    }

    postOrder(node.getLeft());
    System.out.print(node.getData() + " ");
    postOrder(node.getRight());

  }

  public void inOrder(Node node) {
    if (node == null)
      return;

    inOrder(node.getLeft());
    System.out.print(node.getData() + " ");
    inOrder(node.getRight());
  }

  public void levelTraversal(Node node) {
    if (node == null)
      return;

    Queue<Node> queue = new LinkedList<>();
    queue.offer(node);

    while (!queue.isEmpty()) {
      Node currentNode = queue.poll();
      System.out.print(currentNode.getData() + " ");
      if (currentNode.getLeft() != null) {
        queue.offer(currentNode.getLeft());
      }
      if (currentNode.getRight() != null) {
        queue.offer(currentNode.getRight());
      }
    }
  }

  public boolean searchBST(Node r, int val) {
    if (r == null)
      return false;
    if (r.getData() == val) {
      return true;
    } else if (val > r.getData()) {
      return searchBST(r.getRight(), val);
    } else {
      return searchBST(r.getLeft(), val);
    }
  }

}