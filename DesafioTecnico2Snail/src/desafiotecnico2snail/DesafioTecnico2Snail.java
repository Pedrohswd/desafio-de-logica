/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package desafiotecnico2snail;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pedro
 */
public class DesafioTecnico2Snail {

public static List<Integer> snail(int[][] matrix) {
        List<Integer> resultado = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return resultado;
        }

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                resultado.add(matrix[top][i]);
            }
            top++;
            
            for (int i = top; i <= bottom; i++) {
                resultado.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    resultado.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    resultado.add(matrix[i][left]);
                }
                left++;
            }
        }

        return resultado;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        List<Integer> resultado = snail(matrix);
        System.out.println(resultado);
    }
    
}
