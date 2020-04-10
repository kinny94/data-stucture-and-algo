class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        
        int fives = 0;
        int tens = 0;
        int transaction = 5;
        
        for (int i: bills) {
            if (i == transaction) {
                fives++;
            } else if (i == 10) {
                tens++;
                fives--;
            } else  if (tens > 0) {
                tens--;
                fives--;
            } else {
                fives -= 3;
            }
            
            if (fives < 0) {
                return false;
            }
        }
        
        return true;
    }
}