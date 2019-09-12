package wong.bcs345.hwk.purchases.standalonereport;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * The <strong>CustomerDriver</strong> class.
 * <p>
 * Reads an input file and writes to an output file.
 * </p>
 * 
 * @author Natalie Wong
 * @version HW#1
 * @since Sep 11, 2019
 */
public class CustomerDriver {

	/**
	 * Main entry point of the program
	 * @param args Arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String fileName;
		Scanner userInput = new Scanner(System.in);
		Scanner fileScanner;
		System.out.printf("Enter the input filename: ");
		fileName = userInput.nextLine();

		// open the entered fileName, read its contents and close the file
		
		try {
			fileScanner = new Scanner(new FileReader(fileName));
			PrintStream writeReport;

			System.out.printf("Opened %s\n", fileName);
			
			String outputFileName;
			System.out.print("Enter the output file name: ");
			
			outputFileName = userInput.nextLine();
			
			writeReport = new PrintStream(outputFileName);
			
			System.out.printf("Writing to %s.\n\n", outputFileName);
			
			// headers for output
			writeReport.println("Purchase Report");
			writeReport.println("---------------");
			
			String fName, lName, addressNumber, addressStreet, city, state, zipcode;
			
			fName = fileScanner.nextLine();
			lName = fileScanner.nextLine();
			addressNumber = fileScanner.nextLine();
			addressStreet = fileScanner.nextLine();
			city = fileScanner.nextLine();
			state = fileScanner.nextLine();
			zipcode = fileScanner.nextLine();
			
			writeReport.println(fName + " " + lName);
			writeReport.println(addressNumber + " " + addressStreet);
			writeReport.println(city + "," + " " + state + " " + zipcode);
			writeReport.printf("\n");

			
			String description;
			double price, cost, quantity;
			
			// product headers
			writeReport.printf("%-30s","Description");
			writeReport.printf("%25s","Price");
			writeReport.printf("%15s", "Quantity");
			writeReport.printf("%15s", "Cost");
			writeReport.printf("\n");
			writeReport.printf("%-30s", "-----------");
			writeReport.printf("%25s", "-----");
			writeReport.printf("%15s", "--------");
			writeReport.printf("%15s", "----");
			writeReport.printf("\n");
			
			double totalQuantity = 0.0;
			double totalCost = 0.0;
			while (fileScanner.hasNext()) {
			
				
				description = fileScanner.nextLine(); // reads line and consumes new line character
				price = fileScanner.nextDouble();     // reads number and then stops there, does not read new line character
				quantity = fileScanner.nextDouble();
				fileScanner.nextLine();               // reads number and consumes that new line character after it
				cost = price * quantity;
				
				// prints product data into the writeReport PrintStream
				writeReport.printf("%-30s", description);
				writeReport.printf("%25.2f", price);
				writeReport.printf("%15.0f", quantity);
				writeReport.printf("%15.2f\n", cost);
				
				totalQuantity += quantity;
				totalCost += cost;
				
			}
			
			// prints separators to the writeReport PrintStream
			writeReport.printf("%-30s", "-----------");
			writeReport.printf("%25s", "-----");
			writeReport.printf("%15s", "--------");
			writeReport.printf("%15s", "----");
			writeReport.printf("\n");
			writeReport.printf("%-30s", "Total");
			writeReport.printf("%25s", "");
			writeReport.printf("%15.0f", totalQuantity);
			writeReport.printf("%15.2f\n", totalCost);

			System.out.printf("Finished writing to ", fileName);
			
			writeReport.close();
			fileScanner.close();

		} catch (FileNotFoundException e) {
			System.out.println("\nCould not open " + fileName);
		}

	}

}
