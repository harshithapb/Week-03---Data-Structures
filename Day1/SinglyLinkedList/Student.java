package SinglyLinkedList;

import java.util.Scanner;

public class Student {
    int rollnumber;
    String Name;
    int Age;
    String grade;
    Student next;

    public Student(int rollnumber,String Name,int Age, String grade){
        this.rollnumber = rollnumber;
        this.Name = Name;
        this.Age = Age;
        this.grade = grade;
        this.next = null;
    }
}
class StudentLinkedList{
    private Student head = null;

    public void addAtBeginning(Student newStudent){
        newStudent.next = head;
        head = newStudent;
    }
    public void addAtEnd(Student newStudent){
        if(head == null){
            head = newStudent;
            return;
        }
        Student temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = newStudent;
    }
    public void addAtPosition(Student newStudent, int position){
        if(position <= 1){
            addAtBeginning(newStudent);
            return;
        }
        Student temp = head;
        for(int i=1;i<position-1 &&  temp!= null;i++){
            temp = temp.next;
        }
        if(temp == null){
            addAtEnd(newStudent);
        }else{
            newStudent.next = temp.next;
            temp.next = newStudent;
        }
    }
    public void deleteByRollNumber(int rollnumber){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        if(head.rollnumber == rollnumber){
            head = head.next;
            System.out.println("Student deleted.");
            return;
        }
        Student current = head;
        while (current.next != null && current.next.rollnumber != rollnumber){
            current = current.next;
        }
        if(current.next == null){
            System.out.println("Student not found");
        }else {
            current.next = current.next.next;
            System.out.println("Student deleted");
        }
    }
    public void searchByRollnumber(int rollNumber){
        Student current = head;
        while (current != null){
            if(current.rollnumber == rollNumber){
                System.out.println("Student found");
                displayStudent(current);
                return;
            }
            current = current.next;
        }
        System.out.println("Student not found");
    }
    public void updateGrade(int rollnumber,String newgrade){
        Student current = head;
        while(current != null){
            if(current.rollnumber == rollnumber){
                current.grade = newgrade;
                System.out.println("Grade updated");
                return;
            }
            current = current.next;
        }
        System.out.println("Student not found");
    }
    public void displayAll(){
        if(head == null){
            System.out.println("No Student records");
            return;
        }
        Student current = head;
        while(current != null){
            displayStudent(current);
            current = current.next;
        }
    }
    private void displayStudent(Student s){
        System.out.println("Roll Number : "+ s.rollnumber);
        System.out.println("Name :"+s.Name);
        System.out.println("Age : "+s.Age);
        System.out.println("Grade: "+s.grade);
    }
}
class StudentRecordMangement{
    public static void msin(String[]args){
        Scanner scan = new Scanner(System.in);
        StudentLinkedList list = new StudentLinkedList();
        while (true){
            System.out.println("\n--- Student Record Management ---");
            System.out.println("1. Add Student at Beginning");
            System.out.println("2. Add Student at End");
            System.out.println("3. Add Student at Specific Position");
            System.out.println("4. Delete Student by Roll Number");
            System.out.println("5. Search Student by Roll Number");
            System.out.println("6. Update Grade by Roll Number");
            System.out.println("7. Display All Students");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scan.nextInt();
            int rollNumber, age, position;
            String name, grade;

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    System.out.print("Enter Roll Number: ");
                    rollNumber = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Enter Name: ");
                    name = scan.nextLine();
                    System.out.print("Enter Age: ");
                    age = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Enter Grade: ");
                    grade = scan.nextLine();
                    Student student = new Student(rollNumber, name, age, grade);
                    if (choice == 1)
                        list.addAtBeginning(student);
                    else if (choice == 2)
                        list.addAtEnd(student);
                    else {
                        System.out.print("Enter Position: ");
                        position = scan.nextInt();
                        list.addAtPosition(student, position);
                    }
                    break;
                case 4:
                    System.out.print("Enter Roll Number to Delete: ");
                    rollNumber = scan.nextInt();
                    list.deleteByRollNumber(rollNumber);
                    break;

                case 5:
                    System.out.print("Enter Roll Number to Search: ");
                    rollNumber = scan.nextInt();
                    list.searchByRollnumber(rollNumber);
                    break;

                case 6:
                    System.out.print("Enter Roll Number to Update: ");
                    rollNumber = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Enter New Grade: ");
                    grade = scan.nextLine();
                    list.updateGrade(rollNumber, grade);
                    break;

                case 7:
                    list.displayAll();
                    break;

                case 8:
                    System.out.println("Exiting...");
                    scan.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

