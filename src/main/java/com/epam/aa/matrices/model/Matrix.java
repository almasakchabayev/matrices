package com.epam.aa.matrices.model;


import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.Random;

public class Matrix {
    private int rows;
    private int columns;
    private int[][] values;

    public Matrix(int rows, int columns) {
        if (rows >= 0 && columns >= 0) {
            this.rows = rows;
            this.columns = columns;
            this.values = new int[rows][columns];
        }
        else {
            System.out.println("Please input non-negative number for rows and columns");
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int getValue(int row, int column) {
        return values[row][column];
    }

    public void setValue(int row, int column, int value) {
        values[row][column] = value;
    }

    @Override
    public String toString() {
        String matrixString = "";
        String RowSeparator = "|";
        String ColumnSeparator = ", ";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (j == 0) {
                    matrixString += RowSeparator + values[i][j] + ColumnSeparator;
                } else if (j == columns-1) {
                    matrixString += values[i][j] + RowSeparator;
                }
                else {
                    matrixString += values[i][j] + ColumnSeparator;
                }
            }
            matrixString += "\n";
        }
        return matrixString;
    }

    public void fillRandom() {
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                setValue(i, j, random.nextInt());
            }
        }
    }

    public static Matrix multiply(Matrix matrixA, Matrix matrixB) {
        if (matrixA.getColumns() == matrixB.getRows()){
            Matrix result = new Matrix(matrixA.getRows(), matrixB.getColumns());
            for (int i = 0; i < matrixA.getRows(); i++) {
                for (int j = 0; j < matrixB.getColumns(); j++) {
                    int value = 0;
                    for (int k = 0; k < matrixB.getRows(); k++) {
                        value += matrixA.getValue(i, k) * matrixB.getValue(k, j);
                    }
                    result.setValue(i, j, value);
                }
            }
            return result;
        }
        else {
            System.out.println("these matrices are not multipliable");
            return null;
        }
    }

    public void fillBy(int value) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                setValue(i, j, value);
            }
        }
    }

    public static Matrix sum(Matrix matrixA, Matrix matrixB) {
        if (matrixA.getRows() == matrixB.getRows() && matrixA.getColumns() == matrixB.getColumns()){
            Matrix result = new Matrix(matrixA.getRows(), matrixB.getColumns());
            for (int i = 0; i < matrixA.getRows(); i++) {
                for (int j = 0; j < matrixA.getColumns(); j++) {
                    result.setValue(i, j, matrixA.getValue(i, j) + matrixB.getValue(i, j));
                }
            }
            return result;
        } else {
            System.out.println("these matrices cannot be summed");
            return null;
        }
    }

    public void fillMainDiagonalBy(int value) {
        if (rows == columns) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (i == j) {
                        setValue(i, j, value);
                    } else {
                        setValue(i, j, 0);
                    }
                }
            }
        } else {
            System.out.println("not a square matrix, cannot be performed");
        }
    }

    public void fillRandomZeroOne() {
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int value = random.nextInt()%2;
                if (value < 0) {
                    value = -value;
                }
                setValue(i, j, value);
            }
        }
    }

    public Matrix multiply(Matrix matrix) {
        return multiply(this, matrix);
    }

    public Matrix sum(Matrix matrix) {
        return sum(this, matrix);
    }

    public void timesScalar(int scalar) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                setValue(i, j, this.getValue(i, j) * scalar);
            }
        }
    }
}
