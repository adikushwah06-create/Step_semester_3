package main.java.session_6.practice_problems;

class PlacementRecord {
    String studentName;
    String company;
    double packageLpa;

    PlacementRecord(String name, String company, double packageLpa){
      studentName=name;
      this.company=company;
      this.packageLpa=packageLpa;
    }

    void printRecord(){
        System.out.println( studentName + " -> " + company + " @ " + packageLpa + " LPA " );
    }

 }

 public class PlacementRecordMain{
  public static void main(String[] args){

     PlacementRecord[] records = new PlacementRecord[] {
        new PlacementRecord("Ravi" ,"TCS", 4.5),
        new PlacementRecord("Anitha", "Zoho" , 6.2),
        new PlacementRecord("Karthik", "Infosys", 4.0)
     };
      
      for(int i = 0; i<records.length; i++){
          records[i].printRecord();
      }
  }
 }
