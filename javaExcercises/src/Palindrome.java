
public class Palindrome{

        public boolean checkPalindrome(String number){
            int length = number.length();

            String str = "";
            for(int count = length - 1; count >= 0; count--){

                str += number.charAt(count);
            }
            if(number.equals(str)){
                return true;
            }
            return false;
        }


    }



