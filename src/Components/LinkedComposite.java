package Components;

import ComponentNode.ComponentNode;

public class LinkedComposite extends Composite{
	
	private ComponentNode head = null;
	
	public LinkedComposite(){};
	
	public LinkedComposite(Component... components){
		for(Component component: components){
			add(component);
		}
	}

	@Override
	public void specificAdd(Component component) {
		if(head == null){
			head = new ComponentNode(component);;
		}
		else{
			ComponentNode temp = head;
			while(temp.next != null){
				temp = temp.next;
			}
			temp.next = new ComponentNode(component);
		}
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
		return result.component;
	}
	
	@Override
	public boolean canRemove(){
		if(head != null){
			return true;
		}
		return false;
	}
	
	public void removeAll(){
		while(head != null){
			remove();
		}
	}
	
	@Override
	public String toString(){
		String result = super.toString();
		result += "LinkedComposite containing";
		ComponentNode temp = head;
		while(temp != null){
			result += "\n" + temp.toString();
			temp = temp.next;
		}
		return result;
	}

}
