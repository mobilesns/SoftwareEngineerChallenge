package paypay.sechallenge.source;

/*
 * The interface of immutable stack.
 * An push or pop will not alter the old stack
 * and will return a new stack.
 * After an push or pop both the old stack and the new stack exist. 
 */
public interface Stack<T> {
    /*
     * Pushes the element into this stack 
     * and returns the new stack. 
     *
     * @param t the element to push onto this stack.
     * @ return the new immutable stack after pushing the element.
     */
    public Stack<T> push(T t);

    /*
     * Pops the element at the top of this stack
     * and returns the new stack.
     *
     * @return the new stack after popping the top element.
     * @throws EmptyStackException if this stack is empty.
     */
    public Stack<T> pop();


    /*
     * Looks at the element at the top of this stack
     * without removing it from the stack.
     *
     * @return the element at the top of this stack,
     * null if the stack is tempty.
     */
    public T peek();

    /*
     * Test if this stack is empty.
     *
     * @return true if this stack contains no elements, 
     * false otherwise.
     */
    public boolean isEmpty();
}
