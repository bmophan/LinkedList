package alinkedlist;

public class Main {
    public static void main(String[] args) {
        var list = new ALinkedList();
        
        list.inputList();
        list.display("Your list: ");
        
        var bs = new BinarySearch(list);
        bs.BSearch(list.head, null, 4);
        bs.location.display("Location: ");
    }
}
