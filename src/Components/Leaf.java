package Components;

public class Leaf extends Component {

	private String x;
	
	public Leaf(String x){
		this.x = x;
	}
	
	@Override
	public String toString(){
		String result = super.toString();
		return result += "Leaf " + x;
	}
	
}
