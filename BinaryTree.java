import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T> {

  private static class Node<T> {
    private T data;
    private Node<T> parent;
    private Node<T> left;
    private Node<T> right;

    public Node(T t) {
      this.data = t;
      this.parent = null;
      this.left = null;
      this.right = null;
    }

    public T getData() {
      return data;
    }

    public Node<T> getParent() {
      return parent;
    }

    public Node<T> getLeft() {
      return left;
    }

    public Node<T> getRight() {
      return right;
    }

    public void setParent(Node<T> p) {
      this.parent = p;
    }

    public void setLeft(Node<T> l) {
      this.left = l;
    }

    public void setRight(Node<T> r) {
      this.right = r;
    }
  }

  private Node<T> root;

  public BinaryTree() {
    root = null;
  }

  public void setRoot(T t) {
    root = new Node<T>(t);
  }

  public Node<T> getRoot() {
    return root;
  }

  public void preOrder(Node<T> node) {
    if (node == null) {
      return;
    }
    System.out.print(node.getData() + " ");
    preOrder(node.getLeft());
    preOrder(node.getRight());
  }

  public void postOrder(Node<T> node) {
    if (node == null) {
      return;
    }

    postOrder(node.getLeft());
    System.out.print(node.getData() + " ");
    postOrder(node.getRight());

  }

  public void inOrder(Node<T> node) {
    if (node == null)
      return;

    inOrder(node.getLeft());
    System.out.print(node.getData() + " ");
    inOrder(node.getRight());
  }

  public void levelTraversal(Node<T> node) {
    if (node == null)
      return;

    Queue<Node<T>> queue = new LinkedList<>();
    queue.offer(node);

    while (!queue.isEmpty()) {
      Node<T> currentNode = queue.poll();
      System.out.print(currentNode.getData() + " ");
      if (currentNode.getLeft() != null) {
        queue.offer(currentNode.getLeft());
      }
      if (currentNode.getRight() != null) {
        queue.offer(currentNode.getRight());
      }
    }
  }

}