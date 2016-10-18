package Components;

import ComponentNode.ComponentNode;
import Iterators.Iter;

public class LinkedComposite extends Composite{
	
	private static int numOfInstances = 0;
	private Integer id = 0; 
	private String instanceID;
	private ComponentNode head = null;
	private int size = 0;
	
	public LinkedComposite(){
		this.id = numOfInstances++;
		this.instanceID = "LinkedComposite" + id.toString(); 
	}
	
	public LinkedComposite(Component... components){
		this.id = numOfInstances++;
		this.instanceID = "LinkedComposite" + id.toString(); 
		for(Component component: components){
			add(component);
		}
	}

	@Override
	public void specificAdd(Component component) {
		if(head == null){
			head = new ComponentNode(component);
		}
		else{
			ComponentNode temp = head;
			while(temp.next != null){
				temp = temp.next;
			}
			temp.next = new ComponentNode(component);
		}
		size++;
	}
	

	@Override
	public Component specificRemove() {
		ComponentNode temp = head;
		if(head.next == null){
			ComponentNode res = temp;
			head = null;
			return res.component;
		}
		while(temp.next.next != null){
			temp = temp.next;
		}
		ComponentNode result = temp.next;
		temp.next = null;
		size--;
		return result.component;
	}
	
	@Override
	public boolean canRemove(){
		if(head != null){
			return true;
		}
		return false;
	}
	
	@Override
	public Component getChild(int n){
		if(n < 0){
			System.out.println("No negative children index!");
			return null;
		}
		ComponentNode temp = head;
		int i = 0;
		while(temp != null){
			if(i == n){
				return temp.component;
			}
			i++;
			temp = temp.next;
		}
		System.out.println("There is no child at that position!");
		return null;
	}
	
	@Override 
	public Iter<Component> makeIter(){
		return new Iter<Component>(){
			private ComponentNode current;
			
			@Override
			public void first() {
				current = head;
			}

			@Override
			public void next() {
				current = current.next;
			}

			@Override
			public boolean isDone() {
				return current == null;
			}

			@Override
			public Component currentItem() {
				if(isDone()){
					System.out.println("The Iterator is out of bounds!");
					return null;
				}
				return current.component;
			}

		};
	}
	
	@Override
	public String indent(Component parent){
		String result = super.indent(parent) + "LinkedComposite containing";
		ComponentNode temp = head;
		while(temp != null){
			result += "\n" + temp.indent(parent);
			temp = temp.next;
		}
		return result;
	}
	
	@Override
	public String toString(){
		//return indent(this);
		return(parent == null) ?
		instanceID + " is the root.":
		instanceID + " is the child of " + parent; 
	}
	
	public int getSize(){
		return size;
	}
	
	public String getInstanceID(){
		return instanceID;
	}

}
