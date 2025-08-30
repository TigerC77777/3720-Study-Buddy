public class TimeSlot
{
	private String day;
	private int startTime;
	private int endTime;

	public TimeSlot(String d, int s, int e)
	{
		day = d;
		startTime = s;
		endTime = e;
	}

	public boolean overlaps(TimeSlot ts)
	{
		return ts.day == this.day && ts.endTime > this.startTime && ts.startTime < this.endTime;
	}

	@Override
	public boolean equals(Object obj)
	{
		TimeSlot ts = (TimeSlot)obj;
		return this.day == ts.day && this.startTime == ts.startTime && this.endTime == ts.endTime;
	}

	@Override
	public String toString()
	{
		return day + ", " + startTime + " to " + endTime;
	}

	public String getDay(){
		return day;
	}

	public void setDay(String d){
		day = d;
	}

	public void setStartTime(int s){
		startTime = s;
	}

	public void setEndTime(int e){
		endTime = e;
	}
}