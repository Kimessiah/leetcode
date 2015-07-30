// Time O(logx)
public int mySqrt(int x) {

	if (x <= 0) return 0;

	int n = x/2 + 1;

	int start = 1;
	int end = n;

	while (start <= end) {
		int mid = (start + end) / 2;

		if(mid <= x/mid && x/(mid+1) < mid+1) {
            return mid;  
        }

        if(x/mid < mid) {  
            end = mid - 1;  
        } else {  
            start = mid + 1;  
        }
	}
	return 0;
}