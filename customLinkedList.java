public class LinkedList {

    public class Node{

        String data;
        Node nextNode;

        public Node() {
        }

        public Node(String data) {
            this.data = data;
            this.nextNode = null;
        }
    }

    Node head = new Node();

    //< -------------------------- display Box View------------------->

    public void displayBoxView()
    {
        Node temp = head;

        if (temp == null)
        {
            System.out.println("------------------------");
            System.out.println("| LinkedList is Empty! |");
            System.out.println("------------------------");
        }
        else
        {
            System.out.println("#########  BOX VIEW  #########\n");
            while (temp.nextNode!=null)
            {
                System.out.println("\t\t---------------------");
                System.out.print("\t\t|  "+temp.data+"  |\t\t\t|\n\t\t---------------------\n\t\t\t\t\t |\n\t\t\t\t\t |\n");

                temp = temp.nextNode;
            }
            System.out.println("\t\t---------------------");
            System.out.print("\t\t|  "+temp.data+"  |\t\t\t|\n\t\t---------------------");
        }
    }
//  < -------------- display  ------------------>
    public void display()
    {
        Node temp = head;

        if (temp == null)
            System.out.println("<------ LinkedList is Empty! ------>");
        else
        {
            while (temp.nextNode!=null)
            {
                System.out.print(temp.data+" --> ");

                temp = temp.nextNode;
            }
            System.out.print(temp.data+"\n");
        }
    }
//  < ----------------------- add  ----------------------->
    public void add(String value)
    {
        Node node = new Node(value);
      if (head != null)
      {
          Node temp = head;

          while (temp.nextNode != null)
          {
              temp = temp.nextNode;
          }
          temp.nextNode = node;
      }
      else head = node;
    }

    //< ----------------- delete ------------------------>
    public void delete()
    {
        Node temp = head;
        if (temp == null)
            System.out.println("Cannot perform delete operation on empty LinkList");
        else if (temp.nextNode == null)
        {
            head = null;
        }
        else
        {
            while (temp.nextNode.nextNode != null)
            {
                temp = temp.nextNode;
            }
            temp.nextNode = null;


        }
    }

// <------------------------ size of LinkedList ---------------------->
    public int size()
    {
        Node node = head;
        int size = 0;
        if (node == null)
            return 0;
        else if(node.nextNode == null)
            return 1;
        else {
            while (node.nextNode != null)
            {
                node = node.nextNode;
                size++;
            }
            return size+1;
        }
    }

    //<--------------------- delete at position -------------------->

    public void deleteAtPosition(int index)
    {
        try {
            Node temp = head;
            int i=0;

            if (index == 0)
                head = head.nextNode;

            else
            {
                while (i<index-1)
                {
                    temp = temp.nextNode;
                    i++;
                }
                Node node = temp.nextNode.nextNode;
                temp.nextNode = node;
            }
        }
        catch (Exception e){
            System.out.println("\n\n------------------------------------------");
            System.out.println("| Can't operate delete operation         |");
            System.out.println("| Index is out of the size of LinkedList |");
            System.out.println("------------------------------------------\n\n");
        }
    }

    //<-------------------- add at position ----------------->


    public void addAtPosition(int index,String value)
    {
        try {
            Node temp = head;
            int i = 0;

            if (index == 0) {
                Node node = new Node(value);
                node.nextNode = head;
                head = node;

            } else {
                while (i < index - 1)
                {
                    temp = temp.nextNode;
                    i++;
                }

                Node node = new Node(value);
                node.nextNode = temp.nextNode;
                temp.nextNode = node;
            }
        } catch (Exception e) {
            System.out.println("\n\n------------------------------------------");
            System.out.println("| Can't operate addition operation       |");
            System.out.println("| Index is out of the size of LinkedList |");
            System.out.println("------------------------------------------\n\n");
        }
    }
//  <---------------------------- reversing a LinkedList --------------------->
    public void reverse()
    {
        Node temp = head.nextNode;
        Node tail = new Node(head.data);

        while (temp != null)
        {
            Node node = new Node(temp.data);
            node.nextNode = tail;
            tail =  node;

            temp = temp.nextNode;
        }
        head = tail;
    }

    // <------------------ get at position ------------->

    public String get(int position)
    {
        Node temp = head;
        int x=0;
        while (x<position)
        {
            temp = temp.nextNode;
            x++;
        }
        return temp.data;

    }
// <-------------- checking contains string or not ------------------>
    public boolean contains(String value)
    {
        Node node = head;
        while (node.nextNode != null)
        {
            if (node.data == value)
            {
                return true;

            }
            node = node.nextNode;
        }
        return false;
    }

}
