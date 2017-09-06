
public class Sorting {

    /**
     * Implement the mergesort function, which should sort the array of
     * integers in place
     *
     * You will probably want to use helper functions here, as described in the lecture recordings
     * (ex. merge(), a helper mergesort function)
     * @param arr
     */
    public static void mergeSort(CompareInt[] arr) {
        //TODO

        int i = 0;
        int j = arr.length-1;
        mergeSort1(arr, i, j);
    }

    public static void mergeSort1(CompareInt[] arr, int i, int j){
        if(i<j){
            int mid = i+ (j-i)/2;
            mergeSort1(arr, i, mid);
            mergeSort1(arr, mid+1, j);

            CompareInt[] newArr = new CompareInt[(mid - i+1)];
            int y=i;
            for(int x =0; x<mid-i+1;){
                newArr[x++] = arr[y++];
            }


            int leftPt, rightPt, newArrPter;
            rightPt = mid+1;
            newArrPter = 0;
            leftPt = i;
            while (newArrPter <= mid-i && rightPt <=j){
                if(newArr[newArrPter].compareTo(arr[rightPt])<=0){
                    arr[leftPt++] = newArr[newArrPter++];
                }
                else{
                    arr[leftPt++] = arr[rightPt++];

                }
            }
            while(newArrPter <= mid -i) {
                arr[leftPt++] = newArr[newArrPter++];
            }
        }
    }

    /**
     * Implement the quickSelect
     *
     * Again, you will probably want to use helper functions here
     * (ex. partition(), a helper quickselect function)
     */
    public static CompareInt quickSelect(int k, CompareInt[] arr) {
        //TODO
        return recursive(arr, 0, arr.length-1, k);
    }

    public static CompareInt recursive(CompareInt[] array, int left, int right, int n) {
        if (left == right) { // If the list contains only one element,
            return array[left]; // return that element
        }

        // select a pivotIndex between left and right
        int pivotIndex = randomPivot(left, right);
        pivotIndex = partition(array, left, right, pivotIndex);
        // The pivot is in its final sorted position
        if (n == pivotIndex) {
            return array[n];
        } else if (n < pivotIndex) {
            return recursive(array, left, pivotIndex - 1, n);
        } else {
            return recursive(array, pivotIndex + 1, right, n);
        }
    }

    public static int partition(CompareInt[] array, int left, int right, int pivotIndex) {
        CompareInt pivotValue = array[pivotIndex];
        swap(array, pivotIndex, right); // move pivot to end
        int storeIndex = left;
        for(int i = left; i < right; i++) {
            if(array[i].compareTo(pivotValue)<0) {
                swap(array, storeIndex, i);
                storeIndex++;
            }
        }
        swap(array, right, storeIndex); // Move pivot to its final place
        return storeIndex;
    }

    public static void swap(CompareInt[] array, int a, int b) {
        CompareInt tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    public static int randomPivot(int left, int right) {
        return left + (int) Math.floor(Math.random() * (right - left + 1));
    }

}

