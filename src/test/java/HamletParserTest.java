import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class HamletParserTest {
    private static final Logger LOGGER = Logger.getLogger(HamletParserTest.class.getName());
    private String hamletText;
    private HamletParser hamletParser;
    private String leonRegex = "[^e][Ll][Ee][Oo][Nn]'?s?";
    private String tariqRegex = "[Tt][Aa][Rr][Ii][Qq]'?s?";

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        hamletParser.changeHamletToLeon();
        Pattern pattern = Pattern.compile(leonRegex);
        Matcher matcher = pattern.matcher(hamletParser.getHamletData());

        int expected = 472;

        int actual = 0;
        while (matcher.find()) {
            actual++;
        }

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testChangeHoratioToTariq() {
        hamletParser.changeHoratioToTariq();
        Pattern pattern = Pattern.compile(tariqRegex);
        Matcher matcher = pattern.matcher(hamletParser.getHamletData());

        int expected = 158;

        int actual = 0;
        while (matcher.find()) {
            actual++;
        }

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindHoratio() {
        int actual = hamletParser.getNumberOfHoratio();
        int expected = 158;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindHamlet() {
        int actual = hamletParser.getNumberOfHamlets();
        int expected = 472;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testChangeBothNames() {
        hamletParser.changeBothNames();
        hamletParser.printData();
    }

    @Test
    public void printTest() {
        hamletParser.printData();
    }
}