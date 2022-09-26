public class MissingTwo17_19 {
    public int[] missingTwo(int[] nums) {
        int xor = 0;
        int n = nums.length + 2;
        for (int num : nums) xor ^= num;
        for (int i = 1; i <= n; i++) xor ^= i;
        //取xor最低的1构成的数，即low0的二进制里面只有1个1，且这个1位于xor最低位的1
        int low0 = xor & (-xor);
        int bit0 = 0;
        int bit1 = 0;
        //将数字分为两类，在low0位置上为0，和在low0位置上为1
        for (int num : nums) {
            if ((num & low0) == 0) bit0 ^= num;
            else bit1 ^= num;
        }
        //两类数字分别异或
        for (int i = 1; i <= n; i++) {
            if ((i & low0) == 0) bit0 ^= i;
            else  bit1 ^= i;
        }
        return new int[]{bit0, bit1};
    }


}
