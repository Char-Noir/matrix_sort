package ua.com.matrix.helpers;

import java.util.Scanner;

import ua.com.matrix.Settings;

public class ConsoleHelper {
    private static final String TASK_DESCRIPTION = "Дана матриця (N*10+1)x(N*10+1). \nОтсортировать главную и побочную диагонали, если стоящий в точке пересечения элемент совпадает, \nтогда вернуть матрице исходный вид и отсортировать в прямом порядке все четные столбцы, \nиначе отсортировать в обратном порядке все нечетные строки.";
    private static final String TASK_INPUT = "Предпочтительный ввод: N - целое число.";
    private static final String TASK_ERROR = "Неверный ввод";

    public static int[][] getMatrix() {
        Scanner scanner = new Scanner(System.in);
        int n = 0;//partial size of matrix
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
        return MatrixHelper.getMatrix(Settings.calcMatrixSize(n));
    }

    public static void describeTask() {
        System.out.println(TASK_DESCRIPTION);
        System.out.println(TASK_INPUT);
    }

    public static void printMatrix(int[][] matrix) {
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length; j++){
                System.out.print(matrix[j][i]+"\t");
            }
            System.out.println("");
        }
    }

}
