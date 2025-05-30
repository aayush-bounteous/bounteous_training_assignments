public class q6 {
    class node {

        int data;
        node next;

        public node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public node head;

    public void add(int data) {
        node newnode = new node(data);
        if (head == null) {
            head = newnode;
            return;
        }
        node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newnode;
    }

     public void display() {
        if (head == null)
            return;
        node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }


    public void deletenode(int lastnode) {
    if (head == null) {
        System.out.println("Empty list");
        return;
    }

    int length = 0;
    node temp = head;
    while (temp != null) {
        length++;
        temp = temp.next;
    }

    if (lastnode > length || lastnode <= 0) {
        System.out.println("Node does not exist");
        return;
    }

    if (lastnode == length) {
        head = head.next;
        return;
    }

    // Step 4: Traverse to the node before the one to delete
    int targetIndex = length - lastnode;
    node current = head;
    for (int i = 1; i < targetIndex; i++) {
        current = current.next;
    }

    // Step 5: Delete the node
    if (current.next != null) {
        current.next = current.next.next;
    }
}
    
    public static void main(String[] args) {
        q6 ll = new q6();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(6);
        ll.add(7);
        ll.add(8);
        ll.display();
        ll.deletenode(3);
        ll.display();
    }
}
