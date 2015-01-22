
package binary.search.trees;
/*
 * Gerald Blake
 * CS 4343 Program 3
 * This program will read from two files the aproapiate information
 * It will store the information in two binary search trees accordingly
 * the program will separate the file contents into tokens and remove punctuation.
 * it will output the statistics of the file: percentage, token count, and token.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class WordCounter 
{
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException 
    {
        // GET FIRST TWO FILE NAMES
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the first filename: ");
        String inputString1 = scan.next();
        System.out.print("Enter the second filename: ");
        String inputString2 = scan.next();
        
        //REFERENCE FILES
        File input1 = new File(inputString1);
        File input2 = new File(inputString2);
        FileReader fileRead1, fileRead2;
       //SEE IF FILES EXIST
        //IF THEY DONT TERMINATE PROGRAM
        if(input1.exists())
        {
              fileRead1 = new FileReader(input1.getAbsoluteFile());
        
        }
        else
        {
            System.out.println(inputString1 + " not found the program has terminated...");
            return;
        }
        if(input2.exists())
        {
               fileRead2 = new FileReader(input2.getAbsoluteFile());
        
        }
        else
        {
            System.out.println(inputString2 + " not found the program has terminated...");
            return;
        }
        //CREATE FILE READERS
        BufferedReader reader1 = new BufferedReader(fileRead1);
        BufferedReader reader2 = new BufferedReader(fileRead2);
        BSTree tree1 = new BSTree();
        BSTree tree2;
        String inputFileString;
        //READ FIRST FILE INTO BST
        while(reader1.ready())
        {
               inputFileString = reader1.readLine();
               String delims = "[\\s\t]+";
               String[] tokens = inputFileString.split(delims);
               for(String u:tokens)
               { 
                      tree1.insert(u);
               }
        }
        
        reader1.close();
       //COPY TREE ONE INTO TREE TWO
        tree2 = tree1.copy();
        //READ SECOND FILE AND DELETE FROM TREE
        while(reader2.ready())
        {
               inputFileString = reader2.readLine();
               String delims = "[\\s\t]+";
               String[] tokens = inputFileString.split(delims);
               for(String u:tokens)
               {
                   tree1.delete(u);
               }
        }
        //PRINT TREE ONE
       System.out.println("BST 1\n");
       tree1.print();
       //PRINT Tree Two
       System.out.println("BST 2\n");
       tree2.print();
       System.out.println("BST 1 (POSTORDER)\n");
       tree1.printPostOrder();
     
    }
    
    
    
    
}
