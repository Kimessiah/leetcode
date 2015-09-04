// Time O(n)   Space O(1)
public int rob(int[] nums) {

	if (nums == null || nums.length == 0) return 0;

	int n = nums.length;
	int[] money = new int[n+1]; //the maximum amount to the i'th house

	money[0] = 0;
	money[1] = nums[0];

	for (int i = 2; i <= n; i++) {
		money[i] = Math.max(money[i-1], money[i-2] + nums[i-1]);
	}
	return money[n];
}

// Time O(n)   Space O(1)
public int rob(int[] nums) {

	if(nums == null || nums.length == 0) return 0;
 
	int even = 0;
	int odd = 0;
 
	for (int i = 0; i < nums.length; i++) {
		if (i % 2 == 0) {
			even += nums[i];
			even = even > odd ? even : odd;
		} else {
			odd += nums[i];
			odd = even > odd ? even : odd;
		}
	}
	return even > odd ? even : odd;
}