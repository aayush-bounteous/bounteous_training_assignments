// 4. Linked Lists
// Add Two Numbers
// You are given two non-empty linked lists representing two non-negative integers. Add the two numbers and return the sum as a linked list.

public class q4 {
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

    static int count = 0;

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

    public node sumll(q4 l1, q4 l2) {

        node p1 = l1.head;
        node p2 = l2.head;
        node dummy = new node(0);
        node curr=dummy;
        int carry = 0;

        while (p1 != null || p2 != null || carry !=0) {
            int x=0;
            int y=0;
            if(p1!=null){
                x=p1.data;
            }
            if(p2!=null){
                y=p2.data;
            }
            int sum = x+ y + carry;
            carry=sum/10;
            int digit=sum%10;
            curr.next= new node(digit);
            curr= curr.next;

            if(p1!=null)p1=p1.next;
            if(p2!=null)p2=p2.next;
        }
        return dummy;
        
    }

    public static void main(String[] args) {
        q4 ll1 = new q4();
        ll1.add(6);
        ll1.add(3);
        ll1.add(9);
        ll1.display();
        q4 ll2 = new q4();
        ll2.add(9);
        ll2.add(9);
        ll2.add(2);
        ll2.display();

        q4 res=new q4();
        res.head=res.sumll(ll1,ll2);

        System.out.println("SUM :");
        res.display();

    }
}
