package Expeditors;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class JUnitTests {

    // Tests Main.format method to ensure proper output
    @Test
    public void test_format() {
        // Each line from input file
        String one = "\"Dave\",\"Smith\",\"123 main st.\",\"seattle\",\"wa\",\"43\"";
        String two = "\"Alice\",\"Smith\",\"123 Expeditors.Main St.\",\"Seattle\",\"WA\",\"45\"";
        String three = "\"Bob\",\"Williams\",\"234 2nd Ave.\",\"Tacoma\",\"WA\",\"26\"";
        String four = "\"Carol\",\"Johnson\",\"234 2nd Ave\",\"Seattle\",\"WA\",\"67\"";
        String five = "\"Eve\",\"Smith\",\"234 2nd Ave.\",\"Tacoma\",\"WA\",\"25\"";
        String six = "\"Frank\",\"Jones\",\"234 2nd Ave.\",\"Tacoma\",\"FL\",\"23\"";
        String seven = "\"George\",\"Brown\",\"345 3rd Blvd., Apt. 200\",\"Seattle\",\"WA\",\"18\"";
        String eight = "\"Helen\",\"Brown\",\"345 3rd Blvd. Apt. 200\",\"Seattle\",\"WA\",\"18\"";
        String nine = "\"Ian\",\"Smith\",\"123 main st \",\"Seattle\",\"Wa\",\"18\"";
        String ten = "\"Jane\",\"Smith\",\"123 Expeditors.Main St.\",\"Seattle\",\"WA\",\"13\"";

        // Expected output after calling Main.format on each line:
        // contains zero periods and commas, no double quotes.
        String oneAns = "\"Dave\"Smith\"123 main st\"seattle\"wa\"43\"";
        String twoAns = "\"Alice\"Smith\"123 ExpeditorsMain St\"Seattle\"WA\"45\"";
        String threeAns = "\"Bob\"Williams\"234 2nd Ave\"Tacoma\"WA\"26\"";
        String fourAns = "\"Carol\"Johnson\"234 2nd Ave\"Seattle\"WA\"67\"";
        String fiveAns = "\"Eve\"Smith\"234 2nd Ave\"Tacoma\"WA\"25\"";
        String sixAns = "\"Frank\"Jones\"234 2nd Ave\"Tacoma\"FL\"23\"";
        String sevenAns = "\"George\"Brown\"345 3rd Blvd Apt 200\"Seattle\"WA\"18\"";
        String eightAns = "\"Helen\"Brown\"345 3rd Blvd Apt 200\"Seattle\"WA\"18\"";
        String nineAns = "\"Ian\"Smith\"123 main st \"Seattle\"Wa\"18\"";
        String tenAns = "\"Jane\"Smith\"123 ExpeditorsMain St\"Seattle\"WA\"13\"";

        assertEquals(oneAns, Main.format(one));
        assertEquals(twoAns, Main.format(two));
        assertEquals(threeAns, Main.format(three));
        assertEquals(fourAns, Main.format(four));
        assertEquals(fiveAns, Main.format(five));
        assertEquals(sixAns, Main.format(six));
        assertEquals(sevenAns, Main.format(seven));
        assertEquals(eightAns, Main.format(eight));
        assertEquals(nineAns, Main.format(nine));
        assertEquals(tenAns, Main.format(ten));

    }
}
