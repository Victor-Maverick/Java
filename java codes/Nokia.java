import java.util.Scanner;
public class Nokia{

  Scanner scanner = new Scanner(System.in);
  public void menu(){
   System.out.print("--MAIN MENU--\n1. Phonebook\n2. Messages\n3. Chat\n4. Call register\n5. Tones\n6. Settings\n7. Call divert\n8. Games\n9. Calculator\n10. Reminders\n11. Clock\n12. Profiles\n13. SIM sevices\n");

  System.out.println("Enter a number between 1-13 to select an item: ");
  int number = scanner.nextInt();
      switch(number){
      case 1: phoneBook();
      case 2: message();break;
      case 3: chat();
      case 4: callRegister();
      case 5: tones();
      case 6: settings();
      case 7: callDivert();
      case 8: games();
      case 9: calculator();
      case 10: reminders();
      case 11: clock();
      case 12: profiles();
      case 13: simServices();
      default:  menu();
      }
    

    }
    
    public void phoneBook(){
     System.out.print("Phone book\n 1. Search\n2. Service Nos.\n3. Add name\n4. Erase\n5. Edit\n6. Assign tone\n7. Send b'card\n8. Options\n9. Speed dials\n10. Voice tags\n");
  
     System.out.print("Enter a number from 1-10 to select an option");
     int phoneBookSelection = scanner.nextInt();

     switch(phoneBookSelection){
      case 1: System.out.println("Search\n");
	search();
       break;
      case 2: System.out.println("Service Nos\n");
         servicenos();
       break;
      case 3: System.out.println("Add name\n");
        System.out.println("if you want to go back, enter 1: ");
       	 int backExit3 = scanner.nextInt();
         if (backExit3 == 1){
          phoneBook();
	}else{
         menu();
        }
       break;
      case 4: System.out.println("Erase\n");
	System.out.println("if you want to go back, enter 1 or any other number to return to main menu: ");
         int backExit4 = scanner.nextInt();
         if (backExit4 == 1){
          phoneBook();
	}else{
         menu();
        }
	break;
      case 5: System.out.println("Edit\n");
	System.out.println("if you want to go back, enter 1 or any other number to return to main menu: ");
        int backExit5 = scanner.nextInt();
         if (backExit5 == 1){
          phoneBook();
	}else{
         menu();
        }
	break;
      case 6: System.out.println("Assign tone\n");
	System.out.println("if you want to go back, enter 1 or any other number to return to main menu: ");
        int backExit6 = scanner.nextInt();
         if (backExit6 == 1){
          phoneBook();
	}else{
         menu();
        }
	break;
      case 7: System.out.println("Send b'card\n");
	System.out.println("if you want to go back, enter 1 or any other number to return to main menu: ");
       int backExit7 = scanner.nextInt();
         if (backExit7 == 1){
          phoneBook();
	}else{
         menu();
        }
	break;
      case 8: options();
	break;
      case 9: System.out.println("Speed dials\n");
	System.out.println("if you want to go back, enter 1 or any other number to return to main menu: ");
         int backExit8 = scanner.nextInt();
         if (backExit8 == 1){
          phoneBook();
	}else{
         menu();
        }
	break;
      case 10: System.out.println("Edit\n");
	System.out.println("if you want to go back, enter 1 or any other number to return to main menu: ");
        int backExit9 = scanner.nextInt();
         if (backExit9 == 1){
          phoneBook();
	}else{
         menu();
        }
	break;
	default: phoneBook();
       }
    }
 
	public void options(){
	System.out.println("Options\n 1.Type of view\n 2.Memory status");
	System.out.println("Select between options 1 or 2: ");
	int optionSelect = scanner.nextInt();
	 
	  switch(optionSelect){
	   case 1: System.out.println("Type of view\n");
		System.out.println("if you want to go back, enter 1, to return to main menu enter any other number: ");
        	 int goBack1 = scanner.nextInt();
        	 if (goBack1 == 1){
          	 options();
		 }
		 else if(goBack1 == 0){
		 phoneBook();
        	 }else{
		  menu();
		  }
		 break;
		
	   case 2: System.out.println("Memory status\n"); 
		System.out.println("if you want to go back, enter 1, to return to main menu enter any other number: ");
        	 int goBack2 = scanner.nextInt();
        	 if (goBack2 == 1){
          	 options();
		 }
		 else if(goBack2 == 0){
		 phoneBook(); 
		 }else{
         	 menu();
        	 }
		break;
		}
	  }	
	
