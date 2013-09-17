package Chapter_1;

class Node{
	int number;
	Node next;
	
	Node(int number){
		this.number = number;
		this.next = null;
	}
	
	Node(int number, Node next){
		this.number = number;
		this.next = next;
	}
}

class IndexWrapper{
    public int index = 0;
}

class LinkedListCustom{
	
	public Node head;
	
	public void addNodeToEndOfLinkedList(Node newNode){
		if(head == null){
			head = newNode;
			head.next = null;
		}
		else{
			Node current = head;
			while(current.next != null){
				current = current.next;
			}
			current.next = newNode; 
		}
	}
	
	public void addNodeToStartOfLinkedList(Node newNode){
		newNode.next = head; 
		head = newNode;
	}
	
	public void printLinkedList(){
		Node current = head;
		while(current!=null){
			System.out.print(current.number + "-->");
			current = current.next;
		}
		System.out.print("null");
	}
	
	public void reverseLinkedList(){
		Node previous, current, next;
		current = head;
		previous = null;
		while(current != null){
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		head = previous;
	}

    public void findKNodeFromTheEnd(int k){
      findKNodeFromTheEnd(head,k);
    }

    private int findKNodeFromTheEnd(Node head, int k){
      if(head == null){
          return 0;
      }
      int i = findKNodeFromTheEnd(head.next, k)+1;
      if(i == k){
          System.out.println("\n\nFound the kth element from the end: "+head.number);
      }
      return i;
    }

    public Node findKNodeFromTheEnd(int k, IndexWrapper i){
        return findKNodeFromEnd(head,k,i);
    }

    private Node findKNodeFromEnd(Node head, int k, IndexWrapper i){

        if(head == null){
            return null;
        }

        Node node = findKNodeFromEnd(head.next, k, i);
        i.index++;
        if(i.index == k){
            return head;
        }
        return node;
    }

    public Node findKNodeFromEndIteratively(int k){
        return findKNodeFromEndIteratively(head,k);
    }

    private Node findKNodeFromEndIteratively(Node head,int k){
        if(head == null){
            return null;
        }
        Node headStart = head;
        for(int i=0; i<k; ++i){
            headStart = headStart.next;
            if(headStart == null){
                return null;
            }
        }
        Node kthNode = head;
        while(headStart!= null){
            headStart = headStart.next;
            kthNode = kthNode.next;
        }
        return kthNode;
    }

    public boolean deleteNodeFromMiddle(Node nodeToBeDeleted){

        if(nodeToBeDeleted == null || nodeToBeDeleted.next == null){
            return false;
        }

        nodeToBeDeleted.number = nodeToBeDeleted.next.number;
        nodeToBeDeleted.next = nodeToBeDeleted.next.next;
        return true;

        /*
        if(nodeToBeDeleted == null){
            return false;
        }
        else if(nodeToBeDeleted.next ==null){
            nodeToBeDeleted = null;
            // Making it null here doesn't mean that we are deleting the node,
            // it just means that the node that was sent by reference (as is the case with Java always)
            // has just been made to reference to the null value and nothing else.
            // The linkedList still has access to this node through the next pointer of the previous node while traversing the list.
            // Uncomment this section, run it and see for yourself if you don't recollect much.
        }
        else {
            nodeToBeDeleted.number = nodeToBeDeleted.next.number;
            nodeToBeDeleted.next = nodeToBeDeleted.next.next;
        }
        return true;
        */
    }

    public int linkedListLength(){
        Node current = head;
        int length = 0;
        while (current!=null){
            current = current.next;
            ++length;
        }
        return length;
    }
    public Node returnARandomNodeFromMiddle(){
        int length = linkedListLength();
        int randomNumber = (int)(Math.random()*length);
        Node randomNode = head;
        for(int i=0; i<randomNumber; ++i){
            randomNode = randomNode.next;
        }
        return randomNode;
    }
}

public class kthNodeInALinkedList {
	
	public static void main(String[] args) {
		LinkedListCustom linkedList = new LinkedListCustom();
		linkedList.head = new Node(2);
		for(int i=3; i<= 20; ++i){
			linkedList.addNodeToEndOfLinkedList(new Node(i));			
		}
		linkedList.addNodeToStartOfLinkedList(new Node(1));
		linkedList.printLinkedList();

        int k = 3;
        linkedList.findKNodeFromTheEnd(k);

        k=1;
        Node kNode = linkedList.findKNodeFromTheEnd(k,new IndexWrapper());
        System.out.println("\n'Number-value' of the "+ k + "-th node from the end: "+kNode.number);

        k=5;
        kNode = linkedList.findKNodeFromEndIteratively(k);
        System.out.println("\n'Number-value' of the "+ k + "-th node from the end: "+kNode.number);

		linkedList.reverseLinkedList();
		System.out.println();
		linkedList.printLinkedList();

        linkedList.reverseLinkedList();

        Node randomNodeFromMiddle = linkedList.returnARandomNodeFromMiddle();
        int nodeValue = randomNodeFromMiddle.number;
        boolean randomNodeDeleted = linkedList.deleteNodeFromMiddle(randomNodeFromMiddle);
        if(randomNodeDeleted){
            System.out.println("\n\nRandom node with number: " +nodeValue+" has been successfully deleted!");
            linkedList.printLinkedList();
        }
	}
	
}
