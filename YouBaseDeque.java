/**
 * This program provides an implementation of the Deque interface
 * and demonstrates it.  This program also relies on Node.java.
 *
 * @author David You, Acuna
 * @version 1/21/19
 */
import java.util.NoSuchElementException;

//TODO: implement.
public class YouBaseDeque<Item> implements Deque<Item> {

    private Node<Item> front;
    private Node<Item> back;
    private int n=0;

    public YouBaseDeque(){
        front = null;
        back = null;
    }

    public void enqueueFront (Item element){
        Node<Item> newNode = new Node<>(element);
        if (isEmpty()==true){  //special instructions if you're adding to an empty list
            newNode.setNext(null);
            newNode.setBack(null);
            newNode.setData(element);
            n++;
            front = newNode;
            back = newNode;
        }else{
            newNode.setNext(front);
            newNode.setBack(null);
            newNode.setData(element);
            n++;
            if (front != null){
                front.setBack(newNode);
            }
            front = newNode;
        }
    }

    public void enqueueBack(Item element){
        Node<Item> newNode = new Node<>(element);
        // handle a case where you're adding to an empty list
        if (isEmpty()==true){
            newNode.setData(element);
            n++;
            front = newNode;
            back = newNode;
        }else{
            newNode.setData(element);
            n++;
            newNode.setNext(null);
            newNode.setBack(back);
            back.setNext(newNode);
            back = newNode;
        }
    }

    public Item dequeueFront(){
        if (isEmpty()==true){
            throw new NoSuchElementException();
        }
        //handle a case where the list has only one node.
        if (n == 1){
            front = null;
            back = null;
            n=0;
            return null;
        }else{
            Node<Item> temp = front.getNext();
            n--;
            Item temp1 = front.getData();
            front.setNext(null);
            temp.setBack(null);
            front = temp;
            return temp1;
        }

    }

    public Item dequeueBack(){
        if (isEmpty()==true){
            throw new NoSuchElementException();
        }
        //handle a case where the list has only one node.
        if (n == 1){
            front = null;
            back = null;
            n=0;
            return null;
        }else{
            Node<Item> temp = back.getBack();
            n--;
            Item temp1 = back.getData();
            back.setBack(null);
            temp.setNext(null);
            back = temp;
            return temp1;
        }
    }

    public Item first(){
        if (isEmpty()==true){
            throw new NoSuchElementException();
        }
        return front.getData();
    }

    public Item last (){
        if (isEmpty()==true){
            throw new NoSuchElementException();
        }
        return back.getData();
    }

    public boolean isEmpty(){
        if (front == null){
            return true;
        }else{
            return false;
        }
    }

    public int size(){
        return n;
    }

    public String toString(){
        String output = "";
        Node<Item> temp;
        temp = back;
        int temp1 = size();
        while (temp1>0){
            output += temp.getData() + " ";
            temp = temp.getBack();
            temp1--;
        }
        return output;
    }

    /**
     * Program entry point for deque.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        YouBaseDeque<Integer> deque = new YouBaseDeque<>();

        //standard queue behavior
        deque.enqueueBack(3);
        deque.enqueueBack(7);
        deque.enqueueBack(4);
        deque.dequeueFront();
        deque.enqueueBack(9);
        deque.enqueueBack(8);
        deque.dequeueFront();
        System.out.println("size: " + deque.size());
        System.out.println("contents:\n" + deque.toString());

        //deque features
        System.out.println(deque.dequeueFront());
        deque.enqueueFront(1);
        deque.enqueueFront(11);
        deque.enqueueFront(3);
        deque.enqueueFront(5);
        System.out.println(deque.dequeueBack());
        System.out.println(deque.dequeueBack());
        System.out.println(deque.last());
        deque.dequeueFront();
        deque.dequeueFront();
        System.out.println(deque.first());
        System.out.println("size: " + deque.size());
        System.out.println("contents:\n" + deque.toString());
    }
}