//
// Created by Joshua.cao, 2018/10/16
//
// https://leetcode.com/problems/linked-list-cycle-ii/
//

class ListNode {
  int val;
  ListNode next;
  ListNode(int x) {
    val = x;
    next = null;
  }
}

public class LinkedListCircleTwo {
  // Accepted, beats 100%
  public ListNode detectCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = slow;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        slow = head;
        while (slow != fast) {
          slow = slow.next;
          fast = fast.next;
        }
        return slow;
      }
    }
    return null;
  }

  // Accepted, beats 52.03%
  public ListNode detectCycle_2(ListNode head) {
    if (head == null || head.next == null) {
      return null;
    }
    ListNode slow = head;
    ListNode fast = head;
    do {
      slow = slow.next;
      fast = fast.next.next;
    } while (slow != fast && fast != null && fast.next != null);
    
    if (fast == null || slow == null) {
      return null;
    }
    if (fast != null && fast.next == null) {
      return null;
    }

    slow = head;
    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }
    return slow;
  }

  public ListNode constructLinkedList(int[] input, int loopIndex) {
    ListNode tail = null;
    ListNode head = null;
    for (int i = input.length - 1; i >= 0; i--) {
      ListNode node = new ListNode(input[i]);
      node.next = head;
      head = node;
      if (i == input.length - 1) {
        tail = node;
      }
    }

    ListNode node = head;
    int counter = 0;
    while (counter < loopIndex) {
      node = node.next;
      counter++;
    }
    tail.next = node;
    return head;
  }

  public void printLinkedList(ListNode head) {
    int counter = 0;
    while (counter < 10 && head != null) {
      System.out.print(head.val + "\t");
      head = head.next;
      counter++;
    }
    System.out.println();
  }

  public void printListNode(ListNode node, String prefix) {
    if (node == null) {
      System.out.println(prefix + ": null");
    } else {
      System.out.println(prefix + ": " + node.val);
    }
  }

  public static void main(String[] args) {
    LinkedListCircleTwo obj = new LinkedListCircleTwo();
    int[] input = {3, 2, 0, -4};
    ListNode head = obj.constructLinkedList(input, 1);
    obj.printLinkedList(head);
    ListNode loopNode = obj.detectCycle(head);
    if (loopNode == null) {
      System.out.println("There is no loop");
    } else {
      System.out.println("Loop node is: " + loopNode.val);
    }
  }
}