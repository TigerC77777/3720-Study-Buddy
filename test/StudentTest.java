import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void addCourseTest() {
        Scanner fakeScanner = new Scanner("CPSC\n4300\n");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        Student me = new Student("Jonah");
        me.AddCourse(fakeScanner);
        System.setOut(originalOut);
        assertFalse(me.getCourses().isEmpty());
        String myClass = me.getCourses().get(0);
        assertEquals("CPSC 4300", myClass);
    }
}