import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class prince {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for(int i=0; i< testCase; i++) {
            List<planet> planets = new ArrayList<>();
            coor start = new coor();
            coor end = new coor();
            start.setX(sc.nextInt());
            start.setY(sc.nextInt());
            end.setX(sc.nextInt());
            end.setY(sc.nextInt());
            int planetTotal = sc.nextInt();
            int count=0;
            System.out.println("1번");
            for(int j=0; j<planetTotal; j++) {
                int startX = start.getX();
                int startY = start.getY();
                int endX = end.getX();
                int endY = end.getY();

                planet p = new planet();
                p.setX(sc.nextInt());
                p.setY(sc.nextInt());
                p.setR(sc.nextInt());

                int planetX = p.getX();
                int planetY = p.getY();
                int planetR = p.getR();

                if(Math.pow(startX - planetX,2) + Math.pow(startY - planetY,2) < Math.pow(planetR, 2)) {
                    p.setStart(true);
                }
                if(Math.pow(endX - planetX,2) + Math.pow(endY - planetY,2) < Math.pow(planetR, 2)) {
                    p.setEnd(true);
                }

                planets.add(p);
                System.out.println("2번");
            }

            for(int k=0; k<planets.size(); k++) {
                if(planets.get(k).getStart() != planets.get(k).getEnd()) {
                    count++;
                    System.out.println("3번");
                }
            }

            System.out.println(count);

        }

    }
}

class coor {
    private int x;
    private int y;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y)  {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

class planet {
    private int x;
    private int y;
    private int r;

    private boolean start = false;

    private boolean end = false;

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setR(int r) {
        this.r = r;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getR() {
        return r;
    }

    public boolean getStart() {
        return start;
    }

    public boolean getEnd() {
        return end;
    }

}
