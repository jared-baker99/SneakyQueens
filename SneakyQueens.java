// Jared Baker
// NID: ja907583
// Assignment 1 - Sneaky queens

import java.util.*;
import java.io.*;

public class SneakyQueens
{
  public static boolean allTheQueensAreSafe(ArrayList<String> coordinateStrings, int boardSize)
  {
    // Initilizing the arrays that will store if a queen attacking a coordinate
    // The vertical and horizontal that the queens attack
    boolean[] xAxis = new boolean[boardSize];
    boolean[] yAxis = new boolean[boardSize];
    // The diagonals that the queens attack
    boolean[] posDiag = new boolean[2 * boardSize];
    boolean[] negDiag = new boolean[2 * boardSize];

    // Loops throught all the strings with-in the array of str
    for (int i = 0; i < coordinateStrings.size(); i++)
    {
      // base for the number conversion
      int nBase = 1;
      // base for the letter conversion
      int lBase = 1;
      // count for traversing the cordinate from right -> left
      int travers = 1;
      // X and Y cordinate of the queen piece
      int x = 0;
      int y = 0;

      // Loops through the coordinate and calculates the y - value
      while (Character.isDigit(coordinateStrings.get(i).charAt(coordinateStrings.get(i).length() - travers)))
      {
        y += ((coordinateStrings.get(i).charAt(coordinateStrings.get(i).length() - travers)) - '1' + 1) * nBase;
        nBase *= 10;
        travers ++;
      }

      // Loops through the coordinate and calculates the x - Value
      while (travers <= coordinateStrings.get(i).length() &&
            Character.isLetter(coordinateStrings.get(i).charAt(coordinateStrings.get(i).length() - travers)))
      {
        x += ((coordinateStrings.get(i).charAt(coordinateStrings.get(i).length() - travers)) - 'a' + 1) * lBase;
        lBase *= 26;
        travers++;
      }

      // Calculates the diagonals for the Cordinate
      int pDiag = boardSize + y - x;
      int nDiag = x + y - 1;

      // Stops the out of bounds error if the queen is on the edge of the board
      // for the x - axis and y - axis arrays
      x -= 1;
      y -= 1;

      // checks to see if the cordinate is already being attacked by another queen
      // If so it will return False and the program will end, else it will keep looping
      // false = empty    true = being attacked
      if (xAxis[x] == true || yAxis[y] == true || posDiag[pDiag] == true || negDiag[nDiag] == true)
      {
        // returns false if not all queens are safe
        return false;
      }

      // Changes the values for the specific cordinate to true once a queen
      // occupies the space
      xAxis[x] = true;
      yAxis[y] = true;
      posDiag[pDiag] = true;
      negDiag[nDiag] = true;
    }

    // Returns true if it loops through all the cordinates without queens attakcing each other
    return true;
  }

  public static double difficultyRating()
  {
    double difficulty = 3.0;
    return difficulty;
  }

  public static double hoursSpent()
  {
    double hours = 30;
    return hours;
  }
}
