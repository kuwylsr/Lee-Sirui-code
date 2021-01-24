import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

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

		String[] slist = new String[1];
		System.out.print(slist[0] == null);
	}

}