		public void servicenos(){
		System.out.println("Enter 1 to go back to phonebook or any other number to return to main menu: ");
      		 int back1 = scanner.nextInt();
        	 if (back1 == 1){
         	 phoneBook();
		}else{
         	menu();
        	}
	     
	     }
		public void search(){
		System.out.println("Enter 1 to go back to phonebook or any other number to return to menu: ");
       		int backSearch = scanner.nextInt();
         	if (backSearch == 1){
          	phoneBook();
		}else{
         	menu();
        	}
	      }
	
	public void message(){
  System.out.print("Messages\n1. Write messages\n2. Inbox\n3. Outbox\n4. Picture messages\n5. Templates\n6. Smileys\n7. Message settings\n8. Info Service\n9. Voice mailbox number\n10. Service command editor\n"); 
  System.out.print("select an option from 1-10 \n");
  int messageSelector = scanner.nextInt();

    switch(messageSelector){
    case 1: System.out.println("Write messages\n");
	System.out.println("Enter 1 to go back or any number to go back to main menu: ");
	int backMessage = scanner.nextInt();
	if (backMessage ==1){
	message();
	}else{
	menu();
	}
     	break;
    case 2: System.out.println("Inbox\n");
	System.out.println("Enter 1 to go back or any number to go back to main menu: ");
	int backInbox = scanner.nextInt();
	if (backInbox ==1){
	message();
	}else{
	menu();
	}
	break;
    case 3: System.out.println("Outbox\n");
	System.out.println("Enter 1 to go back or any number to go back to main menu: ");
	int backOutbox = scanner.nextInt();
	if (backOutbox ==1){
	message();
	}else{
	menu();
	}
	break;
    case 4: System.out.print("Picture messages\n");
	System.out.println("Enter 1 to go back or any number to go back to main menu: ");
	int backPicture = scanner.nextInt();
	if (backPicture == 1){
	message();
	}else{
	menu();
	}
	break;
    case 5: System.out.println("Templates\n");
	System.out.println("Enter 1 to go back or any number to go back to main menu: ");
	int backTemplate = scanner.nextInt();
	if (backTemplate == 1){
	message();
	}else{
	menu();
	}
	break;
    case 6: System.out.println("Smileys\n");
	System.out.println("Enter 1 to go back or any number to go back to main menu: ");
	int backSmileys = scanner.nextInt();
	if (backSmileys ==1){
	message();
	}else{
	menu();
	}
	break;
    case 7: System.out.println("Message settings");
    System.out.print("  1. Set\n2. Common\n");
    System.out.println("Enter 1 or 2 to select between the options: ");
    int setCommonSelector = scanner.nextInt();
      switch(setCommonSelector){
       
       case 1: System.out.print("1. Message centre number\n2. Message sent as\n3. Message validity");
		System.out.println("choose from options 1-3: ");
		int messageCentre = scanner.nextInt();
		switch(messageCentre){
		  case 1: System.out.println("Message centre number\n");
		    System.out.println("Enter 1 to go back or any number to go back to menu: ");
			int backCentre = scanner.nextInt();
			if (backCentre ==1){
			message();
			}else{
			menu();
			}
		  break;
		  case 2: System.out.println("Message sent as\n");
		     System.out.println("Enter 1 to go back or any number to go back to menu: ");
			int backSentAs = scanner.nextInt();
			if (backSentAs ==1){
			message();
			}else{
			menu();
			}
			break;
		  case 3: System.out.println("Message validity\n");
		      System.out.println("Enter 1 to go back or any number to go back to menu: ");
			int backValidity = scanner.nextInt();
			if (backValidity ==1){
			message();
			}else{
			menu();
			}
			break;
		}
		break;      

       		case 2:System.out.print("1. Delivery reports\n2. Reply via same centre\n3. Character support\n");
		System.out.println("choose from options 1-3: ");
		int deliveryReport = scanner.nextInt();
		switch(deliveryReport){
		  case 1: System.out.println("Delivery reports\n");
		  System.out.println("Enter 1 to go back or any number to go back to menu: ");
			int backSentAs = scanner.nextInt();
			if (backSentAs ==1){
			message();
			}else{
			menu();
			}
			break;

		  case 2: System.out.println("Reply via same centre\n");
			System.out.println("Enter 1 to go back or any number to go back to menu: ");
			int backCentre = scanner.nextInt();
			if (backCentre ==1){
			message();
			}else{
			menu();
			}
			break;
		  case 3: System.out.println("Character support\n");
			System.out.println("Enter 1 to go back or any number to go back to menu: ");
			int backCharacter = scanner.nextInt();
			if (backCharacter ==1){
			message();
			}else{
			menu();
			}
			break;
		}
			
		break;
           }
	
      case 8: 
       System.out.print("Info service\n");
	System.out.println("Enter 1 to go back or any number to go back to menu: ");
	  int backInfo = scanner.nextInt();		
	   if (backInfo ==1){
	     message();
		}else{
		menu();
		}
       		break;

      case 9: 
       System.out.print("Voice mailbox number\n");
	System.out.println("Enter 1 to go back or any number to go back to menu: ");
	  int backMail = scanner.nextInt();
	   if (backMail ==1){
	    message();
	     }else{
		menu();
		}
       break;

      case 10:
       System.out.print("Service command editor\n");
	System.out.println("Enter 1 to go back or any number to go back to menu: ");
	 int backSentAs = scanner.nextInt();
	  if (backSentAs ==1){
	   message();
	    }else{
	     menu();
		}
       	     break;
	     }
		
	}

