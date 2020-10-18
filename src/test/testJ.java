package test;

import java.util.*;

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
	int i = 0;

	public void dfs(int j) {
		i++;
		if (j == 2) {
			return;
		}
		j++;
		dfs(j);
		System.out.println("1:" + i);
	}

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		String[] A = {"123","132"};
		String t = A[0];
		int index = 1;
		t = t.substring(0, index) + t.substring(index + 1);
		System.out.println(A[0]);

	}

}
