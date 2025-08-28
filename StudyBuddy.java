public class StudyBuddy{
    ArrayList<Student> students;
    ArrayList<StudySession> sessions;

    public static void main(String[] args){
        System.out.println("Welcome to the Clemson Study Buddy Helper App!\n");
        System.out.println("Input your selection:\n1. Create Profile\n2.View Profile\n3.Add Availability\n4.Remove Availability\n5.Search for Classmates\n6.Suggest Matches\n7.Schedule Session\n8.Confirm Session\n9.Exit");
        int num = System.in.read();
        switch(num){
            case 1:
                createProfile();
                break;
            case 2:
                //print profile information
                break;
            case 3:
                //add availability
                break;
            case 4:
                //remove availability
                break;
            case 5:
                //search for classmates
                break;
            case 6:
                //suggest matches
                break;
            case 7:
                //schedule session
                break;
            case 8:
                //confirm session
                break;
            case 9:
                //exit
                break;
        }
        
    }

    public void createProfile(){

    }

    public void searchByCourse(){

    }

    public void suggestMatches(){

    }

    public void scheduleSession(){

    }

    public void confirmSession(){

    }
}