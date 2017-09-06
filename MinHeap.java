

public class MinHeap {

    CompareInt[] heap;
    int size;

    /**
     * Constructs a new heap with maximum capacity n
     * Remember to index your heap at 1 instead of 0!
     * @param n the maximum number of elements allowed in the heap
     */
    public MinHeap(int n) {
        heap = new CompareInt[n+1];
        size = 0;
    }

    /**
     * Adds an element to the heap
     *
     * @param val the value to be added to the heap
     */
    public void add(CompareInt val) {

        //if(heap==null) return;
        if(heap.length==size+1)
            throw new IllegalArgumentException();

        size++;

        heap[size]=val;
        swim2(heap,size);



        /*
        int i;
        for(i=1;i<=size;i++){
            if(val.compareTo(heap[i])<0) break;
        }

        if(i<=size){
        sink(heap,i,size);
        }
        heap[i]=val;
        size++;
        */

        /*
        if(heap.length==size+1)
            throw new IllegalArgumentException();
        heap[size+1]=val;
        size++;
        Sorting.mergeSort1(heap,1,size);
        */
    }

    /**
     * Extracts the smallest element from the heap
     */
    public CompareInt extractMin() {
        /*
        CompareInt res=new CompareInt(heap[1].val);
        swim(heap,1,size);
        size--;
        return res;
        */
        CompareInt res=new CompareInt(heap[1].val);
        heap[1]=heap[size--];
        sink1(heap,1);
        return res;


        /*
        CompareInt res=new CompareInt(heap[1].val);
        CompareInt temp=new CompasreInt(Integer.MAX_VALUE);
        heap[1]=temp;
        Sorting.mergeSort1(heap,1,size);
        size--;
        return res;
        */

    }


    public void sink1(CompareInt[] arr,int i){
        int smallest;
        while(2*i<=size){
            smallest=2*i;
            if(2*i+1<=size && arr[2*i+1].compareTo(arr[2*i])<0) smallest=2*i+1;
            if(arr[i].compareTo(arr[smallest])<0) break;
            swap(arr,i,smallest);
            i=smallest;
        }
    }
    public void swap(CompareInt[] arr,int i,int j){
        CompareInt temp=new CompareInt(heap[i].val);
        arr[i]=arr[j];
        arr[j]=temp;
    }



    public void sink(CompareInt[] arr,int i,int j){
        for(int k=j+1;k>i;k--){
            arr[k]=arr[k-1];
        }

    }
    public void swim(CompareInt[] arr,int i,int j){
        for(int k=i;k<j;k++){
            arr[k]=arr[k+1];
        }

    }

    public void swim2(CompareInt[] arr,int i){
        while(i>1 && arr[i/2].compareTo(arr[i])>0){
            swap(arr,i,i/2);
            i=i/2;
        }

    }

}
