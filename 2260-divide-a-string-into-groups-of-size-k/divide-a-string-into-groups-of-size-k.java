class Solution {
    public String[] divideString(String s, int k, char fill) {
        int totalSegments = (s.length() + k - 1) / k; // Calculate total segments needed
        String[] res = new String[totalSegments];

        int start = 0;
        for (int i = 0; i < totalSegments; i++) {
            // Determine the end index for the substring
            int end = Math.min(start + k, s.length());
            String stringToAdd = s.substring(start, end);
            
            // Fill with the specified character if the segment is shorter than k
            while (stringToAdd.length() < k) {
                stringToAdd += fill;
            }
            
            res[i] = stringToAdd;
            start += k; // Move to the next segment
        }
        return res;
    }
}
