package ua.com.matrix.helpers;

import java.util.Arrays;
import java.util.Random;

import ua.com.matrix.Settings;

public class MatrixHelper {

    public static int[][] getMatrix(int n) {
        int[][] matrix = new int[n][n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = rand.nextInt(Settings.minRandValue,Settings.maxRandValue);
            }
        }
        return matrix;
    }

    public static int[][] copy(int[][] matrix) {
        int[][] matrixCopy = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrixCopy[i][j] = matrix[i][j];
            }
        }
        return matrixCopy;
    }

    public static int[][] sortDiagonals(int[][] matrix) {
        int[] diagonalMain = new int[matrix.length];
        int[] diagonalSec = new int[matrix.length];
        for (int i = 0; i <matrix.length; i++){
            diagonalMain[i] = matrix[i][i];
            diagonalSec[i] = matrix[i][matrix.length-i-1];
        }
        Arrays.sort(diagonalMain);
        Arrays.sort(diagonalSec);
        for (int i = 0; i <matrix.length; i++){
            matrix[i][i] = diagonalMain[i];
            matrix[i][matrix.length-i-1] = diagonalSec[i];
        }
        return matrix;
    }

    public static int[][] sort(int[][] matrix, boolean isColmns) {
        if(isColmns){
            for(int i = 1; i < matrix.length; i+=2){
                int[] row = new int[matrix.length]; 
                for (int j = 0; j < matrix.length; j++){
                    row[j] = matrix[i][j];
                }
                Arrays.sort(row);
                for (int j = 0; j < matrix.length; j++){
                    matrix[i][j] = row[j];
                }
            }
        }
        else{
            for(int j = 0; j < matrix.length; j+=2){
                int[] row = new int[matrix.length]; 
                for (int i = 0; i < matrix.length; i++){
                    row[i] = matrix[i][j];
                }
                Arrays.sort(row);
                for (int i = 0; i < matrix.length; i++){
                    matrix[i][j] = row[i];
                }
            }
        }
        return matrix;
    }

}