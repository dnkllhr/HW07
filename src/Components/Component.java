package Components;

import Iterators.Iter;
import Iterators.PreOrderIter;

public abstract class Component {
	
/*	Here I decide to not declare the Add and Remove operations. This is because I am
	opting for safety over transparency in my design. If the next homework warrants
	transparency over safety, I will move the Add and Remove operations to this class
	from the Composite class. */
	
	protected Composite parent = null;
	
	protected void setParent(Composite parent){
		this.parent = parent;
	}
	
	protected Component getParent(){
		return parent;
	}
	
	public String indent(Component parent){
		String result = "";
		Component temp = this;
		while(temp != null && temp != parent){
			result += "\t";
			temp = temp.getParent();
		}
		return result;
	}
	
	//makeIter() is a FM that defers creation to Component's subclasses 
	public abstract Iter<Component> makeIter();
	
	public PreOrderIter makePreOrderIterator(){
		return new PreOrderIter(this);
	}
	
	public abstract String getInstanceID();
	
}
