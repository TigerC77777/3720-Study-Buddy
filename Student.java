import TimeSlot;
import java.util.Scanner;
import java.util.ArrayList;

public class Student
{
	private String name;
	private ArrayList<String> courses;
	private ArrayList<TimeSlot> availability;

    public String getName(){
        return name;
    }

	public void AddCourse()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the course name: ");
		String course = input.nextLine();

		// Prevent adding a duplicate course
		while (courses.contains(course))
		{
			System.out.println(course + " is already present.");
			System.out.println("Enter the course name: ");
			course = input.nextLine();
		}
		courses.add(course);
	}
	public void AddAvailability()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the date, as the month name followed by the day: ");
		string day = input.nextLine();
		System.out.println("Enter the starting time. Use 24-hour time with nothing in between the hour and minute. ");
		int start = input.nextLine();
		System.out.println("Enter the ending time. Use 24-hour time with nothing in between the hour and minute. ");
		int end = input.nextLine();
		TimeSlot time = new TimeSlot(day, start, end);

		// Prevent adding a duplicate TimeSlot
		while (availability.contains(time))
		{
			System.out.println("This time slot is already present.");
			System.out.println("Enter the date, as the month name followed by the day: ");
			time.day = input.nextLine();
			System.out.println("Enter the starting time. Use 24-hour time with nothing in between the hour and minute. ");
			time.startTime = input.nextLine();
			System.out.println("Enter the ending time. Use 24-hour time with nothing in between the hour and minute. ");
			time.endTime = input.nextLine();
		}
		availability.add(time);
	}
	public void RemoveAvailability()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the date, as the month name followed by the day: ");
		String day = input.nextLine();
		System.out.println("Enter the starting time. Use 24-hour time with nothing in between the hour and minute. ");
		int start = input.nextLine();
		System.out.println("Enter the ending time. Use 24-hour time with nothing in between the hour and minute. ");
		int end = input.nextLine();
		TimeSlot time = new TimeSlot(day, start, end);

		// The remove method checks if the item exists for us
		if (!availability.remove(time))
			System.out.println("Inputted time slot does not exist.");
	}
}