class Solution {
    Boolean isPalindrome (String pal) {
        int start = 0;
        int end = pal.length()-1;
        while (start <= end) {
            if (pal.charAt(start) != pal.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    String convertToBaseK (long num, int k) {
        if (num == 0) {
            return "0";
        }

        String res = "";
        while (num > 0) {
            long rem = num%k;
            res += String.valueOf(rem);
            num /= k;
        }
        return res;
    }
    public long kMirror(int k, int n) {
        int L = 1;
        long sum = 0;
        while (n > 0) {
            int half_length = (L+1)/2;
            long min_num_possible = (long)(Math.pow(10, half_length-1));
            long max_num_possible = (long)(Math.pow(10, half_length)-1);

            for (long num = min_num_possible; num <= max_num_possible; num++) {
                // first half for palidrome
                String first_half = String.valueOf(num);

                // 2nd half for palidrome
                String temp = String.valueOf(num);
                String second_half = new StringBuilder(temp).reverse().toString();

                String pal = "";
                if (L%2 == 0) {
                    // even length palindrome to be generated
                    pal = first_half + second_half;
                }
                else {
                    // odd length palindrome to be generated
                    pal = first_half + second_half.substring(1); // skips first character
                }

                Long val = Long.parseLong(pal);
                String baseK = convertToBaseK(val, k);
                if (isPalindrome(baseK)) {
                    sum += val;
                    n--;
                    if (n == 0) {
                        break;
                    }
                }
            }
            L++;
        }
        return sum;
    }
}