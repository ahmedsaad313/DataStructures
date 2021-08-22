public class LinkedStudentList{
  Node head =  new Node(null, null);
  int size = 0;
  
  public boolean isEmpty(){
    return head.next == null;
  }

  public String toString(){
    String str = "";
    Node curr = head.next;
    while (curr != null){
      str += curr.data.IDNo + " ";
      curr = curr.next;
    }
    return str;
  }

  public void insertSorted(Student s){
    Node prev = head;
    Node curr = head.next;
    while(curr != null && curr.data.compareTo(s) < 0){
      prev = curr;
      curr = curr.next;
    }
    prev.next = new Node(s, curr);
    size++;
  }

  public void delete(Student s){
    Node prev = head;
    Node curr = head.next;
    while(curr != null && curr.data.compareTo(s) < 0){
      prev = curr;
      curr = curr.next;
    }
    if (curr.data == s){
      prev.next = curr.next;
    }
    else{
      System.out.println("Not found");
    }
    size--;
  }

}