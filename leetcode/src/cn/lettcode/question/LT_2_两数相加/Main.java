package cn.lettcode.question.LT_2_两数相加;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houzi
 * @Date 2022/12/19
 * <p>
 * 1. 两数之和
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 * <p>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/add-two-numbers">2. 两数相加</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Main {
    public static void main(String[] args) {
        /**
         *  * 输入：l1 = [2,4,3], l2 = [5,6,4]
         *  * 输出：[7,0,8]
         *  * 解释：342 + 465 = 807.
         */
        Integer[] l1 = {2,4,3};
        Integer[] l2 = {5,6,4};

        ListNode ln1 = arrChangeListNode(l1);
        ListNode ln2 = arrChangeListNode(l2);
        System.out.println(ln1);
        System.out.println(ln2);

        String s1 = listNodeChangeString(ln1);
        String s2 = listNodeChangeString(ln2);
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);

        String[] split1 = s1.split(", ");
        String[] split2 = s2.split(", ");
        String[] arr1;
        String[] arr2;
        if (split1.length == split2.length) {
            arr1 = split1;
            arr2 = split2;
        } else {
            arr1 = split1.length < split2.length ? split1 : split2;
            arr2 = split1.length < split2.length ? split2 : split1;
        }
        int length1 = arr1.length;
        int length2 = arr2.length;

        List<Integer> list = new ArrayList<>();

        int index = 0, a = 0, b = 0, c = 0, d = 0;
        for (int i = length2 - 1; i >= 0; i--) {
            a = index++ < length1 ? Integer.parseInt(arr1[length1 - index]) : 0;
            b = Integer.parseInt(arr2[i]);
            c = a + b + d;
            d = c / 10;
            if (d > 0) {
                c -= 10;
            }
            list.add(0, c);
            if (i == 0 && d > 0) {
                list.add(0, d);
            }
        }
        System.out.println("list = " + list);
        Integer[] integers = list.toArray(new Integer[0]);
        ListNode listNode = arrChangeListNode1(integers);
        System.out.println("listNode = " + listNode);
    }

    private static String listNodeChangeString(ListNode ln) {
        return (ln.next == null ? "" : listNodeChangeString(ln.next)) + ln.val + ", ";
    }

    private static ListNode arrChangeListNode1(Integer[] arr) {
        ListNode ln = new ListNode();
        for (int i = 0; i < arr.length; i++) {
            ln = i == 0 ? new ListNode(arr[i]) : new ListNode(arr[i], ln);
        }
        return ln;
    }

    private static ListNode arrChangeListNode(Integer[] arr) {
        ListNode ln = new ListNode();
        for (int i = arr.length - 1; i >= 0; i--) {
            ln = i < arr.length - 1 ? new ListNode(arr[i], ln) : new ListNode(arr[i]);
        }
        return ln;
    }
}

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return this.val + ", " + (this.next == null ? "" : this.next.toString());
    }
}

