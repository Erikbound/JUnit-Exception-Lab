import java.util.Scanner;

public class SocSecProcessor {

	public static void main(String[] args) {
		String name = "";
		String ssn = "";
		String ans = "";
		Scanner scan = new Scanner(System.in);
		boolean valid = false;
		
		while (!valid) {
			
			System.out.println("Name? ");
			name = scan.nextLine();
			System.out.println("SSN? ");
			ssn = scan.nextLine();
			
			try {
				valid = isValid(ssn);
			}
			catch (SocSecException e) {
				System.out.println("Continue? Y/N");
				ans = scan.nextLine();
				if (ans == "N" || ans == "n") {
					break;
				}
			}
		}
		scan.close();
		System.out.print(name + " " + ssn + " is valid.");
	}
	
	public static boolean isValid(String ssn) throws SocSecException{
		
			//Check Length
		if (ssn.length() != 11) {
			throw new SocSecException("Invalid Social Security Number, wrong number of characters.");
		}
			//Check Dashes in the correct spots and digits only
		for (int i = 0; i < ssn.length(); i++) {
			if (i == 3 || i == 6){
				if (ssn.charAt(i) != '-') {
					throw new SocSecException("Invalid Social Security Number, dash at wrong position.");
				}
			}
			else if (ssn.charAt(i) < 48 || ssn.charAt(i) > 57) {
				throw new SocSecException("Invalid Social Security Number, contains a character that isn't a digit.");
			}
		}
		
		return true;
	}

}
