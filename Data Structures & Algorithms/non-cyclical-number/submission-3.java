class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> visited = new HashSet<>();

        while (n != 1 && !visited.contains(n)) {
            visited.add(n);
            n = SquaresSum(n);
        }

        return n == 1;
    }

    public int SquaresSum(int n) {
        int total = 0;

        while (n != 0) {
            int remainder = n % 10;
            total += remainder * remainder;
            n = n / 10;
        }

        return total;
    }
}

// class Solution {
//     public boolean isHappy(int n) {
//         int slow = n;
//         int fast = n;

//         do {
//             slow = squareSum(slow);
//             fast = squareSum(squareSum(fast));
//         } while (slow != fast);

//         return slow == 1;
//     }

//     private int squareSum(int n) {
//         int sum = 0;

//         while (n > 0) {
//             int digit = n % 10;
//             sum += digit * digit;
//             n /= 10;
//         }

//         return sum;
//     }
// }