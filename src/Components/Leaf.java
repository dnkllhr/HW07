package Components;

import Iterators.Iter;
import Iterators.NullIterator;

public class Leaf extends Component {

	private static int numOfInstances = 0;
	private Integer id = 0; 
	private String instanceID;
	private String x;
	
	public Leaf(String x){
		this.id = numOfInstances++;
		this.instanceID = "Leaf" + id.toString(); 
		this.x = x;
	}
	
	public Iter<Component> makeIter(){
		return new NullIterator();
	}
	
	@Override
	public String indent(Component parent){
		return super.indent(parent) + toString();
	}
	
	@Override
	public String toString(){
		//return "Leaf " + x;
		return(parent == null) ?
		instanceID + " is the root.":
		instanceID + " is the child of " + parent; 
	}
	
	@Override
	public String getInstanceID(){
		return instanceID;
	}
	
}
