public class Array<T> {

    private T[] items;
    private int count;
    private int size;

    @SuppressWarnings("unchecked")
    public Array(int size) {
        this.items = (T[]) new Object[size];
        this.count = 0;
        this.size = size;
    }

    public boolean isFull() {
        return count == items.length;
    }

    public boolean append(T newValue) {
        if (!isFull()) {
            items[count++] = newValue;
           return true;
        } else {
           return false;
        }
    }

    public void traverse() {
        System.out.print("[");
        for (int i = 0; i < count; i++) {
            System.out.print(items[i]);
            System.out.print(i < count - 1 ? "," : "");
        }
        System.out.println("]");
    }

    public int search(T wantedValue) {
        for (int i = 0; i < count; i++) {
            if (items[i].equals(wantedValue))
                return i;
        }
        return -1;
    }

    public int getCount() {
        return count;
    }

    public boolean deleteByPosition(int pos) {
        if (pos >= count || pos < 0) {
            return false;
        }

        for (int i = pos; i < count - 1; i++) {
            items[i] = items[i + 1];
        }

        items[count - 1] = null;
        count--;
        return true;
    }

    public boolean insert(T newValue, int pos) {
        if (isFull()) {
            return false;
        }

        if (pos < 0 || pos > count) {
            return false;
        }

        for (int i = count; i > pos; i--) {
            items[i] = items[i - 1];
        }

        items[pos] = newValue;
        count++;
    return true;
    }

    public int getSize() {
        return size;
    }

    public Array<T> merge(Array<T> newArray) {
        Array<T> mergedArray = new Array<>(this.count + newArray.getCount());

        for (int i = 0; i < this.count; i++) {
            mergedArray.append(this.items[i]);
        }

        for (int i = 0; i < newArray.getCount(); i++) {
            mergedArray.append(newArray.items[i]);
        }

        return mergedArray;
    }

    public Array<T> enlarge(int newSize) {
        if (newSize > size) {
            Array<T> enlargedArray = new Array<>(newSize);
            for (int i = 0; i < count; i++) {
                enlargedArray.append(this.items[i]);
            }
            return enlargedArray;
        } else {
//            System.out.println("You have to insert size more than " + size);
            return this;
        }
    }
}
