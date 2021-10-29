import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MatrixSortMain{

    private static final int maxRandValue = 16;
    private static final String TASK_DESCRIPTION = "Дана матриця (N*10+1)x(N*10+1). \nОтсортировать главную и побочную диагонали, если стоящий в точке пересечения элемент совпадает, \nтогда вернуть матрице исходный вид и отсортировать в прямом порядке все четные столбцы, \nиначе отсортировать в обратном порядке все нечетные строки.";
    private static final String TASK_INPUT = "Предпочтительный ввод: N - целое число.";
    private static final String TASK_ERROR = "Неверный ввод";

    public static int calcMatrixSize(int n){
        return (n*10)+1;
    }

    public static void main(String[] args){
        describeTask();
        int[][] matrix = getMatrix();
        int[][] matrix1 = copy(matrix);
        printMatrix(matrix1);
        sortDiagonals(matrix1);
        System.out.println("############################################");
        printMatrix(matrix1);
        int central = (matrix.length/2);
        if(matrix1[central][central]==matrix[central][central]){
            matrix1 = matrix;
            sort(matrix1, true);
            System.out.println("First variant");
        }
        else{
            sort(matrix1, false);
            System.out.println("Second variant");
        }
        System.out.println("############################################");
        printMatrix(matrix1);
    }

    public static int[][] getMatrix() {
        Scanner scanner = new Scanner(System.in);
        int n;//partial size of matrix
        do{
            try {
                n = scanner.nextInt();
            }
            catch (Exception e){
                System.err.println(TASK_ERROR);
                System.out.println(TASK_INPUT);
                n=0;
            }
        }while(n<=0);
        scanner.close();
        return getMatrix(calcMatrixSize(n));
    }

    public static void describeTask() {
        System.out.println(TASK_DESCRIPTION);
        System.out.println(TASK_INPUT);
    }

    public static void printMatrix(int[][] matrix) {
        for(int i=0; i<matrix.length; i++){
            for (int[] ints : matrix) {
                System.out.print(ints[i] + "\t");
            }
            System.out.println();
        }
    }
    public static int[][] getMatrix(int n) {
        int[][] matrix = new int[n][n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = rand.nextInt(maxRandValue);
            }
        }
        return matrix;
    }

    public static int[][] copy(int[][] matrix) {
        int[][] matrixCopy = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(matrix[i], 0, matrixCopy[i], 0, matrix.length);
        }
        return matrixCopy;
    }

    public static void sortDiagonals(int[][] matrix) {
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
    }

    public static void sort(int[][] matrix, boolean isColmns) {
        if(isColmns){
            for(int i = 1; i < matrix.length; i+=2){
                int[] row = new int[matrix.length];
                System.arraycopy(matrix[i], 0, row, 0, matrix.length);
                Arrays.sort(row);
                System.arraycopy(row, 0, matrix[i], 0, matrix.length);
            }
        }
        else{
            for(int j = 0; j < matrix.length; j+=2){
                int[] row = new int[matrix.length];
                for (int i = 0; i < matrix.length; i++){
                    row[i] = matrix[i][j];
                }
                Arrays.sort(row);
                reverse(row);
                for (int i = 0; i < matrix.length; i++){
                    matrix[i][j] = row[i];
                }
            }
        }
    }

    private static void reverse(int[] array){
        for(int i = 0; i < array.length / 2; i++)
        {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }

}