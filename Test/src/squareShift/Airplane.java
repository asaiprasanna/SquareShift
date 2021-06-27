package squareShift;
import java.util.Scanner;

public class Airplane {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of Panels/ divisions");
		int noOfPanels = scanner.nextInt();
		if(noOfPanels < 3) {
			throw new Exception("Panel count is not less than 3");
		}
		int seatStructure[][] = new int[noOfPanels][2];
		int maxSeatsAllowed = 0;
		for(int i = 0; i < noOfPanels; i++) {
			System.out.println("Enter Number of adjacent seats in the panel - " + (i+1));
			int seatsCount = scanner.nextInt();
			System.out.println("Enter Number of rows in the panel - " + (i+1));
			int rowsCount = scanner.nextInt();
			maxSeatsAllowed = maxSeatsAllowed + (seatsCount * rowsCount);
			seatStructure[i][0] = seatsCount;
			seatStructure[i][1] = rowsCount;
		}
		System.out.println("Enter maximum number of seats to allow");
		int maxSeatsToAllot = scanner.nextInt();
		if (maxSeatsAllowed < maxSeatsToAllot) {
			throw new Exception(" Entered seats are more than plane seat capacity");
		}
		
		int rows = 0;
		int cols = 0;
		for(int i=0; i < seatStructure.length; i++) {
			if(rows < seatStructure[i][1]) {
				rows = seatStructure[i][1];
			}
			cols += seatStructure[i][0];
		}
		cols = (cols + seatStructure.length) - 1;
		char seatLayout[][] = new char[rows][cols];
		
		System.out.println(rows + " " + cols);
		
		// Window Seat Arrangement
		for(int i=0; i < seatLayout.length; i++) {
			if(i < seatStructure[0][1]) {
				seatLayout[i][0] = 'W';
			}
			if(i < seatStructure[seatStructure.length-1][1]) {
				seatLayout[i][cols-1] = 'W';
			}
			
		}
		
		// Left Side
		int aSeat = 0;
		for(int i=0; i < seatStructure[seatStructure.length-1][1]; i++) {
			aSeat = cols - seatStructure[seatStructure.length-1][0];
			seatLayout[i][aSeat] = 'A';	
		}
		for(int i=0; i < seatStructure[seatStructure.length-1][1]; i++) {
			for(int j = 1; j< seatStructure[seatStructure.length-1][0] - 1; j++) {
				seatLayout[i][aSeat+j] = 'M';
			}
		}
		
		// Right Side
		for(int i=0; i < seatStructure[0][1]; i++) {
			seatLayout[i][seatStructure[0][0]-1] = 'A';	
		}
		for(int i=0; i < seatStructure[0][1]; i++) {
			for(int j = 1; j< seatStructure[0][0] - 1; j++) {
				seatLayout[i][j] = 'M';
			}
		}
		
		// Middle Layout
		int currentCol = seatStructure[0][0] + 1;
		for(int i = 1; i < seatStructure.length-1; i++) {
			for(int j= 0; j < seatStructure[i][1]; j++ ) {
				seatLayout[j][currentCol] = 'A';
				seatLayout[j][currentCol + seatStructure[i][0] -1] = 'A';
				for(int k= 1; k < seatStructure[i][0]-1; k++ ) {
					seatLayout[j][currentCol + k] = 'M';
				}
			}
			
			
			currentCol += seatStructure[i][0] + 1;
			
		}
		int seatNumber = 1;
		int [][]seats = new int[rows][cols];
		
		// Seat Numbering
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if(seatLayout[i][j] == 'A') {
					seats[i][j] = seatNumber;
					seatNumber++;
				}
				if(seatNumber > maxSeatsToAllot)
					break;
			}   
		}
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if(seatLayout[i][j] == 'W') {
					seats[i][j] = seatNumber;
					seatNumber++;
				}
				if(seatNumber > maxSeatsToAllot)
					break;
			}   
		}
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if(seatLayout[i][j] == 'M') {
					seats[i][j] = seatNumber;
					seatNumber++;
				}
				if(seatNumber > maxSeatsToAllot)
					break;
			}   
		}
		
		for(int i =0; i<seatLayout[0].length; i++) {
			if(seatLayout[0][i] != ' ')
				System.out.print(seatLayout[0][i] + "\t");
			else
				System.out.print("\t");
		}
		System.out.println();
		for(int i = 0; i< rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(seats[i][j] != 0)
					System.out.print(seats[i][j] + "\t");
				else
					System.out.print("\t");
			}
			System.out.println();
		}

	}

}
