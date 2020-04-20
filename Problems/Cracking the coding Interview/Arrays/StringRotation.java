class StringRotation {

    public boolean isRotation(String s1, String s2) {
        int len = s1.length();

        if (len == s2.length() && len > 0) {
            String s1s2 = s1 + s2;
            return isSubsString(s1s1, s2);
        }

        return false;
    }
}