//Tashnim Khan Ishika 
//CS 300

public class LinkedStack<E> {
    private Node<E> top;

    public void push(E toPush) {
        top = new Node<>(toPush, top);
    }

    public E pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        E value = top.value();
        top = top.next();
        return value;
    }

    public boolean isEmpty() {
        return top == null;
    }

    private record Node<E>(E value, Node<E> next) {}
}
