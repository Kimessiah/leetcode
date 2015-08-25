// Time O(2^n)   Space O(2^n)
public List<Integer> grayCode(int n) {

	List<Integer> res = new ArrayList<Integer>();
    res.add(0);

    for(int i=1; i<=n; i++){
        for(int j=res.size()-1; j>=0; j--){
            res.add(res.get(j) + (i<<(n-1))));
        }
    }
    return res;
}

