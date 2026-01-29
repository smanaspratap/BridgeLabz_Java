/*Rock-Paper-Scissors is a game played between a minimum of two players. Each player can choose either rock, paper, or scissors. Here the game is played between a user and a computer. Based on the rules, either a player or a computer will win. Show the stats of player and computer win in a tabular format across multiple games. Also, show the winning percentage between the player and the computer.
Hint => 
The rule is: rock-scissors: rock will win (rock crushes scissors); rock-paper: paper wins (paper covers rock); scissors-paper: scissors win (scissors cuts paper)
Create a Method to find the Computer Choice using the Math.random
Create a Method to find the winner between the user and the computer
Create a Method to find the average and percentage of wins for the user and the computer and return a String 2D array
Create a Method to display the results of every game and also display the average and percentage wins 
In the main take user input for the number of games and call methods to display result
 */

import java.util.Scanner;

public class RockPaperScissors {
    static String computerChoice() {
        int r = (int)(Math.random() * 3);
        if (r == 0) return "rock";
        if (r == 1) return "paper";
        return "scissors";
    }

    static String winner(String user, String comp) {
        if (user.equals(comp)) return "Draw";
        if (user.equals("rock") && comp.equals("scissors")) return "User";
        if (user.equals("scissors") && comp.equals("paper")) return "User";
        if (user.equals("paper") && comp.equals("rock")) return "User";
        return "Computer";
    }

    static String[][] stats(int userWin, int compWin, int games) {
        String[][] res = new String[2][3];
        res[0][0] = "User";
        res[0][1] = String.valueOf(userWin);
        res[0][2] = String.valueOf((userWin * 100.0) / games);

        res[1][0] = "Computer";
        res[1][1] = String.valueOf(compWin);
        res[1][2] = String.valueOf((compWin * 100.0) / games);

        return res;
    }

    static void display(String[][] games, String[][] stats) {
        System.out.println("Game\tUser\tComputer\tWinner");
        for (int i = 0; i < games.length; i++)
            System.out.println((i+1) + "\t" + games[i][0] + "\t" + games[i][1] + "\t" + games[i][2]);

        System.out.println("\nPlayer\tWins\tPercentage");
        for (int i = 0; i < stats.length; i++)
            System.out.println(stats[i][0] + "\t" + stats[i][1] + "\t" + stats[i][2]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String[][] games = new String[n][3];
        int userWin = 0, compWin = 0;

        for (int i = 0; i < n; i++) {
            String user = sc.next();
            String comp = computerChoice();
            String win = winner(user, comp);

            if (win.equals("User")) userWin++;
            if (win.equals("Computer")) compWin++;

            games[i][0] = user;
            games[i][1] = comp;
            games[i][2] = win;
        }

        String[][] stat = stats(userWin, compWin, n);
        display(games, stat);
    }
}
