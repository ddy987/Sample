/*
 * This program is for the creation of the Node object for use in the BaseDeque.java program.
 *
 * @author David you
 * @version 12/21/19
 */
public class Node<Input> {
    private Node<Input> next;
    private Node<Input> back;
    private Input data;

    public Node() {
        next = null;
        back = null;
        data = null;
    }

    public Node (Input user_data){
        data = user_data;
        next = null;
        back = null;
    }

    public Node<Input> getNext(){
        return next;
    }

    public Node<Input> getBack(){
        return back;
    }

    public void setNext (Node<Input> node){
        next = node;
    }

    public void setBack (Node<Input> node){
        back = node;
    }

    public Input getData(){
        return data;
    }

    public void setData(Input user_data){
        data = user_data;
    }

}
