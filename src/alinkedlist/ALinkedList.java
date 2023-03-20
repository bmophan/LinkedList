package alinkedlist;

import java.io.*;

class ALinkedList {
    public Node head;
    public Node pos;
    private int elements;
    
    // Constructor.
    public ALinkedList() {
        head = pos = null;
        elements = 0;
    }
    
    // Check if a list is empty.
    public boolean isEmpty() {
        return head == null;
    }
    
    // Get number of elements.
    public int getElements() {
        return elements;
    }
    
    private void newNode(Node r, int data) {
        Node newNode = new Node(data);
        if (r == null) {
            newNode.next = head;
            head = newNode;
        } else {
            newNode.next = r.next;
            r.next = newNode;
        }
    }
    
    public void insert(int data) {
        if (head == null) {
            Node newNode = new Node(data);
            head = newNode;
        } else {
            pos = head;
            if (pos.data > data) newNode(null, data);
            else {
                while (pos != null) {
                    if (pos.next == null || pos.next.data > data) {
                        newNode(pos, data);
                        break;
                    }
                    pos = pos.next;
                }
            }
        }
    }
    
    public void inputList() {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var pw = new PrintWriter(System.out, true);
        
        pw.print("Input (Press 0 to exit): ");
        pw.flush();
        try {
            boolean aFlag = true;
            Outer: while(aFlag) {
                String[] s = br.readLine().split(" ");
                int i;
                for (String item : s) {
                    try {
                        i = Integer.parseInt(item);
                        if (i == 0) {
                            aFlag = false;
                            continue Outer;
                        }
                    }catch(NumberFormatException e) {
                        continue;
                    }
                    insert(i);
                }
            }
        } catch(IOException e) {
            pw.println("IO Error!");
            pw.flush();
        }
    }
    
    public void display(String msg) {
        var pw = new PrintWriter(System.out, true);
        
        pw.print(msg + "\n");
        pw.flush();
        
        pos = head;
        int count = 0;
        
        while(pos != null) {
            if (count == 10) {
                pw.println();
                pw.flush();
                count = 0;
            }
            pw.printf("%11d", pos.data);
            pw.flush();
            pos = pos.next;
            count++;
        }
        pw.println();
    }
}
