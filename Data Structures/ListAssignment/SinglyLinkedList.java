public class SinglyLinkedList {
    public Node head;
    public SinglyLinkedList() {
        // your code here
        this.head=null;
    }
    // SLL methods go here. As a starter, we will show you how to add a node to the list.
    public void add(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = newNode;
        } else {
            Node runner = head;
            while(runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
    } 
    
    public void remove(){
        Node runner = head;
        while(head.next!=null){
            runner=runner.next;
        }
        runner=null;
    }

    public void remove(int index)
    {
        // If linked list is empty
        if (head == null){
            return;
        }
        // Store head node
        Node temp = head;
        // If head needs to be removed
        if (index == 0) {
            head = temp.next; // Change head
            return;
        }
        // Find previous node of the node to be deleted
        for (int i = 0; temp != null && i < index - 1;i++){
            temp = temp.next;
        }
        // If position is more than number of nodes
        if (temp == null || temp.next == null){
            return;
        }
        // Node temp->next is the node to be deleted
        // Store pointer to the next of node to be deleted
        Node next = temp.next.next;
        temp.next= next; // Unlink the deleted node from list
    }

    public void printValues()
    {
        Node tnode = head;
        while (tnode != null) {
            System.out.print(tnode.value + " ");
            tnode = tnode.next;
        }
    }

}