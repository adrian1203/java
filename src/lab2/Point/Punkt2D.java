package lab2.Point;
import java.lang.Math.*;

public class Punkt2D {
    private double x,y;
    Punkt2D(double x, double y){
        this.x=x;
        this.y=y;
    }
    public void SetX(int x){
        this.x=x;
    }
    public void SetY(int y){
        this.y=y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    public double distance(Punkt2D point){
        double d;
        return Math.sqrt(Math.pow(this.x-point.x,2)+Math.pow(this.y-point.y,2));
    }
}
