package paypay.sechallenge.source;

//import paypay.sechallenge.source.Stack;

/*
 * The implementation of immutable stack.
 * An push or pop will not alter the old stack
 * and will return a new stack.
 * After an push or pop both the old stack and the new stack exist. 
 *
 * Stacks are linked by the tail member.
 * A push or pop will not copy elements of the stack so that memory can be saved.
 */
public class ImmutableStack<T> implements Stack<T> {
    /*
     * The top element of this immutable stack.
     */
    private T head;
    /*
     * The tail immutable stack of this immutable stack.
     */
    private Stack<T> tail;

    /*
     * The singleton empty ImmutableStack.
     */
    public static final Stack EMPTY = new ImmutableStack();

    /*
     * Constructs a new ImmutableStack passing no arguments
     */
    private ImmutableStack() {}
    
    /*
     * Constructs a new ImmutableStack.
     *
     * @param head the top element.
     * @param tail the tail immutable stack.
     */
    private ImmutableStack(T head, Stack<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    /*
     * Pushes the element into this immutable stack 
     * and returns the new immutable stack. 
     *
     * @param t the element to push onto this immutable stack.
     * @ return the new immutable stack after pushing the element.
     */
    public Stack<T> push(T t) {
        return new ImmutableStack<T>(t, this);
    }

    /*
     * Pops the element at the top of this immutable stack
     * and returns the new immutable stack.
     *
     * @return the new immutable stack after popping the top element.
     * @throws EmptyStackException if this immutable stack is empty.
     */
    public Stack<T> pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("The stack is empty.");
        }
        return tail;
    }

    /*
     * Looks at the element at the top of this immutable stack
     * without removing it from the stack.
     *
     * @return the element at the top of this immutable stack,
     * null if the stack is tempty.
     */
    public T peek() {
        return head;
    }
    
    /*
     * Test if this immutable stack is empty.
     *
     * @return true if this immutable stack contains no elements, 
     * false otherwise.
     */
    public boolean isEmpty() {
        return this == EMPTY;
    }
}
