class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int boats = 0;
        int i = 0;
        int j = n-1;
        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                i++;
                j--;
            }
            else if (people[i] + people[j] > limit) {
                j--;
            }
            boats++;
        }
        return boats;
    }
}