/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrices;

public class Matrices {

    public static void main(String[] args) {
        int[][] matriz = {
            {1, 2, 3, 4, 5},
            {2, 1, 3, 4, 5},
            {3, 2, 1, 4, 5},
            {2, 4, 5, 1, 3},
            {5, 4, 3, 2, 1}
        };
        int nDiagonal = 0;
        boolean hasAssignedNDiagonal = false;
        boolean diagonalOk = true;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (i == j) {
                    if (!hasAssignedNDiagonal) {
                        hasAssignedNDiagonal = true;
                        nDiagonal = matriz[i][j];
                    } else if (nDiagonal != matriz[i][j]) {
                        diagonalOk = false;
                    }
                }
                System.out.println("Diagonal: " + (diagonalOk ? "ok" : "mal"));

            }

        }

    }

}
