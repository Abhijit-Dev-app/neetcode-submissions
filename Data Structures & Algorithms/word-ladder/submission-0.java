class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> dictionary = new HashSet<>(wordList);

        // If endWord is not present, no transformation is possible.
        if (!dictionary.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        // Mark beginWord as visited if it's present in the dictionary.
        dictionary.remove(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size-- > 0) {

                String word = queue.poll();

                if (word.equals(endWord)) {
                    return level;
                }

                char[] chars = word.toCharArray();

                for (int i = 0; i < chars.length; i++) {

                    char original = chars[i];

                    for (char ch = 'a'; ch <= 'z'; ch++) {

                        if (ch == original) {
                            continue;
                        }

                        chars[i] = ch;
                        String nextWord = new String(chars);

                        if (dictionary.contains(nextWord)) {
                            queue.offer(nextWord);
                            dictionary.remove(nextWord);
                        }
                    }

                    chars[i] = original;
                }
            }

            level++;
        }

        return 0;
    }
}