package Components;

import Iterators.Iter;

public class ArrayComposite extends Composite{
	
	private static int numOfInstances = 0;
	private Integer id = 0; 
	private String instanceID;
	private Component[] componentsArr;
	private int size;
	private int position;
	
	public ArrayComposite(){
		this.id = numOfInstances++;
		this.instanceID = "ArrayComposite" + id.toString(); 
	}
	
	public ArrayComposite(Component... components){
		this.id = numOfInstances++;
		this.instanceID = "ArrayComposite" + id.toString(); 
		int inputLength = components.length;
		componentsArr = new Component[inputLength];
		size = inputLength;
		for(int i = 0; i < inputLength; i++){
			add(components[i]);
		}
		size = position;
	}

	@Override
	public void specificAdd(Component component) {
		componentsArr[position] = component;
		position++;
	}

	@Override
	public Component specificRemove() {
		Component temp = componentsArr[position - 1];
		componentsArr[position - 1] = null;
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
	public Component getChild(int n){
		if(n < 0){
			System.out.println("No negative children index!");
			return null;
		}
		if(n > size){
			System.out.println("No negative children index!");
			return null;
		}
		return componentsArr[n];
	}
	
	@Override
	public Iter<Component> makeIter(){
		return new Iter<Component>(){
			private ArrayComposite ac = ArrayComposite.this;
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
				return current >= ac.getSize();
			}

			@Override
			public Component currentItem() {
				if(isDone()){
					System.out.println("The Iterator is out of bounds!");
					return null;
				}
				return ac.getChild(current);
			}
		};
	}
	
	@Override
	public String indent(Component parent){
		String result = super.indent(parent) + "ArrayComposite containing";
		for(int i = 0; i < position; i++){
			result += "\n" + componentsArr[i].indent(parent);
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
