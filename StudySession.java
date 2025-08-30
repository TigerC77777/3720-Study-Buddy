
public class StudySession{
    String course;
    String status; //proposed, confirmed
    Student maker;
    Student invitee;
    TimeSlot timeSlot;

    public StudySession(String c, Student m, Student i, TimeSlot t){
        course = c;
        status = "proposed";
        maker = m;
        invitee = i;
        timeSlot = t;
    }

    public void propose(){
        status = "proposed";
    }

    public void confirm(){
        status = "confirmed";
    }

    public String getInviteeName(){
        return invitee.getName();
    }
}