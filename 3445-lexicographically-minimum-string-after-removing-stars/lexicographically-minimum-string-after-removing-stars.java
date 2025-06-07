class P {
    public char c;
    public int i;
    public P (char c, int i) {
        this.c = c;
        this.i = i;
    }
}

class Solution {
    public String clearStars(String s) {
        char str[] = s.toCharArray();
        PriorityQueue <P> pq = new PriorityQueue<> ((a, b) -> {
            // if character is same then sort on the basis of highest index else
            // sort on the basis of smallest character
            if (a.c == b.c) {
                return b.i - a.i;
            }
            return Character.compare(a.c, b.c);
        });

        for (int i = 0; i < s.length(); i++) {
            char c = str[i];
            if (c != '*') {
                pq.add(new P(c, i));
                continue;
            }
            if (!pq.isEmpty()) {
                P p = pq.poll();
                str[p.i] = '*';
            }
        }
        // String newStr = "";
        // for (char c : str) {
        //     if (c != '*') {
        //         newStr += c;
        //     }
        // }
        // return newStr;
        char[] result = new char[str.length]; 
        int index = 0;
        for (char c : str) {
            if (c != '*') {
                result[index] = c;
                index++;
            }
        }
        return new String(result, 0, index); 
    }
}