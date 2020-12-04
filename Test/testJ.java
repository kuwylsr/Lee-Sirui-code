import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		
		Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		map.put(1,list);
		System.out.println(map);
		List<Integer> list1 = map.get(1);
		list1.add(2);
		System.out.println(map);

	}

}
