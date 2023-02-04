package MovieSearch;

import java.util.ArrayList;
import java.util.List;


class Tree {
	private Node root;
	
	public Tree() {
		root = new Node('*'); //Ağacın ana kökü tanımlandı 
		
	}
	 public void insert(String word) {
		 if(search(word)==true)
			 return;
		 Node mevcut = root;
		 Node onceki;
		 for(char ch : word.toCharArray()) {
			 onceki = mevcut;
			 Node child =mevcut.getChild(ch);
			 if(child != null) {
				 mevcut = child;
				 child.parent = onceki;
			 }else {
				 mevcut.children.add(new Node(ch));
				 mevcut = mevcut.getChild(ch);
				 mevcut.parent =onceki;
			 }
		 }
		 mevcut.word =true;
		 
	 }
	 
	 public boolean search (String word) {
		 Node mevcut = root;
		 for(char ch : word.toCharArray()) {
			 if(mevcut.getChild(ch) == null) {
				 return false;
			 }else {
				 mevcut = mevcut.getChild(ch);
			 }
		 }
		 if (mevcut.word == true) {
			 return true;
		 }
		 return false;
		 
	 }
	 
	 public List<String> autocomplete(String prefix){
		 Node lastNode = root;
		 for (int i = 0; i< prefix.length(); i++) {
			 lastNode =lastNode.getChild(prefix.charAt(i));
			 if(lastNode == null)
				 return new ArrayList<>();			 
		 }
		return lastNode.getWords();
	 }

}
