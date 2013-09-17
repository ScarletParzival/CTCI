package Chapter_2;

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
        System.out.println("\nprintLinkedList called:");
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

    public Node partitionTheLinkedList(int x){
//       return partitionTheLinkedList(head,x);
        return partitionTheLinkedListUsingTwoExtraNodes(head,x);
    }

    private Node partitionTheLinkedListUsingTwoExtraNodes(Node head, int x){
        Node smaller = null;
        Node larger =null;

        while(head!=null){
            Node next = head.next;
            if(head.number<x) {
                head.next = smaller;
                smaller = head;
//                if(smaller == null){
//                    smaller = head;
//                }
//                else{
//                    head.next = smaller;
//                    smaller = head;
//                }
            }
            else {
                head.next = larger;
                larger = head;
//                if(larger == null){
//                    larger = head;
//                }
//                else{
//                    head.next = larger;
//                    larger = head;
//                }
            }
            head = next;
//            System.out.println("I am here");
        }
        if(smaller != null){
            Node current = smaller;
            while (current.next != null){
                current = current.next;
//                System.out.println(current.number);
            }
            current.next = larger;
            return smaller;
        }
        return larger;
    }
    private Node partitionTheLinkedList(Node head,int x){
        if(head == null)
            return null;
        Node largerListHead = null;
        Node smallerListHead = null;

        Node largerListTail = null;
        Node smallerListTail = null;

        Node current = head;     //current is a redundant pointer, you can directly advance head.

        while(current!=null){
            if(current.number<x){
                if(smallerListHead == null){
                    smallerListHead = current;
                    smallerListTail = smallerListHead;
                }
                else {
                    smallerListTail.next = current;
                    smallerListTail = smallerListTail.next;
                }
            }
            else{
                if(largerListHead ==null){
                    largerListHead = current;
                    largerListTail = largerListHead;
                }
                else {
                    largerListTail.next = current;
                    largerListTail = largerListTail.next;
                }
            }
            current = current.next;
        }
        if(smallerListHead != null){
            smallerListTail.next = largerListHead;
            return smallerListHead;
        }
        return largerListHead;
    }
//    private GraphNode partitionTheLinkedList(GraphNode head,int x){
//        if(head == null)
//            return null;
//        LinkedListCustom largerLinkedList = new LinkedListCustom();
//        LinkedListCustom smallerLinkedList = new LinkedListCustom();
//
//        GraphNode largerLinkedListNext = null;
//        GraphNode smallerLinkedListNext = null;
//        GraphNode current = head;
//
//        while(current!=null){
//            if(current.number < x){
//                if(largerLinkedListNext == null){
//                    largerLinkedList.head = current;
//                    largerLinkedListNext = largerLinkedList.head;
//                }
//                else{
//                    largerLinkedListNext.next = current;
//                }
//            }
//            else{
//                if(smallerLinkedListNext== null){
//                    smallerLinkedList.head = current;
//                    smallerLinkedListNext = smallerLinkedList.head;
//                }
//                else{
//                    smallerLinkedListNext.next = current;
//                }
//            }
//            current = current.next;
//        }
//        smallerLinkedListNext.next = largerLinkedList.head;
//        return smallerLinkedList.head;
//    }
}

public class partitionALinkedList {
	
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

        LinkedListCustom linkedListPartition = new LinkedListCustom();

        /*
        for(int i=0; i<=7; ++i){
            linkedListPartition.addNodeToEndOfLinkedList(new GraphNode((int)(Math.random()*7)));
        }
        Math.random() really sucks :) It always gives a constant number, yuck it is.
        */

        linkedListPartition.addNodeToEndOfLinkedList(new Node(5));
        linkedListPartition.addNodeToEndOfLinkedList(new Node(18));
        linkedListPartition.addNodeToEndOfLinkedList(new Node(45));
        linkedListPartition.addNodeToEndOfLinkedList(new Node(1));
        linkedListPartition.addNodeToEndOfLinkedList(new Node(23));
        linkedListPartition.addNodeToEndOfLinkedList(new Node(3));
        linkedListPartition.addNodeToEndOfLinkedList(new Node(50));
        linkedListPartition.addNodeToEndOfLinkedList(new Node(2));
        linkedListPartition.addNodeToEndOfLinkedList(new Node(22));
        linkedListPartition.addNodeToEndOfLinkedList(new Node(43));
        linkedListPartition.addNodeToEndOfLinkedList(new Node(19));
        linkedListPartition.addNodeToEndOfLinkedList(new Node(16));
        linkedListPartition.addNodeToEndOfLinkedList(new Node(1));
        linkedListPartition.addNodeToEndOfLinkedList(new Node(7));
        linkedListPartition.addNodeToEndOfLinkedList(new Node(13));
        linkedListPartition.addNodeToEndOfLinkedList(new Node(12));
        linkedListPartition.addNodeToEndOfLinkedList(new Node(11));
        linkedListPartition.addNodeToEndOfLinkedList(new Node(10));
        linkedListPartition.addNodeToEndOfLinkedList(new Node(8));
        linkedListPartition.addNodeToEndOfLinkedList(new Node(7));
        linkedListPartition.addNodeToEndOfLinkedList(new Node(5));
        linkedListPartition.addNodeToEndOfLinkedList(new Node(4));
        linkedListPartition.addNodeToEndOfLinkedList(new Node(3));
        linkedListPartition.addNodeToEndOfLinkedList(new Node(2));
        linkedListPartition.addNodeToEndOfLinkedList(new Node(0));
        linkedListPartition.addNodeToEndOfLinkedList(new Node(89));

        System.out.println();
        linkedListPartition.printLinkedList();

        System.out.println();
        linkedListPartition.head = linkedListPartition.partitionTheLinkedList(16);
        System.out.println();
        linkedListPartition.printLinkedList();
	}
	
}
