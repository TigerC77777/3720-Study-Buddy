import TimeSlot;
import java.util.List;

public class Student
{
	private string name;
	private List<string> courses;
	private List<TimeSlot> availability;

	public void AddCourse(string course)
	{
		// Prevent adding a duplicate course
		if (courses.contains(course))
		{
			System.out.println(course + " is already present.");
			return;
		}
		courses.add(course);
	}
	public void AddAvailability(TimeSlot time)
	{
		// Prevent adding a duplicate TimeSlot
		/*for (int i = 0; i < availability.Length; i++)
		{
			if (time.equals(courses[i]))
			{
				System.out.println("This time slot is already present.");
				return;
			}
		}*/
		if (availability.contains(time))
		{
			System.out.println("This time slot is already present.");
			return;
		}
		availability.add(time);
	}
	public void RemoveAvailability(TimeSlot time)
	{
		// The remove method checks if the item exists for us
		availability.remove(time);
	}
}