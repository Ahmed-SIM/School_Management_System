public class SLL<T> {
    private Node<T> head;
    private Node<T> tail;

    public SLL() {
        head = null;
        tail = null;
    }

    public void traverse() {
        int i = 0;
        if (head == null) {
            System.out.println("The list is empty");
        } else {
            Node<T> temp = head;
            while (temp != null) {
                System.out.println("The item number " + i + " : " + temp.data); // index by 0
                temp = temp.next;
                i++;
            }
        }
    }

    // return if the list is empty
    public boolean isEmpty() {
        return (head == null);
    }

    // add at the end
    public void Append(T data) {
        Node<T> nw = new Node<>(data);
        if (head == null) {
            head = tail = nw;
        } else {
            tail.next = nw;
            tail = nw;
        }
    }
    // Add at beginning
    public void addFirst(T data) {
        Node<T> nd = new Node<>(data);

        if (head == null) {
            head = tail = nd;
            return;
        }

        nd.next = head;
        head = nd;
    }
    // add at position
    public boolean insert(int index, T data) {
        if (index < 0) return false;

        if (index == 0) {
            addFirst(data);
            return true;
        }

        Node<T> temp = head;
        for (int i = 0; i < index - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) return false;

        Node<T> nd = new Node<>(data);
        nd.next = temp.next;
        temp.next = nd;

        if (nd.next == null) {
            tail = nd;
        }

        return true;
    }
    // return number of nodes
    public int count() {
        int result = 0;
        if (head == null) {
            return result;
        } else {
            Node temp = head;
            while (temp != null) {
                result++;
                temp = temp.next;
            }
        }
        return result;
    }

    // delete the data
    public boolean delete(T data) {
        if (isEmpty()) {
            System.out.println("The list is empty");
            return false;
        }
        if (head.data == data) {
            head = head.next;
            return true;
        }
        Node<T> temp = head;
        while (temp.next != null && temp.next.data != data) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("The data not found");
            return false;
        }
        temp.next = temp.next.next;
        return true;
    }
// search items
    public boolean search(T d) {
        boolean exist = false;
        if (head == null) return exist;
        Node<T> temp = head;
        while (temp != null) {
            if (temp.data == d) {
                exist = true;
                break;
            }
            temp = temp.next;
        }
        return exist;
    }

}
