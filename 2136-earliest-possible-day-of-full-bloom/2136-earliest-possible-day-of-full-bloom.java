// try to groow plants during planting
// overlap the planting and growing time to minimze the result
class Solution {
	public int earliestFullBloom(int[] plantTime, int[] growTime) {
		int n = plantTime.length;
		int[][] temp = new int[n][2];
		for (int i = 0; i < temp.length; i++) {
			temp[i][0] = plantTime[i];
			temp[i][1] = growTime[i];
		}
        // sort according to plant time in descending order
		Arrays.sort(temp, (a, b) -> b[1] - a[1]);
		int max = 0;
		int plant_time = 0;
        //keeping track of max time
		for (int i = 0; i < temp.length; i++) {
			max = Math.max(max, plant_time + temp[i][0] + temp[i][1]);
			plant_time = plant_time + temp[i][0];
		}
		return max;
	}
}