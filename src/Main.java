import Components.*;

public class Main {

	public static void main(String[] args){
		Composite lc = new LinkedComposite(new Leaf("A"), new Leaf("B"));
		Composite ac = new ArrayComposite(new Leaf("C"), lc);
		Composite ivc = new InstanceVarComposite(ac);
		System.out.println(ivc);
	}
	
}