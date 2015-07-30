// Time O(n)   Space O(1)
public void sortColors(int[] nums) {

	if (nums == null || nums.length <= 1) return;

	int lowId = 0;
	int hiId = nums.length-1;
	int i = 0;

	while (i <= hiId) {
		if (nums[i] == 0) {
			swap(nums, i, lowId);
			lowId++;
			i++;
		} else if (nums[i] == 2) {
			swap(nums, i, hiId);
			hiId--;
		} else {
			i++;
		}
	} 
}

void swap(int[] a, int i, int j) {
	int temp = a[i];
	a[i] = a[j];
	a[j] = temp;
}