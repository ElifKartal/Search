import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Node {
	char data;
	LinkedList<Node> children; 
	Node parent;
	boolean word;
	
	public Node(char c) {
		data =c;
		children =new LinkedList<>(); 
		word =false;
		
	}

	public Node getChild(char c) {
		if(children != null)
			for (Node eachChild : children)
				if(eachChild.data == c)
					return eachChild;
		return null;
	}
	
	protected List<String> getWords() {
		
		List<String> list =new ArrayList<>();
		if (word) {
			list.add(toString());
			
		}
		if(children != null) {
			for(int i= 0; i< children.size(); i++) {
				if(children.get(i) != null) {
					list.addAll(children.get(i).getWords());
					
					
				}
			}
		}
		return list;
	}
	 public String toString() {
		 if(parent == null) {
			 return "";
			 
		 }else {
			 return parent.toString() + new String(new char[] {data});
			 
		 }
	 }
}
