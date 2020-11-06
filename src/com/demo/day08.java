package com.demo;

import com.demo.element.ListNode;

/**
 * @author liusong0224
 * @date 2020/11/6 8:52
 * @Description
 */
//给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，po
//s 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
//
// 说明：不允许修改给定的链表。
//
// 进阶：
//
//
// 你是否可以使用 O(1) 空间解决此题？
//
//
public class day08 {
    public ListNode detectCycle(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode quick = head;
        ListNode slow = head;
        while (quick!=null){
            if (quick.next!=null){
                quick = quick.next.next;
            }else {
                return null;
            }
            slow = slow.next;
            if (quick==slow){
                ListNode ptr = head;
                while (ptr!=slow){
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
