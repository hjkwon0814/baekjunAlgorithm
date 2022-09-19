import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        int x1, y1, r1, x2, y2, r2;
        int x3=0,y3=0;
        int result=0;
        double dist_x1y1_x2y2=0;
        for (int i = 0; i<testcase; i++) {
            x1 = sc.nextInt();
            y1 = sc.nextInt();
            r1 = sc.nextInt();
            x2 = sc.nextInt();
            y2 = sc.nextInt();
            r2 = sc.nextInt();
            dist_x1y1_x2y2 =  Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2));
            if(dist_x1y1_x2y2 > r1 +r2) {
                result = 0;
            } else if (dist_x1y1_x2y2 == r1 + r2){
                result = 1;
            } else if(x1 == x2 && y1 == y2 && r1 == r2) {
                result = -1;
            } else if (dist_x1y1_x2y2 == Math.abs(r1-r2)) {
                result = 1;
            } else if(dist_x1y1_x2y2 < r1 + r2  && dist_x1y1_x2y2 > Math.abs(r1-r2)) {
                result = 2;
            } else if(dist_x1y1_x2y2 < Math.abs(r1-r2)) {
                result = 0;
            }
            System.out.println(result);
        }
    }
}
