class Solution {
    List<List<Integer>>result;
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        backtrack(nums, 0);
        return result;
    }

   public void backtrack(int[] arr, int start) {

        if (start == arr.length) {
            List<Integer> current = new ArrayList<>();

            for (int num : arr) {
                current.add(num);
            }

            result.add(current);
            return;
        }

        for (int i = start; i < arr.length; i++) {

            swap(arr, start, i);

            backtrack(arr, start + 1);

            swap(arr, start, i);
        }
    }

    public void swap(int[]arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    }
