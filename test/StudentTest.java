import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void addCourseTest() {
        Scanner fakeScanner = new Scanner("CPSC\n4300\n");
        Student me = new Student("Jonah");
        me.AddCourse(fakeScanner);
        assertFalse(me.getCourses().isEmpty());
        String myClass = me.getCourses().get(0);
        assertEquals("CPSC 4300", myClass);
    }

    @Test
    void addAvailabilityTest(){
        Scanner fakeScanner = new Scanner("October 3\n1230\n1630\n");
        Student me = new Student("Jonah");
        me.AddAvailability(fakeScanner);
        assertFalse(me.getAvailability().isEmpty());
        TimeSlot time = new TimeSlot("October 3", 1230, 1630);
        assertTrue(me.getAvailability().get(0).equals(time));
    }

    @Test
    void removeAvailabilityTest(){
        Scanner fakeScanner = new Scanner("October 3\n1230\n1630\n");
        Student me = new Student("Jonah");
        me.AddAvailability(fakeScanner);
        Scanner fakeScanner2 = new Scanner("October 3\n1230\n1630\n");
        me.RemoveAvailability(fakeScanner2);
        assertTrue(me.getAvailability().isEmpty());
    }
}