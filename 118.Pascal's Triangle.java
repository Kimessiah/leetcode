public List<List<Integer>> generate(int numsRows) {

	List<List<Integer>> res = new ArrayList<List<Integer>>();

	if (numRows <= 0) return res;

	List<Integer> prev = new ArrayList<Integer>();
	prev.add(1);
	res.add(prev);

	for (int i = 2; i <= numRows; i++) {
		List<Integer> temp = new ArrayList<Integer>();
		temp.add(1);
		for (int j = 0; j < prev.size()-1; j++) {
			temp.add(prev.get(j) + prev.get(j+1));
		}
		temp.add(1);
		res.add(temp);
		prev = temp;
	}
	return res;
}