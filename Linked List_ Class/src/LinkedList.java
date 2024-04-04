public class LinkedList {
    Node head;
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            next = null;
        }
    }
    static LinkedList insert(int data, LinkedList list){
        Node temp = new Node(data);
        if(list.head==null){
            list.head = temp;
        } 
         
        else{
            Node trav = list.head;
            while(trav.next!=null){
                trav = trav.next;
            }
            trav.next= temp;
        }
        return list;
    }

    static void delete(LinkedList list, int index){
        if(list.head == null){
            return;
        }
        else{
            Node temp = list.head;
            for(int i=0;i<index-1;i++){
                temp = temp.next;
            }
            if(temp.next.next!=null){
                temp.next = temp.next.next;
            }
            else{
                temp.next = null;
            }
        }
    }
}