	  public void chat(){
	  System.out.println("Chat\n");
	   System.out.println("Enter 1 to go back or any number to go back to menu: ");
	    int backChat = scanner.nextInt();
		if (backChat ==1){
		menu();
		}else{
		chat();
		 }
			
		}
		

	public void callRegister(){
	 System.out.println("	CALL REGISTER\n 1.-> Missed calls\n 2.-> Received calls\n 3.-> Dialled numbers\n 4.-> Erase recent call lists\n 5.-> Show call duration\n 6.-> Show all costs\n 7.-> Call cost settings\n 8.-> Prepaid credit\n");
  System.out.println("Select from options 1-8: ");
  int callRegisterSelector =  scanner.nextInt();
      switch(callRegisterSelector){
      case 1:
	System.out.println("Missed calls\n");
	System.out.println("Enter 1 to go back or any number to go back to menu: ");
	    int backMissed = scanner.nextInt();
	     if (backMissed ==1){
	      callRegister();
	       }else{
		menu();
		}	
	break;
      case 2:
	System.out.println("Received calls\n");
	System.out.println("Enter 1 to go back or any number to go back to menu: ");
	    int backReceived = scanner.nextInt();
	     if (backReceived ==1){
	      callRegister();
	       }else{
		menu();
		}	
	break;
       case 3:
	System.out.print("Dialled numbers");
	System.out.println("Enter 1 to go back or any number to go back to menu: ");
	    int backDialled = scanner.nextInt();
	     if (backDialled ==1){
	      callRegister();
	       }else{
		menu();
		}	
	break;
       case 4:
	System.out.print("Erase cost settings");
	System.out.println("Enter 1 to go back or any number to go back to menu: ");
	    int backErase = scanner.nextInt();
	     if (backErase ==1){
	      callRegister();
	       }else{
		menu();
		}	
	break;
       case 5:
	showCallDuration();
	break;
	case 6:
	 showAllCosts();
		break;
	 case 7:
	  callCostLimit();
		break;
	 case 8:
	  System.out.println("Prepaid credit\n");
	   System.out.println("Enter 1 to go back or any other number to go back to main menu");
	   int backPrepaid = scanner.nextInt();
	   if(backPrepaid == 1){
	    callRegister();
	    }else{
	     menu();
	     }
		break;
      }
    }
        public void showCallDuration(){
	System.out.print("Show call duration\n  1.->Last call duration\n  2.->All calls' duration\n  3.->Received calls' duration\n  4.->Dialled calls' duration\n  5.->Clear timers\n");
        System.out.print("Select an option from 1-5: ");
        int callRegister = scanner.nextInt();

		switch(callRegister){
		  case 1: System.out.println("Last call duration\n");
		   System.out.println("Enter 1 to go back or 0 to go back to call register or any other number to main menu: ");
	    	    int backDuration = scanner.nextInt();
	     	    if (backDuration ==1){
	      	     showCallDuration();
	             }
		     else if (backDuration ==0){
		     callRegister();
		      }else{
			menu();
			}	
			break;
		  case 2: System.out.println("All calls' duration\n");
		   System.out.println("Enter 1 to go back or 0 to go back to call register or any other number to main menu: ");
	    	    int backAllCalls = scanner.nextInt();
	     	    if (backAllCalls ==1){
	      	     showCallDuration();
	             }
		     else if (backAllCalls ==0){
		     callRegister();
		      }else{
			menu();
			}	
			break;
		  case 3: System.out.println("Received calls' duration");
		   System.out.println("Enter 1 to go back or 0 to go back to call register or any other number to main menu: ");
	    	    int backReceivedDuration = scanner.nextInt();
	     	    if (backReceivedDuration ==1){
	      	     showCallDuration();
	             }
		     else if (backReceivedDuration ==0){
		     callRegister();
		      }else{
			menu();
			}	
			break;
		  case 4: System.out.println("Dialled calls' duration");
		  System.out.println("Enter 1 to go back or 0 to go back to call register or any other number to main menu: ");
	    	    int backDialledDuration = scanner.nextInt();
	     	    if (backDialledDuration ==1){
	      	     showCallDuration();
	             }
		     else if (backDialledDuration ==0){
		     callRegister();
		      }else{
			menu();
			}	
			break;
		  case 5: System.out.println("Clear timers\n");
		   System.out.println("Enter 1 to go back or 0 to go back to call register or any other number to main menu: ");
	    	    int backTimers = scanner.nextInt();
	     	    if (backTimers ==1){
	      	     showCallDuration();
	             }
		     else if (backTimers ==0){
		     callRegister();
		      }else{
			menu();
			}	
			break;
		}
		
	     }

