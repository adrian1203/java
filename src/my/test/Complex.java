package my.test;

public class Complex {
    private double re;
    private double im;

    public Complex(double re,double im) {
        this.re = re;
        this.im = im;
    }

    public Complex add(Complex c) {
        return new Complex(re+c.re,im+c.im);
    }

    public Complex mul(Complex c) {
        double newRe = re*c.re + im*c.im;
        double newIm = re*c.im + im*c.re;
        return new Complex(newRe,newIm);
    }

    public double re(){
        return re;
    }

    public double im(){
        return im;
    }
}