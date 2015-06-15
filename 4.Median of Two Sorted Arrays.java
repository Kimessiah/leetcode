public double findMedianSortedArrays(int A[], int B[]) {
	if (A.length <= B.length)
		return findMedian(A, B, 0, A.length-1, A.length, B.length);
	else 
		return findMedian(B, A, 0, B.length-1, B.length, A.length);
}

public double findMedian(int A[], int B[], int left, int right, int n, int m) {
	if (left > right)
		return findMedian(B, A, Math.max(0, (m+n)/2-n), Math.min(m-1, (m+n)/2), m, n);

	int i = (left+right) / 2;
	int j = (m+n)/2 - i - 1;

	if (A[i]>=B[j] && (j== m-1 || A[i]<=B[j+1])) {
		if ((m+n)%2 == 1) {
			return A[i];
		} else {
			return (A[i] + Math.max(A[i-1], B[j])) / 2;
		}
	} else if (A[i] > B[j+1]) {
		return findMedian(A, B, left, i-1, n, m);
	} else {
		return findMedian(A, B, i-1, right, n, m);
	}
}