public class file {
    public static void main(String[] args) {
        int[] arr = { 2, 24253, 5, 54, 3, 2, 4, 7, 3, };
        int size = arr.length / 5;
        Cthread c1 = new Cthread(arr, 0, size);
        Cthread c2 = new Cthread(arr, size, 2 * size);
        Cthread c3 = new Cthread(arr, size * 2, 3 * size);
        Cthread c4 = new Cthread(arr, size * 3, 4 * size);
        Cthread c5 = new Cthread(arr, size * 4, 5 * size);
        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
        

    }

}

class Cthread extends Thread {
    public int[] arr;
    public int start;
    public int end;

    public Cthread(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        for (int i = start; i < end; i++) {
            System.out.println(arr[i]);
        }
    }
}