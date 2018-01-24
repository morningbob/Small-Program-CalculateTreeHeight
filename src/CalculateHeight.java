import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CalculateHeight {

	public class Node{
		
		int mName;
		Node mParent;
		int mLevel = 0;
		
		public Node(int name) {
			mName = name;
		}
		
	}
	
	public int calculate(ArrayList<Node> tree) {
		
		Queue<Node> route = new LinkedList<Node>();
		Node root = new Node(-1);
		for (Node each : tree) {
			if (each.mName == -1) {
				root = each;
			}
		}
		Node currentNode = root;
		int maxLevel = 0;
		route.add(currentNode);
		
		while (!route.isEmpty()) {
			currentNode = route.remove();
			if (indexOfChildren(currentNode, tree).size()!=0) {
				for (Node child : indexOfChildren(currentNode, tree)) {
					route.add(child);
					child.mLevel = currentNode.mLevel + 1;
					if (maxLevel < child.mLevel) {
						maxLevel = child.mLevel;
					}
					
				}
				
			}
		}
		
		return maxLevel;
		
	}
	
	public ArrayList<Node> indexOfChildren(Node target, ArrayList<Node> list){
		ArrayList<Node> resultList = new ArrayList<Node>();
		for (int i=0; i<list.size(); i++) {
			Node currentNode = list.get(i);
			if (target.equals(currentNode.mParent)) {
				resultList.add(currentNode);
			}
		}
		return resultList;
	}
	
	
}
