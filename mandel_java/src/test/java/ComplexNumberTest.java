import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: PHIMCD
 * Date: 26/03/15
 * Time: 12:03
 * To change this template use File | Settings | File Templates.
 */
public class ComplexNumberTest {
    @Test
    public void addComplexTest() throws Exception {
        ComplexNumber complexNumberA = new ComplexNumber(2,3);
        ComplexNumber complexNumberB = new ComplexNumber(4.5,1.72);
        ComplexNumber total = new ComplexNumber(6.5,4.72);

        Assert.assertTrue("Confirm adding complex numbers 2+3i + 4.5+1.72i = 6.5 + 4.72i", complexNumberA.add(complexNumberB).equals(total));
        Assert.assertFalse("Confirm adding complex numbers 2+3i + 2+3i = 6.5 + 4.72i", complexNumberA.add(complexNumberA).equals(total));
    }

    @Test
    public void multiplyComplexTest() throws Exception {
        ComplexNumber complexNumberA = new ComplexNumber(2,3);
        ComplexNumber complexNumberB = new ComplexNumber(1.5,2);
        ComplexNumber product = new ComplexNumber(-3,8.5);
        
        Assert.assertTrue("Confirm multiplying complex numbers 2+3i * 1.5+2i = -3 + 8.5i", complexNumberA.multiply(complexNumberB).equals(product));
    }

    @Test
    public void absComplexTest() throws Exception {
        ComplexNumber complexNumberA = new ComplexNumber(4,3);

        Assert.assertTrue("Confirm abs value  4^2 +3i^2 = abs^2", complexNumberA.abs() == 5);
    }
}
