import java.util.Scanner;
  public class GeoPoliticalZone{

    public static void main(String[] args){
  
     Scanner input = new Scanner(System.in);
 
      System.out.println("Enter your state: ");
      String state = input.next().toLowerCase();

       switch(state){

	case "kebbi", "sokoto", "katsina", "zamfara", "kaduna", "kano" -> System.out.println("you are from the north west");
	case "borno", "adamawa", "yobe", "taraba", "gombe", "jigawa", "bauchi" -> System.out.println("you are from the north east");
	case "plateau", "kwara", "kogi", "benue", "niger", "nassarawa", "fct" -> System.out.println("you are from the north central");
	case "lagos", "ondo", "osun", "oyo", "ogun", "ekiti" -> System.out.println("you are from the south west");
	case "abia", "anambra", "ebonyi", "enugu", "imo" -> System.out.println("you are from the south east");
	case "bayelsa", "edo", "cross-river", "delta", "rivers", "akwa-ibom" -> System.out.println("you are from the south south");

	}

  }
 
}