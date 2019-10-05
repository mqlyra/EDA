public class LinkedList {


    private Node head;

    public LinkedList() {
        this.head = null;
    }

    private boolean isEmpty() {
        return this.head == null;
    }

    public int size(){
        int total = 0;
        if (!isEmpty())
            total = size(head) ;

        return total;
    }

    private int size(Node node){
        int total = 1;
        if(node.next != null)
            total = 1 + size(node.next);

        return total;
    }

    public int soma() {

        return this.head.value;
    }

    private int soma(Node node) {
        if(node == null) {
            return 0;
        } else {
            return node.value + soma(node.next);
        }
    }

    public boolean isSorted() {

        return this.isSorted(head);
    }

    private boolean isSorted(Node node) {
        boolean isSorted = true;

        if(!isEmpty())
            if (node.value > node.next.value )
                return false;
            else
                isSorted(node.next);

        return isSorted;
    }


    public void addLast(int elemento) {
        if (isEmpty()) {
            this.head = new Node(elemento);
        } else {
            this.addLast(this.head, elemento);
        }
    }

    private void addLast(Node node, int elemento) {

        if (node.next == null) {
            Node newNode = new Node(elemento);
            node.next = newNode;
            newNode.previous = node;
            return;
        } else {
            addLast(node.next, elemento);
        }
    }

    public void add(int index, int elemento){
        Node node = new Node(elemento);

        if (index >= 0 && index < size()) {
            if (index == 0) {
                node.next = head;
                this.head.previous = node;
                this.head = node;

            } else {
                Node aux = this.head;

                for (int i = 0; i < index - 1; i++) {
                    aux = aux.next;
                }

                node.next = aux.next;
                aux.next = node;
                node.next.previous = node;
                node.previous = aux;

            }
        }
    }

    public void remove(int index){
        if (index >= 0 && index < size()) {

            Node aux = this.head;

            for (int i = 0; i < index - 1; i++) {
                aux = aux.next;
            }

            aux.previous.next = aux.next;
            aux.next.previous = aux.previous;

        }
    }


}