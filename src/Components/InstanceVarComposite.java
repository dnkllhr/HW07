package Components;

public class InstanceVarComposite extends Composite{
	
	private Component component = null;
	
	public InstanceVarComposite(){};
	
	public InstanceVarComposite(Component component){
		add(component);
	}

	@Override
	public void specificAdd(Component component) {
		this.component = component;
	}

	@Override
	public Component specificRemove() {
		Component tempComponent = this.component;
		this.component = null;
		return tempComponent;
	}
	
	@Override
	public boolean canAdd(Component component){
		if(this.component == null && super.canAdd(component)){
			return true;
		}
		return false;
	}
	
	@Override
	public boolean canRemove(){
		return !canAdd(component);
	}
	
	@Override
	public String toString(){
		String result = super.toString();
		result += "InstanceVarComposite Containing";
		if(this.component != null){
			result += "\n" + this.component.toString();
		}
		return result;
	}

}