	public void showAllCosts(){
	System.out.print("Show call costs\n  1.->Last call cost\n  2.->All calls' cost\n  3.->Clear counters\n");
        System.out.print("Select an option from 1-3: ");
	int callCostSelector = scanner.nextInt();
		switch(callCostSelector){
		  case 1: System.out.println("Last call cost\n");
		   System.out.println("Enter 1 to go back or 0 to go back to call register or any other number to main menu: ");
	    	    int backCallCost = scanner.nextInt();
	     	    if (backCallCost ==1){
	      	     showAllCosts();
	             }
		     else if (backCallCost ==0){
		     callRegister();
		      }else{
			menu();
			}	
			break;
		  case 2: System.out.println("All calls' cost\n");
		   System.out.println("Enter 1 to go back or 0 to go back to call register or any other number to main menu: ");
	    	    int backAllCallCost = scanner.nextInt();
	     	    if (backAllCallCost ==1){
	      	     showAllCosts();
	             }
		     else if (backAllCallCost ==0){
		     callRegister();
		      }else{
			menu();
			}	
			break;
		  case 3: System.out.println("Clear counters");
		    System.out.println("Enter 1 to go back or 0 to go back to call register or any other number to main menu: ");
	    	    int backClearCounters = scanner.nextInt();
	     	    if (backClearCounters ==1){
	      	     showAllCosts();
	             }
		     else if (backClearCounters ==0){
		     callRegister();
		      }else{
			menu();
			}	
			break;
		}
	      }
	   public void callCostLimit(){    
	   System.out.print("Call cost limit\n  1.->Call cost limit\n  2.->Show costs in\n");
	System.out.print("Select an option between 1 or 2: ");
	int costSettings = scanner.nextInt();
		switch(costSettings){
		  case 1: System.out.println("Call cost limit");
		   System.out.println("Enter 1 to go back or 0 to go back to call register or any other number to main menu: ");
	    	    int backCostLimit = scanner.nextInt();
	     	    if (backCostLimit ==1){
	      	     callCostLimit();
	             }
		     else if (backCostLimit ==0){
		     callRegister();
		      }else{
			menu();
			}	
			break;
		  case 2: System.out.println("Show cost in");
		    System.out.println("Enter 1 to go back or 0 to go back to call register or any other number to main menu: ");
	    	    int backCostIn = scanner.nextInt();
	     	    if (backCostIn ==1){
	      	     callCostLimit();
	             }
		     else if (backCostIn ==0){
		     callRegister();
		      }else{
			menu();
			}	

			break;
			 }
		}

