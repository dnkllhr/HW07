package ComponentNode;

import Components.Component;

public class ComponentNode {

	public Component component;
	public ComponentNode next;
	
	public ComponentNode(Component component){
		this.component = component;
		this.next = null;
	}
	
	@Override
	public String toString(){
		return component.toString();
	}
	
}
