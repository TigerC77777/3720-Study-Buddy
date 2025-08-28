public class TimeSlot
{
	private string day;
	private int startTime;
	private int endTime;

	public boolean overlaps(TimeSlot ts)
	{
		return ts.endTime > this.startTime && ts.startTime < this.endTime;
	}

	@Override
	public boolean equals (Object obj)
	{
		TimeSlot ts = (TimeSlot)obj;
		return this.day == ts.day && this.startTime == ts.startTime && this.endTime == ts.endTime;
	}
}