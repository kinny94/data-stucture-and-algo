class AdditiveNumber {
    public boolean isAdditiveNumber(String s) {
        for (int i=1; i<s.length(); i++) {
            for (int j=i+1; j<s.length(); j++) {
                long a = parseLong(s.substring(0, i));
                long b = parseLong(s.substring(i, j));

                if (a == -1 || b== -1) {
                    continue;
                }

                if (dfs(s.substring(j), a, b)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(String s, long a, long b) {
        if (s.length() == 0) {
            return true;
        }

        for (int i=1; i<=s.length(); i++) {
            long c = parseLong(s.substring(0, i));
            if (c == -1) {
                continue;
            }

            if (c - a == b && dfs(s.substring(i), b, c)) {
                return true;
            }
        }

        return false;
    }

    private long parseLong(String s) {
        if (!s.equals("0") && s.startsWith("0")) {
            return -1;
        }

        long result = 0;
        try {
            result = Long.parseLong(s);
        } catch (NumberFormatException e) {
            return -1;
        }

        return result;
    }

    public static void main(String[] args) {
        AdditiveNumber obj = new AdditiveNumber();
        System.out.println(obj.isAdditiveNumber("112358"));
    }
}