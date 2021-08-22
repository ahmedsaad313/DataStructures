


import java.io.File;
import java.util.*;
import java.io.*;
import java.lang.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class main{
  
  public static Student[] saveChanges(LinkedStudentList list){
    Student array[] = new Student[10];
    Node trav = list.head.next;
    int i = 0;
    while(trav != null && i != 10){
      array[i] = trav.data;
      trav = trav.next;
      i++;
    }
    return array;
  }
  
  public static Student[] addStudentSorted(Student []array, Student s){
    if (array[array.length-1] != null){
      System.out.println("Array can hold at most 10 elements");
      return array;
    }
    int i;
    for(i=0; i < array.length-1; i++){
      if(array[i] != null && array[i].compareTo(s)>0)
          break;
      }
    for(int k=array.length-2; k >= i; k--){
        array[k+1]=array[k];            
    }
    array[i]=s;
    return array;
  }

  public static Student searchById(Student[] array, String key) throws NoSuchElementException{
    for(int i = 0; i < array.length; i++){
      if (array[i].IDNo.equals(key)){
        return array[i];
      }
    }
    throw new NoSuchElementException();
  }    

    public static Student searchByName(Student[] array, String key, int high, int low) throws NoSuchElementException{
      int middle = low  + ((high - low) / 2);  
      if (high < low) {
          throw new NoSuchElementException();
      }
      if (key.compareTo(array[middle].lastName + array[middle].firstName) == 0) {
          return array[middle];
      } 
      else if (key.compareTo(array[middle].lastName + array[middle].firstName) < 0) {
          return searchByName(array, key, middle-1, low);
      } 
      else {
          return searchByName(array, key, middle+1, high);
      }
  }

    public static Student[] deleteStudentByIDNo(Student []array, String IDNo){
      for (int i = 0; i < array.length; i++){
        if (array[i] != null && array[i].IDNo.equals(IDNo)){
          array[i] = null;
          for (int j = i ; j < array.length-1; j++){
            array[j] = array[j+1];
          }
        array[array.length-1] = null;
        break;
        }
      }
    return array;

  }

  public static void saveChanges(Student []array){
    File file = new File ("Output.txt");
    try {
      PrintWriter printWriter = new PrintWriter(file);
      for (int i = 0; i < array.length; i++){
        if (array[i] != null){
          printWriter.println(array[i]);
        }
      }
      printWriter.close();
    } catch (Exception e) {
      //TODO: handle exception
    }
  }

  public static void finalize(Student []array, Queue<Student> waitList){
    saveChanges(array);
    File file = new File ("WaitList.txt");
    try {
      PrintWriter printWriter = new PrintWriter(file);
      for (Student item: waitList){
        if (item != null){
          printWriter.println(item);
        }
      }
      printWriter.close();
    } catch (Exception e) {
      //TODO: handle exception
    }
  }
 
  public static void main(String[] args){

    System.out.println("Option 1: Would you like to create a new roster (Project 1) or Option 2: Develop a waiting List with options to add/drop students (Project2)");
    System.out.println("Write 1 for Option 1 and 2 for Option 2");
    Scanner sc = new Scanner(System.in);
    int action = sc.nextInt();
    if (action == 1){
      project1();
    }
    else{
      try{
        project2();
      }
      catch(Exception o){
        System.out.println(o);
      }
    }
  }

  public static void project1(){
    int action = 0;
    Scanner sc = new Scanner(System.in);
    //LinkedStudentList roster = new LinkedStudentList();
    BinarySearchTree roster = new BinarySearchTree();
    Student arrayRoster[] = new Student[100];
    Student array[] = new Student[1];
    Student x = new Student("Lionel", "Messi", "M12345");
    roster.insert(x);
    //x added to hash used for testing hash
    addToHash(x, arrayRoster);
    //the rest of these elements not added into the hash, used mostly for testing bst
    roster.insert(new Student("Andres", "Iniesta", "I12342"));
    roster.insert(new Student("Ziedine", "Zidane", "Z12344"));
    roster.insert(new Student("Xavi", "Hernandez", "H12335"));
    roster.insert(new Student("Neymarf", "DaSilvaf", "D12339"));
    roster.insert(new Student("Neymard", "DfaSilva", "D22340"));
    roster.insert(new Student("Neymsr", "DaSifva", "D16350"));
    roster.insert(new Student("Neymar", "DaSilva", "D12355"));
    roster.insert(new Student("Neyhmar", "DaSijva", "D10375"));
    roster.insert(new Student("Ahmed", "Saad", "S10395"));
    int state = 0;
    while (state < 2){
      if (state == 0){
        System.out.println("What would you like to do? Input the number that corresponds with your option. Here are your options: ");
        System.out.println("1 - Add to bst and hash");
        System.out.println("2 - Delete from bst");
        System.out.println("3 - Delete from Hash (Project 4)");
        System.out.println("4 - Save to Array");
        action = sc.nextInt();
        if (action == 1){
          System.out.println("Please provide first name");
          String fName = sc.next();
          System.out.println("Please provide last name");
          String lName = sc.next();
          System.out.println("Please provide ID");
          String IDNo = sc.next();
          Student newAddition = new Student(fName, lName, IDNo);
          roster.insert(newAddition);
          addToHash(newAddition, arrayRoster);
        }
        else if (action == 2){
          roster.delete(x);
          deleteFromHash(x.IDNo, arrayRoster);
          System.out.println("The function delete in the list class takes in a Students argument");
          System.out.println("Because of this we will not be accepting user input for deletion but");
          System.out.println("instead simply deleting a previously added Student x.");
          System.out.println("If you select option 2 again Student x will no longer be available.");
        }
        else if(action == 3){
          //delete from hash
          System.out.println("Enter Id to be searched");
          String ID = sc.next();
          deleteFromHash(ID, arrayRoster);
        }
        else if(action == 4){
          array = roster.inOrder();
          state++;
          // for (int i = 0; i < arrayRoster.length; i++){
          //   System.out.println(arrayRoster[i]);
          // }
        }
      }
      else if(state == 1){
        System.out.println("What would you like to do? Input the number that corresponds with your option. Here are your options: ");
        System.out.println("1 - Search by ID");
        System.out.println("2 - Search by name");
        System.out.println("3- Save to File");
        action = sc.nextInt();
        if (action == 1){
          System.out.println("Enter Id to be searched");
          String ID = sc.next();
          Boolean foundOrNot = searchFromHash(ID, arrayRoster);
          String foundOrNotWord = foundOrNot ? "found" : "not found";
          System.out.println("The student was " + foundOrNotWord);
        }
        else if (action == 2){
          System.out.println("Enter name to be searched in this formart: lastnameFirstname");
          String name = sc.next();
          String foundOrNot = searchByName(array, name, array.length-1, 0).getClass().getName().equals("Student") ? "found" : "not found";
          System.out.println("The student was " + foundOrNot);
        }
        else if(action == 3){
          saveChanges(array);
          state++;
          try{
          project2();
          }
          catch(FileNotFoundException e){
            System.out.println("File not found" + e);
          }
        }
      }
    }
  }

  public static void addToHash(Student newAddition, Student arrayRoster[]){
    int lastTwo = Integer.parseInt(newAddition.IDNo.substring(newAddition.IDNo.length() - 2, newAddition.IDNo.length()));
    if (arrayRoster[lastTwo] == null){
      arrayRoster[lastTwo] = newAddition;
    }
  }

  public static void deleteFromHash(String IDNo, Student arrayRoster[]){
    int lastTwo = Integer.parseInt(IDNo.substring(IDNo.length() - 2, IDNo.length()));
    if (arrayRoster[lastTwo] != null){
      arrayRoster[lastTwo] = null;
    }
  }
  
  public static boolean searchFromHash(String IDNo, Student arrayRoster[]){
    int lastTwo = Integer.parseInt(IDNo.substring(IDNo.length() - 2, IDNo.length()));
    return arrayRoster[lastTwo] != null && arrayRoster[lastTwo].IDNo.equals(IDNo);
  }

  public static void project2() throws FileNotFoundException{
    Scanner sc = new Scanner(System.in);
    File inputFile = new File("Output.txt");
    Scanner in = new Scanner(inputFile);
    Student.clearIDNOs();
    Queue<Student> waitList = new LinkedList<>();
    Student array[] = new Student[20];
    int i = 0;
    while (in.hasNextLine()){
      String line = in.nextLine();
      String[] words = line.split(" ");
      array[i] = new Student(words[0], words[1], words[2]);
      i++;
    }
    int action = 0;
    while (action !=3){
    System.out.println("Great! Your roster is now complete. For more options input the number that corresponds with the option");
    System.out.println("1 - Add a student");
    System.out.println("2 - Drop a student");
    System.out.println("3 - Finalize roster and waiting list");
    action = sc.nextInt();
      if (action == 1){
        System.out.println("Please provide first name");
        String fName = sc.next();
        System.out.println("Please provide last name");
        String lName = sc.next();
        System.out.println("Please provide ID");
        String IDNo = sc.next();
        if (array[array.length - 1] == null){
          System.out.println("There is space for " + fName + "! Adding to the roster");
          array = addStudentSorted(array, new Student(fName, lName, IDNo));
        }
        else{
          System.out.println("Roster full. " + fName + " has been wait listed");
          waitList.add(new Student(fName, lName, IDNo));
        }
      }
      else if(action == 2){
        System.out.println("Please provide ID of student you wish to delete");
        String IDNo = sc.next();
        array = deleteStudentByIDNo(array, IDNo);
        if (waitList.peek() != null){
          Student nextUp = waitList.peek();
          waitList.remove();
          array = addStudentSorted(array, nextUp);
        }
      }
      else if(action == 3){
        finalize(array, waitList);
      }
    }
  }
}
//errors with userinput in particular seacrching