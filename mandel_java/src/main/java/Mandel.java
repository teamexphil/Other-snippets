import org.apache.commons.math3.complex.Complex;

/**
 * Created with IntelliJ IDEA.
 * User: PHIMCD
 * Date: 23/03/15
 * Time: 14:39
 * To change this template use File | Settings | File Templates.
 */
public class Mandel {

    public int getIterations(int asize, double acorner, double bcorner, double side, int depth, int i, int j){

        double step = side/asize;
        Complex c = new Complex(acorner+i*step, bcorner+j*step);
        Complex z = new Complex(0,0);

        int count = 0;

        while( (count<depth) && (z.abs()<2)) {
            z = (z.multiply(z)).add(c);
            count ++;
        }
        //System.out.println("i: " + i + " j: " + j + " iter count: " + count);
        return count;
    }

    /* mandel(400, -2, -1.25, 2.5) */
    public int[] mandel(int asize, double acorner, double bcorner, double side){

        //Map<Integer, Integer> iterMap = new HashMap<Integer, Integer>();

        int depth = 1000;
        int iter = 0;
        int max_iter =0;

        // create array of size asize*asize containing iterations for mandelbrot set
        // start at acorner, bcorner and move towards side in steps of side/asize

        // return array for colouring - number of iterations will determine colour

        int i,j,counter;
        counter = 0;

        int[] pic = new int [asize*asize];

        for (i=0 ; i<asize ; i++){

            for (j=0 ; j<asize ; j++){
                iter = getIterations(asize,acorner,bcorner,side,depth,i,j);
                //System.out.println(iter);
                pic[counter] = iter;
                counter++;
            }
        }

        /*
        for (Map.Entry<Integer, Integer> entry : iterMap.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        } */

        return pic;
    }

    public static void main(String[] args) {

        int[] pic;
        Mandel mandel = new Mandel();
        pic = mandel.mandel(400, -2, -1.25, 2.5);
        System.out.println("end");
    }
}


