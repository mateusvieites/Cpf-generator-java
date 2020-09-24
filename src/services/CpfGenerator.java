package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CpfGenerator {
	private static CpfGenerator uniqueInstance;
	static List<Integer> a = new ArrayList<Integer>();
	
	private CpfGenerator() {
	}
	public static synchronized CpfGenerator getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new CpfGenerator();

		return uniqueInstance;
	}
	
	private static int generateRandomNum() {
		Random randomNum = new Random();
		return randomNum.nextInt(10);
	}
	
	private static void firstDigit(){
		int result = 0;
		for(int i = 10, aux = 0;i >= 2;i--, aux++) {
			a.add(generateRandomNum());
			result += a.get(aux)/i;
		}
		a.add(verifyDigit(result));
	}
	private static int verifyDigit(int digit) {
		System.out.println("Digito antes: " + digit);
		if(digit < 2) {
			digit = 0;
		}else {
			digit = 11 - digit;
		}
		System.out.println("Digito depois: " + digit);
		return digit;
	}
	
	private static void secondDigit() {
		int result = 0;
		for(int i = 11, aux = 0; i >= 2;i--,aux++) {
			result += a.get(aux)/i;
		}
		a.add(verifyDigit(result));
		System.out.println("Result: " + a.get(a.size() - 1));
	}
	
	private static void printCpf() {
		for(int i = 0; i < 11;i++) {
			System.out.print(a.get(i));
		}
	}
	
	public static synchronized String generateCPF() {
		firstDigit();
		secondDigit();
		printCpf();
		
		return null;
	}
}
