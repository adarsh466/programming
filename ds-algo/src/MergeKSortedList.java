package com.ds.demo;

/**
 * Definition for singly-linked list.
 * */
  class ListNode {
     int val;
     ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class ListStringNode {
    String val;
    ListStringNode next;
    ListStringNode() {}
    ListStringNode(String val) { this.val = val; }
    ListStringNode(String val, ListStringNode next) { this.val = val; this.next = next; }
}

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 *
 *Example 1:
 *
 *
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * Example 2:
 *
 * Input: list1 = [], list2 = []
 * Output: []
 * Example 3:
 *
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 *
 *
 * Constraints:
 *
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 */
class Merge2SortedList {



    /**
     * Uses Recurssion to merge the two lists
     * Time Complexity: O(n+m) - Linear Time Complexity
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode mergeTwoLists (ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    public static void main (String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list1val2 = new ListNode (2);
        ListNode list1val3 = new ListNode (4);
        list1.next = list1val2;
        list1val2.next = list1val3;

        ListNode list2 = new ListNode(1);
        ListNode list2val2 = new ListNode (3);
        ListNode list2val3 = new ListNode (4);
        list2.next = list2val2;
        list2val2.next = list2val3;

        ListNode resultList = mergeTwoLists(list1, list2);
        while (resultList != null) {
            System.out.println(resultList.val);
            resultList = resultList.next;
        }

    }
}

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 *
 *
 * Example 1:
 *
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 * Example 2:
 *
 * Input: lists = []
 * Output: []
 * Example 3:
 *
 * Input: lists = [[]]
 * Output: []
 */

public class MergeKSortedList {

    /**
     * Divide the list into two parts and merge them
     * Dividing time complexity - O(logk)
     * Merging time complexity - O(n)
     * Time Complexity: O(nlogk) - n is the total number of elements in the k lists
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        return divide(lists, 0, lists.length-1);
    }

    public static ListNode divide (ListNode[] List, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return List[startIndex];
        }
        if (startIndex < endIndex) {
            int mid = (startIndex + endIndex) / 2;
            ListNode left = divide(List, startIndex, mid);
            ListNode right = divide(List, mid+1, endIndex);
            return mergeTwoLists(left, right);
        } else {
            return null;
        }
    }

    public static ListNode mergeTwoLists (ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }



    public static void main (String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list1val2 = new ListNode (4);
        ListNode list1val3 = new ListNode (5);
        list1.next = list1val2;
        list1val2.next = list1val3;

        ListNode list2 = new ListNode(1);
        ListNode list2val2 = new ListNode (3);
        ListNode list2val3 = new ListNode (4);
        list2.next = list2val2;
        list2val2.next = list2val3;

        ListNode list3 = new ListNode(2);
        ListNode list3val2 = new ListNode (6);
        list3.next = list3val2;

        ListNode[] list = new ListNode[3];
        list[0] = list1;
        list[1] = list2;
        list[2] = list3;

        ListNode resultList = mergeKLists(list);
        while (resultList != null) {
            System.out.println(resultList.val);
            resultList = resultList.next;
        }

        ListStringNode list1Str = new ListStringNode("Def");
        ListStringNode list1Strval2 = new ListStringNode("Ghi");
        ListStringNode list1Strval3 = new ListStringNode("Abc");
        ListStringNode list1Strval4 = new ListStringNode("Jkl");
        ListStringNode list1Strval5 = new ListStringNode("Xyz");
        list1Str.next = list1Strval2;
        list1Strval2.next = list1Strval3;
        list1Strval3.next = list1Strval4;
        list1Strval4.next = list1Strval5;

        ListStringNode list2Str = new ListStringNode("Mno");
        ListStringNode list2Strval2 = new ListStringNode("Pqr");
        ListStringNode list2Strval3 = new ListStringNode("Stu");
        ListStringNode list2Strval4 = new ListStringNode("uuy");
        ListStringNode list2Strval5 = new ListStringNode("Yuv");
        ListStringNode list2Strval6 = new ListStringNode("Uio");
        list2Str.next = list2Strval2;
        list2Strval2.next = list2Strval3;
        list2Strval3.next = list2Strval4;
        list2Strval4.next = list2Strval5;
        list2Strval5.next = list2Strval6;

        ListStringNode list3Str = new ListStringNode("Pqr");
        ListStringNode list3Strval2 = new ListStringNode("Stu");
        ListStringNode list3Strval3 = new ListStringNode("uuy");
        ListStringNode list3Strval4 = new ListStringNode("Xyz");
        list3Str.next = list3Strval2;
        list3Strval2.next = list3Strval3;
        list3Strval3.next = list3Strval4;

        ListStringNode[] listString = new ListStringNode[3];
        listString[0] = list1Str;
        listString[1] = list2Str;
        listString[2] = list3Str;

        ListStringNode resultStringList = mergeKLists(listString);
        while (resultStringList != null) {
            System.out.println(resultStringList.val);
            resultStringList = resultStringList.next;
        }


    }


    public static ListStringNode mergeKLists(ListStringNode[] lists) {
        return divide(lists, 0, lists.length-1);
    }

    /**
     * Divide the list into two parts and merge them
     * Dividing time complexity - O(logk)
     * Merging time complexity - O(n)
     * Time Complexity: O(nlogk) - n is the total number of elements in the k lists
     * @param List
     * @param startIndex
     * @param endIndex
     * @return
     */
    public static ListStringNode divide (ListStringNode[] List, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return List[startIndex];
        }
        if (startIndex < endIndex) {
            int mid = (startIndex + endIndex) / 2;
            ListStringNode left = divide(List, startIndex, mid);
            ListStringNode right = divide(List, mid+1, endIndex);
            return mergeTwoLists(left, right);
        } else {
            return null;
        }
    }

    /**
     * Uses Recurssion to merge the two lists based on the string value.
     * Time Complexity: O(n+m) - Linear Time Complexity
     * @param list1
     * @param list2
     * @return
     */
    public static ListStringNode mergeTwoLists (ListStringNode list1, ListStringNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val.compareTo(list2.val) < 0){
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

}
