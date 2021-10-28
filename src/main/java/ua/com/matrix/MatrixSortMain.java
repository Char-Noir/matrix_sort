package ua.com.matrix;

import ua.com.matrix.helpers.ConsoleHelper;
import ua.com.matrix.helpers.MatrixHelper;

public class MatrixSortMain{

    public static void main(String[] args){
        ConsoleHelper.describeTask();
        int[][] matrix = ConsoleHelper.getMatrix();
        int[][] matrix1 = MatrixHelper.copy(matrix);
        ConsoleHelper.printMatrix(matrix1);
        matrix1 = MatrixHelper.sortDiagonals(matrix1);
        System.out.println("############################################");
        ConsoleHelper.printMatrix(matrix1);
        int central = (matrix.length/2);
        if(matrix1[central][central]==matrix[central][central]){
            matrix1 = matrix;
            matrix1 = MatrixHelper.sort(matrix1,true);
            System.out.println("First variant");
        }
        else{
            matrix1 = MatrixHelper.sort(matrix1,false);
            System.out.println("Second variant");
        }
        System.out.println("############################################");
        ConsoleHelper.printMatrix(matrix1);
    }

}