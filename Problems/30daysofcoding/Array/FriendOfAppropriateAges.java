import java.util.Arrays;

class FriendOfAppropriateAges {
    public int numFriendRequests(int[] ages) {
        int res = 0; 
        int[] numInAge = new int[121];
        int[] sumInAge = new int[121]; 
        for (int age : ages) {
            numInAge[age]++; 
        }
        for (int i = 1; i <= 120; i++) {
            sumInAge[i] = numInAge[i] + sumInAge[i - 1];
        }
        for (int i = 15; i <= 120; i++) {
            if (numInAge[i] == 0) {
                continue; 
            }
            int cnt = sumInAge[i] - sumInAge[i / 2 + 7]; 
            res += cnt * numInAge[i] - numInAge[i]; 
        }
        return res; 
    }

    public static void main(String[] args) {
        FriendOfAppropriateAges foa = new FriendOfAppropriateAges();
        int[] ages = {20,30,100,110,120};
        System.out.println(foa.numFriendRequests(ages));
    }
}