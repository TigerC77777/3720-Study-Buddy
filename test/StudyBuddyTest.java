import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudyBuddyTest {

    @beforeeach
    void setUp(){
    }

    @org.junit.jupiter.api.Test
    void testCreateProfileAndPrintProfile() {
        String name = "Jonah Colestock";
        ArrayList<String> courses = new ArrayList<String>();
        courses.add("CPSC 3720");
        courses.add("CPSC 4300");
        courses.add("CPSC 2310");
        String simulatedInput = "Jonah\nColestock\n1\nCPSC\n3720\n1\nCPSC\n4300\nCPSC\n2310\n2\n1\nOctober 3\n0830\n1230\n2\n";
        InputStream originalIn = System.in;
        InputStream originalOut = System.out;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }


}