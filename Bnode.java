public class Bnode{
  Student data;
  Bnode left;
  Bnode right;
  
  public Bnode(Student data, Bnode left, Bnode right){
    this.data = data;
    this.left = left;
    this.right = right;
  }
}