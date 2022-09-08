package _202209;

public class ConstructArray667 {
    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        //总共n个数，之间的绝对差值有n-1个，使前面x个数的差值为1,那么还需要k-1个不同差值，需要k-1个数，
        // 但是因为序列中后续数是交替出现，后面的差值中是会出现差值为1的差值，所以需要的仍然是k个不同差值，需要k个数
        // 因此x=n-k
        //[1,2,⋯,n−k,  n,n−k+1,n−1,n−k+2,⋯] 前面n-k个数差值为1，后面从n-k+1到n共k个数，最后因为交替出现，会出现差值为1的情况

        for (int i = 1; i <= n - k; i++) {
            ans[i - 1] = i;
        }
        int i = n - k + 1, j = n;
        for (int idx = n - k; idx < n; idx++) {
            ans[idx++] = j;
            if (idx < n)
                ans[idx] = i;
            j--;
            i++;
        }
        return ans;
    }
}
