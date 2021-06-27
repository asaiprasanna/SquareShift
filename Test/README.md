Please refer the Airplane.java for the solution

#User need to enter Following inputs:
	Number of Panels/ Divisions in a row
	Number of adjacent seats and rows for each Panel/ Division
	Number of seats to allocate

#My Approach:
	Assigning the Seat type first by picking an character array as follows:
	1. first and last rows are specified as Window 'W' in the each row according to the panel rows
	2. By using loops last seat of first division and first seat in the last division specified as Aisel 'A'
	3. Remaining seats are specified as Middle Seats 'M'
	4. By using for loop iterated through all panel except first and last.
	5. First and Last of all the panels are specified as Aisel 'A'
	6. Remaining seats are specified as Middle Seats 'M'
	
#Sample Input
Enter number of Panels/ divisions
4
Enter Number of adjacent seats in the panel - 1
3
Enter Number of rows in the panel - 1
2
Enter Number of adjacent seats in the panel - 2
4
Enter Number of rows in the panel - 2
3
Enter Number of adjacent seats in the panel - 3
2
Enter Number of rows in the panel - 3
3
Enter Number of adjacent seats in the panel - 4
3
Enter Number of rows in the panel - 4
4
Enter maximum number of seats to allow
30

#Sample Output
W	M	A		A	M	M	A		A	A		A	M	W
19	25	1		2	26	27	3		4	5		6	28	20	
21	29	7		8	30		9		10	11		12		22	
				13			14		15	16		17		23	