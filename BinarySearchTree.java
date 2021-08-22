import java.util.*;

public class BinarySearchTree{
  int size = 0;
  Bnode root = null;

  public boolean isEmpty(){
    return size == 0;
  }

  public void insert(Student s){
    if (size < 20){
      root = insert(s, root);
    }
    size++;
  }

  private Bnode insert(Student s, Bnode t){
    if (t != null){
      if (s.compareTo(t.data) < 0){
        t.left = insert(s, t.left);
      }
      else{
        t.right = insert(s, t.right);
      }
    }
    else{
      return new Bnode(s, null, null);
    }
    return t;
  }
  
  public void delete(Student s){
    delete(s, root);
    size--;
  }

  private Bnode delete(Student s, Bnode t) throws NoSuchElementException{
    if (t == null){
      throw new NoSuchElementException();
    }
    if(s.compareTo(t.data) < 0){
      t.left = delete(s, t.left);
    }
    if(s.compareTo(t.data) > 0){
      t.right = delete(s, t.right);
    }
    else{
      //found
      if (t.right == null){
        return t.left;
      }
      if(t.left == null){
        return t.right;
      }
      t.data = findMax(t.left);
      t.left = delete(t.data, t.left);
    }
    return t;
  }

  public Student findMax(Bnode t) throws NoSuchElementException{
    if (t == null){
      throw new NoSuchElementException();
    }
    Bnode trav = t;
    while(trav.right != null){
      trav = trav.right;
    }
    return trav.data;
  }

  public Student search(Student s)throws NoSuchElementException{
    if (isEmpty()){
      throw new NoSuchElementException();
    }
    return search(s, root);
  }
  public Student search(Student s, Bnode t)throws NoSuchElementException{
    if (t == null){
      throw new NoSuchElementException();
    }
    else if (s.compareTo(t.data) < 0){
      return search(s, t.left);
    }
    else if(s.compareTo(t.data) > 0){
      return search(s, t.right);
    }
    else{
      return t.data;
    }
  }

  public Student[] inOrder(){
    Student[] array = new Student[20];
    inOrder(root, array);
    index = 0;
    return array;
  }
  
  int index = 0;
  private void inOrder(Bnode t, Student[] array){
    if (t != null){
      inOrder(t.left, array);
      array[index++] = t.data;
      inOrder(t.right, array);
    }
  }

  public void preOrder(){
    preOrder(root);
  }
  
  private void preOrder(Bnode t){
    if (t != null){
      System.out.println(t.data);
      preOrder(t.left);
      preOrder(t.right);
    }
  }

  public void postOrder(){
    postOrder(root);
  }
  
  private void postOrder(Bnode t){
    if (t != null){
      postOrder(t.left);
      postOrder(t.right);
      System.out.println(t.data);
    }
  }


  public static void main(String[] args){
    //Just some tests
    // BinarySearchTree bst = new BinarySearchTree();
    // Student x = new Student("SDFSDF", "DFGHDFGH", "D55667");
    // bst.insert(x);
    // bst.insert(new Student("Andres", "Iniesta", "I12345"));
    // bst.insert(new Student("Ziedine", "Zidane", "Z12345"));
    // bst.insert(new Student("Xavi", "Hernandez", "H12345"));
    // bst.insert(new Student("Neymarf", "DaSilvaf", "D12335"));
    // bst.insert(new Student("Neymard", "DfaSilva", "D22345"));
    // bst.insert(new Student("Neymsr", "DaSifva", "D16345"));
    // bst.insert(new Student("Neymar", "DaSilva", "D12395"));
    // bst.insert(new Student("Neyhmar", "DaSijva", "D10345"));
    // bst.insert(new Student("Ahmed", "Saad", "S10345"));
    // Student test = bst.search(x);
    // System.out.println(test.IDNo);
    // Student array[] = bst.inOrder();
    // for(int i = 0; i < array.length; i++){
    //   System.out.println(array[i]);
    // }
    // bst.preOrder();
    // bst.postOrder();
  }
}
