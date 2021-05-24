
package telephone.directory;

import java.util.*;
import java.io.*;

class Directory{
	String name;
        int age;
        String phoneNo;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

}

//append to an array
class AddtoArray{
    public ArrayList AddtoArray(String data){
    
        ArrayList Info = new ArrayList();
        Info.add(data);
        return Info;
    }
}
//Creates Contact and Saves to a file.
class CreateContact{
    String name;
    int age;
    String phoneNo;
    
    public void CreateContact(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the following details respectively to save contacts");
        Directory  data = new Directory();
        System.out.println("Name :");
        this.name = scan.next();
        data.setName(name);
        System.out.println("Age :");
        this.age = scan.nextInt();
        data.setAge(age);
        System.out.println("Phone Number :");
        this.phoneNo = scan.next();
        data.setPhoneNo(phoneNo);
        String Age = Integer.toString(age);
        //Storing data to array after receiving inforamtion.
        AddtoArray myInfo = new AddtoArray();
        myInfo.AddtoArray(Age);
        myInfo.AddtoArray(name);
        myInfo.AddtoArray(phoneNo);
}
    public void Save() throws IOException{
        FileWriter fw;
        fw = new FileWriter(new File("Telephone.txt"), true);
        BufferedWriter out = new BufferedWriter(fw);
        out.write("Name : " + name + " " + "Age : " + age + ", " + "PhoneNo : "  + phoneNo + ".");
        out.newLine();
	out.close();
        System.out.println("All Information stored succesfully...");
    }


}
//Actions that can be done on the contacts
class Actions{
    //Can be used to search for a contact in the file
    public void Search(){
            System.out.print("Enter name to search information: ");
            Scanner scan = new Scanner(System.in);
            String word = scan.next();
            word = word.toLowerCase();
            File f = new File("Telephone.txt");
                try {
                        BufferedReader freader = new BufferedReader(new FileReader(
                                        f));
                        String s;
                        while ((s = freader.readLine()) != null) {
                                String[] st = s.split(" ");
                                String nm = st[2];
                                nm = nm.toLowerCase();
                                String ag = st[5];
                                String pn = st[8];
                                if (word.equals(nm)) {
                                        System.out.println("***********Information**************");
                                        System.out.println("Age : " + ag);
                                        System.out.println("PhoneNo : " + pn);
                                }
                        }
                        freader.close();
                } catch (IOException e) {


                }

    }
    // can be usd to check a sorted list of the contacts.
    public void List() throws FileNotFoundException, IOException{
        BufferedReader reader = new BufferedReader(new FileReader(
                                        "Telephone.txt"));
        
        ArrayList<String> str = new ArrayList<>();
        
        String line = " ";
        while((line=reader.readLine())!= null){
            str.add(line);
                
            }
            Collections.sort(str);
            String[] strArr = str.toArray(new String[0]);
            PrintWriter writer =new PrintWriter(new FileWriter("newsorted.txt"));
            for(String cur :strArr){
                writer.println(cur);
            }
            writer.close();
            FileInputStream fis = new FileInputStream(new File(
                                               "newsorted.txt"));
                   DataInputStream dis = new DataInputStream(fis);
                   BufferedReader reader2 = new BufferedReader(
                                   new InputStreamReader(dis));
                   String st;
                   ArrayList al = new ArrayList();
                   while ((st = reader2.readLine()) != null) {
                           al.add(st);
                   }
                   Iterator itr;
                   for (itr = al.iterator(); itr.hasNext();) {
                           String str2 = itr.next().toString();
                           String[] splitSt = str2.split(" ");
                           String na = "", aga = "", ph = "";
                           for (int i = 0; i < splitSt.length; i++) {
                                   na = splitSt[2];
                                   aga = splitSt[5];
                                   ph = splitSt[8];
                           }
                           System.out.println("Name : " + na + ", " + "Age : " + aga + ", " + "PhoneNo : "  + ph);
                   }
    
            
}
    
    
    
    

}



/**
 *
 * @author Mubarak
 *
 */
public class TelephoneDirectory {
    
    
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) throws IOException {
        //taking inputs from user
        
        Scanner scan = new Scanner(System.in);
        int menu = 0;
        System.out.println("Welcome");
        System.out.println("Telephone Directory");
        System.out.println("What would you like to do");
        System.out.println("\t1. for Add Contact");
	System.out.println("\t2. for Perform Action on Contact");
        menu = scan.nextInt();
       
        
         switch (menu) {
            case 1:
                CreateContact myContact= new CreateContact();
                myContact.CreateContact();
                myContact.Save();
                    break;
            case 2:
                int newmenu = 0;
                System.out.println("What would like to do to your contact?");
                System.out.println("\t1. for  Search");
	        System.out.println("\t2. for List of all Contacts");
                newmenu = scan.nextInt(); 
                Actions myAction= new Actions();
                switch (newmenu){
                    case 1:
                        myAction.Search();
                    break;
                    
                    case 2:
                         myAction.List();   
                    break;
                    
                }
                
                }
                

                
    }	
       
}
        
      
        
 

