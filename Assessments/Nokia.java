import java.util.Scanner;
public class Nokia{
  public static void main(String... args){

Scanner scanner = new Scanner(System.in);

  System.out.print("--MAIN MENU--\n1. Phonebook\n2. Messages\n3. Chat\n4. Call register\n5. Tones\n6. Settings\n7. Call divert\n8. Games\n9. Calculator\n10. Reminders\n11. Clock\n12. Profiles\n13. SIM sevices\n");

  
  System.out.println("Enter a number between 1-13 to select an item: ");
  int number = scanner.nextInt();

  if (number==1){
  System.out.println("Phone book");
  System.out.print("1. Search\n2. Service Nos.\n3. Add name\n4. Erase\n5. Edit\n6. Assign tone\n7. Send b'card\n8. Options\n9. Speed dials\n10. Voice tags\n");
  
    System.out.print("Enter a number from 1-10 to select an option");
    int phoneBookSelection = scanner.nextInt();

      if (phoneBookSelection ==1){
       System.out.println("Search");
      }
      else if (phoneBookSelection==2){
       System.out.println("Service Nos");
      }
      else if(phoneBookSelection==3){
      System.out.print("Add name");
      }
      else if(phoneBookSelection==4){
       System.out.print("Erase");
      }
      else if(phoneBookSelection==5){
       System.out.print("Edit");
      }
      else if (phoneBookSelection==6){
       System.out.printf("Assign tone");
      }
      else if(phoneBookSelection==7){
      System.out.print("Send b'card");
      }
      else if(phoneBookSelection==8){
       System.out.print("Options\n  1. Type of view\n  2. Memory status");
	System.out.println("select between options 1 or 2: ");
	int optionType = scanner.nextInt();
		if(optionType==1){
		   System.out.println("Type of view");
                 }
                 else if(optionType==2){
		  System.out.println("Memory status");
		}
		
      }
      else if(phoneBookSelection==9){
       System.out.println("Speed dials");
      }
      else if(phoneBookSelection==10){
       System.out.println("Voice tags");
       }

  }
  else if(number==2){
  System.out.print("Messages\n1. Write messages\n2. Inbox\n3. Outbox\n4. Picture messages\n5. Templates\n6. Smileys\n7. Message settings\n8. Info Service\n9. Voice mailbox number\n10. Service command editor\n"); 
  System.out.print("select an option from 1-10");
  int messageSelector = scanner.nextInt();

    if(messageSelector==1){
     System.out.print("Write messages");
     }
     else if(messageSelector==2){
     System.out.println("Inbox");
     }
     else if(messageSelector==3){
      System.out.println("Outbox");
     }
     else if(messageSelector==4){
      System.out.print("Picture messages");
     }
     else if(messageSelector==5){
      System.out.println("Templates");
     }
     else if(messageSelector==6){
     System.out.println("Smileys");
     }
     else if(messageSelector==7){
     System.out.println("Message settings");
    System.out.print("  1. Set\n2. Common\n");
    System.out.println("Enter 1 or 2 to select between the options: ");
    int setCommonSelector = scanner.nextInt();
      if(setCommonSelector==1){
       System.out.print("1. Message centre number\n2. Message sent as\n3. Message validity");
		System.out.println("choose from options 1-3: ");
		int messageCentre = scanner.nextInt();
		if(messageCentre==1){
		  System.out.println("Message centre number");
                }
		else if (messageCentre==2){
		  System.out.println("Message sent as");
                }
                else if(messageCentre==3){
		   System.out.println("Message validity");
		}
		
       }
       else if(setCommonSelector==2){
        System.out.print("1. Delivery reports\n2. Reply via same centre\n3. Character support\n");
		System.out.println("choose from options 1-3: ");
		int deliveryReport = scanner.nextInt();
		if(deliveryReport==1){
		   System.out.println("Delivery reports");
                }
		else if (deliveryReport==2){
		  System.out.println("Reply via same centre");
		}
		else if(deliveryReport==3){
		  System.out.println("Character support");
		}
           }
	
     } 
     else if (messageSelector==8){
       System.out.print("Info service");
     }
     else if(messageSelector==9){
       System.out.print("Voice mailbox number");
     }
     else if(messageSelector==10){
       System.out.print("Service command editor");
     }

  }
  else if(number==3){   
   System.out.println("Chat");
  }
  else if(number==4){
   System.out.println("	CALL REGISTER\n 1.-> Missed calls\n 2.-> Received calls\n 3.-> Dialled numbers\n 4.-> Erase recent call lists\n 5.-> Show call duration\n 6.-> Show all costs\n 7.-> Call cost settings\n 8.-> Prepaid credit\n");
  System.out.println("Select from options 1-8: ");
  int callRegisterSelector =  scanner.nextInt();
      if(callRegisterSelector==1){
	System.out.print("Missed calls");
      }
      else if(callRegisterSelector==2){
	System.out.print("Received calls");
      }
      else if(callRegisterSelector==3){
	System.out.print("Dialled numbers");
      }
      else if(callRegisterSelector==4){
	System.out.print("Erase cost settings");
      }
      else if(callRegisterSelector==5){
	System.out.print("Show call duration\n  1.->Last call duration\n  2.->All calls' duration\n  3.->Received calls' duration\n  4.->Dialled calls' duration\n  5.->Clear timers\n");
        System.out.print("Select an option from 1-5: ");
        int callRegister = scanner.nextInt();

		if(callRegister==1){
		  System.out.println("Last call duration");
		}
		else if(callRegister==2){
		  System.out.println("All calls' duration");
		}
		else if(callRegister==3){
		  System.out.println("Received calls' duration");
		}
		else if(callRegister==4){
		  System.out.println("Dialled calls' duration");
		}
		else if(callRegister==5){
		  System.out.println("Clear timers");
		}
		
	}
	else if(callRegisterSelector==6){
	 System.out.print("Show call costs\n  1.->Last call cost\n  2.->All calls' cost\n  3.->Clear counters\n");
          System.out.print("Select an option from 1-3: ");
	  int callCostSelector = scanner.nextInt();
		if (callCostSelector==1){
		   System.out.println("Last call cost");
		}
		else if(callCostSelector==2){
		   System.out.println("All calls' cost");
		}
		else if(callCostSelector==3){
  		   System.out.println("Clear counters");
		}
		
	}
	else if(callRegisterSelector==7){
	  System.out.print("Call cost limit\n  1.->Call cost limit\n  2.->Show costs in\n");
	   System.out.print("Select an option between 1 or 2: ");
	   int costSettings = scanner.nextInt();
		if(costSettings==1){
		  System.out.println("Call cost limit");
		}
		else if(costSettings==2){
		  System.out.println("Show cost in");
		}
		
	}
	else if(callRegisterSelector==8){
	  System.out.print("Prepaid credit");
        }
  

  }
  else if(number==5){
  System.out.println("Tones\n  1.->Ringing tone\n  2.->Ringing volume\n  3.->Incoming call alert\n  4->Composer\n  5->Message alert tone\n  6.->Keypad tones\n  7.->Warning and game tones\n  8.->Vibrating alert\n  9.->Screen saver\n");
	System.out.print("Select an option from 1-9: ");
        int toneSelector = scanner.nextInt();

		if(toneSelector==1){
		  System.out.println("Ringing tone");
		}
		else if(toneSelector==2){
		  System.out.println("Ringing volume");
		}
		else if(toneSelector==3){
		  System.out.println("Incoming call alert");
		}
		else if(toneSelector==4){
		  System.out.println("Composer");
		}
		else if(toneSelector==5){
		  System.out.println("Message alert tone");
		}
		else if(toneSelector==6){
		  System.out.println("Keypad tones");
		}
		else if(toneSelector==7){
		  System.out.println("Warning and game tones");
		}
		else if(toneSelector==8){
		  System.out.println("Vibrating alert");
		}
		else if(toneSelector==9){
		  System.out.println("Screen saver");
		}
 

  }
  else if(number==6){
  System.out.println("Settings\n  1.->Call settings\n  2.->Phone settings\n  3.->Security settings\n  4.->Restore factory settings\n");
  System.out.print("Select an option from 1-4: ");
        int settingSelector = scanner.nextInt();
		if(settingSelector==1){
		  System.out.println("Call settings\n  1.->Automatic redail\n  2.->Speed dailing\n  3.->Call waiting options\n  4.->Own number sending\n  5.->Phone line in use\n  6.->Confirm SIM service actions\n");
		 System.out.print("Select an option from 1-6: ");
        	 int callSet = scanner.nextInt(); 
		
		    if(callSet==1){
		     System.out.println("Automatic redail");
		    }
		    else if(callSet==2){
		      System.out.println("Speed dailing");
		    }
		    else if(callSet==3){
		     System.out.println("Call waiting options");
		    }
		    else if(callSet==4){
		      System.out.println("Own number sending");
		    }
		    else if(callSet==5){
		      System.out.println("Phone line in use");
		    }
		    else if(callSet==6){
		      System.out.println("Automatic answer");
		    }
	
		}
		else if(settingSelector==2){
		    System.out.println("Phone settings\n  1.->Language\n  2.->Cell info display\n  3.->Welcome note\n  4.->Network selection\n  5.->Lights\n  6.->Confirm SIM service actions\n");
		  System.out.print("Select an option from 1-6: ");
                  int phoneSet = scanner.nextInt(); 
		
		    if(phoneSet==1){
		      System.out.println("Language");
		    }
		    else if(phoneSet==2){
		      System.out.println("Cell info display");
		    }
		    else if(phoneSet==3){
		      System.out.println("Welcome note");
		    }
		    else if(phoneSet==4){
		      System.out.println("Network selection");
		    }
		    else if(phoneSet==5){
		      System.out.println("Lights");
		    }
		    else if(phoneSet==6){
		     System.out.println("Confirm SIM service actions");
		    }
		
		}
		else if(settingSelector==3){
		  System.out.println("Security settings\n  1.->PIN code request\n  2.->Call barring service\n  3.->Fixed dialling\n  4.->Closed user group\n  5.->Phone security\n  6.->Change access codes\n");
		  System.out.print("Select an option from 1-6: ");
                  int securitySet = scanner.nextInt(); 
		
		    if(securitySet==1){
		      System.out.println("PIN code request");
		    }
		    else if(securitySet==2){
		      System.out.println("Call barring service");
		    }
		    else if(securitySet==3){
		      System.out.println("Fixed dialling");
		    }
		    else if(securitySet==4){
		      System.out.println("Closed user group");
		    }
		    else if(securitySet==5){
		      System.out.println("Phone security");
		    }
		    else if(securitySet==6){
		      System.out.println("Change access codes");
		    }
		}
		else if(settingSelector==4){
		    System.out.println("Restore factory settings");
		}
 

  }
  else if(number==7){
  System.out.print("Call divert");
  }

  else if(number==8){
  System.out.print("Games");
  }

  else if(number==9){
  System.out.print("Calculator");
  }

  else if(number==10){
  System.out.print("Reminders");
  }

  else if (number==11){
  System.out.println("Clock\n  1.->Alarm clock\n  2.->Clock settings\n  3.->Date setting\n  4.->Stopwatch\n  5.->Countdown timer\n  6.->Auto update of date and time\n");
  	System.out.print("Select an option from 1-6: ");
                  int clockSetSelector = scanner.nextInt(); 
		
		if(clockSetSelector==1){
		  System.out.println("Alarm clock");
		}
		else if(clockSetSelector==2){
		  System.out.println("Clock settings");
		}
		else if(clockSetSelector==3){
		  System.out.println("Date setting");
		}
		else if(clockSetSelector==4){
		  System.out.println("Stopwatch");
		}
		else if(clockSetSelector==5){
		  System.out.println("Countdown timer");
		}
		else if(clockSetSelector==6){
		  System.out.println("Auto update of date and time");
		}
  

  }
  else if(number==12){
  System.out.print("Profiles");
  }

  else if(number==13){
  System.out.print("SIM services");
  }

  }

  

  

 

}












