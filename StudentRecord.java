import java.util.ArrayList;
public class StudentRecord extends Student{
  ArrayList<String> classes;
 
  
  public StudentRecord(String firstName, String lastName, String IDNo, ArrayList<String> classes){
    super(firstName, lastName, IDNo);
    this.classes = classes;
  }

  public String toString(){
    String classesPrint = "";
    for (int i = 0; i < classes.size(); i++){
      classesPrint += classes.get(i) + " ";
    }
    return firstName + " " + lastName + " " + IDNo + " " + classesPrint;
  }


}