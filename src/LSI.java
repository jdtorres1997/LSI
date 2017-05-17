import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

import Jama.Matrix;
import Jama.SingularValueDecomposition;

public class LSI {

  private static Scanner scanner;


  public static void main(String[] args) throws IOException {


    /*
     * A will be a Matrix that represent the User and the Rating for each product
     * Columns will be the Products
     * Rows will be the Users
     */

    // Read File
    String filePath = new File("").getAbsolutePath();
    FileReader f = new FileReader(filePath + "/input/in.txt");
    BufferedReader b = new BufferedReader(f);

    // Create Matrix of FileReader
    Matrix A = Matrix.read(b);
    Matrix Atopn = A.copy();

    System.out.println("Matrix of files i - key words j: ");
    // Print matrix A, first parameter is the width(for better read), second is the number of digits after 0
    A.print(4, 2);
    // Calculate the recommendation to customer c and product p
   
    //Calculate the SVD
    SingularValueDecomposition s= A.svd();
    
 // Get U Matrix
    System.out.println("U = ");
    Matrix U = s.getU();
    U.print(4, 2);
    // Get S Matrix
    System.out.println("S = ");
    Matrix S = s.getS();
    S.print(4, 2);
    // Get V Matrix
    System.out.println("V = ");
    Matrix V = s.getV();
    V.print(4, 2);
    
    //Define k, preguntar si se saca igual que el anterior o se define un numero fijo. Es muy ineficiente
    int k = 2;
    System.out.println("k = " + k);
    
    //Reduction of Matrix U, S y V
    Matrix Uk = U.getMatrix(0, U.getRowDimension() - 1, 0, (k-1));
    Matrix Sk = S.getMatrix(0, (k-1), 0, (k-1));
    Matrix Vk = V.getMatrix(0, (k-1), 0, V.getColumnDimension() - 1);

    System.out.println("Uk: ");
    Uk.print(4, 2);
    System.out.println("Sk: ");
    Sk.print(4, 2);
    System.out.println("Vk: ");
    Vk.print(4, 2);
    
    
  }



}