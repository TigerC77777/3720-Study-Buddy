import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class StudyBuddyTest {

    @beforeeach
    void setUp(){
    }

    @org.junit.jupiter.api.Test
    void testCreateProfileAndPrintProfile(){
        Scanner fakeScanner = new Scanner("Jonah\nColestock\n1\nCPSC\n3720\n1\nCPSC\n4300\nCPSC\n2310\n2\n1\nOctober 3\n0830\n1230\n2\n");
        StudyBuddy app = new StudyBuddy();
        app.createProfile(fakeScanner);
        
    }


}