public List<List<Integer>> subsetsWithDup(int[] nums) {

	List<List<Integer>> res = new ArrayList<List<Integer>>();
	res.add(new ArrayList<Integer>());

	if (nums == null || nums.length == 0) return res;

	Arrays.sort(nums);

	for (int i = 0; i < nums.length; i++) {
		int size = res.size();
		for (int j = 0; j < size; j++) {

			List<Integer> curr = new ArrayList<Integer>(res.get(i));
			curr.add(nums[i]);
			if (!res.contains(curr)) {
				res.add(curr);
			}
		}
	}
	return res;
}

public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {  

    List<List<Integer>> res = new ArrayList<List<Integer>>();  
    res.add(new ArrayList<Integer>());  

    if(nums == null || nums.length == 0) {
        return res;  
    }
    Arrays.sort(num); 

    int start = 0;  
    for(int i = 0; i < nums.length; i++) {  
        int size = res.size();  
        for(int j = start; j < size; j++) {  
            List<Integer> newItem = new ArrayList<Integer>(res.get(j));  
            newItem.add(num[i]);  
            res.add(newItem);  
        }  

        if(i<num.length-1 && num[i]==num[i+1]) {  
            start = size;  
        } else {  
            start = 0;  
        }  
    }  
    return res;  
} 