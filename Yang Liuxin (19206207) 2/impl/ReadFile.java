package dsa.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    /*
    This class writes the readFile function to read and perform tree operation from a file
     */

    public static BinarySearchTree readFile(BinarySearchTree tree, String fileName){
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();
            while(line != null){
                String[] operations = line.split(" ");
                if (operations[0].equals("remove")){
                    tree.remove(Integer.parseInt(operations[1]));
                }
                else if (operations[0].equals("insert")){
                    tree.insert(Integer.parseInt(operations[1]));
                }
                else if (operations[0].equals("contains")){
                    tree.contains(Integer.parseInt(operations[1]));
                }
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tree;
    }
}
