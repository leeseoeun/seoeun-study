package com.eomcs.util;

public class LinkedList extends AbstractList {

  static class Node {
    Object item;
    Node next;

    public Node(Object item) {
      this.item = item;
    }
  }

  Node head;
  Node tail;
  int size = 0;

  @Override
  public void add(Object item) {
    Node node = new Node(item);

    if (head == null) {
      tail = head = node;
    } else {
      tail.next = node;
      tail = node;
    }

    size++;
  }

  @Override
  public Object[] toArray() {
    Object[] arr = new Object[size];

    Node node = head;

    for (int i = 0; i < this.size; i++) {
      arr[i] = node.item;

      node = node.next;
    }

    return arr;
  }

  @Override
  public boolean remove(Object item) {
    Node node = head;
    Node prev = null;

    while (node != null) {
      if (node.item == item) {
        if (node == head) {
          head = node.next;
        } else {
          prev.next = node.next;
        }

        node.next = null;

        if (node == tail) {
          tail = prev;
        }

        size--;

        return true;
      }

      prev = node;
      node = node.next;
    }

    return false;
  }

  @Override
  public Object get(int index) {
    if (index < 0 || index >= this.size) {
      return null;
    }

    Node node = this.head;

    for (int i = 0; i < this.size; i++) {
      if (i == index) {
        //기억! (node.board)
        return node.item;
      }

      node = node.next;
    }

    return null;
  }

  @Override
  public Object remove(int index) {
    if (index < 0 || index >= this.size) {
      return null;
    }

    Node node = head;
    Node prev = null;

    for (int i = 0; i < this.size; i++) {
      if (i == index) {
        Object deleted = node.item;

        if (node == head) {
          head = node.next;
        } else {
          prev.next = node.next;
        }

        node.item = null;
        node.next = null;

        if (node == tail) {
          tail = prev;
        }

        size--;

        return deleted;
      } else {
        prev = node;
        node = node.next;
      }
    }

    return null;
  }


}
