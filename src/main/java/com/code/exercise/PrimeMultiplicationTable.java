package com.code.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Kesav Chintada
 * Print the multiplication table of the first 'N' prime numbers where 'N' is a
 * positive integer. the 1st row and 1st column are the primes and the cells are
 * the cross product of the corresponding row and column.
 **/
public class PrimeMultiplicationTable {
	public static void main(String[] args) {
		System.out.println("What is the Number of Primes you want in the Multiplication Table ? ");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.close();

		PrimeMultiplicationTable pmt = new PrimeMultiplicationTable();
		pmt.printPrimeMltplcnTbl(pmt.primeList(n));
	}

	public List<Integer> primeList(int n) {
		List<Integer> primeList = new ArrayList<Integer>();
		int initialPrime = 2;

		while (primeList.size() < n) {
			if (isPrime(initialPrime)) {
				primeList.add(initialPrime);
			}
			initialPrime++;
		}
		return primeList;
	}
/*
 * A Prime Number greater than 1 whose only factors are 1 and itself. 
 * Any number whose factors are unique upto it's square root 
 * and after that the factors are interchanged with repeation.
 * The business logic in this method verifies any divisible factors upto the square root of the number.
 */
	public static boolean isPrime(int num) {
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
/*
 * This method will print the table with each cell has 4 digit/char padding 
 */
	public void printPrimeMltplcnTbl(List<Integer> primeList) {
		// 1st row with primes
		System.out.format("%4s", "X");
		primeList.forEach((Integer eachPrime) -> System.out.format("%4d", eachPrime));
		System.out.println();
        // remaining rows with cells containing  calculated cross products..
		for (Integer colmnPrime : primeList) {
			System.out.format("%4d", colmnPrime);
			primeList.forEach((Integer rowPrime) -> System.out.format("%4d", rowPrime * colmnPrime));
			System.out.println();
		}
	}
}
