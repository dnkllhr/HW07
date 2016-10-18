package Iterators;

import Components.Component;

public class NullIterator implements Iter<Component>{
	
	public NullIterator(){}

	@Override
	public void first() {}

	@Override
	public void next() {}

	@Override
	public boolean isDone() {
		return true;
	}

	@Override
	public Component currentItem() {
		return null;
	}

}
