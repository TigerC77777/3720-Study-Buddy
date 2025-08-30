import java.util.ArrayList;
import java.util.Scanner;

public class StudyBuddy{
    static ArrayList<Student> students = new ArrayList<Student>();
    static ArrayList<StudySession> sessions = new ArrayList<StudySession>();
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
                    ArrayList<Student> peers = searchByCourse(course);
                    if(peers.isEmpty()){
                        System.out.println("None");
                    }else{
                        for(Student s : peers){
                            System.out.println(s.getName());
                        }
                    }
                    break;
                case 6:
                    System.out.println("What is your first name?");
                    firstName = sc.nextLine();
                    System.out.println("What is your last name?");
                    lastName = sc.nextLine();
                    fullName = firstName+" "+lastName;
                    found = false;
                    for(Student stud : students){
                        if(stud.getName().equals(fullName)){
                            found = true;
                            suggestMatches(stud);
                            break;
                        }
                    }
                    if(!found){
                        System.out.println("Student profile not found");
                    }
                    break;
                case 7:
                    scheduleSession();
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
                continue;
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

    public static ArrayList<Student> searchByCourse(String course){
        ArrayList<Student> peers = new ArrayList<Student>();
        for(Student s : students){
            if(s.isEnrolled(course)){
                peers.add(s);
            }
        }
        return peers;
    }

    public static void suggestMatches(Student s){
        for(String c : s.getCourses()){
            ArrayList<Student> peers = searchByCourse(c);
            for(Student p : peers){
                if(!(p.getName()).equals(s.getName())){
                    ArrayList<String> sharedClasses = new ArrayList<String>();
                    for(String e : p.getCourses()){
                        if(s.isEnrolled(e)){
                            sharedClasses.add(e);
                        }
                    }
                    ArrayList<TimeSlot> sharedTimes = new ArrayList<TimeSlot>();
                    if(!sharedClasses.isEmpty()){
                        for(TimeSlot t : p.getAvailability()){
                            for(TimeSlot tt : s.getAvailability()){
                                if(tt.overlaps(t)){
                                    sharedTimes.add(t);
                                }
                            }
                        }
                    }
                    if(!sharedTimes.isEmpty()){
                        System.out.println("\nMatch found!\nStudent Name: "+p.getName()+"\nShared Classes:");
                        for(String sc : sharedClasses){
                            System.out.println(sc);
                        }
                        System.out.println("Overlapping timeslots:");
                        for(TimeSlot st : sharedTimes){
                            System.out.println(st.toString());
                        }
                        System.out.println();
                    }
                }
            }
        }
    }

    public static void scheduleSession(){
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your first name?");
        String firstName = sc.nextLine();
        System.out.println("What is your last name?");
        String lastName = sc.nextLine();
        String fullName = firstName+" "+lastName;
        boolean found = false;
        Student me = new Student(fullName);
        for(Student s : students){
            if(s.getName().equals(fullName)){
                found = true;
                me = s;
            }
        }
        if(!found){
            System.out.println("Student profile not found.");
            return;
        }else{
            while(true){
                System.out.println("What is the first name of the person you want to study with?");
                String peerFirst = sc.nextLine();
                System.out.println("What is the last name of the person you want to study with?");
                String peerLast = sc.nextLine();
                String peerFull = peerFirst+" "+peerLast;
                found = false;
                for(Student s : students){
                    if(s.getName().equals(peerFull)){
                        found = true;
                        makeSession(me, s);
                        break;
                    }
                }
                if(!found){
                    System.out.println("No student profile found. Please try again!");
                    continue;
                }else{
                    break;
                }
            }
        }
    }

    public static void makeSession(Student maker, Student invitee){
        Scanner input = new Scanner(System.in);
        String course;
        while(true){
            System.out.println("Enter the course subject code (the 2-4 letters at the start):");
            String subj = input.nextLine();
            if(subj.length() < 2 || subj.length() > 4){
                System.out.println("Invalid course code. Please try again!");
                continue;
            }else{
                System.out.println("Enter the course identifier code (the 4 numbers at the end):");
                int code = Integer.parseInt(input.nextLine());
                if(code > 9999 || code < 1000){
                    System.out.println("Invalid course code. Please try again!");
                    continue;
                }
                course = subj+" "+code;
				break;
            }
        }
        System.out.println("Select a time slot for your study session");
        System.out.println("Enter the date, as the month name followed by the day (ex: September 4): ");
        String day = input.nextLine();
        System.out.println("Enter the starting time. Use 24-hour time with nothing in between the hour and minute. (ex: 0830, 1745)");
        int start = (Integer.parseInt(input.nextLine()));
        System.out.println("Enter the ending time. Use 24-hour time with nothing in between the hour and minute. (ex: 0830, 1745)");
        int end = (Integer.parseInt(input.nextLine()));
        TimeSlot time = new TimeSlot(day, start, end);
        StudySession thisSession = new StudySession(course, maker, invitee, time);
        sessions.add(thisSession);
        System.out.println("Session proposed!");
    }

    public void confirmSession(){

    }
}