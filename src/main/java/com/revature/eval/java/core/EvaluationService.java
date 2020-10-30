package com.revature.eval.java.core;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j=0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		// TODO Write an implementation for this method declaration
		String acronym = "";
		//splitting the string on the basis of space and -
		String[] allArr = phrase.split("\\ |\\-");
		
		for (int i = 0; i < allArr.length; i++) {
			
			
			acronym += allArr[i].charAt(0);
			
		}
		return acronym.toUpperCase();
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			// TODO Write an implementation for this method declaration
			if(this.sideOne == this.sideTwo) {
				if(this.sideOne == this.sideThree) {
					return true;
				}
			}
			return false;
		}

		public boolean isIsosceles() {
			// TODO Write an implementation for this method declaration
			if(this.sideOne == this.sideTwo || this.sideOne == this.sideThree || this.sideTwo == this.sideThree) {
					return true;
			}
			return false;
		}

		public boolean isScalene() {
			// TODO Write an implementation for this method declaration
			if(this.sideOne == this.sideTwo || this.sideOne == this.sideThree || this.sideTwo == this.sideThree) {
				return false;
			}
			return true;
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		// TODO Write an implementation for this method declaration

		
		//record all the value in hashmap
		//traverse through string 
		//declare variable to calculate total scrablescore
		
		Map<Character, Integer> storeValue = new HashMap<Character, Integer>() {{
			put('a', 1);
			put('e', 1);
			put('i', 1);
			put('o', 1);
			put('u', 1);
			put('l', 1);
			put('n', 1);
			put('r', 1);
			put('s', 1);
			put('t', 1);
			put('g', 2);
			put('b', 3);
			put('c', 3);
			put('m', 3);
			put('p', 3);
			put('k', 5);
			put('h', 4);
			put('f', 4);
			put('w', 4);
			put('y', 4);
			put('v', 4);
			put('z', 10);
			put('q', 10);
			put('j', 8);
			put('x', 8);
		}};
		int scrabbleScore = 0;
		string = string.toLowerCase();
		
		for(int i = 0; i <string.length(); i++ ) {
			
			if(storeValue.containsKey(string.charAt(i))) {
				scrabbleScore += storeValue.get(string.charAt(i));
			}
		}
		
		return scrabbleScore;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		//converting string into character array
		char[] numberArray = string.toCharArray();
		
		//creating mutable string to create the string of available numbers
		StringBuilder cleanedUpNumber = new StringBuilder();
		
		
		for(char c : numberArray) {
			if(Character.isDigit(c ))  {
				cleanedUpNumber.append(c);
			}
		}
		
		if(cleanedUpNumber.length() == 11 && cleanedUpNumber.charAt(0) == 1) {
			cleanedUpNumber.deleteCharAt(0);
		}
		
		/*since only digit will be appended to the cleanedUpNumber; cleanedUpNumber smaller than 10 represents the 
		 * string had more non=numerics */
		else if(cleanedUpNumber.length() >= 11 || cleanedUpNumber.length() < 10) {
			throw new IllegalArgumentException();
		}
		
		
		
		return cleanedUpNumber.toString();
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		
		String[] stringArr = string.split("\\P{Alpha}+");
		
		Map<String, Integer> countStr = new HashMap<>();
		
		//keeping track of number of repeated string 
		//by reassigning value if already in countStr
		for (int i =0; i < stringArr.length; i++) {
			if(countStr.get(stringArr[i]) != null) {
				countStr.put(stringArr[i], countStr.get(stringArr[i]) + 1);
			}else {
				
				countStr.put(stringArr[i], 1);
				
			}
		}
		return countStr;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
			// TODO Write an implementation for this method declaration
			return 0;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		// TODO Write an implementation for this method declaration
		//TODO - last case is failing
		
		Set<Character> vowels = new HashSet<Character>() {{
			add('a');
			add('e');
			add('i');
			add('o');
			add('u');
			
		}};
		StringBuffer latinStr = new StringBuffer();
		StringBuffer addAtConsonant = new StringBuffer();
		String addAtVowel = "ay";
		boolean vowelCheck = true;
		int index = 0;
		
		while(!vowels.contains(string.charAt(index))) {
			vowelCheck = false;
			
			addAtConsonant.append(string.charAt(index));
			index++;
			
		}
		addAtConsonant.append("ay");
		
		for( int i = index; i < string.length(); i++) {
			
			latinStr.append(string.charAt(i));
			
//			if(string.charAt(i) == ' ') {
//				if(vowels.contains(string.charAt(i))) {
//					addAtLast.append("ay");
//				}
//			}
		}
		if(vowelCheck) {
			latinStr.append(addAtVowel);
		}else {
			latinStr.append(addAtConsonant);
		}
		
		return latinStr.toString();
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {

		double armOrNot = 0;
		int length = String.valueOf(input).length();
		
		int temp = input;
		int eachDigit;
		
		while(temp > 0) {
			eachDigit = temp % 10;
			armOrNot += Math.pow(eachDigit, length);
			temp = temp /10;
		}
		
		if(armOrNot == input)
			return true;
		
		return false;
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		
		List<Long> listOfPrimeFactors = new ArrayList<Long>();
		
		while(l % 2 == 0) {
			listOfPrimeFactors.add(2L);
			l /= 2;
		}
		
		//since l must be odd at this point, incrementing i by 2
		for( long i = 3; i <= Math.sqrt(l); i += 2) {
			
			while(l % i == 0) {
				listOfPrimeFactors.add(i);
				l /= i;
			}
		}
		
		//to handle the prime numbers greater than 2
		if(l > 2) {
			listOfPrimeFactors.add(l);
		}
		
		return listOfPrimeFactors;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			
			int recordAscii;
			int rotValue = 0;
			String[] charArray = new String[string.length()];
			StringBuffer rotatedString = new StringBuffer();
			
			//recordAscii is getting the actual ASCII value of the character in string
			//rotValue is the actual value that we need to simplify so that we don't end up rotating non-alphabets
			for ( int i = 0; i < string.length(); i++) {
				recordAscii = string.charAt(i);
				
				if(recordAscii >=65 && recordAscii <=90) {
					rotValue = recordAscii + this.key;
					if(rotValue > 90) {
						rotValue = rotValue - 90 + 64;
					}
					rotatedString.append((char)rotValue);
				}else if(recordAscii >=97 && recordAscii <= 122) {
					rotValue = recordAscii + this.key;
					if(rotValue > 122) {
						rotValue = rotValue - 122 + 96;
					}
					charArray[i] = Character.toString((char)rotValue);
					rotatedString.append((char)rotValue);
				}else {
					rotatedString.append(string.charAt(i));
				}
				rotValue = 0;
			}
			
			return rotatedString.toString();
		}

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		
		int count = 2;
		
		int all_number = 5;
		
		int countForPrime = 0;
		
		if(i <= 0) {
			throw new IllegalArgumentException();
		}
		
		if(i == 1) {
			return 2;
		}
		if( i == 2) {
			return 3;
		}
		
		while(count != i) {
			
			for(int j = 2; j <= all_number/2; j++) {
				
				if(all_number % j == 0) {
					countForPrime ++;
					j = all_number/2;
				}
				
			}
			
			if(countForPrime == 0) {
				count ++;
			}
			countForPrime = 0;
			all_number+= 2;
		}
		
		return all_number -= 2;
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		//working fine but try implementing linked list if possible
		
		public static String encode(String string) {
			
			int recordAsciinumber ;
			
			int encodingAsciiNumber = 0;
			
			int midPoint = 110;
			
			StringBuffer encodedStr = new StringBuffer();
			
			int groupLen = 0;
			
			string = string.toLowerCase();
			
			for( int  i =0 ; i < string.length(); i++) {
				
				//find ascii number of character
				recordAsciinumber = (int)string.charAt(i);
				
				if(recordAsciinumber >=97 && recordAsciinumber <= 122) {
					if(recordAsciinumber >= 97 && recordAsciinumber <=midPoint) {
						encodingAsciiNumber = recordAsciinumber - 97;
						encodingAsciiNumber = 122 - encodingAsciiNumber;
						
						if( encodingAsciiNumber <= 0) {
							encodingAsciiNumber = encodingAsciiNumber + 97;
						}
						
					}else if(recordAsciinumber > midPoint && recordAsciinumber <= 122) {
						encodingAsciiNumber = 122 - recordAsciinumber;
						encodingAsciiNumber = 97 + encodingAsciiNumber;
					}
					
					encodedStr.append((char)encodingAsciiNumber);
					groupLen++;
					
					if (groupLen >= 5 && string.length() != i) {
						encodedStr.append(' ');
						groupLen = 0;
					}
					
				}else if(recordAsciinumber >= 48 && recordAsciinumber <= 57) {
					
					encodedStr.append(string.charAt(i));
					groupLen++;
					
					if (groupLen >= 5 && string.length() != i) {
						encodedStr.append(' ');
						groupLen = 0;
					}
					
				}else {
					
					continue;
					
				}
					
			}
			
			if(encodedStr.charAt(encodedStr.length()-1) == ' ') {
				encodedStr.deleteCharAt(encodedStr.length()-1);
			}
				
			
			return encodedStr.toString();
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			
			
			int recordAsciinumber ;
			
			int decodingAsciiNumber = 0;
			
			int midPoint = 110;
			
			StringBuffer decodedStr = new StringBuffer();
			
			string = string.toLowerCase();
			
			for( int  i =0 ; i < string.length(); i++) {
				
				//find ascii number of character
				recordAsciinumber = (int)string.charAt(i);
				
				if(recordAsciinumber >=97 && recordAsciinumber <= 122) {
					if(recordAsciinumber >= 97 && recordAsciinumber <=midPoint) {
						decodingAsciiNumber = recordAsciinumber - 97;
						decodingAsciiNumber = 122 - decodingAsciiNumber;
						
						if( decodingAsciiNumber <= 0) {
							decodingAsciiNumber = decodingAsciiNumber + 97;
						}
						
					}else if(recordAsciinumber > midPoint && recordAsciinumber <= 122) {
						decodingAsciiNumber = 122 - recordAsciinumber;
						decodingAsciiNumber = 97 + decodingAsciiNumber;
					}
					
					decodedStr.append((char)decodingAsciiNumber);
					
					
				}else if(recordAsciinumber >= 48 && recordAsciinumber <= 57) {
					
					decodedStr.append(string.charAt(i));
					
				}else {
					
					continue;
					
				}
					
			}
			
			return decodedStr.toString();
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		
		//not all test cases has passed
		
		char[] numberArray = string.toCharArray();
		
		//creating mutable string to create the string of available numbers
		StringBuilder isbnNum = new StringBuilder();
		
		
		for(int c=0; c < numberArray.length; c++) {
			if(Character.isDigit(c) || numberArray[c] == 'X')  {
				isbnNum.append(c);
			}
		}
		
		if(isbnNum.length() < 10) {
			return false;
		}
		
		
		int checkValidity = 0;
		int num = Integer.parseInt(isbnNum.toString());
		int[] digits = Integer.toString(num).chars().map(c -> c-'0').toArray();
		
		for( int i = 0; i < digits.length; i++) {
			
			
			if(digits[i] == 'X') {
				
				checkValidity += 10 * (digits.length - i) ;
				
			}else {
				
				checkValidity += digits[i] * (digits.length - i) ;
			}
		}
		
		if(checkValidity % 11 == 0) {
			return true;
		}
		return false;		
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		
		Set<Character> allCharacters = new HashSet<Character>();
		string = string.toLowerCase();
		
		if(string.length() < 26) {
			return false;
		}
		
		for( int i =0; i < string.length(); i++) {
			if(string.charAt(i) != ' ') {
				allCharacters.add(string.charAt(i));
			}
		}
		if( allCharacters.size() < 26)
			return false;
		
		return true;
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		// TODO Write an implementation for this method declaration
		return null;
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		
		int sumOfMultiples = 0;
		int multiplier;
		int multiplies = 1;
		
		Set<Integer> noRepeatedMultiplies = new HashSet<Integer>();
		
		for(int j = 0; j <= set.length; j++) {
			multiplier = 1;
			while(multiplies < i) {
				
				multiplies = set[j] * multiplier;
				
				
				if(!noRepeatedMultiplies.contains(multiplies) && multiplies < i ) {
					sumOfMultiples += multiplies;
					noRepeatedMultiplies.add(multiplies);
					
				}
				
				multiplier++;
			}
			 
			
		}
		
		return sumOfMultiples;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		// TODO Write an implementation for this method declaration
		return false;
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		
		
		String [] stringArr = string.split("\\ |\\?");
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		Integer result = 0;
		char[] operator = new char[1];
		
		for(int i = 0; i < stringArr.length; i++) {
			
			if(isInteger(stringArr[i])) {
				
				numbers.add(Integer.parseInt(stringArr[i]));
				
			}else {
				
				if(stringArr[i].equals("plus")) {

					operator[0] = '+';
				}
				
				else if(stringArr[i].equals("minus")) {
					operator[0] = '-';
				}
				
				else if(stringArr[i].equals("multiplied")) {
					operator[0] = '*';
				}
				
				else if(stringArr[i].equals("divided")) {
					operator[0] = '/';
				}
			}
			
			
		}
		
		
		if(operator[0] == '+') {
			result = numbers.get(0) + numbers.get(1);
		}
		if(operator[0] == '-') {
			result = numbers.get(0) - numbers.get(1);
		}
		
		if(operator[0] == '*') {
			result = numbers.get(0) * numbers.get(1);
		}
		
		if(operator[0] == '/') {
			result = numbers.get(0) / numbers.get(1);
		}
		
		return result;
	}
	
	
	 static boolean isInteger(String s) {
	      boolean isValidInteger = false;
	      try
	      {
	         Integer.parseInt(s);
	 
	         // s is a valid integer
	 
	         isValidInteger = true;
	      }
	      catch (NumberFormatException ex)
	      {
	         // s is not an integer
	      }
	 
	      return isValidInteger;
	   }

}
