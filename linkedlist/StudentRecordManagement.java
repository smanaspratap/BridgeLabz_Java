/*Problem Statement: Create a program to manage student records using a singly linked list. Each node will store information 
about a student, including their Roll Number, Name, Age, and Grade. Implement the following operations:
Add a new student record at the beginning, end, or at a specific position.
Delete a student record by Roll Number.
Search for a student record by Roll Number.
Display all student records.
Update a student's grade based on their Roll Number.
Hint:
Use a singly linked list where each node contains student information and a pointer to the next node.
The head of the list will represent the first student, and the last node’s next pointer will be null.
Update the next pointers when inserting or deleting nodes. */

public class StudentRecordManagement{
    //Here we have defined the head, tail and size. 
    private Node head;
    private Node tail;
    private int size;
    //constructor for this class that acknowledges the size doesn't declare it.
    StudentRecordManagement(){
        this.size=0;
        this.head = null;
        this.tail = null;
    }

    private class Node{
        int Roll_Number;
        String Name;
        int Age;
        char Grade;
        Node next;//This is a pointer to iterate go to the the next nodes.

        Node(int Roll_Number, String Name, int Age, char Grade){
            this.Roll_Number = Roll_Number;
            this.Name = Name;
            this .Age = Age;
            this.Grade = Grade;
            this.next = null;
        }

    }
    // this is what we do to Insert the Node at the begining or head....
    public void InsertFirst(int Roll_Number, String Name, int Age, char Grade){
        Node node = new Node(Roll_Number, Name, Age, Grade);
        if(head == null){
            head = node;
            tail = node;
        }else{
            node.next = head;
            head = node;
        }
        size++;
    }
    //Insert at the bottom 
    public void InsertLast(int Roll_Number, String Name, int Age, char Grade){
        Node node = new Node(Roll_Number, Name, Age, Grade);
        if(head == null){
            head = node;
            tail = node;

        }else{
            tail.next = node;
            //node.next = null is done by default just for better understanding I have done this...
            node.next = null;
            tail = node;

        }
        size++;
    }
    //Insert at a random position...
    public void Insert(int Roll_Number, String Name, int Age, char Grade, int idx){
        if(idx == 0){
            InsertFirst(Roll_Number, Name, Age, Grade);
            return;

        } else if(idx == size){
            InsertLast(Roll_Number, Name, Age, Grade);
            return;

        }
        //First we need to traverse the LL to the desired index for that we take temp variable.
        Node temp = head;
        for(int i = 1; i<idx; i++){
            temp = temp.next;
        }
        Node node = new Node(Roll_Number, Name, Age, Grade);
        node.next = temp.next;
        temp.next = node;
        size++;
    }


    //DELETE THE NODE BY USING THE ROLL NUMBER.
    public void deletebyroll(int Roll_Number){
        if(head == null){
            System.out.println("The List is Empty!! ");
        }
        //The roll number to be deleted is found at the head only.
        if(head.Roll_Number == Roll_Number){
            head = head.next;
            size--;
            if(head == null){
                tail = null;

            }
            System.out.println("Student Deleted");
            return;
        }

        Node temp = head;
        while(temp.next!=null && temp.next.Roll_Number != Roll_Number){
            temp = temp.next;
        }
        //After loop 2 cases 
        if(temp.next == null){
            System.out.println("Student not found");
        }else{
            if (temp.next == tail){
                tail = temp;
            }
            temp.next = temp.next.next;
            size--;
            System.out.println("Student Deleted");
        }
    }

    //Search by ROll_Number
    public void search(int Roll_Number){
        Node temp = head;
        while(temp!= null){
            if(temp.Roll_Number == Roll_Number){
                System.out.print("Found: "+temp.Roll_Number+ " "+ temp.Name+ " "+ temp.Age+ " "+ temp.Grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Not Found!!");
    }

    //UPDATE THE GRADE BY ROLL NUMBER!!
    public void UpdateGrade(int ROll_Number, char newGrade){
        Node temp = head;
        while(temp != head){
            if(temp.Roll_Number == ROll_Number){
                temp.Grade = newGrade;
                System.out.println("Grade Updated");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student Not Found!!!");
    }

    //Display all the Students...
    public void Display(){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.Roll_Number +" "+ temp.Name+" "+temp.Age+" "+temp.Grade+ "->");
            temp = temp.next;
        }
        System.out.println("Total Students = " +size );
    }


}
class Student{
    public static void main(String[] args) {
        StudentRecordManagement SRM = new StudentRecordManagement();

        SRM.InsertFirst(97, "Manas Pratap Singh", 22, 'O');
        SRM.InsertFirst(87, "SAMEER", 22, 'O');
        SRM.InsertLast(555, "Kartik",22, 'F');
        SRM.Display();
    }
}