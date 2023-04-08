import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class wordle {

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);   
     //Creat a new array list with default word.
	 //Create a new array list to store returned list.
     ArrayList <Character> output = new ArrayList<>();

    MyArrayList<String> myArrayList = new MyArrayList<>();

     String wordE, wordFF; //Verables to store the word entered and the word from the list.

    File f1=new File("input.txt");   

    Boolean valid = false;


    try { //Open the file to read the words in the list.

        FileReader fr = new FileReader(f1);

        BufferedReader br = new BufferedReader(fr);
        wordFF = br.readLine();
        while(wordFF != null ) {
            // once the file is not equal to null 
            // use the wordFF as the word of the day
            

            for(int x=0;x<5;x++) { //run 5 time user get 5 guesses.
        
                System.out.println("Guess the five-letter word.");
        
                wordE = in.nextLine();
                
                if(wordE.length()==5) {

                    wordE = "atlas";
                    wordFF = "admin";
                    valid = true;
                    System.out.println("The entered word is a valid 5 letter word: " + valid);
        
                    if(valid) {
                        //display the feedback of the entered word
                        //display the result of the feedback (Winner, Try again, Looser)
                        
                        myArrayList.checkWin();
                        }

                        if(valid) {
                            //Call checkChar to check the validity of the chars and store the info.
                            output = myArrayList.checkChar(wordFF, wordE);
                            System.out.println("******Output********:\n"+output);
                            output.clear();

                            }
                } else {
                    valid = false;
                    // output word not valid
                    System.out.println("The entered word is a valid 5 letter word: " + valid);
        
                }// end of if statement
            } // end of for loop
            wordFF = br.readLine(); // update the wordFF
        } // end of while

    } catch (IOException e) {

        System.out.println("File Read Error");
    } // end of try catch


    } // end of main method

} // end of class
