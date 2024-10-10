#include <stdio.h>
#include <time.h>

#define N 3
#define M 3

void displayRuntime(clock_t start, clock_t end) {
    double time_taken = ((double)(end - start)) / CLOCKS_PER_SEC; 
    printf("Runtime: %f seconds\n", time_taken*1000);
}
void rowSumCalculation(int matrix[N][M]) {
    for (int i = 0; i < N; i++) {
        int sum = 0;
        for (int j = 0; j < M; j++) {
            sum += matrix[i][j];
        }
        printf("Sum of elements in row %d: %d\n", i+1, sum);
    }
}

void columnSumCalculation(int matrix[N][M]) {
    for (int j = 0; j < M; j++) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += matrix[i][j];
        }
        printf("Sum of elements in column %d: %d\n", j+1, sum);
    }
}

void matrixAddition(int matrix1[N][M], int matrix2[N][M], int result[N][M]) {
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            result[i][j] = matrix1[i][j] + matrix2[i][j];
        }
    }
}

void matrixSubtraction(int matrix1[N][M], int matrix2[N][M], int result[N][M]) {
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            result[i][j] = matrix1[i][j] - matrix2[i][j];
        }
    }
}

void matrixMultiplication(int matrix1[N][M], int matrix2[M][N], int result[N][N]) {
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            result[i][j] = 0;
            for (int k = 0; k < M; k++) {
                result[i][j] += matrix1[i][k] * matrix2[k][j];
            }
        }
    }
}

void displayMatrix(int matrix[N][M]) {
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            printf("%d ", matrix[i][j]);
        }
        printf("\n");
    }
}

int main() {
    clock_t start, end;
    start = clock();
    int matrix1[N][M], matrix2[N][M], result[N][M];

    printf("Enter elements of matrix1:\n");
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            scanf("%d", &matrix1[i][j]);
        }
    }

    printf("Enter elements of matrix2:\n");
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            scanf("%d", &matrix2[i][j]);
        }
    }

    printf("Matrix1:\n");
    displayMatrix(matrix1);

    printf("Matrix2:\n");
    displayMatrix(matrix2);

    rowSumCalculation(matrix1);
    columnSumCalculation(matrix1);

    matrixAddition(matrix1, matrix2, result);
    printf("Addition Result:\n");
    displayMatrix(result);

    matrixSubtraction(matrix1, matrix2, result);
    printf("Subtraction Result:\n");
    displayMatrix(result);

    matrixMultiplication(matrix1, matrix2, result);
    printf("Multiplication Result:\n");
    displayMatrix(result);
    
    end = clock();
    displayRuntime(start, end);

    return 0;
}

