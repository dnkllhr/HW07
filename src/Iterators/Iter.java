package Iterators;

public interface Iter<T> {
	
/*	Some of these operations seem like they should have default behavior since all
 	of the Iterators basically have the same first(), next() and currentItem() methods.
 	The NullIterator is the exception to this but I think it could override this default
 	behavior. */
	
	public void first();
	
	public void next();
	
	public boolean isDone();
	
	public T currentItem();
	
}
