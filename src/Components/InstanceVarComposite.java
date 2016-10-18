package Components;

import Iterators.Iter;

public class InstanceVarComposite extends Composite{
	
	private static int numOfInstances = 0;
	private Integer id = 0; 
	private String instanceID;
	private Component componentInstanceVar = null;
	
	public InstanceVarComposite(){
		this.id = numOfInstances++;
		this.instanceID = "InstanceVarComposite" + id.toString(); 
	}
	
	public InstanceVarComposite(Component component){
		add(component);
		this.id = numOfInstances++;
		this.instanceID = "InstanceVarComposite" + id.toString();
	}

	@Override
	public void specificAdd(Component component) {
		componentInstanceVar = component;
	}

	@Override
	public Component specificRemove() {
		Component tempComponent = componentInstanceVar;
		componentInstanceVar = null;
		return tempComponent;
	}
	
	@Override
	public boolean canAdd(Component component){
		if(componentInstanceVar == null && super.canAdd(component)){
			return true;
		}
		return false;
	}
	
	@Override
	public boolean canRemove(){
		if(componentInstanceVar != null){
			return true;
		}
		return false;
	}
	
	@Override
	public Component getChild(int n){
		if(n != 0){
			System.out.println("There is no child at that position!");
			return null;
		}
		return componentInstanceVar;
	}
	
	@Override
	public Iter<Component> makeIter(){
		return new Iter<Component>(){
			private InstanceVarComposite ivc = InstanceVarComposite.this;
			private int current = 0;

			@Override
			public void first() {
				current = 0;
			}

			@Override
			public void next() {
				current++;
			}

			@Override
			public boolean isDone() {
				return current != 0;
			}

			@Override
			public Component currentItem() {
				if(isDone()){
					System.out.println("The Iterator is out of bounds!");
					return null;
				}
				return ivc.getChild(current);
			}
		};
	}
	
	@Override
	public String indent(Component parent){
		String result = super.indent(parent) + "InstanceVarComposite containing";
		if(componentInstanceVar != null){
			result += "\n" + componentInstanceVar.indent(parent);
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
	
	@Override
	public String getInstanceID(){
		return instanceID;
	}

}
