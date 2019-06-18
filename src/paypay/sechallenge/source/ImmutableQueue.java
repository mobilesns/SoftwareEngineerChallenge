package paypay.sechallenge.source;

/*
 * The implemention of immutable queue.
 * An enqueue or dequeue will not alter the old queue 
 * and will return a new queue.
 * After an enqueue or dequeue both the old queue and the new queue exist. 
 *
 * The immutable queue is implemented with 2 immutable stacks.
 * To enqueue an element just push it onto the back stack.
 * To dequeue an element just pop the top element from the front stack.
 * If the front stack is empty pop all elements from the back stack and push them onto the front stack.
 */
public class ImmutableQueue<T> implements Queue<T> {
    /*
     * THe front immutable stack;
     */
    Stack<T> front;
    /*
     * THe back immutable stack;
     */
    Stack<T> back; 

    /*
     * The singleton empty ImmutableQueue.
     */
    public static final ImmutableQueue EMPTY = 
            new ImmutableQueue(ImmutableStack.EMPTY, ImmutableStack.EMPTY);

    /*
     * Constructs a new ImmutableQueue.
     *
     * @param front the front immutable stack.
     * @param back  the back immutable stack.
     */
    private ImmutableQueue(Stack<T> front, Stack<T> back) {
        this.front = front;
        this.back = back;
    }

    /*
     * Adds the element to the end of this immutable queue
     * and return the new queue.
     *
     * @param t the element to add.
     * @return the new immutable queue after adding the element.
     */
    public Queue<T> enQueue(T t) {
        back = back.push(t);
        return new ImmutableQueue(front, back);
    }

    /*
     * Removes the element at the beginning of this immutable queue 
     * and returns the new queue.
     *
     * @return the new stack after removing the head element.
     * @throws EmptyStackException if this immutable queue is empty.
     */
    public Queue<T> deQueue() {
        if (front.isEmpty()) {
            if (back.isEmpty()) {
                throw new NoSuchElementException("The queue is empty."); 
            } else { 
                reverse();
            }
        }
        front = front.pop();
        return new ImmutableQueue(front, back);
    }

    /*
     * Looks at the element at the beginning of this immutable queue 
     * without removing it from the queue.
     *
     * @return the element at the beginning of this immutable queue,
     * null if the queue is tempty.
     */
    public T head() {
        if (front.isEmpty() && !back.isEmpty()) {
            reverse();
        }
        return front.peek();
    }

    /*
     * Test if this immutable queue is empty.
     *
     * @return true if this immutable queue contains no elements, 
     * false otherwise.
     */
    public boolean isEmpty() {
        return front.isEmpty() && back.isEmpty();
    }

    private void reverse() {
        while (!back.isEmpty()) {
            front = front.push(back.peek());
            back = back.pop();
        }
    }
}
