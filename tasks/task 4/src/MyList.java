public interface MyList<T> {

    void addFirst(T data);
    void addLast(T data);

    boolean remove(T data);
    boolean contains(T data);

    boolean isEmpty();
    int size();

    boolean isPalindrome();
    void reverse();

    void print();
}