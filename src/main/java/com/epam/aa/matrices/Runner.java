package com.epam.aa.matrices;


import com.epam.aa.matrices.model.Matrix;

public class Runner {
    public static void main(String[] args) {

        Matrix matrixA = new Matrix(4, 3);
        Matrix matrixB = new Matrix(3, 3);

        System.out.println("Random matrices:");
        matrixA.fillRandom();
        matrixB.fillRandom();
        System.out.println(matrixA);
        System.out.println(matrixB);

        System.out.println("Filled by 1 and 2");
        matrixA.fillBy(1);
        matrixB.fillBy(2);
        System.out.println(matrixA);
        System.out.println(matrixB);

        System.out.println("Main diagonal filled by 1 and 2");
        matrixA.fillMainDiagonalBy(1);
        matrixB.fillMainDiagonalBy(2);
        System.out.println(matrixA);
        System.out.println(matrixB);

        System.out.println("Filled randomly by 0 or 1");
        matrixA.fillRandomZeroOne();
        matrixB.fillRandomZeroOne();
        System.out.println(matrixA);
        System.out.println(matrixB);

        System.out.println("matrixA times matrixB is");
        Matrix matrixC = Matrix.multiply(matrixA, matrixB);
        System.out.println(matrixC);

        System.out.println("matrixA times matrixB is");
        Matrix matrixE = matrixA.multiply(matrixB);
        System.out.println(matrixE);

        System.out.println("matrixA plus matrixC is");
        Matrix matrixD = Matrix.sum(matrixA, matrixC);
        System.out.println(matrixD);

        System.out.println("matrixA plus matrixC is");
        Matrix matrixF = matrixA.sum(matrixC);
        System.out.println(matrixF);

        System.out.println("matrixA times 5");
        int scalar = 5;
        matrixA.timesScalar(scalar);
        System.out.println(matrixA);
    }
}
