package test;

import java.util.*;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
        next = null;
    }

    // @Override
    // public int hashCode(){
    //     final int prime = 31;
    //     int result = 1;
    //     result = prime * result + val;
    //     return result;
    // }

    @Override
    public boolean equals(Object otherObject) {
        if(otherObject.getClass() == getClass()){
            ListNode other = (ListNode)otherObject;
            if(this.val == other.val){
                
                return true;
            }
        }
        return false;
    }
}

public class testJ {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        Set<ListNode> s = new HashSet<ListNode>();
        s.add(n1);
        ListNode n2 = new ListNode(2);
        System.out.println(n1.hashCode());
        System.out.println(n2.hashCode());
        
        System.out.println(s.contains(n2));    
    }

    
}
