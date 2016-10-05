package Components;

public abstract class Component {
	
/*	Here I decide to not declare the Add and Remove operations. This is because I am
	opting for safety over transparency for my design. If the next homework warrants
	transparency over safety, I will move the Add and Remove operations to this class
	from the Composite class. */
	
	private Composite parent = null;
	
	protected void setParent(Composite parent){
		this.parent = parent;
	}
	
	protected Component getParent(){
		return this.parent;
	}
	
	@Override
	public String toString(){
		String result = "";
		Component parent = this.getParent();
		while(parent != null){
			result += "\t";
			parent = parent.getParent();
		}
		return result;
	}
	
}
