import java.util.Scanner;
public class Nokia3310{
  public static void main(String... args){

Scanner scanner = new Scanner(System.in);

  System.out.print("--MAIN MENU--\n1. Phonebook\n2. Messages\n3. Chat\n4. Call register\n5. Tones\n6. Settings\n7. Call divert\n8. Games\n9. Calculator\n10. Reminders\n11. Clock\n12. Profiles\n13. SIM sevices\n");

  
  System.out.println("Enter a number between 1-13 to select an item: ");
  int number = scanner.nextInt();

  switch(number){
  case 1:
  System.out.println("Phone book");
  System.out.print("1. Search\n2. Service Nos.\n3. Add name\n4. Erase\n5. Edit\n6. Assign tone\n7. Send b'card\n8. Options\n9. Speed dials\n10. Voice tags\n");
  
    System.out.print("Enter a number from 1-10 to select an option");
    int phoneBookSelection = scanner.nextInt();

     switch(phoneBookSelection){
      case 1: System.out.println("Search");break;
      case 2: System.out.println("Service Nos");break;
      case 3: System.out.print("Add name");break;
      case 4: System.out.print("Erase");break;
      case 5: System.out.print("Edit");break;
      case 6: System.out.printf("Assign tone");break;
      case 7: System.out.print("Send b'card");break;
      case 8: System.out.print("Options\n  1. Type of view\n  2. Memory status");
	System.out.println("select between options 1 or 2: ");
	int optionType = scanner.nextInt();
		switch (optionType){
		  case 1: System.out.println("Type of view");break;
		  case 2: System.out.println("Memory status");break;
		}
		break;
      case 9: System.out.println("Speed dials");break;
      case 10: System.out.println("Voice tags");break;
       }
break;

  case 2:
  System.out.print("Messages\n1. Write messages\n2. Inbox\n3. Outbox\n4. Picture messages\n5. Templates\n6. Smileys\n7. Message settings\n8. Info Service\n9. Voice mailbox number\n10. Service command editor\n"); 
  System.out.print("select an option from 1-10");
  int messageSelector = scanner.nextInt();

    switch(messageSelector){
    case 1: System.out.print("Write messages");break;
    case 2: System.out.println("Inbox");break;
    case 3: System.out.println("Outbox");break;
    case 4: System.out.print("Picture messages");break;
    case 5: System.out.println("Templates");break;
    case 6: System.out.println("Smileys");break;
    case 7: System.out.println("Message settings");
    System.out.print("  1. Set\n2. Common\n");
    System.out.println("Enter 1 or 2 to select between the options: ");
    int setCommonSelector = scanner.nextInt();
      switch(setCommonSelector){
       
       case 1: System.out.print("1. Message centre number\n2. Message sent as\n3. Message validity");
		System.out.println("choose from options 1-3: ");
		int messageCentre = scanner.nextInt();
		switch(messageCentre){
		  case 1: System.out.println("Message centre number");break;
		  case 2: System.out.println("Message sent as");break;
		  case 3: System.out.println("Message validity");break;
		}
		break;      

       case 2:System.out.print("1. Delivery reports\n2. Reply via same centre\n3. Character support\n");
		System.out.println("choose from options 1-3: ");
		int deliveryReport = scanner.nextInt();
		switch(deliveryReport){
		  case 1: System.out.println("Delivery reports");break;
		  case 2: System.out.println("Reply via same centre");break;
		  case 3: System.out.println("Character support");break;
		}
			
	break;
           }
	break;
      case 8: 
       System.out.print("Info service");
       break;

      case 9: 
       System.out.print("Voice mailbox number");
       break;

      case 10:
       System.out.print("Service command editor");
       break;
  
     }
break;
   
  
  

  case 3:System.out.println("Chat");break;
  case 4: System.out.println("	CALL REGISTER\n 1.-> Missed calls\n 2.-> Received calls\n 3.-> Dialled numbers\n 4.-> Erase recent call lists\n 5.-> Show call duration\n 6.-> Show all costs\n 7.-> Call cost settings\n 8.-> Prepaid credit\n");
  System.out.println("Select from options 1-8: ");
  int callRegisterSelector =  scanner.nextInt();
      switch(callRegisterSelector){
      case 1:
	System.out.print("Missed calls");break;
      case 2:
	System.out.print("Received calls");break;
       case 3:
	System.out.print("Dialled numbers");break;
       case 4:
	System.out.print("Erase cost settings");break;
       case 5:
	System.out.print("Show call duration\n  1.->Last call duration\n  2.->All calls' duration\n  3.->Received calls' duration\n  4.->Dialled calls' duration\n  5.->Clear timers\n");
        System.out.print("Select an option from 1-5: ");
        int callRegister = scanner.nextInt();

		switch(callRegister){
		  case 1: System.out.println("Last call duration");break;
		  case 2: System.out.println("All calls' duration");break;
		  case 3: System.out.println("Received calls' duration");break;
		  case 4: System.out.println("Dialled calls' duration");break;
		  case 5: System.out.println("Clear timers");break;
		}
		break;
	case 6:
	  System.out.print("Show call costs\n  1.->Last call cost\n  2.->All calls' cost\n  3.->Clear counters\n");
        System.out.print("Select an option from 1-3: ");
	int callCostSelector = scanner.nextInt();
		switch(callCostSelector){
		  case 1: System.out.println("Last call cost");break;
		  case 2: System.out.println("All calls' cost");break;
		  case 3: System.out.println("Clear counters");break;
		}
		break;
	 case 7:
	System.out.print("Call cost limit\n  1.->Call cost limit\n  2.->Show costs in\n");
	System.out.print("Select an option between 1 or 2: ");
	int costSettings = scanner.nextInt();
		switch(costSettings){
		  case 1: System.out.println("Call cost limit");break;
		  case 2: System.out.println("Show cost in");break;
		}
		break;
	 case 8:
	  System.out.print("Prepaid credit");break;
      }
  break;

  case 5:
  System.out.println("Tones\n  1.->Ringing tone\n  2.->Ringing volume\n  3.->Incoming call alert\n  4->Composer\n  5->Message alert tone\n  6.->Keypad tones\n  7.->Warning and game tones\n  8.->Vibrating alert\n  9.->Screen saver\n");
	System.out.print("Select an option from 1-9: ");
        int toneSelector = scanner.nextInt();

		switch(toneSelector){
		  case 1: System.out.println("Ringing tone");break;
		  case 2: System.out.println("Ringing volume");break;
		  case 3: System.out.println("Incoming call alert");break;
		  case 4: System.out.println("Composer");break;
		  case 5: System.out.println("Message alert tone");break;
		  case 6: System.out.println("Keypad tones");break;
		  case 7: System.out.println("Warning and game tones");break;
		  case 8: System.out.println("Vibrating alert");break;
		  case 9: System.out.println("Screen saver");break;
		}
  break;

  case 6:
  System.out.println("Settings\n  1.->Call settings\n  2.->Phone settings\n  3.->Security settings\n  4.->Restore factory settings\n");
  System.out.print("Select an option from 1-4: ");
        int settingSelector = scanner.nextInt();
		switch(settingSelector){
		  case 1: System.out.println("Call settings\n  1.->Automatic redail\n  2.->Speed dailing\n  3.->Call waiting options\n  4.->Own number sending\n  5.->Phone line in use\n  6.->Confirm SIM service actions\n");
		 System.out.print("Select an option from 1-6: ");
        	 int callSet = scanner.nextInt(); 
		
		    switch(callSet){
		     case 1: System.out.println("Automatic redail");break;
		     case 2: System.out.println("Speed dailing");break;
		     case 3: System.out.println("Call waiting options");break;
		     case 4: System.out.println("Own number sending");break;
		     case 5: System.out.println("Phone line in use");break;
		     case 6: System.out.println("Automatic answer");break;
		}
		    break;
			

		  case 2: System.out.println("Phone settings\n  1.->Language\n  2.->Cell info display\n  3.->Welcome note\n  4.->Network selection\n  5.->Lights\n  6.->Confirm SIM service actions\n");
		  System.out.print("Select an option from 1-6: ");
                  int phoneSet = scanner.nextInt(); 
		
		    switch(phoneSet){
		     case 1: System.out.println("Language");break;
		     case 2: System.out.println("Cell info display");break;
		     case 3: System.out.println("Welcome note");break;
		     case 4: System.out.println("Network selection");break;
		     case 5: System.out.println("Lights");break;
		     case 6: System.out.println("Confirm SIM service actions");break;
		}
			break;
		  case 3: System.out.println("Security settings\n  1.->PIN code request\n  2.->Call barring service\n  3.->Fixed dialling\n  4.->Closed user group\n  5.->Phone security\n  6.->Change access codes\n");
		  System.out.print("Select an option from 1-6: ");
                  int securitySet = scanner.nextInt(); 
		
		    switch(securitySet){
		     case 1: System.out.println("PIN code request");break;
		     case 2: System.out.println("Call barring service");break;
		     case 3: System.out.println("Fixed dialling");break;
		     case 4: System.out.println("Closed user group");break;
		     case 5: System.out.println("Phone security");break;
		     case 6: System.out.println("Change access codes");break;
		}
			break;
		  case 4: System.out.println("Restore factory settings");break;
		}
  break;

  case 7:
  System.out.print("Call divert");
  break;

  case 8:
  System.out.print("Games");
  break;

  case 9:
  System.out.print("Calculator");
  break;

  case 10:
  System.out.print("Reminders");
  break;

  case 11:
  System.out.println("Clock\n  1.->Alarm clock\n  2.->Clock settings\n  3.->Date setting\n  4.->Stopwatch\n  5.->Countdown timer\n  6.->Auto update of date and time\n");
  	System.out.print("Select an option from 1-6: ");
                  int clockSetSelector = scanner.nextInt(); 
		
		    switch(clockSetSelector){
		     case 1: System.out.println("Alarm clock");break;
		     case 2: System.out.println("Clock settings");break;
		     case 3: System.out.println("Date setting");break;
		     case 4: System.out.println("Stopwatch");break;
		     case 5: System.out.println("Countdown timer");break;
		     case 6: System.out.println("Auto update of date and time");break;
		}
  	break;	

  case 12:
  System.out.print("Profiles");
  break;

  case 13:
  System.out.print("SIM services");
  break;
  }

  }

  

  

 

}












