package _202209;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RectangleArea850 {
    public final int MOD = (int) 1e9 + 7;

    public int rectangleArea(int[][] rectangles) {
        //将所有矩形的x坐标存到list中
        List<Integer> list = new ArrayList<>();
        for (int[] info : rectangles) {
            list.add(info[0]);
            list.add(info[2]);
        }
        //对list中x坐标从此小到大排序
        Collections.sort(list);
        long ans = 0;
        //每次取出两个相邻x坐标
        for (int i = 1; i < list.size(); i++) {
            //令相邻x坐标距离为len，如果len=0跳过循环
            int a = list.get(i - 1), b = list.get(i), len = b - a;
            if (len == 0) continue;
            //定义lines存储能够覆盖(x1,x2)的y坐标对（y1,y2）
            List<int[]> lines = new ArrayList<>();
            for (int[] info : rectangles) {
                if (info[0] <= a && info[2] >= b) {//当矩形覆盖当前x区间，则将y坐标记录下来
                    lines.add(new int[]{info[1], info[3]});
                }
            }
            //对所有的y坐标对，按照y1,y2,从小到大排序
            Collections.sort(lines, (l1, l2) -> {
                return l1[0] != l2[0] ? l1[0] - l2[0] : l1[1] - l2[1];
            });
            //定义tot存储当前x区间下，y区间的并集，l，r为上一个y区间端点
            long tot = 0, l = -1, r = -1;
            for (int[] cur : lines) {//每次取出一对y区间
                if (cur[0] > r) {//如果和上次的区间不相交，则将上次区间计入总和，同时更新l,r
                    tot += r - l;
                    l = cur[0];
                    r = cur[1];
                } else if (cur[1] > r) {//如果和上次区间相交，则只更新r
                    r = cur[1];
                }
            }
            tot += r - l;//将最后一个区间求和
            ans += tot * len;//面积为区间长度乘以高度和
            ans %= MOD;
        }
        return (int) ans;

    }
}
