public class AutoPolicy{
  private int accountNumber;
  private String makeAndModel;
  private String state;

  public AutoPolicy(int accountNumber, String makeAndModel, String state){
    this.accountNumber = accountNumber;
    this.makeAndModel = makeAndModel;
    if(state.equalsIgnoreCase("CT") || state.equalsIgnoreCase("MA") || state.equalsIgnoreCase("ME") || state.equalsIgnoreCase("NH") || state.equalsIgnoreCase("NJ") || state.equalsIgnoreCase("NY") || state.equalsIgnoreCase("PA") || state.equalsIgnoreCase("VT")){
	this.state = state;
      }
      else{
	this.state = "state not defined";
      }
    
  }
 
  public void setAccountNumber(int accountNumber){
    this.accountNumber = accountNumber;
  }

  public int getAccountNumber(){
    return accountNumber;
  }

  public void setMakeAndModel(String makeAndModel){
    this.makeAndModel = makeAndModel;
  }

  public String getMakeAndModel(){
    return makeAndModel;
  }

  public void setState(String state){
    
      if(!state.equalsIgnoreCase("CT") || !state.equalsIgnoreCase("MA") || !state.equalsIgnoreCase("ME") || !state.equalsIgnoreCase("NH") || !state.equalsIgnoreCase("NJ") || !state.equalsIgnoreCase("NY") || !state.equalsIgnoreCase("PA") || !state.equalsIgnoreCase("VT")){
	state = "State not defined";
      }
      else{
	this.state = state;
      }
  }

  public String getState(){
    return state;
  }

  public boolean isNorthEastState(){
    boolean northEastState;
   
    switch (getState()){
     case "CT": case "MA": case "ME": case "NH": case "NJ": case "NY": case "PA": case "VT":
	northEastState = true;
	break;
     default:
	northEastState = false;
	break;
    }
     return northEastState;
  }
}