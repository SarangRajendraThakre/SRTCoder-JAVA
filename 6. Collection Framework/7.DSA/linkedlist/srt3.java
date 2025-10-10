import java.util.LinkedList;

public class srt3{
    static Node head;
    
    static class Node{
        int data;
         Node next;
         Node(int d){
            data = d;
            next =null;

         }
    }

   Node reverse(Node node){

     Node next = null;
     Node current = node;
     Node previous = null;

     while(current != null){
      next=current.next;
      current.next=previous;
      previous=current;
      current=next;
     }
     node=previous;
   return node;

     

   }
   

   void printlist(Node node){
      while(node != null)
      {
         System.out.println(node.data+" ");
         node=node.next;
      }
   }
   public static void main(String[] args) {
      srt3 list = new srt3();
      list.head = new Node(85);
      list.head.next=new Node(15);
      list.head.next.next = new Node(4);
      list.head.next.next.next=new Node(20);

      System.out.println("Given linked list");
      list.printlist(head);
      head=list.reverse(head);
      System.out.println("");
      System.out.println("reversed linked list");
      list.printlist(head);
   }
}