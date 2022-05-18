import java.util.Arrays;

public class Array {
    private int capacity;
    private String[] elements;
    private int length;

    // CONSTRUCTORS

    public Array() {
        this.capacity = 10;
        this.elements = new String[this.capacity];
        this.length = 0;
    }

    public Array(int n) {
        this.capacity = n;
        this.elements = new String[this.capacity];
        this.length = 0;
    }

    public Array(String[] elements) {
        this.capacity = elements.length;
        this.elements = new String[this.capacity];
        this.elements = elements;
        this.length = this.capacity;
    }

//    public Array(int capacity, String[] elements) {
//        this.capacity = capacity;
//        this.elements = new String[this.capacity];
//        this.elements = elements;
//        this.length = this.capacity;
//    }

    // METHODS

    public Array getArray() {
        return this;
    }

    public String getAnElement(int i) {
        if(i < this.length) {
            return elements[i];
        } else {
            return "out of index";
        }
    }

    public void add(String element) {
        if (this.length >= this.capacity) {
            this.capacity = this.capacity + 10;
            String[] temp = this.elements.clone();
            this.elements = new String[this.capacity];
            System.arraycopy(temp, 0, this.elements, 0, temp.length);
        }
        this.elements[this.length++] = element;
    }

    public void add(int i, String element) {
        if (this.length >= this.capacity) {
            this.capacity = this.capacity + 10;
            String[] temp = this.elements.clone();
            this.elements = new String[this.capacity];
            System.arraycopy(temp, 0, this.elements, 0, temp.length);
        }
//        this.elements[this.length++] = element;
        for (int k=this.length-1; k>=i; k--) {
            this.elements[k+1] = this.elements[k];
        }
        this.elements[i] = element;
        this.length++;
    }

    public void remove(String element) {
        for(int i=0; i<this.length; i++) {
            if(this.elements[i].equals(element)) {
                for(int j=i; j<this.length-1; j++) {
                    this.elements[j] = this.elements[j+1];
                }
                this.elements[--length] = null;
            }
        }
    }

    public int[] findIndex(String element) {
        int[] indices = new int[0];

        for(int i=0; i<this.length; i++) {
            if(this.elements[i].equals(element)) {
                int[] temp = indices.clone();
                indices = new int[indices.length+1];
                System.arraycopy(temp,0,indices,0,temp.length);
                indices[indices.length-1] = i;
            }
        }

        return indices;
    }

    public Array subArray(int start, int end) {
        if(start >= this.length || end >= this.length || start >= end) {
            return null;
        } else {
            Array array = new Array(end-start+1);
            for (int i=start; i<end; i++) {
                array.elements[array.length++] = this.elements[i];;
            }
            return array;
        }
    }

    public void merge(Array a1, Array a2) {
        this.capacity = a1.length + a2.length;
        this.elements = new String[this.capacity];
        this.length = 0;

        int i=0, j=0;
        while (length < capacity) {
            if ((j >= a2.length) || (a1.elements[i].compareTo(a2.elements[j]) < 0)) {
                this.elements[length++] = a1.elements[i++];
            } else {
                this.elements[length++] = a2.elements[j++];
            }
        }

//        int i=0, j=0;
//        while (length < capacity) {
//            if (i >= a1.length) {
//                this.elements[length++] = a2.elements[j++];
//            } else if (j >= a2.length) {
//                this.elements[length++] = a1.elements[i++];
//            } else if (a1.elements[i].compareTo(a2.elements[j]) < 0) {
//                this.elements[length++] = a1.elements[i++];
//            } else if (a1.elements[i].compareTo(a2.elements[j]) >= 0){
//                this.elements[length++] = a2.elements[j++];
//            }
//        }
    }

    public int length() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

//    public String[] getElements() {
//        return this.elements;
//    }

//    @Override
//    public String toString() {
//        return "Array{" +
//                "capacity=" + capacity +
//                ", elements=" + Arrays.toString(elements) +
//                ", length=" + length +
//                '}';
//    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(this.elements,0,length))
                + " length = "
                + this.length;
    }
}
