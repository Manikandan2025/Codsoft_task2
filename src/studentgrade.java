import java.util.ArrayList;
import java.util.Scanner;

class student {
    String name;
    long rollno;
    int nosub;
    int subj[];
    student(Scanner scan){

        System.out.println("Enter the Student name");
        name=scan.next();
        System.out.print("Enter the Register Number:");
        rollno=scan.nextLong();
       
        while(true){
        System.out.println("Enter number of subjects from 1 to 8");
        nosub=scan.nextInt();
        if(nosub<=8 && nosub>=1){
          break;
        }
        else{
          System.out.println("Invalid");
        }
      }
        subj=new int[nosub];
        System.out.println("Enter the marks of each Subject out of 100");
        for(int i=0;i<nosub;){
          
          System.out.printf("Enter the Subject %d mark\n",i+1);
          int temp=scan.nextInt();
          if(temp<=100 && temp>=0){
          subj[i]=temp;
          i++;
        }
        else{
          System.out.println("Invalid please enter mark out of 100");
        }
        }
    

    }
    int calculateTotal(){
      int total=0;
        for (int i : subj) {
          total=total+i;
        }
        return total;
    }
    int averageMark(){
        return calculateTotal()/nosub;
    }
    String gradecal(){
      double avg=averageMark();
      if(avg>=91 && avg<=100){
        return "O" ;
      }
      else if(avg>=81 && avg<=90){
      return "A+";
      }
      else if(avg>=71 && avg<=80){
        return "A";
      }
      else if(avg>=61 && avg<=70){
        return "B+";
      }
      else if(avg>=51 && avg<=60){
        return "B";
      }
      else{
        return "F";
      }
    }

  void  Display() throws InterruptedException{
    if(name==null){
        System.out.println("No data availabel please add the student detail ");
        }
        else{
    System.out.println("Name of the student :"+name);
    System.out.println("Roll Number :"+rollno);
  
    for (int i=0;i<nosub; i++) {
      System.out.printf("Subject %d Mark: %d\n",i+1,subj[i]);
      Thread.sleep(1000);
    }
    
    System.out.println("Total mark: "+calculateTotal());
    System.out.println("Average percentage: "+averageMark());
    System.out.println("Grade: "+gradecal());
    }  

  }
   
}
public class studentgrade{
    public static void main(String args[]) throws InterruptedException{
        Scanner scan=new Scanner(System.in);
        ArrayList <student>a=new ArrayList<student>();
        boolean con=true;
        System.out.println("-------------------Student Grade Calculation------------------");
       
     while(con){
        System.out.println();
        System.out.println("\n1.Enter 1 to add Student details \n2.Enter 2 to Display Student Info \n3.Enter 3 to Exit");
        int option=scan.nextInt();
        switch(option){
          case 1 -> a.add(new student(scan));
         
          case 2 -> {
              for(student s:a){
                  s.Display();
              }     }
          case 3 -> {
              System.out.println("exit");
              con=false;
                }
          default -> System.out.println("Enter valid input");
           
        }
     
    }
    scan.close();
    }
}
