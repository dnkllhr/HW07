package Components;

public abstract class Composite extends Component{
	
/*  These add and remove methods use TM because they are the template that calls the subclass 
	specific specificAdd and specificRemove. They maintain the invariant by setting the parent 
	appropriately when a component is added or removed from a Composite. */
	
	public final boolean add(Component component){
		if(canAdd(component)){
			specificAdd(component);
			component.setParent(this);
			return true;
		}
		else{
			System.out.println("Can't add this component.");
			return false;
		}
	}
	
	public final Component remove(){
		if(canRemove()){
			Component component = specificRemove();
			component.setParent(null);
			return component;
		}
		else{
			System.out.println("No component to remove.");
			return null;
		}
	}
	
	protected boolean canAdd(Component component){
		if(component.getParent() == null){
			return true;
		}
		return false;
	}
	
	protected abstract boolean canRemove();
	
	protected abstract void specificAdd(Component component);
	
	protected abstract Component specificRemove();
	
	public abstract Component getChild(int n);

}
