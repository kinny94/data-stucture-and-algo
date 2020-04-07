class FindAllConcatedNatedWords {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> set = new HashSet<>(10000);
        List<String> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (String word : words) {
            if (word.length() == 0) {
                continue;
            }
            set.add(word);
            min = Math.min(min, word.length());
        }
        for (String word : words) {
            if (check(set, word, 0, min)) {
                res.add(word);
            }
        }
        return res;
    }

    private boolean check(Set<String> set, String word, int start, int min) {
        for (int i = start + min; i <= word.length() - min; i++) {
            if (set.contains(word.substring(start, i)) &&
                (set.contains(word.substring(i)) || check(set, word, i, min))) {
                return true;
            }
        }
        return false;
    }
}