import java.util.ArrayList;
public class Student implements Comparable<Student>{
  String firstName;
  String lastName;
  String IDNo;
  static ArrayList<String> IDNos = new ArrayList<String>();

  
  public Student(String firstName, String lastName, String IDNo) throws IllegalArgumentException{
    this.firstName = firstName;
    this.lastName = lastName;
    boolean checkId  = true;
    for(int i = 0; i < IDNos.size(); i++){
      if(IDNo.equals(IDNos.get(i))){
        checkId = false;
      }
    }
    if (IDNo.length() == (6) && IDNo.charAt(0) == (lastName.charAt(0)) && checkId){
      this.IDNo = IDNo;
    }
    else{
      throw new IllegalArgumentException("Id needs to be of length 6 and start with initial of last name, and can't be the same as another students");
    }
    IDNos.add(IDNo);
  }

  public String toString(){
    return firstName + " " + lastName + " " + IDNo;
  }

  public static void clearIDNOs(){
    IDNos.clear();
  }

  public boolean equals(Student o){
    if(this.IDNo.equals(o.IDNo)){
      return true;
    }
    return false;
  }

  @Override
  public int compareTo(Student o){
    String x= this.lastName + this.firstName + this.IDNo;
    String y = o.lastName + o.firstName + o.IDNo;
    return x.compareTo(y);
  }
  public static void main(String[] args){}
}