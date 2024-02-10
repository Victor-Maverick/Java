import java.util.Scanner;
  public class GeoPoliticalZones{

    public static void main(String[] args){
  
     Scanner input = new Scanner(System.in);
 
      System.out.println("Enter your state: ");
      String state = input.next();
    
      boolean isNorthWestState = state.equalsIgnoreCase("kebbi") || state.equalsIgnoreCase("sokoto") || state.equalsIgnoreCase("katsina") || state.equalsIgnoreCase("zamfara") || state.equalsIgnoreCase("kaduna") || state.equalsIgnoreCase("kano");
       
      boolean isNorthEastState = state.equalsIgnoreCase("adamawa") || state.equalsIgnoreCase("yobe") || state.equalsIgnoreCase("borno") || state.equalsIgnoreCase("bauchi") || state.equalsIgnoreCase("gombe") || state.equals("taraba") || state.equals("jigawa");

      boolean isNorthCentralState = state.equalsIgnoreCase("plateau") || state.equalsIgnoreCase("kwara") || state.equalsIgnoreCase("kogi") || state.equalsIgnoreCase("benue") || state.equalsIgnoreCase("niger") || state.equalsIgnoreCase("nassarawa") || state.equalsIgnoreCase("fct");
 
      boolean isSouthWestState = state.equalsIgnoreCase("lagos") || state.equalsIgnoreCase("ondo") || state.equalsIgnoreCase("osun") || state.equalsIgnoreCase("oyo") || state.equalsIgnoreCase("ogun") || state.equalsIgnoreCase("ekiti"); 

      boolean isSouthEastState = state.equalsIgnoreCase("abia") || state.equalsIgnoreCase("anambra") || state.equalsIgnoreCase("ebonyi") || state.equalsIgnoreCase("enugu") || state.equalsIgnoreCase("imo"); 

      boolean isSouthSouthState = state.equalsIgnoreCase("bayelsa") || state.equalsIgnoreCase("edo") || state.equalsIgnoreCase("cross-river") || state.equalsIgnoreCase("delta") || state.equalsIgnoreCase("rivers") || state.equalsIgnoreCase("akwa-ibom");

	boolean isInvalidState = !isNorthWestState && !isNorthEastState && !isNorthCentralState && !isSouthWestState && !isSouthEastState && !isSouthSouthState;

	if(isNorthWestState) System.out.println("You are from the the north west");
	if(isNorthEastState) System.out.println("You are from the the north east");
	if(isNorthCentralState) System.out.println("You are from the the north central");
	if(isSouthWestState) System.out.println("You are from the the south west");
	if(isSouthEastState) System.out.println("You are from the the south east");
	if(isSouthSouthState) System.out.println("You are from the the south south");
	if(isInvalidState) System.out.println("Your from the projects");


}

}