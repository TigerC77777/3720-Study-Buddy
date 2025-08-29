public class StudySession{
        String course;
        String status; //proposed, confirmed
    public static void main(String[] args){
        //ArrayList<Student> participants;
        //TimeSlot timeSlot;
    }

    public void propose(){
        status = "proposed";
    }

    public void confirm(){
        status = "confirmed";
    }
}