/*
* Recursion.java
*
* Starter code for the recursion lab.
*
*/
import structure5.*;
import java.util.Arrays;

public class Recursion {

  /***** Warmup 0.2 ********************************************/
  public static boolean canMakeSum(int setOfNums[], int targetSum) {
    if(setOfNums.length == 0){
      return false;
    }
    else{
      for(int j = 1; j < setOfNums.length; j++){
        if(setOfNums[0]+setOfNums[j] == targetSum || setOfNums[0] == targetSum || setOfNums[j] == targetSum){
          return true;
        }
      }
      return canMakeSum(Arrays.copyOfRange(setOfNums,1,setOfNums.length), targetSum);
    }
  }

  /*****  1  ***************************************************/

  /*
  * Return number of cannoballs in pyramid with the given `height`.
  * pre:
  * post:
  * Big-O runtime:
  */
  public static int countCannonballs(int height) {
    int sum = 0;
    if(height == 1){
      sum += 1;
    }
    else{
      sum += (height*height)+countCannonballs(height-1);
    }
    return sum;
  }


  /*****  2  ***************************************************/

  /*
  * Return true if `str` is a palindrome.
  * pre:
  * post:
  * Big-O runtime:
  */
//empty string counts as palindrome right?
  public static boolean isPalindrome(String str) {
    if(str.length() == 0 || str.length() == 1){
      return true;
    }
    else if(str.substring(0,1).equals(str.substring(str.length()-1))){
      return isPalindrome(str.substring(1,str.length()-1));
    }
    else{
      return false;
    }
  }

  /*****  3  ***************************************************/

  /*
  * Return true if `str` is a string of matched parens,
  * brackets, and braces.
  *
  * pre:
  * post:
  * Big-O runtime:
  */
  public static boolean isBalanced(String str) {
    if(str.length() == 0){
      return true;
    }
    else{
      for(int i = 0; i < str.length()-1; i++){
        if(str.substring(i,i+2).equals("()") || str.substring(i,i+2).equals("[]") || str.substring(i,i+2).equals("{}")){
          return isBalanced(str.substring(0,i)+str.substring(i+2));
        }
      }
      return false;
    }
  }

  /*****  4  ***************************************************/

  /*
  * Print all substrings of `str`.  (Order does not matter.)
  *
  * pre:
  * post:
  * Big-O runtime:
  */
  public static void substrings(String str) {
    if(str.length() == 0){
      System.out.print("\"\"");
    }
    else{
      System.out.print("\"" + str.charAt(0) + "\", ");
      if(str.length() > 1){
        for(int i = 1; i < str.length(); i++){
          System.out.print("\"" + str.charAt(0) + str.charAt(i) + "\", ");
        }
      }
      if(str.length() > 2){
        for(int i = 2; i < str.length(); i++){
          System.out.print("\"" + str.substring(0,i+1) + "\", ");
        }
      }
      substrings(str.substring(1));
    }
  }

  /*
  * Helper method for substrings(String str)
  * `soFar` keeps track of the characters currently in the substring
  *   being built
  *
  * pre:
  * post:
  * Big-O runtime:
  */
//do we have to use the helper method?
  public static void substringHelper(String str, String soFar) {

  }

  /*****  5  ***************************************************/

  /*
  * Print `number` in binary
  *
  * pre:
  * post:
  * Big-O runtime:
  */
  public static void printInBinary(int number) {
    int mult = 1;
    while(mult < (number/2)+1){
      mult = mult*2;
    }
    if(mult == 1){
      System.out.print(number%2);
    }
    else{
      if(mult <= number){
        System.out.print(1);
        printInBinary(mult/2);
      }
      else{
        System.out.print(0);
      }
      //printInBinary(number-((mult/2)+mult));
    }
  }


  /*****  6  ***************************************************/


  /*
  * Return whether a subset of the numbers in nums add up to sum,
  * and print them out.
  *
  * pre:
  * post:
  * Big-O runtime:
  */
  public static boolean printSubSetSum(int nums[], int targetSum) {
    return false;
  }


  /*
  * Return the number of different ways elements in nums can be
  * added together to equal sum (you do not need to print them all).
  *
  * pre:
  * post:
  * Big-O runtime:
  */
  public static int countSubSetSumSolutions(int nums[], int targetSum) {
    return 0;
  }

  /*
  * OPTIONAL problem:
  * give all possible English words (from Lexicon lex) that correspond to
  * the numbers given in digitSequence
  * pre:
  * post:
  */
  public static void listCompletions(String digitSequence, Lexicon lex){
  }


  public static void helperListCompletions(String remaining, Lexicon lex, String soFar){
  }

  /**************************************************************/

  /*
  * Add testing code to main to demonstrate that each of your
  * recursive methods works properly.
  */
  public static void main(String args[]) {

    // Please add your own tests to supplement these
    // Not all cases are thoroughly checked!!!
/*
    System.out.println(countCannonballs(7));
    System.out.println(countCannonballs(3));
    System.out.println(countCannonballs(10));

    System.out.println(isPalindrome("mom"));
    System.out.println(isPalindrome(""));
    System.out.println(isPalindrome("youth"));
    System.out.println(isPalindrome("deeded"));
    System.out.println(isPalindrome("level"));
    System.out.println(isPalindrome("ablewasIereIsawelba"));

    System.out.println(isBalanced("[{[()()]}]")); //true
    System.out.println(isBalanced("[{[(){(})]}]")); //false
    System.out.println(isBalanced("[{[()()]}][{[()()]}]")); //true
    System.out.println(isBalanced("[{[()()]}{]{[()()]}]")); //false

    substrings("abc");
    System.out.println();
    substrings("CSCI136");
    System.out.println();
    substrings("a");
    System.out.println();
    substrings("");
    System.out.println();
*/
    printInBinary(1);
    System.out.println();
    printInBinary(2);
    System.out.println();
    printInBinary(3);
    System.out.println();
    printInBinary(4);
    System.out.println();
    printInBinary(5);
    System.out.println();
    printInBinary(6);
    System.out.println();
/*    printInBinary(0);
    System.out.println();
    printInBinary(30);
    System.out.println();
    printInBinary(1);
    System.out.println();
    printInBinary(110);
    System.out.println();
    printInBinary(2048);
    System.out.println();
    printInBinary(43);
    System.out.println();

    int[] numSet = {2, 5, 7, 12, 16, 21, 30};
    System.out.println(canMakeSum(numSet, -1));
    System.out.println(canMakeSum(numSet, 19));
    System.out.println(canMakeSum(numSet, 100));
    System.out.println(canMakeSum(numSet, 21));
    System.out.println(canMakeSum(numSet, 22));
    System.out.println(canMakeSum(numSet, 3));
    System.out.println(canMakeSum(numSet, 30));
/*
    System.out.println(printSubSetSum(numSet, 21));
    System.out.println(printSubSetSum(numSet, 22));
    System.out.println(printSubSetSum(numSet, 3));
    System.out.println(printSubSetSum(numSet, 30));

    System.out.println(countSubSetSumSolutions(numSet, 21));
    System.out.println(countSubSetSumSolutions(numSet, 22));
    System.out.println(countSubSetSumSolutions(numSet, 3));
    System.out.println(countSubSetSumSolutions(numSet, 30));
*/
  }
}
