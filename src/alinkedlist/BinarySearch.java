package alinkedlist;

class BinarySearch {
    private ALinkedList list;
    public ALinkedList location;
    
    public BinarySearch(ALinkedList list) {
        this.list = list;
        location = new ALinkedList();
    }
    
    private Node getMid(Node start, Node end) {
        if (start == null) return null;
        
        Node x1 = start;
        Node x2 = start.next;
        while (x2 != end) {
            x2 = x2.next;
            if (x2 != end) {
                x2 = x2.next;
                x1 = x1.next;
            }
        }
        return x1;
    }
    
    private Node getBeforeMid(Node mid) {
        list.pos = list.head;
        
        while (list.pos != mid) {
            list.pos = list.pos.next;
        }
        
        return list.pos;
    }
    
    private int getLocation(Node p) {
        list.pos = list.head;
        int count = 1;
        
        while (list.pos != null) {
            if (list.pos == p) break;
            list.pos = list.pos.next;
            count++;
        }
        
        return count;
    }
    
    public void BSearch(Node start, Node end, int item) {
        if (end != null && start == end);
        else {
            Node mid = getMid(start, end);
            
            if (mid == null);
            else {
                if (mid.data == item) {
                    location.insert(getLocation(mid));
                    
                    BSearch(mid.next, end, item);
                    BSearch(start, getBeforeMid(mid), item);
                } else if (mid.data < item) BSearch(mid.next, end, item);
                else if (mid.data > item) BSearch(start, getBeforeMid(mid), item);
            }
        }
    }
}
