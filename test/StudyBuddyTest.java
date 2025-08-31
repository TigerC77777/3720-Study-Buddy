import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class StudyBuddyTest {

    @Test
    void testCreateProfileAndPrintProfile(){
        Scanner fakeScanner = new Scanner("Jonah\nColestock\n1\nCPSC\n3720\n1\nCPSC\n4300\n1\nCPSC\n2310\n2\n1\nOctober 3\n0830\n1230\n2\n");
        StudyBuddy.createProfile(fakeScanner);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        Scanner fakeScanner2 = new Scanner("Jonah\nColestock\n");
        StudyBuddy.printProfile(fakeScanner2);
        System.setOut(originalOut);
        assertFalse(StudyBuddy.students.isEmpty());
        String output = outContent.toString();
        System.out.println("Reached here\n");
        assertTrue(output.contains("Jonah Colestock"));
        assertTrue(output.contains("CPSC 3720"));
        assertTrue(output.contains("October 3, 830 to 1230"));
    }

    @Test
    void testSearchByCourse(){
        Scanner fakeScanner = new Scanner("Jonah\nColestock\n1\nCPSC\n3720\n1\nCPSC\n4300\n1\nCPSC\n2310\n2\n1\nOctober 3\n0830\n1230\n2\n");
        StudyBuddy.createProfile(fakeScanner);
        Scanner fakeScanner2 = new Scanner("Jack\nHilliard\n1\nCPSC\n4300\n1\nCPSC\n2310\n2\n1\nOctober 3\n0830\n1230\n2\n");
        StudyBuddy.createProfile(fakeScanner2);
        ArrayList<Student> us = StudyBuddy.searchByCourse("CPSC 2310");
        assertFalse(us.isEmpty());
        for(Student s : us){
            assertTrue(s.getName().equals("Jonah Colestock") || s.getName().equals("Jack Hilliard"));
        }
    }


}