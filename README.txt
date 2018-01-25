"# barclays_theater_seating_solution" 



I choose to provide the solution to the 3rd problem that was stated in the assignment.  The approach I have taken is as follows.
As per the theater layout I created a 2 dimension matrix of seats assignments with the give inputs.  Each of the rows and column in the array corresponds to a specific seating arrangement.  You will see this in the file TheaterMap.java 
I also have the added an additional column for each of the rows to keep track of remaining seats on that particular row.
The input is taken via a class ListInputRequest.java to which we can add additional requests for testing.
The InputScanner will scan this input in sequence and generate the output for each input request
The logic will first take for special cases so that we adhere to the principal of quickly existing when some specific conditions are satisfied.  Then go for specific use cases.
You will notice that the assign() method has been split further into methods to keep the code as self-explanatory as possible.  The name of the methods are also kept such that they specific its intended purpose.
However in case you have questions, please do call me 302-494-9935.
I really appreciate you taking the time to provide me this wonderful opportunity.  I enjoyed working at this challenge and look forward to meet you for an interview in person.

To work for Barclays will be my dream come true.



Output of the program:

Smith Row 1 Section 1
Jones Row 2 Section 2
Davis Row 1 Section 2
Wilson Sorry, we can't handle your party.
Johnson Row 2 Section 1
Williams Row 1 Section 1
Brown Row 4 Section 2
Miller Call to split party.
Darshan Row 2 Section 3
Trupti Row 3 Section 2
Janak Row 2 Section 1 
Mohan Row 2 Section 1 


Input to my program above:

		 "Smith 2" 
		 "Jones 5" 
		 "Davis 6" 
		 "Wilson 100" 
		 "Johnson 3" 
		 "Williams 4" 
		 "Brown 8" 
		 "Miller 12" 
		 "Darshan 5" 
		 "Trupti 6" 
		 "Janak 7" 
		 "Mohan 1"

