/*
Modellierung und Programmierung 1
Aufgabentyp: Serie 0
Bearbeitet von: Max Beining
*/

public class Name {

	public static void main(String[] args) {
		String name = "Max Beining";
		String eman = "";
		// Create Loop with length "Name"
		for (int i = 0; i != name.length(); i++) {
			eman += name.charAt(name.length() - i - 1);
		}
		// Print Statement
		System.out.println(eman);
	}

}
