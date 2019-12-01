/**
* @file LinkList.java
*/

/**
 * @brief : Defining linked-list operations
 * @param <T> : generic Type
 */
public class LinkList<T> {
    
    private Node<T> front;
    private Node<T> rear;
    /**
     * @brief add element at the beginning of the queue
     * @param item : item to be inserted at front of linked list
     */
    public void insertFront(T item){
        //add element at the beginning of the queue
        System.out.println("adding at front: "+item);
        Node<T> nd = new Node<T>();
        nd.setValue(item);
        nd.setNext(front);
        if(front != null) front.setPrev(nd);
        if(front == null) rear = nd;
        front = nd;
    }
    /**
     * @brief add element at the end of the queue
     * @param item : item to be inserted at end 
     */
    public void insertRear(T item){
        //add element at the end of the queue
        System.out.println("adding at rear: "+item);
        Node<T> nd = new Node<T>();
        nd.setValue(item);
        nd.setPrev(rear);
        if(rear != null) rear.setNext(nd);
        if(rear == null) front = nd;
         
        rear = nd;
    }

    /**
     * @brief removes an item from Front and updates front
     */
    public void removeFront(){
        if(front == null){
            System.out.println("Deque underflow!! unable to remove.");
            return;
        }
        //remove an item from the beginning of the queue
        Node<T> tmpFront = front.getNext();
        if(tmpFront != null) tmpFront.setPrev(null);
        if(tmpFront == null) rear = null;
        System.out.println("removed from front: "+front.getValue());
        front = tmpFront;
    }

    /**
     * @brief removes an item from rear and updates rear
     */
    public void removeRear(){
        if(rear == null){
            System.out.println("Deque underflow!! unable to remove.");
            return;
        }
        //remove an item from the beginning of the queue
        Node<T> tmpRear = rear.getPrev();
        if(tmpRear != null) tmpRear.setNext(null);
        if(tmpRear == null) front = null;
        System.out.println("removed from rear: "+rear.getValue());
        rear = tmpRear;
    }
     /**
      * 
      * Entry Point of program
      */
    public static void main(String a[]){
        LinkList<Integer> deque = new LinkList<Integer>();
        deque.insertFront(34);
        deque.insertFront(67);
        deque.insertFront(29);
        deque.insertFront(765);
        deque.removeFront();
        deque.removeFront();
        deque.removeFront();
        deque.insertRear(43);
        deque.insertRear(83);
        deque.insertRear(84);
        deque.insertRear(546);
        deque.insertRear(356);
        deque.removeRear();
        deque.removeRear();
        deque.removeRear();
        deque.removeRear();
        deque.removeFront();
        deque.removeFront();
        deque.removeFront();
    }
}
/**
 * @brief : Defining Node class
 * @param <T> : generic type
 */
class Node<T>{
     
    private Node<T> prev;
    private Node<T> next;
    private T value;
    
    /**
     * @brief Get previous node
     * @return previous Node
     */
    public Node<T> getPrev() {
        return prev;
    }
    /**
     * @brief Sets 'prev' member variable
     * @param prev : Node to be set as prev
     */
    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }
    /**
     * @brief Get next node
     * return next Node
     */
    public Node<T> getNext() {
        return next;
    }
    /**
     * @brief Sets 'next' member variable
     * @param next : node to be set as next
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }
    /**
     * @brief returns value of Node
     * @return value
     */
    public T getValue() {
        return value;
    }
    /**
     * @brief sets value of Node
     * @param value : to be set in member variable 'value'
     */
    public void setValue(T value) {
        this.value = value;
    }
}