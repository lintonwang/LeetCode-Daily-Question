package _202212;

public class MaximumScore1753 {
    public int maximumScore(int a, int b, int c) {
        //如果c>=a+b，很容易知道我们最多只能把a,b的石头全部匹配完，因此返回a+b即可
        //如果a+b>c，为了让石头尽可能多匹配几次。我们先让a和b去匹配，一旦a+b的和小于c的时候，就可以用c把他们全部匹配掉。
        //因为c是最大的，一定可以让a,b尽可能相等，直到相等或者相差1
        int sum = a + b + c;
        //c = max,a+b=sum-max
        int max = Math.max(Math.max(a, b), c);
        if (sum - max > max) return sum / 2;
        else return sum - max;
    }
}
