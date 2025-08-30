import java.util.ArrayList;
import java.util.Scanner;

public class StudyBuddy{
    static ArrayList<Student> students;
    //ArrayList<StudySession> sessions;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Clemson Study Buddy Helper App!\n");
        System.out.println("Input your selection:\n1.Create Profile\n2.View Profile\n3.Add Availability\n4.Remove Availability\n5.Search for Classmates\n6.Suggest Matches\n7.Schedule Session\n8.Confirm Session\n9.Exit");
        int num = Integer.parseInt(sc.nextLine());
        switch(num){
            case 1:
                createProfile();
                break;
            case 2:
                printProfile();
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
            default:
                System.out.println("Invalid input, please try again!");
                break;
        }

    }

    public static void createProfile(){
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your first name?");
        String firstName = sc.nextLine();
        System.out.println("What is your last name?");
        String lastName = sc.nextLine();
        Student newStudent = new Student(firstName+" "+lastName);
        while(true){
            System.out.println("Make your selection:\n1.Add a course\n2.Continue");
            int num = Integer.parseInt(sc.nextLine());
            if(num == 1){//add a class
                newStudent.AddCourse();
                break;
            }else if(num == 2){
                break;
            }else{
                System.out.println("Invalid input, please try again!");
                continue;
            }   
        }
        while(true){
            System.out.println("Make your selection:\n1.Add availability\n2.Continue");
            int num = Integer.parseInt(sc.nextLine());
            if(num == 1){//add availability
                newStudent.AddAvailability();
                break;
            }else if(num == 2){
                break;
            }else{
                System.out.println("Invalid input, please try again!");
                continue;
            }
        }
        System.out.println("Student profile created!");
        students.add(newStudent);
        }

    public static void printProfile(){
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the first name of the student whose profile you wish to view?");
        String firstName = sc.nextLine();
        System.out.println("What is the last name of the student whose profile you wish to view?");
        String lastName = sc.nextLine();
        String fullName = firstName+" "+lastName;
        boolean found = false;
        for(Student stud : students){
            if(stud.getName().equals(fullName)){
                //print profile
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("Student profile not found\n");
        }
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