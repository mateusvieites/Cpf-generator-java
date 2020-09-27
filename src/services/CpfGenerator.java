package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entities.Informations;

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
	
	private static int generateRandomNum(int MaxNumber) {
		Random randomNum = new Random();
		return randomNum.nextInt(MaxNumber);
	}
	
	private static void generateRandomCity(String state) {
		
	}
	

	private static int verifyDigit(int digit) {
		System.out.println("DIgito antes: " + digit);
		if(digit < 2) {
			digit = 0;
		}else {
			digit = 11 - digit;
		}
		System.out.println("Digito depois" + digit);
		return digit;
	}
	
	private static void firstDigit(){
		a.clear();
		int result = 0;
		for(int i = 10, aux = 0;i >= 2;i--, aux++) {
			a.add(generateRandomNum(10));
			result += a.get(aux)/i;
		}
		a.add(verifyDigit(result));
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
		System.out.println("Prints:");
		for(int i = 0; i < 11;i++) {
			System.out.print(a.get(i));
		}
	}
	
	private static String randomState(String stateName) {
		String[] stateNames = stateName.split(",");
		stateName = stateNames[generateRandomNum(stateNames.length)];
		return stateName;
	}
	
	private static void verifyState(int state) {
		String stateName = "justToFixBugs";
		System.out.println("State: " + state);
		switch(state) {
			case 0:
				stateName = "Rio Grande do Sul";
				break;
			case 1:
				stateName = "Distrito Federal,Goiás,Mato Grosso,Mato Grosso do Sul,Tocantins";
				break;
			case 2:
				stateName = "Amazonas,Pará,Roraima,Amapá,Acre,Rondônia";
				break;
			case 3:
				stateName = "Ceará,Maranhão,Piauí";
				break;
			case 4:
				stateName = "Paraíba,Pernambuco,Alagoas,Rio Grande do Norte" ;
				break;
			case 5:
				stateName ="Bahia,Sergipe" ;
				break;
			case 6:
				stateName ="Minas Gerais" ;
				break;
			case 7:
				stateName ="Rio de Janeiro,Espírito Santo" ;
				break;
			case 8:
				stateName ="São Paulo" ;
				break;
			case 9:
				stateName ="Paraná,Santa Catarina";
				break;
			default: System.out.println("error");
				break;
			}

		System.out.println("State name: " + stateName);
			if(!(stateName.indexOf(",") == -1)) {
				System.out.println("Entrou");
				stateName = randomState(stateName);
			}

			System.out.println("State name: " + stateName);
			generateRandomCity(stateName);
	}
	
	public static synchronized String generateCPF() {
		firstDigit();
		secondDigit();
		printCpf();
		verifyState(a.get(8));
		return null;
	}
}
