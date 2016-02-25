/**
 * Created with IntelliJ IDEA.
 * User: PHIMCD
 * Date: 26/03/15
 * Time: 11:22
 * To change this template use File | Settings | File Templates.
 */
public class ComplexNumber {

    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }

    public String toString(){
        return String.valueOf(this.real)+" + "+String.valueOf(this.imaginary)+"i";
    }

    public ComplexNumber add(ComplexNumber complexNumber){
        return new ComplexNumber(this.real+complexNumber.real,this.imaginary+complexNumber.imaginary);
    }

    public ComplexNumber multiply(ComplexNumber complexNumber){
        double realTotal;
        double imaginaryTotal;

        realTotal = (this.real * complexNumber.real) + (-1 * this.imaginary * complexNumber.imaginary);
        imaginaryTotal = (this.real * complexNumber.imaginary) + (this.imaginary * complexNumber.real);
        return new ComplexNumber(realTotal,imaginaryTotal);
    }

    public boolean equals(ComplexNumber complexNumber){
        if(this.real == complexNumber.real && this.imaginary == complexNumber.imaginary){
            return true;
        }
        else{
            return false;
        }
    }

    public double abs(){
        return Math.sqrt(Math.pow(this.real,2) + Math.pow(this.imaginary,2));
    }

    public double getReal(){
        return this.real;
    }

    public double getImaginary(){
        return this.imaginary;
    }
}
