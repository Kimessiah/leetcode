// O(n) 
public int hammingWeight(int n) {  
    int res = 0;
    
    while (n != 0) {
        n = n & (n-1);
        res++;
    }
    return res;
}

// O(1)
public int hammingWeight(int n){
	int[] bitSetTable256 = new int[256];

	for (int i=1; i< 256; i++) {
		bitSetTable256[i] = (i&1) + bitSetTable256[i/2];
	}

	return (bitSetTable256[n & 0xff] +
			bitSetTable256[(n>>8) & 0xff] +
			bitSetTable256[(n>>16) & 0xff] +
			bitSetTable256[(n>>24) & 0xff]);
}
