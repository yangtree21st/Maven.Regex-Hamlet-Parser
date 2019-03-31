import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        //Given
        String expect = "Hi,Leon";
        String example = "Hi,Hamlet";
        //When

        String actual = hamletParser.replaceHamlet(example);
        //Then
        Assert.assertEquals(expect,actual);
    }




    @Test
    public void testChangeHoratioToTariq() {
        //Given
        String expect = "Hi,Tariq,Tariq";
        String example = "Hi,Horatio,HORATIO";
        //When
        String actual = hamletParser.replaceHoratio(example);
        //Then
        Assert.assertEquals(expect,actual);
    }

    @Test
    public void testFindHoratio() {
        //Given
        String example = "Horatio,Horatio,Horatio,see you later, Horatio ";
        int expect = 4;
        //When
        int actual = hamletParser.findHoratio(example);
        //Then
        Assert.assertEquals(expect,actual);
    }

    @Test
    public void testFindHamlet() {
        //Given
        String example = "Hamlet,you need to make a choice, or, Hamlet, you will be a leading role of a tragedy";
        int expect = 2;
        //When
        int actual = hamletParser.findHamlet(example);
        //Then
        Assert.assertEquals(expect,actual);
    }
    @Test
    public void testReplaceAllSample() {
        //Given
        String expected = "Hi Leon, Hi Tariq";
        String input = "Hi Hamlet, Hi Horatio";

        //When
        String actual = hamletParser.replaceAll(input);

        //Then
        Assert.assertEquals(expected, actual);
    }
}