


public class Main {

    public static void main(String[] args) {

        int[][] priorityQueues = {{1,2,3,4,5},{1,1,0,1,1},{1,5,1,2,5,6},{1,2,2,3,2,2,17,4},
                {1,2,2,0,2,2,17,4}, new int[1023], new int[1023]};
        for (int x = 5; x < priorityQueues.length; x++)
            for (int i = 0, k = 0; i < 10; i++)
                for (int j = 0; j < Math.pow(2, i); j++, k+=1)
                    priorityQueues[x][k] = (int) Math.pow(2, i);
        priorityQueues[6][500] = 1;
        for (int i = 0, y = 0; i < priorityQueues.length; i++) {
            y = isPriorityQueue(priorityQueues[i],0);
            if (y == 0){
                System.out.println("It's Valid");
            }
            else if(y == -1){
                System.out.println("It's Invalid at index 0");
            }
            else {
                System.out.println("It's Invalid at index " + y);
            }
        }
    }
    public static int isPriorityQueue(int[] array, int z) {
        if (z * 2 + 2 > array.length - 1){
            return 0; // true
        }
        if (array[z * 2 + 1] == 0){
            return z + 1;
        }
        if (array[z * 2 + 2] == 0){
            return z + 2;
        }
        if (array[z] == 0 || (array[z * 2 + 1] < array[z]) || (array[z * 2 + 2] < array[z])) {
            if (z == 0){
                return -1;
            }
            else{
                return z;
            }
        } else {
            int k = isPriorityQueue(array,z * 2 + 1);
            if (k != 0){
                return k;
            }
            k = isPriorityQueue(array,z * 2 + 2);
            if (k != 0){
                return k;
            }
            return isPriorityQueue(array,z * 2 + 1) + isPriorityQueue(array,z * 2 + 2);
        }
    }

}
