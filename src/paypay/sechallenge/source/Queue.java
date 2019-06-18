package paypay.sechallenge.source;

/*
 * The interface of immutable queue.
 * An enqueue or dequeue will not alter the old queue 
 * and will return a new queue.
 * After an enqueue or dequeue both the old queue and the new queue exist. 
 */
public interface Queue<T> {
    /*
     * Adds the element to the end of this queue
     * and return the new queue.
     *
     * @param t the element to add.
     * @return the new queue after adding the element.
     */
    public Queue<T> enQueue(T t);

    /*
     * Removes the element at the beginning of this queue 
     * and returns the new queue.
     *
     * @return the new queue after removing the head element.
     * @throws EmptyStackException if this queue is empty.
     */
    public Queue<T> deQueue();

    /*
     * Looks at the element at the beginning of this queue 
     * without removing it from the queue.
     *
     * @return the element at the beginning of this queue,
     * null if the queue is tempty.
     */
    public T head();

    /*
     * Test if this queue is empty.
     *
     * @return true if this queue contains no elements, 
     * false otherwise.
     */
    public boolean isEmpty();
}
