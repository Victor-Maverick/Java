public class Student1{
  private String name;
  private int average;
  
  public Scanner(String name, int average){
   this.name = name;
   if (average > 0){
     if (average =< 100){
      this.average = average;
     } 
   }
  }

  public void setName(String name){
   this.name = name;
  }

  public String getName(){
   return name;
  }

  public void setAverage(int average){
   if (average > 0){
     if (average <= 100){
     }
    }
  }

  public int getAverage(){
   return average;
  }

  public String getLetterGrade(){
   String letterGrade = "";
   if (average >= 90){
    letterGrade = "A";
   }
   else if (average >= 80){
    leterGrade = "B";
   }
   else if (average >= 70){
    leterGrade = "C";
   }
   else if (average >= 60){
    leterGrade = "C";
   }
   else{
    letterGrade = "F";
   }

   return letterGrade;
  }




}