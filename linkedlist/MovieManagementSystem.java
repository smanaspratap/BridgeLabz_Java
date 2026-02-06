/*2. Doubly Linked List: Movie Management System
Problem Statement: Implement a movie management system using a doubly linked list. Each node will represent a movie and contain
Movie Title, Director, Year of Release, and Rating. Implement the following functionalities:
Add a movie record at the beginning, end, or at a specific position.
Remove a movie record by Movie Title.
Search for a movie record by Director or Rating.
Display all movie records in both forward and reverse order.
Update a movie's Rating based on the Movie Title.
Hint:
Use a doubly linked list where each node has two pointers: one pointing to the next node and the other to the previous node.
Maintain pointers to both the head and tail for easier insertion and deletion at both ends.
For reverse display, start from the tail and traverse backward using the prev pointers.
 */

import java.util.LinkedList;

public class MovieManagementSystem {
    private Node head;
    private Node tail;
    private int size;
    //constructor for the Movie Management
    MovieManagementSystem(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
 //Defining a Node for doubly LL
    private class Node{
        String title;
        String director;
        int year;
        double rating;
        Node next;
        Node prev;
        Node(String title, String director, int year, double rating){
            this.title = title;
            this.director = director;
            this.year = year;
            this.rating = rating;
            this.next=null;
            this.prev = null;
        }
    }
    //Adding a node at the beginning of the List
    public void addmoviefirst(String title, String director, int year, double rating){
        Node node = new Node(title, director, year, rating);
        if(head == null){
            head = tail = node;
        }else{
            node.next=head;
            head.prev = node;
            head =node;
        }
        size++;
    }
    //Adding a node at the end of the list
    public void addmovielast(String title, String director, int year, double rating){
        Node node = new Node(title, director, year, rating);
        if(head == null){
            head = tail = node;
            return;
        }else{
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }
    //Add movie at a specific index (Learn this well I need to work on this)
    public void insertmovie(int idx, String title, String director, int year, double rating){
        if(idx == 1){
            addmoviefirst(title, director, year, rating);
            return;
        }else if(idx == size){
            addmovielast(title, director, year, rating);
            return;    
        }
        //Now we take a temprory variable and Iterate through the LL to reach the position where we actually have to insert
        // the node
        Node temp = head;
        for (int i = 1; i < idx - 1; i++) {
            temp = temp.next;
        }
        Node node = new Node(title, director, year, rating);
        node.next = temp.next;
        node.prev = temp;
        temp.next.prev = node;
        temp.next = node;
        size++;      

    }
    //Remove the movie by a title
    public void RemovebyTitle(String title){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        //If Head is equal to the title of the movie
        if(head.title.equals(title)){
            head = head.next;
            if(head != null){
                head.prev = null;
            }else{
                tail = null;
            }
            size--;
            System.out.println("Movie Removed");
            return;
        }
        //If we want to delete a movie in the middle 
        Node temp = head;
        //For node traversal using a temp variable
        while(temp!=null && !temp.title.equals(title)){
            temp = temp.next;
        }

        if(temp==null){
            System.out.println("Movie not Found");
            return;
        }
        if(temp == tail){
            tail= tail.prev;
            tail.next = null;
            
        }else{
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;

        }
        size--;
        System.out.println("Movie Deleted!!");
    }

    //Search by the director of the movie
    public void searchbydirector(String director){
        Node temp = head;
        boolean found = false;
        while(temp != null){
            if(temp.director.equals(director)){
                System.out.print(temp.title + " "+ temp.director+" "+ temp.year+" "+ temp.rating);
                found = true;
                break;
            }
            
            temp = temp.next;
            
        }
        if(!found){
            System.out.println("Not found");
        }
    }
    //Search by Rating
    public void searchbyrating(double rating){
        Node temp = head;
        boolean found = false;
        while(temp != null){
            if(temp.rating >= rating){
                System.out.println(temp.title + " "+ temp.director+" "+ temp.year+" "+ temp.rating);
                found = true;
                
            }
            temp = temp.next;
            
        }
        if(!found){
            System.out.println("Not Found!!");
        }
    }
    //Update rating by the movie title
    public void UpdateRating(String title, double newrating){
        Node temp = head;
        while(temp != null){
            if(temp.title.equals(title)){
                temp.rating = newrating;
                System.out.println("Rating updated");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie Not Found");
    }
    //To Display the movies the forward fashion...
    public void displayforward(){
        if(head == null){
            System.out.println("No Movies Available");
            return;
        }
        Node temp = head;
        while (temp!= null){
            System.out.print(temp.title + " "+ temp.director+" "+ temp.year+" "+ temp.rating + "->");
            temp = temp.next;
        }
        System.out.println("END");
    }
    //To Display backwards
    public void displaybackwards(){
        if(tail == null){
            System.out.println("No Movies Available");
            return;
        }
        Node temp = tail;
        while (temp!= null){
            System.out.print(temp.title + " "+ temp.director+" "+ temp.year+" "+ temp.rating + "->");
            temp = temp.prev;
        }
        System.out.println("END");
    }

 
}
class Movie {
    public static void main(String[] args) {

        MovieManagementSystem mms = new MovieManagementSystem();

        // 1️⃣ Add movies at beginning
        mms.addmoviefirst("Top Gun", "Tony Scott", 1986, 8.6);
        mms.addmoviefirst("Mission Impossible", "Brian De Palma", 1996, 8.0);

        // 2️⃣ Add movies at end
        mms.addmovielast("Top Gun Maverick", "Joseph Kosinski", 2022, 8.8);
        mms.addmovielast("Edge of Tomorrow", "Doug Liman", 2014, 7.9);

        // 3️⃣ Display forward
        System.out.println("\nDisplay Forward:");
        mms.displayforward();

        // 4️⃣ Display backward
        System.out.println("\nDisplay Backward:");
        mms.displaybackwards();

        // 5️⃣ Insert movie at specific index
        System.out.println("\nInsert movie at position:");
        mms.insertmovie(2, "Jerry Maguire", "Cameron Crowe", 1996, 7.3);
        mms.displayforward();

        // 6️⃣ Search by director
        System.out.println("\nSearch by Director (Tony Scott):");
        mms.searchbydirector("Tony Scott");

        // 7️⃣ Search by rating
        System.out.println("\nSearch by Rating >= 8.0:");
        mms.searchbyrating(8.0);

        // 8️⃣ Update movie rating
        System.out.println("\nUpdate Rating:");
        mms.UpdateRating("Top Gun", 9.0);
        mms.displayforward();

        // 9️⃣ Remove movie by title (middle)
        System.out.println("\nRemove Movie (Jerry Maguire):");
        mms.RemovebyTitle("Jerry Maguire");
        mms.displayforward();

        // 🔟 Remove movie by title (tail)
        System.out.println("\nRemove Movie (Edge of Tomorrow):");
        mms.RemovebyTitle("Edge of Tomorrow");
        mms.displayforward();

        // Remove movie by title (head)
        System.out.println("\nRemove Movie (Mission Impossible):");
        mms.RemovebyTitle("Mission Impossible");
        mms.displayforward();
    }
}
