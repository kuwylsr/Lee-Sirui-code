import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.Map.Entry;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}

	// @Override
	// public int hashCode(){
	// final int prime = 31;
	// int result = 1;
	// result = prime * result + val;
	// return result;
	// }

	@Override
	public boolean equals(Object otherObject) {
		if (otherObject.getClass() == getClass()) {
			ListNode other = (ListNode) otherObject;
			if (this.val == other.val) {

				return true;
			}
		}
		return false;
	}
}


public class testJ {


	public static void main(String[] args) {
		
		Map<Integer,String> map = new HashMap<>();
		map.put(1,"@");
		map.put(2,"33");
		
		Set<Entry<Integer,String>> set = map.entrySet();
		Iterator<Entry<Integer,String>> it = set.iterator();
		
		while(it.hasNext()){
			Entry<Integer,String> entry = it.next();
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
	}

}
