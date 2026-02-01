/*Create a program to take input marks of students in 3 subjects physics, chemistry, and maths. Compute the total, average, and the percentage score 

Hint => 
Take input for the number of students
Write a method to generate random 2-digit scores for Physics, Chemistry, and Math (PCM) for the students and return the scores. This method returns a 2D array with PCM scores for all students
Write a Method to calculate the total, average, and percentages for each student and return a 2D array with the corresponding values. Please ensure to round off the values to 2 Digits using the Math.round() method. 
Finally, write a Method to display the scorecard of all students with their scores, total, average, and percentage in a tabular format using "\t".  */
public class StudentMarks {
    public static void main(String[] args){
        int students=5;
        //Computing the average
        for(int i=1;i<=students;i++){
            int p=(int)(Math.random()*100);
            int c=(int)(Math.random()*100);
            int m=(int)(Math.random()*100);
            int total=p+c+m;
            double avg=total/3.0;
            double per=(total/300.0)*100;
            //printing the average
            System.out.println(i+"\t"+p+"\t"+c+"\t"+m+"\t"+total+"\t"+avg+"\t"+per);
        }
    }
}
