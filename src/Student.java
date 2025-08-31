import java.util.ArrayList;
import java.util.Scanner;

public class Student
{
    private String name;
    private ArrayList<String> courses = new ArrayList<String>();
    private ArrayList<TimeSlot> availability = new ArrayList<TimeSlot>();

    public Student(String n){
        name = n;
    }

    public String getName(){
        return name;
    }

    public void AddCourse()
    {
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println("Enter the course subject code (the 2-4 letters at the start):");
            String subj = input.nextLine();
            if(subj.length() < 2 || subj.length() > 4){
                System.out.println("Invalid course code. Please try again!");
                continue;
            }else{
                System.out.println("Enter the course identifier code (the 4 numbers at the end):");
                int code = Integer.parseInt(input.nextLine());
                if(code > 9999 || code < 1000){
                    System.out.println("Invalid course code. Please try again!");
                    continue;
                }
                courses.add(subj+" "+code);
                System.out.println("Course "+subj+" "+code+" added!");
                break;
            }
        }
    }
    public void AddAvailability()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the date, as the month name followed by the day (ex: September 4): ");
        String day = input.nextLine();
        System.out.println("Enter the starting time. Use 24-hour time with nothing in between the hour and minute. (ex: 0830, 1745)");
        int start = Integer.parseInt(input.nextLine());
        System.out.println("Enter the ending time. Use 24-hour time with nothing in between the hour and minute. (ex: 0830, 1745)");
        int end = Integer.parseInt(input.nextLine());
        TimeSlot time = new TimeSlot(day, start, end);

        // Prevent adding a duplicate TimeSlot
        while (availability.contains(time))
        {
            System.out.println("This time slot is already present.");
            System.out.println("Enter the date, as the month name followed by the day (ex: September 4): ");
            time.setDay(input.nextLine());
            System.out.println("Enter the starting time. Use 24-hour time with nothing in between the hour and minute. (ex: 0830, 1745)");
            time.setStartTime(Integer.parseInt(input.nextLine()));
            System.out.println("Enter the ending time. Use 24-hour time with nothing in between the hour and minute. (ex: 0830, 1745)");
            time.setEndTime(Integer.parseInt(input.nextLine()));
        }
        availability.add(time);
    }
    public void RemoveAvailability()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the date, as the month name followed by the day (ex: September 4): ");
        String day = input.nextLine();
        System.out.println("Enter the starting time. Use 24-hour time with nothing in between the hour and minute. (ex: 0830, 1745)");
        int start = (Integer.parseInt(input.nextLine()));
        System.out.println("Enter the ending time. Use 24-hour time with nothing in between the hour and minute. (ex: 0830, 1745)");
        int end = (Integer.parseInt(input.nextLine()));
        TimeSlot time = new TimeSlot(day, start, end);
        boolean found = false;
        for(TimeSlot t : availability){
            if(t.getDay().equals(day) && t.getStartTime() == start && t.getEndTime() == end){
                found = true;
                availability.remove(t);
                System.out.println("Availability slot removed!");
                break;
            }
        }
        if(!found){
            System.out.println("Time slot not found");
        }
    }

    public void printProfile(){
        System.out.println("\nStudent Profile: "+name);
        System.out.println("Courses:");
        boolean none = true;
        for(String s : courses){
            none = false;
            System.out.println(s);
        }
        if(none){
            System.out.println("None");
        }
        System.out.println("Availability:");
        none = true;
        for(TimeSlot t : availability){
            none = false;
            System.out.println(t.toString());
        }
        if(none){
            System.out.println("None");
        }
    }

    public boolean isEnrolled(String course){
        for(String s : courses){
            if(s.equals(course)){
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> getCourses(){
        return courses;
    }

    public ArrayList<TimeSlot> getAvailability(){
        return availability;
    }
}