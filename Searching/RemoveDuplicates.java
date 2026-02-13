/*StringBuilder Problem 2: Remove Duplicates from a String Using StringBuilder
Problem:
Write a program that uses StringBuilder to remove all duplicate characters from a given string
while maintaining the original order.
Approach:
Initialize an empty StringBuilder and a HashSet to keep track of characters.
Iterate over each character in the string:
If the character is not in the HashSet, append it to the StringBuilder and add it to the HashSet.
Return the StringBuilder as a string without duplicates.
*/

public class RemoveDuplicates {
    public static String removedup(String input){
        if(input == null){
            return null;
        }
        StringBuilder result = new StringBuilder();
        //We iterate through the string
        for (int i = 0; i <input.length() ; i++) {
            //Currchar
            char curr = input.charAt(i);

            //if the char doesn't exist we put it in the result.
            if(result.indexOf(String.valueOf(curr)) == -1){
                result.append(curr);
            }
        }
        //Array ke form me string return karwa do you can't return string you have to add
        // .toString...
        return result.toString();
    }

    public static void main(String[] args) {
        String str = "Programming";

        System.out.println(removedup(str));
    }
}
