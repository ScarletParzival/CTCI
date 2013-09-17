package Chapter_1;

/**
 * Created with IntelliJ IDEA.
 * User: sowmyahariharan
 * Date: 9/8/13
 * Time: 2:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class ImageRotation {
    public static void main(String[] args){
        int[][]  matrix = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        // {{1,2,3,10},{4,5,6,11},{7,8,9,12},{13,14,15,16}}; 4*4 matrix
        rotateImageBy90(matrix);
        for(int i=0; i<matrix.length; ++i){
            System.out.println();
            for(int j=0; j<matrix[0].length; ++j){
                System.out.print(matrix[i][j] + " ");
            }
        }
        matrix = new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        rotateImageBy90Rewrite(matrix);
        System.out.println();
        for(int i=0; i<matrix.length; ++i){
            System.out.println();
            for(int j=0; j<matrix[0].length; ++j){
                System.out.print(matrix[i][j]+" ");
            }
        }
        // rotateImageBy90MyStupidWay(matrix);
    }

    private static void rotateImageBy90Rewrite(int[][] matrix){
        int N = matrix.length;
        for(int layer=0; layer<N/2; ++layer){
            int first = layer;
            int last = N-1-layer;
            for(int i=first; i<last; ++i){
                int offset = i-first;

                int elementAtTheTop = matrix[first][i];
                matrix[first][i] = matrix[last-offset][first];
                matrix[last-offset][first] = matrix[last][last-offset];
                matrix[last][last-offset] = matrix[i][last];
                matrix[i][last] = elementAtTheTop;
            }
        }
    }

    private static void rotateImageBy90(int[][] matrix){
        int N = matrix.length; //matrix[0].length both are just the same, since its a N*N matrix

        for(int i=0; i<N; ++i){
            System.out.println();
            for(int j=0; j<N; ++j){
                System.out.print("  " + matrix[i][j]);
            }
        }
        System.out.println("\n\n");

        for(int layer = 0; layer < N/2; ++layer){
            int first = layer;
            int last = N-1-layer;
            System.out.println("First:"+first+"\tLast:"+last);
            for(int i=first; i<last; ++i){
                int offset = i-first;

                System.out.println("Offset:"+offset+"\tLast-offset:"+(last-offset)+"\ti:"+i);
                System.out.println("Top (matrix[first][i]): "+ matrix[first][i] + " will be replaced by Left (matrix[last-offset][first]): "+ matrix[last-offset][first]);
                System.out.println("Left (matrix[last-offset][first]): "+ matrix[last-offset][first] + " will be replaced by Bottom (matrix[last][last-offset]): "+ matrix[last][last-offset]);
                System.out.println("Bottom (matrix[last][last-offset]): "+ matrix[last][last-offset] + " will be replaced by Right (matrix[i][last]): "+ matrix[i][last]);
                System.out.println("Right (matrix[i][last]): "+ matrix[i][last] + " will be replaced by Top (matrix[first][i]): "+ matrix[first][i]);
                System.out.println("End of this iteration\n");

                //Save elementFromTheTop
                int elementFromTheTop = matrix[first][i];

                // elementFromTheTop <- left
                matrix[first][i] = matrix[last-offset][first];

                // left <- bottom
                matrix[last-offset][first] = matrix[last][last-offset];

                // bottom <- right
                matrix[last][last-offset] = matrix[i][last];

                // right <- elementFromTheTop
                matrix[i][last] = elementFromTheTop;

            }
        }
    }

    private static void rotateImageBy90MyStupidWay(int[][] matrix){
        int k=0;
        int m = matrix[0].length;
        int n = matrix.length; //n won't be used since m and n are the same here

        int[] arrayToBeMoved = new int[n]; //Since m and n are just the same
        int[] arrayToBeReplaced = new int[n];
        int i,j;

        i=0;
        for(j=0; j<n; ++j){
            arrayToBeMoved[j] = matrix[i][j];
        }

        j=n;
        for(i=0; i<n; ++i){
            arrayToBeReplaced[i] = matrix[i][j];
            matrix[i][j] = arrayToBeMoved[i];
            arrayToBeMoved[i] = arrayToBeReplaced[i];
        }

        i=n;
        for(j=n; j>=0; --j){
//            arrayToBeReplaced[j] =
        }




//        for(int i=0; i<m; ++i){
//            for(int j=0; i<n; ++j){
//
//            }
//        }
    }
}
