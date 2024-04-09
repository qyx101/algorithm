public class SelectBubbleInsert {

    public static void swap(int[] arr,int i,int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // 选择排序
    public static void selectionSort(int[] arr) {
        // 5 3 1 2 4
        // 1 3 5 2 4
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int minIndex,i = 0;i < arr.length-1;i++) {
            minIndex = i;
            for (int j = i + 1;j < arr.length;j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr,minIndex,i);
        }
    }

    // 冒泡排序
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 5,3,1,2,4
        // 3 1 2 4 5

        for (int end = arr.length-1;end > 0;end--) {
            for (int i = 0;i < end;i++) {
                if (arr[i] > arr[i+1]) {
                    swap(arr,i,i+1);
                }
            }
        }
    }

    // 插入排序
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1;i < arr.length;i++) {
            for (int j = i - 1;j >= 0 && arr[j] > arr[j + 1];j--) {
                swap(arr,j,j+1);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {5,3,1,2,4};
        //SelectBubbleInsert.selectionSort(array);
        //SelectBubbleInsert.bubbleSort(array);
        SelectBubbleInsert.insertionSort(array);
    }
}