  	public void tones(){ 
  System.out.println("Tones\n  1.->Ringing tone\n  2.->Ringing volume\n  3.->Incoming call alert\n  4->Composer\n  5->Message alert tone\n  6.->Keypad tones\n  7.->Warning and game tones\n  8.->Vibrating alert\n  9.->Screen saver\n");
	System.out.print("Select an option from 1-9: ");
        int toneSelector = scanner.nextInt();

		switch(toneSelector){
		  case 1: System.out.println("Ringing tone\n");
		   System.out.println("Enter 0 to go back or any other number to go back to the main menu: ");
		    int backRinging = scanner.nextInt();
		     if(backRinging == 0){
			tones();
		     }else{
		        menu();
			}
			break;
		  case 2: System.out.println("Ringing volume\n");
		    System.out.println("Enter 0 to go back or any other number to go back to the main menu: ");
		    int backVolume = scanner.nextInt();
		     if(backVolume == 0){
			tones();
		     }else{
		        menu();
			}
			break;
		  case 3: System.out.println("Incoming call alert\n");
		    System.out.println("Enter 0 to go back or any other number to go back to the main menu: ");
		    int backCallAlert = scanner.nextInt();
		     if(backCallAlert == 0){
			tones();
		     }else{
		        menu();
			}
			break;
		  case 4: System.out.println("Composer\n");
		    System.out.println("Enter 0 to go back or any other number to go back to the main menu: ");
		    int backComposer = scanner.nextInt();
		     if(backComposer == 0){
			tones();
		     }else{
		        menu();
			}
			break;
		  case 5: System.out.println("Message alert tone\n");
		    System.out.println("Enter 0 to go back or any other number to go back to the main menu: ");
		    int backMessageAlert = scanner.nextInt();
		     if(backMessageAlert == 0){
			tones();
		     }else{
		        menu();
			}
			break;
		  case 6: System.out.println("Keypad tones\n");
		    System.out.println("Enter 0 to go back or any other number to go back to the main menu: ");
		    int backKeyTones = scanner.nextInt();
		     if(backKeyTones == 0){
			tones();
		     }else{
		        menu();
			}
			break;
		  case 7: System.out.println("Warning and game tones\n");
		    System.out.println("Enter 0 to go back or any other number to go back to the main menu: ");
		    int backWarning = scanner.nextInt();
		     if(backWarning == 0){
			tones();
		     }else{
		        menu();
			}
			break;
		  case 8: System.out.println("Vibrating alert\n");
		     System.out.println("Enter 0 to go back or any other number to go back to the main menu: ");
		    int backVibration = scanner.nextInt();
		     if(backVibration == 0){
			tones();
		     }else{
		        menu();
			}
			break;
		  case 9: System.out.println("Screen saver\n");
		    System.out.println("Enter 0 to go back or any other number to go back to the main menu: ");
		    int backScreenSaver = scanner.nextInt();
		     if(backScreenSaver == 0){
			tones();
		     }else{
		        menu();
			}
			break;
		}
 		
		}

