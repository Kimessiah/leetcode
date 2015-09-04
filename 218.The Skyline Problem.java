// Divide and Conquer: Time O(nlogn)
public List<int[]> getSkyline(int[][] buildings) {

	if (buildings == null || buildings.length == 0 || buildings[0].length == 0) {
		return new ArrayList<int[]>();
	}        

	return getSkylineHelper(buildings, 0, buildings.length-1);
}

List<int[]> getSkylineHelper(int[][] buildings, int lo, int hi) {

	if (lo == hi) {
		List<int[]> sk = new ArrayList<>();
		sk.add(new int[]{ buildings[lo][0], buildings[lo][2] });
		sk.add(new int[]{ buildings[lo][1], 0});
		return sk;
	}

	int mid = (lo+hi) / 2;
	List<int[]> sk1 = getSkylineHelper(buildings, lo, mid);
	List<int[]> sk2 = getSkylineHelper(buildings, mid+1, hi);
	return mergeSkyline(sk1, sk2);
}

List<int[]> mergeSkyline(List<int[]> sk1, List<int[]> sk2) {

	List<int[]> sk = new ArrayList<>();
	int h1 = 0, h2 = 0;
	int i = 0, j = 0;

	while (i < sk1.size() && j < sk2.size()) {
		int[] strip1 = sk1.get(i);
		int[] strip2 = sk2.get(j);
		int[] strip = new int[2];

		if (strip1[0] < strip2[0]) {
			h1 = strip1[1];
			strip[0] = strip1[0];
			strip[1] = Math.max(h1, h2);
			i++;
		} else {
			h2 = strip2[1];
			strip[0] = strip2[0];
			strip[1] = Math.max(h1, h2);
			j++;
		}
		append(sk, strip);
	}

	while (i < sk1.size()) {
		append(sk, sk1.get(i));
		i++;
	} 
	
	while (j < sk2.size()) {
		append(sk, sk2.get(j));
		j++;
	} 

	// Set y of last point to 0
	int[] last = sk.get(sk.size()-1);
	last[1] = 0;
	sk.set(sk.size()-1, last);
	return sk;
}

void append(List<int[]> list, int[] strip) {

	if (list.size() == 0) {
		list.add(strip);
	} else {
		int[] prev = list.get(list.size()-1);
		if (prev[1] == strip[1]) {
			return;
		}
		if (prev[0] == strip[0]) {
			prev[1] = Math.max(prev[1], strip[1]);
			list.set(list.size()-1, prev);
			return;
		}
		list.add(strip);
	}
}