import java.util.Scanner;

public class ConnectFour {
    public static void main(String[] args)
    {
        // Lab 6
        Scanner sc = new Scanner(System.in);
        char chipType;
        int row;
        int column;

        // Prompts user to input the height and length of their desired board.
        System.out.println("What would you like the height of the board to be? ");
        int boardHeight = sc.nextInt();
        System.out.println("What would you like the length of the board to be? ");
        int boardLength = sc.nextInt();

        // Initializes the board array.
        char[][] board = new char[boardHeight][boardLength];
        initializeBoard(board);
        printBoard(board);

        System.out.println("Player 1: x");
        System.out.println("Player 2: o");

        // Creates a while loop for the game that continues until a winner is chosen or a draw occurs.
        while (true)
        {
            chipType = 'x';
            System.out.println("Player 1: Which column would you like to choose? ");
            column = sc.nextInt();
            row = insertChip(board, column, chipType);
            printBoard(board);
            if (checkIfWinner(board,column, row, chipType))
            {
                System.out.println("Player 1 won the game!");
                break;
            }
            else if (checkIfDraw(board, boardHeight, boardLength))
            {
                System.out.println("Draw. Nobody wins.");
                break;
            }

            chipType = 'o';
            System.out.println("Player 2: Which column would you like to choose? ");
            column = sc.nextInt();
            row = insertChip(board, column, chipType);
            printBoard(board);
            if (checkIfWinner(board, column, row, chipType))
            {
                System.out.println("Player 2 won the game!");
                break;
            }
            else if (checkIfDraw(board, boardHeight, boardLength))
            {
                System.out.println("Draw. Nobody wins.");
                break;
            }
        }
    }

    // Method #1
        // Prints the board.
    public static void printBoard(char[][] array)
    {
        for (int i = array.length - 1; i >= 0; i--)
        {
            for (int j = 0; j < array[i].length; j++)
            {
                System.out.print(array[i][j] + "");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Method #2
        // Sets the default value of the array to "-".
    public static void initializeBoard(char[][] array)
    {
        for (int i = array.length - 1; i >= 0; i--)
        {
            for (int j = 0; j < array[i].length; j++)
            {
                array[i][j] = '-';
            }
        }
    }

    // Method #3
        // Places the token in the column the user selects.
        // If the column is full, it is placed in the next available spot.
        // The row the token is placed in is returned.
    public static int insertChip(char[][] array, int col, char chipType)
    {
        int row = 0;
        for (int i = 0; i < array.length; i++)
        {
            if (array[i][col] == '-')
            {
                array[i][col] = chipType;
                row = i;
                break;
            }
        }
        return row;
    }

    // Method #4
        // After a token is added, it checks whether the token is in this location, of the specific chip type, creates four in a row.
        // Returns true if someone won, false if otherwise.
    public static boolean checkIfWinner(char[][] array, int col, int row, char chipType)
    {
        int count = 0;

        for (int i = 0; i < array.length; i++)
        {
            if (array[i][col] == chipType)
            {
                count++;
            }
            else if (count == 4)
            {
                return true;
            }
            else
            {
                count = 0;
            }
        }

        for (int j = 0; j < array[row].length; j++)
        {
            if (array[row][j] == chipType)
            {
                count++;
            }
            if (count == 4)
            {
                return true;
            }
            else if (array[row][j] != chipType)
            {
                count = 0;
            }
        }
        return false;
    }

    // Method #5
        // Draw

    public static boolean checkIfDraw(char[][] array, int boardHeight, int boardLength)
    {
        int count = 0;

        for (int i = array.length - 1; i >= 0; i--)
        {
            for (int j = 0; j < array[i].length; j++)
            {
                if (array[i][j] == 'x' || array[i][j] == 'o')
                {
                    count++;
                }
            }
        }
        if (count == boardHeight * boardLength)
        {
            return true;
        }
        return false;
    }
}