        public void settings(){
	System.out.println("Settings\n  1.->Call settings\n  2.->Phone settings\n  3.->Security settings\n  4.->Restore factory settings\n");
  System.out.print("Select an option from 1-4: ");
        int settingSelector = scanner.nextInt();
		switch(settingSelector){
		  case 1: callSettings();
		    break;
		  case 2: phoneSettings();
			break;
		  case 3: securitySettings();
			break;
		  case 4: System.out.println("Restore factory settings\n");
		    System.out.println("Enter 1 to go back or any other number to go back to main menu: ");
		     int backRestore = scanner.nextInt();
		     if (backRestore == 1){
		      settings();
		     }else{
			menu();
			}
			break;
		}
  
	}
	public void callSettings(){
	System.out.println("Call settings\n  1.->Automatic redail\n  2.->Speed dailing\n  3.->Call waiting options\n  4.->Own number sending\n  5.->Phone line in use\n  6.->Confirm SIM service actions\n");
		 System.out.print("Select an option from 1-6: ");
        	 int callSet = scanner.nextInt(); 
		
		    switch(callSet){
		     case 1: System.out.println("Automatic redail\n");
		       System.out.println("Enter 1 to go back or 0 to go back to settings or any other number to go back to the main menu: ");
		      int backRedail = scanner.nextInt();
			if (backRedail == 1){
			  callSettings();
			}
			else if (backRedail == 0){
			  settings();
			}else{
			  menu();
			}
			break;
		     case 2: System.out.println("Speed dailing\n");
		      System.out.println("Enter 1 to go back or 0 to go back to settings or any other number to go back to the main menu: ");
		      int backSpeedDail = scanner.nextInt();
			if (backSpeedDail == 1){
			  callSettings();
			}
			else if (backSpeedDail == 0){
			  settings();
			}else{
			  menu();
			}
			break;
		     case 3: System.out.println("Call waiting options\n");
		      System.out.println("Enter 1 to go back or 0 to go back to settings or any other number to go back to the main menu: ");
		      int backCallWaiting = scanner.nextInt();
			if (backCallWaiting == 1){
			  callSettings();
			}
			else if (backCallWaiting == 0){
			  settings();
			}else{
			  menu();
			}
			break;
		     case 4: System.out.println("Own number sending\n");
		      System.out.println("Enter 1 to go back or 0 to go back to settings or any other number to go back to the main menu: ");
		      int backOwnNumber = scanner.nextInt();
			if (backOwnNumber == 1){
			  callSettings();
			}
			else if (backOwnNumber == 0){
			  settings();
			}else{
			  menu();
			}
			break;
		     case 5: System.out.println("Phone line in use\n");
		      System.out.println("Enter 1 to go back or 0 to go back to settings or any other number to go back to the main menu: ");
		      int backPhoneLine = scanner.nextInt();
			if (backPhoneLine == 1){
			  callSettings();
			}
			else if (backPhoneLine == 0){
			  settings();
			}else{
			  menu();
			}
			break;
		     case 6: System.out.println("Automatic answer\n");
		      System.out.println("Enter 1 to go back or 0 to go back to settings or any other number to go back to the main menu: ");
		      int backAnswer = scanner.nextInt();
			if (backAnswer == 1){
			  callSettings();
			}
			else if (backAnswer == 0){
			  settings();
			}else{
			  menu();
			}
			break;
		  }
		}
	public void phoneSettings(){
	System.out.println("Phone settings\n  1.->Language\n  2.->Cell info display\n  3.->Welcome note\n  4.->Network selection\n  5.->Lights\n  6.->Confirm SIM service actions\n");
		  System.out.print("Select an option from 1-6: ");
                  int phoneSet = scanner.nextInt(); 
		
		    switch(phoneSet){
		     case 1: System.out.println("Language\n");
		      System.out.println("Enter 1 to go back or 0 to go back to settings or any other number to go back to the main menu: ");
		      int backLanguage = scanner.nextInt();
			if (backLanguage == 1){
			  phoneSettings();
			}
			else if (backLanguage == 0){
			  settings();
			}else{
			  menu();
			}
			break;
		     case 2: System.out.println("Cell info display\n");
		      System.out.println("Enter 1 to go back or 0 to go back to settings or any other number to go back to the main menu: ");
		      int backCellInfo = scanner.nextInt();
			if (backCellInfo == 1){
			  phoneSettings();
			}
			else if (backCellInfo == 0){
			  settings();
			}else{
			  menu();
			}
			break;
		     case 3: System.out.println("Welcome note\n");
		      System.out.println("Enter 1 to go back or 0 to go back to settings or any other number to go back to the main menu: ");
		      int backWelcomeNote = scanner.nextInt();
			if (backWelcomeNote == 1){
			  phoneSettings();
			}
			else if (backWelcomeNote == 0){
			  settings();
			}else{
			  menu();
			}
			break;
		     case 4: System.out.println("Network selection\n");
		      System.out.println("Enter 1 to go back or 0 to go back to settings or any other number to go back to the main menu: ");
		      int backNetwork = scanner.nextInt();
			if (backNetwork == 1){
			  phoneSettings();
			}
			else if (backNetwork == 0){
			  settings();
			}else{
			  menu();
			}
			break;
		     case 5: System.out.println("Lights\n");
		      System.out.println("Enter 1 to go back or 0 to go back to settings or any other number to go back to the main menu: ");
		      int backLights = scanner.nextInt();
			if (backLights == 1){
			  phoneSettings();
			}
			else if (backLights == 0){
			  settings();
			}else{
			  menu();
			}
			break;
		     case 6: System.out.println("Confirm SIM service actions\n");
		      System.out.println("Enter 1 to go back or 0 to go back to settings or any other number to go back to the main menu: ");
		      int backConfirmSim = scanner.nextInt();
			if (backConfirmSim == 1){
			  phoneSettings();
			}
			else if (backConfirmSim == 0){
			  settings();
			}else{
			  menu();
			}
			break;
		}
	      }
	public void securitySettings(){
	System.out.println("Security settings\n  1.->PIN code request\n  2.->Call barring service\n  3.->Fixed dialling\n  4.->Closed user group\n  5.->Phone security\n  6.->Change access codes\n");
		  System.out.print("Select an option from 1-6: ");
                  int securitySet = scanner.nextInt(); 
		
		    switch(securitySet){
		     case 1: System.out.println("PIN code request\n");
		      System.out.println("Enter 1 to go back or 0 to go back to settings or any other number to go back to the main menu: ");
		      int backCodeRequest = scanner.nextInt();
			if (backCodeRequest == 1){
			  securitySettings();
			}
			else if (backCodeRequest == 0){
			  settings();
			}else{
			  menu();
			}
			break;
		     case 2: System.out.println("Call barring service\n");
		      System.out.println("Enter 1 to go back or 0 to go back to settings or any other number to go back to the main menu: ");
		      int backCallBarring = scanner.nextInt();
			if (backCallBarring == 1){
			  securitySettings();
			}
			else if (backCallBarring == 0){
			  settings();
			}else{
			  menu();
			}
			break;
		     case 3: System.out.println("Fixed dialling\n");
		      System.out.println("Enter 1 to go back or 0 to go back to settings or any other number to go back to the main menu: ");
		      int backFixedDailling = scanner.nextInt();
			if (backFixedDailling == 1){
			  securitySettings();
			}
			else if (backFixedDailling == 0){
			  settings();
			}else{
			  menu();
			}
			break;
		     case 4: System.out.println("Closed user group\n");
		      System.out.println("Enter 1 to go back or 0 to go back to settings or any other number to go back to the main menu: ");
		      int backUserGroup = scanner.nextInt();
			if (backUserGroup == 1){
			  securitySettings();
			}
			else if (backUserGroup == 0){
			  settings();
			}else{
			  menu();
			}
			break;
		     case 5: System.out.println("Phone security\n");
		      System.out.println("Enter 1 to go back or 0 to go back to settings or any other number to go back to the main menu: ");
		      int backPhoneSecurity = scanner.nextInt();
			if (backPhoneSecurity == 1){
			  securitySettings();
			}
			else if (backPhoneSecurity == 0){
			  settings();
			}else{
			  menu();
			}
			break;
		     case 6: System.out.println("Change access codes\n");
		      System.out.println("Enter 1 to go back or 0 to go back to settings or any other number to go back to the main menu: ");
		      int backAccessCodes = scanner.nextInt();
			if (backAccessCodes == 1){
			  securitySettings();
			}
			else if (backAccessCodes == 0){
			  settings();
			}else{
			  menu();
			}
			break;
		  }
		}
  public void callDivert(){
  System.out.println("Call divert\n");
   System.out.println("Enter 0 or any other number to return to main menu");
    int backDivert = scanner.nextInt();
     if (backDivert == 0){
      menu();
     }else{
	menu();
     }
   }

