public class MyLinkedListDriver {
    public static void main(String[] args) {

        System.out.println("--- Testing MyLinkedList ---");
        MyLinkedList<Integer> list = new MyLinkedList<>();

        // Test adding elements
        list.add(100);
        list.add(200);
        list.add(300);
        list.add(400);
        list.add(500);

        System.out.println(list);

         
        
        // System.out.println("Initial List: " + list);
        // System.out.println("Initial Size: " + list.size());
        
        // // Test adding at a specific index
        // list.add(2, 777);
        // System.out.println("\nList after adding 777 at index 2: " + list);
        
        // // Test adding at the beginning
        // list.addFirst(50);
        // System.out.println("List after addFirst(50): " + list);
        
        // // Test removing at a specific index
        // System.out.println("\nRemoving element at index 3: " + list.remove(3)); // removes 200
        // System.out.println("List after removing index 3: " + list);
        
        // // Test getting an element
        // System.out.println("\nElement at index 4 is: " + list.get(4)); // should be 500
        
        // // Test setting an element
        // list.set(0, 99); // change 50 to 99
        // System.out.println("List after setting index 0 to 99: " + list);
        
        // System.out.println("\nFinal List: " + list);
        // System.out.println("Final Size: " + list.size());

        // // list.clear();
        // System.out.println(list);
        // System.out.println(list.contains(100));

        







    }
}