import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<Integer> {
  public static class Node<Integer> {
    private int data;
    private Node<Integer> parent;
    private Node<Integer> left;
    private Node<Integer> right;

    public Node(int num) {
      data = num;
      parent = null;
      left = null;
      right = null;
    }

    public int getData() {
      return data;
    }

    public Node<Integer> getParent() {
      return this.parent;
    }

    public Node<Integer> getLeft() {
      return this.left;
    }

    public Node<Integer> getRight() {
      return this.right;
    }

    public void setParent(Node<Integer> p) {
      this.parent = p;
    }

    public void setLeft(Node<Integer> l) {
      this.left = l;
    }

    public void setRight(Node<Integer> r) {
      this.right = r;
    }
  }

  private Node<Integer> root;

  public BinarySearchTree() {
    root = null;
  }

  public BinarySearchTree(int num) {
    root = new Node<>(num);
  }

  public Node<Integer> getRoot() {
    return root;
  }

  public void preOrder(Node<Integer> roo) {
    if (roo == null)
      return;
    System.out.print(roo.getData() + " ");
    preOrder(roo.getLeft());
    preOrder(roo.getRight());
  }

  public void postOrder(Node<Integer> roo) {
    if (roo == null)
      return;
    postOrder(roo.getLeft());
    postOrder(roo.getRight());
    System.out.print(roo.getData() + " ");

  }

  public void inOrder(Node<Integer> roo) {
    if (roo == null)
      return;
    inOrder(roo.getLeft());
    System.out.print(roo.getData());
    inOrder(roo.getRight());

  }

  public void levelTraversal(Node<Integer> roo) {
    if (roo == null)
      return;
    Queue<Node<Integer>> queue = new LinkedList<>();
    queue.offer(roo);
    if (!queue.isEmpty()) {
      Node<Integer> currentNode = queue.poll();
      System.out.print(currentNode.getData() + " ");
      if (currentNode.getLeft() != null) {
        queue.offer(currentNode.getLeft());
      } else if (currentNode.getRight() != null) {
        queue.offer(currentNode.getRight());
      }
    }
  }

  public boolean bstSearch(Node<Integer> roo, int val) {
    if (roo == null)
      return false;
    if (roo.getData() == val)
      return true;
    if (val < roo.getData()) {
      return bstSearch(roo.getLeft(), val);
    } else {
      return bstSearch(roo.getRight(), val);
    }
  }

  public Node<Integer> recursiveInsert(Node<Integer> node, int val) {
    if (node == null) {
      return new Node<>(val);
    } else if (val < node.getData()) {
      node.setLeft(recursiveInsert(node.getLeft(), val));
    } else if (val > node.getData()) {
      node.setRight(recursiveInsert(node.getRight(), val));
    }
    return node;
  }

  public void insert(int val) {
    root = recursiveInsert(root, val);
  }
}