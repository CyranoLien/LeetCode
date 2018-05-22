package leetcode.local;

public class Num2_AddTwoNumbers {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode listInstance(int a1, int a2, int a3) {
        ListNode l = new ListNode(a1);
        l.next = new ListNode(a2);
        l.next.next = new ListNode(a3);
        return l;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        // l is a dummy head. We instance it to smooth the following adding operation.
        // now is the end node of the list. At beginning it coincides with the head.
        ListNode l = new ListNode(0), now = l;

        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            now.next = new ListNode((x + y + carry) % 10);
            now = now.next;
            carry = (x + y + carry) / 10;

            // That's brilliant. In this case we do not need to write a lot of 'if'.
            // But the cost is, every loop we have to re-compare the wasted list.
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }

        // If both l1 & l2 are null, carry must be 0. So doing nothing is just fine.
        if (carry > 0)
            now.next = new ListNode(carry);

        return l.next;
    }

    public static void main(String[] args) {
        Num2_AddTwoNumbers x = new Num2_AddTwoNumbers();

        ListNode l1, l2, l3;
        l1 = x.listInstance(9, 8, 7);
        l2 = x.listInstance(1, 2, 3);
        l3 = x.addTwoNumbers(l1, l2);

        System.out.print(l3.val + " " + l3.next.val);
    }

}

//    My original dummy but fast method.
//    public ListNode doTheLeft(ListNode l, ListNode now, ListNode lLeft, int nextFlag) {
//        ListNode temp;
//        while (lLeft != null) {
//            int tempValue = lLeft.val + nextFlag;
//            if (tempValue < 10) {
//                temp = new ListNode(tempValue);
//                nextFlag = 0;
//            } else {
//                temp = new ListNode(tempValue - 10);
//                nextFlag = 1;
//            }
//            if (l == null) {
//                l = temp;
//                now = l;
//            } else {
//                now.next = temp;
//                now = now.next;
//            }
//            lLeft = lLeft.next;
//        }
//
//        if (nextFlag == 1) {
//            temp = new ListNode(1);
//            now.next = temp;
//        }
//        return now;
//    }
//      
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        int tempValue, nextFlag = 0;
//        ListNode l = null, now = null, temp;
//        while (l1 != null && l2 != null) {
//            tempValue = l1.val + l2.val + nextFlag;
//
//            if (tempValue < 10) {
//                temp = new ListNode(tempValue);
//                nextFlag = 0;
//            } else {
//                temp = new ListNode(tempValue - 10);
//                nextFlag = 1;
//            }
//            if (l == null) {
//                l = temp;
//                now = l;
//            } else {
//                now.next = temp;
//                now = now.next;
//            }
//            l1 = l1.next;
//            l2 = l2.next;
//        }
//
//        if (l1 != null)
//            now = doTheLeft(l, now, l1, nextFlag);
//        else if (l2 != null)
//            now = doTheLeft(l, now, l2, nextFlag);
//        else if (nextFlag == 1) {
//            temp = new ListNode(1);
//            now.next = temp;
//        }
//        return l;
//    }

