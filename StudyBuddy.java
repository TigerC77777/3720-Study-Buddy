import java.util.ArrayList;
import java.util.Scanner;

public class StudyBuddy{
    static ArrayList<Student> students = new ArrayList<Student>();
    //ArrayList<StudySession> sessions;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Clemson Study Buddy Helper App!\n");
        while(true) {
            System.out.println("\nInput your selection:\n1.Create Profile\n2.View Profile\n3.Add Availability\n4.Remove Availability\n5.Search for Classmates\n6.Suggest Matches\n7.Schedule Session\n8.Confirm Session\n9.Exit");
            int num = Integer.parseInt(sc.nextLine());
            String firstName, lastName, fullName;
            boolean found = false;
            switch (num) {
                case 1:
                    createProfile();
                    break;
                case 2:
                    printProfile();
                    break;
                case 3:
                    System.out.println("What is the first name of the student whose availability you wish to add?");
                    firstName = sc.nextLine();
                    System.out.println("What is the last name of the student whose availability you wish to add?");
                    lastName = sc.nextLine();
                    fullName = firstName+" "+lastName;
                    found = false;
                    for(Student stud : students){
                        if(stud.getName().equals(fullName)){
                            stud.AddAvailability();
                            found = true;
                            break;
                        }
                    }
                    if(!found){
                        System.out.println("Student profile not found");
                    }
                    break;
                case 4:
                    System.out.println("What is the first name of the student whose availability you wish to remove?");
                    firstName = sc.nextLine();
                    System.out.println("What is the last name of the student whose availability you wish to remove?");
                    lastName = sc.nextLine();
                    fullName = firstName+" "+lastName;
                    found = false;
                    for(Student stud : students){
                        if(stud.getName().equals(fullName)){
                            stud.RemoveAvailability();
                            found = true;
                            break;
                        }
                    }
                    if(!found){
                        System.out.println("Student profile not found");
                    }
                    break;
                case 5:
                    String course;
                    while (true) { 
                        System.out.println("Enter the course subject code (the 2-4 letters at the start):");
                        String subj = sc.nextLine();
                        if(subj.length() < 2 || subj.length() > 4){
                            System.out.println("Invalid course code. Please try again!");
                            continue;
                        }else{
                            System.out.println("Enter the course identifier code (the 4 numbers at the end):");
                            int code = Integer.parseInt(sc.nextLine());
                            if(code > 9999 || code < 1000){
                                System.out.println("Invalid course code. Please try again!");
                                continue;
                            }else{
                                course = subj+" "+code;
                                break;
                            }
                        }
                    }
                    System.out.println("Students enrolled in "+course+":");
                    searchByCourse(course);
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
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input, please try again!");
                    break;
            }
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
                continue;
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
                stud.printProfile();
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("Student profile not found");
        }
    }

    public static void searchByCourse(String course){
        for(Student s : students){
            if(s.isEnrolled(course)){
                System.out.println(s.getName());
            }
        }
    }

    public void suggestMatches(){

    }

    public void scheduleSession(){

    }

    public void confirmSession(){

    }
}