package Components;

public class ArrayComposite extends Composite{
	
	private Component[] components;
	private int size;
	private int position;
	
	public ArrayComposite(){};
	
	public ArrayComposite(Component... components){
		this.components = new Component[components.length];
		size = components.length;
		for(int i = 0; i < components.length; i++){
			add(components[i]);
		}
		size = position;
	}

	@Override
	public void specificAdd(Component component) {
		components[position] = component;
		position++;
	}

	@Override
	public Component specificRemove() {
		Component temp = components[position - 1];
		components[position - 1] = null;
		position--;
		return temp;	
	}
	
	@Override 
	public boolean canAdd(Component component){
		if(position < size && super.canAdd(component)){
			return true;
		}
		return false;
	}
	
	@Override
	public boolean canRemove(){
		if(position > 0){
			return true;
		}
		return false;
	}
	
	@Override
	public String toString(){
		String result = super.toString();
		result += "ArrayComposite containing";
		for(int i = 0; i < position; i++){
			result += "\n" + components[i].toString();
		}
		return result;
	}

}
