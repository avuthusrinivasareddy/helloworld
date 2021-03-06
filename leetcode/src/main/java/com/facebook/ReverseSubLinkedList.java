package com.facebook;
/*

Reverse Operations
        You are given a singly-linked list that contains N integers. A subpart of the list is a contiguous set of even elements, bordered either by either end of the list or an odd element. For example, if the list is [1, 2, 8, 9, 12, 16], the subparts of the list are [2, 8] and [12, 16].
        Then, for each subpart, the order of the elements is reversed. In the example, this would result in the new list, [1, 8, 2, 9, 16, 12].
        The goal of this question is: given a resulting list, determine the original order of the elements.
*/

import java.util.*;

public class ReverseSubLinkedList {

    // Structure of a node of the linked list
    static class node {
        int data;
        node next;
    }

    ;

    // Function to create a new node
    static node newNode(int d) {
        node newnode = new node();
        newnode.data = d;
        newnode.next = null;
        return newnode;
    }

    // Recursive function to reverse the consecutive
    // even nodes of the linked list
    static node reverse(node head, node prev) {

        // Base case
        if (head == null)
            return null;

        node temp;
        node curr;
        curr = head;

        // Reversing nodes until curr node's value
        // turn odd or Linked list is fully traversed
        while (curr != null && curr.data % 2 == 0) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        // If elements were reversed then head
        // pointer needs to be changed
        if (curr != head) {
            head.next = curr;

            // Recur for the remaining linked list
            curr = reverse(curr, null);
            return prev;
        }

        // Simply iterate over the odd value nodes
        else {
            head.next = reverse(head.next, head);
            return head;
        }
    }

    // Utility function to print the
    // contents of the linked list
    static void printLinkedList(node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    // Driver code
    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 6, 3};
        int n = arr.length;

        node head = null;
        node p = new node();

        // Constructing linked list
        for (int i = 0; i < n; i++) {
            if (head == null) {
                p = newNode(arr[i]);
                head = p;
                continue;
            }
            p.next = newNode(arr[i]);
            p = p.next;
        }

        // Head of the updated linked list
        head = reverse(head, null);

        // Printing the reversed linked list
        printLinkedList(head);
    }
} 