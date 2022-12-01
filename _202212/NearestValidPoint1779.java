package _202212;

public class NearestValidPoint1779 {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int ans = Integer.MAX_VALUE;
        int minIndex =-1;
        for(int i = 0; i < points.length; i++) {
            if(points[i][0]==x){
                if(Math.abs(points[i][1]-y)<ans){
                    ans = Math.abs(points[i][1]-y);
                    minIndex = i;
                }
            }else if(points[i][1]==y){
                if(Math.abs(points[i][0]-x)<ans){
                    ans = Math.abs(points[i][0]-x);
                    minIndex = i;
                }
            }
        }
        return minIndex;
    }
}
