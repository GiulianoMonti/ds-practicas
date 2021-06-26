package giulian.LinkedList;

class MyLinkedList {
    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private int size;



    /** Initialize your data structure here. */
    public MyLinkedList() {
        size = 0 ;
        head= null;

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index==0){
            return head.val;
        }else if(index>=size){
            return -1;
        }

        Node current = head;

        while(index-->0){
            current = current.next;
        }
        return current.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next=head;
        head=newNode;
        size++;

    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node newNode = new Node(val);


        if(size==0){
            addAtHead(val);
        }
        Node curr = head;

        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
        newNode.next = null;
        size++;

    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        Node newNode = new Node(val);
        if (index ==size){
            addAtTail(val);
            return;
        }else if (index==0){
            addAtHead(val);
            return;
        }else{
            Node tempNode = head;
            int i = 0;
            while (i < index - 1) {
                tempNode = tempNode.next;
                i++;
            }
            newNode.next = tempNode.next;
            tempNode.next = newNode;



        }
        size++;



    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index > size) {
            System.out.println("index is greater than size");
            return;}

        else if(index==0){
            head=head.next;
            size--;
            return;
        }else  if (index < 0 || index >= this.size) {
            return;
        }else{

            Node curr = head;
            int i = 0 ;
            while(i<index-1){
                curr=curr.next;
                i++;
            }
            curr.next = curr.next.next;
            size--;


        }

    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */