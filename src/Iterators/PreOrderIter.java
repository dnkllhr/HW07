package Iterators;

import java.util.Stack;

import Components.Component;

public class PreOrderIter implements Iter<Component>{
	
/*	Here I copied the way the PreOrderIterator was implemented on pg. 68-69 of 
    the GoF  book. The difference is that the first() method in the book skips the 
    first  element of the structure (the root). Because of this, I had to create a
    fake iterator that would iterate over the component that created it only. This 
    way the preorder traversal can begin with the root.   */ 
	
	private Component root;
	private Stack<Iter<Component>> iterators = new Stack<Iter<Component>>();
	
	public PreOrderIter(Component component){
			root = new Component(){
				@Override
				public Iter<Component> makeIter() {
					return new Iter<Component>(){
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
							return component;
						}
					};
				}
				
				@Override
				public String getInstanceID() {
					return null;
				}		
		};
	}

	@Override
	public void first() {
		Iter<Component> i = root.makeIter();
		if(!i.isDone()){
			i.first();
			iterators.removeAllElements();
			iterators.push(i);
		}
	}

	@Override
	public void next() {
		Iter<Component> i = iterators.peek().currentItem().makeIter();
		i.first();
		iterators.push(i);
		while(iterators.size() > 0 && iterators.peek().isDone()){
			iterators.pop();
			if(!iterators.isEmpty()){
				iterators.peek().next();
			}
		}
	}

	@Override
	public boolean isDone() {
		return iterators.size() > 0 ? false : true;
	}

	@Override
	public Component currentItem() {
		return iterators.size() > 0 ? iterators.peek().currentItem() : null;
	}

}
