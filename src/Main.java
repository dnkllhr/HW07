import Components.*;
import Iterators.Iter;

public class Main {

	public static void printWithIter(Iter<Component> iter){
		for(iter.first(); !iter.isDone(); iter.next()){
			System.out.println("\t" + iter.currentItem().getInstanceID());
		}
	}
	
	public static void main(String[] args){
//		Leaf l = new Leaf("A");
//		Composite ivc = new InstanceVarComposite(l);
//		Leaf l2 = new Leaf("B");
//		Composite ac = new ArrayComposite(ivc, l2);
//		Leaf l3 = new Leaf("C");
//		Composite lc = new LinkedComposite(ac, l3);
//		System.out.println("*Testing the nest Composites with correct identation.*");
//		System.out.println(l);
//		System.out.println(ivc);
//		System.out.println(ac);
//		System.out.println(lc);
//		System.out.println("\n*Testing remove methods.*");
//		ivc.remove();
//		ivc.remove();
//		ac.remove();
//		ac.remove();
//		ac.remove();
//		lc.remove();
//		lc.remove();
//		lc.remove();
//		System.out.println(ivc);
//		System.out.println(ac);
//		System.out.println(lc);
//		System.out.println("\n*Testing add methods.*");
//		ivc.add(l);
//		ac.add(l2);
//		lc.add(l3);
//		System.out.println(ivc);
//		System.out.println(ac);
//		System.out.println(lc);
//		System.out.println("\n*Testing whether a child can only have one parent.*");
//		ac.add(l3);
//		System.out.println(ac);
		System.out.println("\n*Testing new toString() methods.*");
		Leaf l = new Leaf("A");
		Composite ivc = new InstanceVarComposite(l);
		Composite ac = new ArrayComposite(ivc);
		Composite lc = new LinkedComposite(ac);
		System.out.println(ivc);
		System.out.println(ac);
		System.out.println(lc);
		System.out.println("\n*Testing the Iterators.*");
		Leaf l2 = new Leaf("B");
		InstanceVarComposite ivc2 = new InstanceVarComposite(l2);
		ArrayComposite ac2 = new ArrayComposite(ivc2, new Leaf("C"));
		LinkedComposite lc2 = new LinkedComposite(ac2, new Leaf("D"));
		Iter<Component> lIter = l2.makeIter();
		Iter<Component> ivcIter = ivc2.makeIter();
		Iter<Component> acIter = ac2.makeIter();
		Iter<Component> lcIter  = lc2.makeIter();
		System.out.println("Iterating over " + l2.getInstanceID() + "'s children...");
		printWithIter(lIter);
		System.out.println("Iterating over " + ivc2.getInstanceID() + "'s children...");
		printWithIter(ivcIter);
		System.out.println("Iterating over " + ac2.getInstanceID() + "'s children...");
		printWithIter(acIter);
		System.out.println("Iterating over " + lc2.getInstanceID() + "'s children...");
		printWithIter(lcIter);
		System.out.println("\n*Testing the makePreOrderIterator().*");
		System.out.println(l2.getInstanceID() + "'s preOrder traversal:");
		Iter<Component> l2POIter = l2.makePreOrderIterator();
		printWithIter(l2POIter);
		System.out.println(ivc2.getInstanceID() + "'s preOrder traversal:");
		Iter<Component> ivc2POIter = ivc2.makePreOrderIterator();
		printWithIter(ivc2POIter);
		System.out.println(ac2.getInstanceID() + "'s preOrder traversal:");
		Iter<Component> ac2POIter = ac2.makePreOrderIterator();
		printWithIter(ac2POIter);
		System.out.println(lc2.getInstanceID() + "'s preOrder traversal:");
		Iter<Component> lc2POIter = lc2.makePreOrderIterator();
		printWithIter(lc2POIter);
	}
	
}