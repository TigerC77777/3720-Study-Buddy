import java.util.Scanner;

public class StudyBuddy{
    //ArrayList<Student> students;
    //ArrayList<StudySession> sessions;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Clemson Study Buddy Helper App!\n");
        System.out.println("Input your selection:\n1. Create Profile\n2.View Profile\n3.Add Availability\n4.Remove Availability\n5.Search for Classmates\n6.Suggest Matches\n7.Schedule Session\n8.Confirm Session\n9.Exit");
        int num = Integer.parseInt(sc.nextLine());
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

    public static void createProfile(){
        System.out.println("What is your name?");
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