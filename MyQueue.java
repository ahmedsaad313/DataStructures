import java.util.*;
public class MyQueue{
  Node front = null;
  Node  rear = null;
  int size = 0;
  
  public boolean isEmpty(){
    return size == 0;
  }

  public Student deQ() throws NoSuchElementException{
    if (isEmpty()){
      throw new NoSuchElementException();
    }
    Student oldFront = front.data; 
    front = rear.next = front.next;
    size--;
    return oldFront;
  }

  public void enQ(Student s){
    if (rear == null){
      front = rear = new Node(s, front);
    }
    else{
      rear.next = new Node(s, front);
      rear = rear.next;
    }
    size++;
  }

  public String toString(){
    String str = "";
    Node trav = front;
    int i = 0;
    while(i < size){
      str += trav.data.toString() + " ";
      trav = trav.next;
      i++;
    }
    return str;
  }

  public Student peek() throws NoSuchElementException{
    if (isEmpty()){
      throw new NoSuchElementException();
    }
    return front.data;
  }

  public static void main(String[] args) {
    //some tests
    // MyQueue x = new MyQueue();
    // x.enQ(new Student("Andres", "Iniesta", "I12345"));
    // x.enQ(new Student("Ziedine", "Zidane", "Z12345"));
    // x.enQ(new Student("Xavi", "Hernandez", "H12345"));
    // x.enQ(new Student("Neymarf", "DaSilvaf", "D12335"));
    // x.enQ(new Student("Neymard", "DfaSilva", "D22345"));
    // x.enQ(new Student("Neymsr", "DaSifva", "D16345"));
    // x.enQ(new Student("Neymar", "DaSilva", "D12395"));
    // x.enQ(new Student("Neyhmar", "DaSijva", "D10345"));
    // x.enQ(new Student("Ahmed", "Saad", "S10345"));
    // x.deQ();
    // x.deQ();
    // x.enQ(new Student("Andreee", "Inieeeesta", "I1e345"));
    // System.out.print(x.toString());
  }
}