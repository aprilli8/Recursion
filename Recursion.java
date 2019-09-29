//I am the sole author of the work in this repository.

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
  * Return number of cannonballs in pyramid with the given `height`.
  * pre: height is a postive integer
  * post: returns sum of all cannonballs in each level of the pyramid
  * Big-O runtime: O(n) because there are only O(n) type executions in the method,
  such as the if loop that can run at most the number of times the method is called.
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
  * pre: str is a valid String
  * post: returns true if str is a palindrome and false if it is not
  * Big-O runtime: O(n^2) because the method recursively calls itself, which is
  a O(n) execution, using a substring of str every time, which is an O(n) execution
  as well. Overall then, the method ends up being O(n^2).
  */
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
  * pre: str is a valid String consisting of only bracketing operators (), [], and {}
  * post: returns true if bracketing operators in str are balanced and false if they are unbalanced
  * Big-O runtime: O(n^2) because the method recursively calls itself n times,
  which is of O(n), and uses substrings in the calls each time, which is also
  of O(n). Overall, the method is then of O(n^2).
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
  * pre: str is a valid String
  * post: prints out all possible substrings made of letters in str
  * Big-O runtime: O(2^n); it should be the same order as substringHelper
  because this method only calls it once.
  */
  public static void substrings(String str) {
    substringHelper(str, "");
  }

  /*
  * Helper method for substrings(String str)
  * `soFar` keeps track of the characters currently in the substring
  *   being built
  *
  * pre: str and soFar are valid Strings
  * post: builds all substrings from str
  * Big-O runtime: O(2^n) because since there are two possible states of
  whether or not to include a letter in each run of the method, which needs to
  be run n times, the method has to be of O(2^n).
  */
  public static void substringHelper(String str, String soFar) {
    if(str.length() == 0){
      System.out.print("\"" + soFar + "\" ");
    }
    else{
      substringHelper(str.substring(1), soFar+str.substring(0,1));
      substringHelper(str.substring(1), soFar);
    }
  }

  /*****  5  ***************************************************/

  /*
  * Print `number` in binary
  *
  * pre: number is a non-negative integer
  * post: prints out the binary number corresponding to the decimal number
  * Big-O runtime: O(n) because the only execution larger than O(1) is the
  method's recursive call to itself, which is O(n).
  */
  public static void printInBinary(int number) {
    if(number <= 1){
      System.out.print(number);
    }
    else{
      printInBinary(number/2);
      System.out.print(number%2);
    }
  }

  /*****  6  ***************************************************/


  /*
  * Return whether a subset of the numbers in nums add up to sum,
  * and prints them out.
  *
  * pre: nums[] is an array of integers and targetSum is an integer
  * post: returns true if any one or two numbers in nums array adds up to equal targetSum
  * Big-O runtime: O(n^2) because the method runs recursive calls to itself,
  which is of O(n), where in each call it creates and copies over a new array
  that includes one less element, which is O(n) as well. Overall, the method is
  then of O(n^2).
  */
  public static boolean printSubSetSum(int nums[], int targetSum) {
    if(nums.length == 0){
      return false;
    }
    else{
      for(int i = 1; i < nums.length; i++){
        if(nums[0] == targetSum){
          System.out.println("[" + nums[0] + "]");
          return true;
        }
        else if(nums[0]+nums[i] == targetSum){
          System.out.println("[" + nums[0] + ", " + nums[i] + "]");
          return true;
        }
      }
      return printSubSetSum(Arrays.copyOfRange(nums,1,nums.length), targetSum);
    }
  }


  /*
  * Return the number of different ways elements in nums can be
  * added together to equal sum (you do not need to print them all).
  *
  * pre: nums[] is an array of integers and targetSum is an integer
  * post: returns an integer which is a count of all possible combinations of integers in nums[] that add to targetSum
  * Big-O runtime: O(n^2) because the method runs recursive calls to itself,
  which is of O(n), where in each call it creates and copies over a new array
  that includes one less element, which is O(n) as well. Overall, the method is
  then of O(n^2).
  */
  public static int countSubSetSumSolutions(int nums[], int targetSum) {
    int count = 0;
    if(nums.length == 0){
      return count;
    }
    else{
      if(nums[0] == targetSum){
        count++;
      }
      for(int i = 1; i < nums.length; i++){
        if(nums[0]+nums[i] == targetSum){
          count++;
        }
      }
      count+=countSubSetSumSolutions(Arrays.copyOfRange(nums,1,nums.length), targetSum);
    }
    return count;
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

    System.out.println(countCannonballs(7));
    System.out.println(countCannonballs(3));
    System.out.println(countCannonballs(10));

    System.out.println(isPalindrome("mom"));
    System.out.println(isPalindrome(""));
    System.out.println(isPalindrome("youth"));
    System.out.println(isPalindrome("deeded"));
    System.out.println(isPalindrome("dood"));
    System.out.println(isPalindrome("ablewasIereIsawelba"));

    System.out.println(isBalanced("[{[()()]}]"));
    System.out.println(isBalanced("[{[(){(})]}]"));
    System.out.println(isBalanced("[{[()()]}][{[()()]}]"));
    System.out.println(isBalanced("[{[()()]}{]{[()()]}]"));

    substrings("abc");
    System.out.println();
    substrings("hello");
    System.out.println();
    substrings("CSCI136");
    System.out.println();
    substrings("a");
    System.out.println();
    substrings("");
    System.out.println();
    substrings("Recursion");
    System.out.println();

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
    printInBinary(0);
    System.out.println();
    printInBinary(30);
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

    System.out.println(printSubSetSum(numSet, 21));
    System.out.println(printSubSetSum(numSet, 19));
    System.out.println(printSubSetSum(numSet, 22));
    System.out.println(printSubSetSum(numSet, 3));
    System.out.println(printSubSetSum(numSet, 28));
    System.out.println(printSubSetSum(numSet, 30));

    System.out.println(countSubSetSumSolutions(numSet, 17));
    System.out.println(countSubSetSumSolutions(numSet, 21));
    System.out.println(countSubSetSumSolutions(numSet, 22));
    System.out.println(countSubSetSumSolutions(numSet, 2));
    System.out.println(countSubSetSumSolutions(numSet, 30));
    System.out.println(countSubSetSumSolutions(numSet, -3));
  }
}
