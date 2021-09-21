package com.eomcs.pms.handler;

import com.eomcs.pms.domain.Board;

public class BoardList2 {

  static class Node {
    Board board;
    Node next;

    public Node(Board board) {
      this.board = board;
    }
  }

  Node head;
  Node tail;
  int size = 0;

  public void add(Board board) {
    Node node = new Node(board);

    if (head == null) {
      tail = head = node;
    } else {
      tail.next = node; //기억!
      tail = node;
    }

    size++;
  }

  public Board[] toArray() {
    Board[] arr = new Board[size];

    Node node = head;

    for (int i = 0; i < this.size; i++) {
      arr[i] = node.board;

      node = node.next;
    }

    return arr;
  }

  public Board findByNo(int no) {
    Node node = head;

    while (node != null) {
      if (node.board.no == no) {
        return node.board;
      }
      node = node.next;
    }

    return null;
  }

  public boolean remove(Board board) {
    Node node = head;
    Node prev = null;

    while (node != null) {
      if (node.board == board) {
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


}
