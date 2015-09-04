// Using Iterator
public class Vector2D {

	Iterator<List<Integer>> outterIter;
	Iterator<Integer> innerIter = Collections.emptyIterator();

	public Vector2D(List<List<Integer>> vec2d) {
		outterIter = vec2d.iterator();
	}

	public int next() {
		if (hasNext()) {
        	return innerIter.next();
        }
        return -1;
	}

	public boolean hasNext() {
	    if(innerIter.hasNext()){
	    	return true;
	    }

	    // while to skip empty collection
	    if(!outterIter.hasNext()){
	    	return false;
	    }

	    innerIter = outterIter.next().iterator();

	    return hasNext();
	 }
}