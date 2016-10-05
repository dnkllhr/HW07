package Components;

public abstract class Composite extends Component{
	
	public boolean add(Component component){
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
	
	public Component remove(){
		if(canRemove()){
			Component component = specificRemove();
			component.setParent(null);
			return component;
		}
		else {
			System.out.println("No component to remove.");
			return null;
		}
	}
	
	public boolean canAdd(Component component){
		if(component.getParent() == null){
			return true;
		}
		return false;
	}
	
	public abstract boolean canRemove();
	
	public abstract void specificAdd(Component component);
	
	public abstract Component specificRemove();

}
