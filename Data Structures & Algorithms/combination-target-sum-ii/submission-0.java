class Solution {
    List<List<Integer>>result;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();
        Arrays.sort(candidates);

        dfs(candidates, target, 0, 0, new ArrayList<>());

        return result;
    }

    public void dfs(int[]candidates, int target, int i, int total, List<Integer>curr){
        if(target == total){
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int j = i; j < candidates.length; j++){
            if(j > i && candidates[j] == candidates[j - 1]){
                continue;
            }

            if (total + candidates[i] > target) {
                break;
            }

            curr.add(candidates[j]);
            dfs(candidates, target, j + 1, total + candidates[j], curr);
            curr.remove(curr.size() - 1);
        }
    }
}
