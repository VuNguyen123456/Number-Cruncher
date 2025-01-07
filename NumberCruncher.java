public class NumberCruncher {
	public static boolean isPrime(int input){
		// return false if input is 0 because 0 is not prime and you can't divide by 0
		int checkprime = 0;
		if (input == 0){
			return false;
		}
		//Divide input with each of the number leading up to it to find input factors
		for (int i = 1; i <=input; i++){
			if (input % i == 0){
				checkprime += 1;
			}
		}
		//If the amount of factor = 2 then it is prime
		if (checkprime == 2) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	*
	* This method returns true if
	*
	*
	*/
	public static boolean isCoprime(int input1, int input2) {
		//Create 2 arrays to store factor of input 1 and input 2
		int[] factor1 = new int[input1];
		int[] factor2 = new int[input2];
		//Find the factor of input1
		for (int i = 1; i <= input1; i++){
			if(input1 % i == 0){
				factor1[i-1] = i;
			}
			//If num not a factor of input1 put it equal to 1
			else{
				factor1[i-1] = 1;
			}
		}
		//Find the factor of input2
		for (int i = 1; i <= input2; i++){
			if(input2 % i == 0){
				factor2[i-1] = i;
			}
			//If num not a factor of input2 put it equal to 1
			else{
				factor2[i - 1] = 1;
			}

		}
		//Check the 2 arrays for similarities 
		int checkCo = 1;
		for (int i = 0; i < factor1.length; i++){
			for (int j = 0; j < factor2.length; j++){
				//Check if the similarities exist and it is not 1
				if (factor1[i] == factor2[j] && factor1[i] != 1) {
					checkCo += 1;
				}
			}
		}
		//If similarities between 2 array = 1 then its not coprime else it is coprime
		if (checkCo > 1){
			return false;
		}
		else{
			return true;
		}
	     
	}


	/**
	*
	* This method returns true if
	*
	*
	*/
	public static boolean isFibonacciPrime(long input) {
		//Variable
		int head = 1;
		int tail = 1;
		int nextFibo;
		//Convert long into int
		int input1 = (int)input;
		//Create an array with length equals 2 times input just in case
		int [] array = new int[input1*2];
		boolean fiboCheck = false;
		//F1 and F2 always equals 1
		for (int i = 0; i < array.length; ++i) {
			if (i == 0 || i == 1){
				array[i] = 1;
			}
			//Make the next Fibocci = sum of 2 fibo before it, put it into the array, make sure that the next "next" Fibo = sum of 2 fibo before it
			else{
				nextFibo = head + tail;
				array[i] = nextFibo;
				tail = head;
				head = nextFibo;
			}
		}
		//Checking if input is a Fibocci num
		for (int i =0; i< array.length; ++i){
			if(array[i] == input1){
				fiboCheck = true;
			}
			}
		//Returnning result
		if (fiboCheck == true && isPrime(input1) == true){
			return true;
		}
		else{
			return false;
		}

	}

	/**
	 *
	 * This method returns the number of steps it takes to get to 1
	 * following the collatz game rules starting at the input
	 */
	public static int countCollatzSteps(int input){
		int num =0;
		//while the input is not 1, the loop doesn't end
		while ( input != 1 && input !=0) {
			//Increment num by 1 if input is even, and divide input by 2
			if(input % 2 == 0){
				input /= 2;
				num+= 1;
			}
			//Increment num by 1 if input is odd, multiply input by 3 and add 1 to input 
			else if (input % 2 == 1){
				input = input * 3 + 1;
				num += 1;
			}
		}
		//return number of times it took for input to return to 0
		return num;
	}

	/**
	 *
	 * This method marks off all the spots in the input array
	 * corresponding to composite numbers, leaving only the
	 * prime numbers as true.
	 */
	public static void sieveOfEratosthenes(boolean[] array){
		//Looping by the length of the array
		for (int i = 0; i < array.length; ++i){
			//If the index of the array is prime then make the elements in it equals to true
			if (isPrime(i) == true) {
				array[i] = true;
			}
			//If the index of the array is not prime then make the elements in it equals to false
			else if(isPrime(i) == false){
				array[i] = false;
			}
			
		}
	}

	/**
	 * Modifies a two-dimensional array in-place. Every occurrence of item
	 * is replaced by replacement.
	 */
	public static void replaceItem(int[][] array, int item, int[] replacement){
		//Create variable that count the number of item need to be replace in the array
		int replaceCheck = 0;
		for (int i =0; i < array.length; ++i) {
			replaceCheck =0;
			for(int j = 0; j < array[i].length; ++j){
				if (array[i][j] == item){
					replaceCheck += 1;
				}
			}
			//Create a temperory array that has the length of the array that is going to replace the original array
			int[] temparray = new int[array[i].length + replaceCheck*(replacement.length - 1)];
			//Index for the temparray
			int index = 0;
			//Index for the original array
			int arrayIndex =0;
			//Looping through temparray elements
			while(index <= temparray.length-1){
				//If the element in original array doesn't match the item need to be replace, put the element in the original array in
				if(array[i][arrayIndex] != item){
					temparray[index] = array[i][arrayIndex];
					index += 1;
					arrayIndex +=1;
					}
				//If the element in original array match the item need to be replace, put all the element in the replacement array in
				else{
					for (int j =0; j < replacement.length; ++j){
						temparray[index] = replacement[j];
						//Increase the index of the loop by the amount of element that replacement have
						index +=1;
					}
					arrayIndex += 1;
				}
			}
			//Change the original array into the modified array
			array[i] = temparray;
			} 
		}
	

	/**
	 *
	 * Main method. Is not tested by the tester, create your own tests here!
	 */
	public static void main(String[] args){
		boolean [] array = new  boolean[6];
		sieveOfEratosthenes(array);
		for (int i =0; i < array.length;++i){
			System.out.println(array[i]);
		}
		/*int[][] array = {{1,2,3,1,2,3,5},{5,1,2,3,3,1,2,3}};
		int item = 4;
		int[] replacement = {1,2,3};
		replaceItem(array,item,replacement);
		for (int i =0; i < array.length; ++i ){
			for (int j =0; j< array[i].length;++j ){
					System.out.println(array[i][j]);
			}
		}*/
	}
}
