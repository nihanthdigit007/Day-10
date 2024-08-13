import java.util.Arrays;
class Assignment91 {
    private static class WorkerThread extends Thread {
        private int row;
        private int col;
        private int[][] A;
        private int[][] B;
        private int[][] result;

        public WorkerThread(int row, int col, int[][] A, int[][] B, int[][] result) {
            this.row = row;
            this.col = col;
            this.A = A;
            this.B = B;
            this.result = result;
        }
        @Override
        public void run() {
            result[row][col] = 0;
            for (int k = 0; k < B.length; k++) {
                result[row][col] += A[row][k] * B[k][col];
            }
        }
    }
    public static int[][] multiply(int[][] A, int[][] B) {
        int rowsA = A.length;
        int colsA = A[0].length;
        int rowsB = B.length;
        int colsB = B[0].length;

        if (colsA != rowsB) {
            throw new IllegalArgumentException("Number of columns in A must be equal to number of rows in B");
        }
        int[][] result = new int[rowsA][colsB];
        Thread[] threads = new Thread[rowsA * colsB];
        int threadIndex = 0;

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                threads[threadIndex] = new WorkerThread(i, j, A, B, result);
                threads[threadIndex].start();
                threadIndex++;
            }
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] A = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] B = {
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        };
        int[][] result = multiply(A, B);
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}

