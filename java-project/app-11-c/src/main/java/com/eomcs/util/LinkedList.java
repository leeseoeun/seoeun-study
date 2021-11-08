package com.eomcs.util;

import java.lang.reflect.Array;

public class LinkedList<E> extends AbstractList<E> {

  static class Node<E> {
    E item;
    Node<E> next;

    public Node(E item) {
      this.item = item;
    }
  }

  Node<E> head;
  Node<E> tail;
  int size = 0;

  @Override
  public void add(E item) {
    Node<E> node = new Node<>(item);

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

    Node<E> node = head;

    for (int i = 0; i < this.size; i++) {
      arr[i] = node.item;

      node = node.next;
    }

    return arr;
  }

  @Override
  public boolean remove(E item) {
    Node<E> node = head;
    Node<E> prev = null;

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
  public E get(int index) {
    if (index < 0 || index >= this.size) {
      return null;
    }

    Node<E> node = this.head;

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
  public E remove(int index) {
    if (index < 0 || index >= this.size) {
      return null;
    }

    Node<E> node = head;
    Node<E> prev = null;

    for (int i = 0; i < this.size; i++) {
      if (i == index) {
        E deleted = node.item;

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

  @SuppressWarnings("unchecked")
  @Override
  public E[] toArray(E[] arr) {
    E[] temp = null;

    if (arr.length >= this.size) {
      temp = arr;
    } else {
      temp = (E[]) Array.newInstance(arr.getClass().getComponentType(), this.size);
    }

    Node<E> node = head;
    for (int i = 0; i < this.size; i++) {
      temp[i] = node.item;
      node = node.next;
    }

    return temp;
  }


}
