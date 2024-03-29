public class TwoSum {

	Map<Integer, Integer> elements = new HashMap<>();

	public void add(int number) {
		if (elements.containsKey(number)) {
			elements.put(number, elements.get(number)+1);
		} else {
			elements.put(number, 1);
		}
	    
	}

	public boolean find(int value) {

		for (Integer i : elements.keySet()) {
			int target = value - i;
			if (elements.containsKey(target)) {
				if (target == i && elements.get(target) < 2) {
					continue;
				}
				return true;
			}
		}
	    return false;
	}
}