  public void games(){
  System.out.print("Games\n");
   System.out.println("Enter 0 or any number to return to main menu");
    int backGames = scanner.nextInt();
     if (backGames == 0){
      menu();
     }else{
	menu();
     }
  }
  public void calculator(){
  System.out.print("Calculator\n");
   System.out.println("Enter 0 or any other number to return to main menu");
    int backCalculator = scanner.nextInt();
     if (backCalculator == 0){
      menu();
     }else{
	menu();
     }
  }
  public void reminders(){
  System.out.print("Reminders\n");
   System.out.println("Enter 0 or any other number to return to main menu");
    int backReminders = scanner.nextInt();
     if (backReminders == 0){
      menu();
     }else{
	menu();
     }
  }
   public void clock(){
   System.out.println("Clock\n  1.->Alarm clock\n  2.->Clock settings\n  3.->Date setting\n  4.->Stopwatch\n  5.->Countdown timer\n  6.->Auto update of date and time\n");
  	System.out.print("Select an option from 1-6: ");
                  int clockSetSelector = scanner.nextInt(); 
		
		    switch(clockSetSelector){
		     case 1: System.out.println("Alarm clock\n");
		      System.out.println("Enter 1 to return to clock or any other number to go back to  main menu: ");
		       int backAlarm = scanner.nextInt();
		        if (backAlarm == 1){
			  clock();
			}else{
			 menu();
			}
			break;
		     case 2: System.out.println("Clock settings\n");
		      System.out.println("Enter 1 to return to clock or any other number to go back to  main menu: ");
		       int backClockSet = scanner.nextInt();
		        if (backClockSet == 1){
			  clock();
			}else{
			 menu();
			}
			break;
		     case 3: System.out.println("Date setting\n");
		      System.out.println("Enter 1 to return to clock or any other number to go back to  main menu: ");
		       int backDateSet = scanner.nextInt();
		        if (backDateSet == 1){
			  clock();
			}else{
			 menu();
			}
			break;
		     case 4: System.out.println("Stopwatch\n");
		      System.out.println("Enter 1 to return to clock or any other number to go back to  main menu: ");
		       int backStopwatch = scanner.nextInt();
		        if (backStopwatch == 1){
			  clock();
			}else{
			 menu();
			}
			break;
		     case 5: System.out.println("Countdown timer\n");
		      System.out.println("Enter 1 to return to clock or any other number to go back to  main menu: ");
		       int backCountdown = scanner.nextInt();
		        if (backCountdown == 1){
			  clock();
			}else{
			 menu();
			}
			break;
		     case 6: System.out.println("Auto update of date and time\n");
		      System.out.println("Enter 1 to return to clock or any other number to go back to  main menu: ");
		       int backUpdate = scanner.nextInt();
		        if (backUpdate == 1){
			  clock();
			}else{
			 menu();
			}
		break;
		}
  		
	}

	public void profiles(){
 	 System.out.println("Profiles\n");
   	System.out.println("Enter 0 or any other number to return to main menu");
   	 int backProfile = scanner.nextInt();
    	 if (backProfile == 0){
     	 menu();
    	 }else{
	  menu();
   	  }
 	 }

 	public void simServices(){
  	System.out.print("SIM services\n");
   	System.out.println("Enter 0 or any number to return to main menu");
    	int backServices = scanner.nextInt();
     	if (backServices == 0){
      	menu();
     	}else{
	menu();
     	}
  	}
  	

}
