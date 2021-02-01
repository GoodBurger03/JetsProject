package com.skilldistillery.jets;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class JetsApp {
	public Object jet;

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		JetsApp app = new JetsApp();

		launch(app, kb);

	}

	private static void launch(JetsApp app, Scanner kb) {
		AirField bay = new AirField();
		fillAirfield(bay);
		boolean pushOn = true;

		// printBay(bay);
		System.out.println("Welcome! To Hangars R Grunts. Please, press enter to see our menu! ");
		kb.nextLine();
		showMenu();

		System.out.print("Please make a selection from out menu: ");
		kb.nextInt();
		while (pushOn) {

			System.out.println();
			int selection = 1;
			if (kb.hasNextInt()) {
				selection = kb.nextInt();
				pushOn = true;

			} else {
				System.out.println("Please make a valid selection. Exiting now. ");
				pushOn = false;
			}

			System.out.println();

			switch (selection) {
			case 1:
				printFleet(bay);
				break;
			case 2:
				flyAll(bay);
				break;
			case 3:
				fastest(bay);
				break;
			case 4:
				longestDistance(bay);
				break;
			case 5:
				cargoLoad(bay);
				break;
			case 6:
				dogFights(bay);
				break;
			case 7:
				addJet(bay, kb);
				break;
			case 8:
				removeJet(bay, kb);
				break;
			case 9:
				pushOn = false;
				break;
			default:
				pushOn = false;
				break;

			}

		}

	}

	private static void printFleet(AirField bay) {
		for (Jets jet : bay.getJetsList())

			System.out.println(jet);

	}

	private static void flyAll(AirField bay) {
		for (Jets jet : bay.getJetsList()) {
			jet.fly();
		}

	}

	private static void fastest(AirField bay) {

		Jets a = new FighterJet();
		a.setSpeed(52);
		for (Jets eachJet : bay.getJetsList()) {
			if (eachJet.getSpeed() > a.getSpeed()) {
				a = eachJet;
			}
		}
		System.out.println(a.toString());
		System.out.printf("Or in Mach %.2f\n", a.getSpeedInMach());

	}

	private static void longestDistance(AirField bay) {

		Jets a = new FighterJet();
		a.setRange(52);
		for (Jets eachJet : bay.getJetsList()) {
			if (eachJet.getRange() > a.getRange()) {
				a = eachJet;
			}
		}
		System.out.println(a.toString());

	}

	private static void cargoLoad(AirField bay) {
		for (Jets eachJet : bay.getJetsList()) {
			if (eachJet instanceof CargoPlane) {
				((CargoPlane) eachJet).loadUp();
			}
		}
	}

	private static void dogFights(AirField bay) {
		for (Jets eachJet : bay.getJetsList()) {
			if (eachJet instanceof FighterJet) {
				((FighterJet) eachJet).fight();
				System.out.println("WHEW!, WE GOT ALL OG THE BOGIES! WHAT A GREAT DOGFIGHT!");
			}
		}
	}

	private static Jets jetAddSet(Jets j, Scanner kb) {
		System.out.print("Please enter the model of the Jet :");
		j.setModel(kb.next());
		System.out.println("Please enter the speed of the Jet (mph) : ");
		j.setSpeed(kb.nextDouble());
		System.out.println("Please enter the range of the Jet : ");
		j.setRange(kb.nextInt());
		System.out.println("What was the purchase price for the Jet?  ");
		j.setPrice(kb.nextLong());
		System.out.println(j.toString());
		return j;

	}

	private static void removeJet(AirField bay, Scanner kb) {
		System.out.println("Please just let me know which Jet you would like to remove from the bay. ");
		for (int i = 0; i < bay.getJetsList().size(); i++) {
			System.out.println(i + ": " + bay.getJetsList().get(i).getModel());
		}
		int selection = kb.nextInt();
		switch (selection) {
		case 0:
			bay.removeJet(selection);
		case 1:
			bay.removeJet(selection);
			break;
		case 2:
			bay.removeJet(selection);
			break;
		case 3:
			bay.removeJet(selection);
			
			break;
		case 4:
			bay.removeJet(selection);
			break;
		case 5:
			bay.removeJet(selection);
			break;
		case 6:
			bay.removeJet(selection);
			break;
		case 7:
			bay.removeJet(selection);
			break;
		case 8:
			bay.removeJet(selection);
			break;
		case 9:
			bay.removeJet(selection);
			break;
		default:
			break;
		}
	}

	private static void showMenu() {
		System.out.println("*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*");
		System.out.println(": Selection         Description         :");
		System.out.println(":      	1)  List Fleet                  |");
		System.out.println(":     	2)  Fly All Jets                |");
		System.out.println(":       3)  View Fastest jet            |");
		System.out.println(":       4)  View jet with longest range |");
		System.out.println(":       5)  Load all Cargo Jets         |");
		System.out.println(":       6)  Dogfight!                   |");
		System.out.println(":       7)  Add a jet to fleet          |");
		System.out.println(":       8)  Remove a Jet from fleet     |");
		System.out.println(":       9)  Quit                        |");
		System.out.println("*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*");

	}

	private static void addJet(AirField bay, Scanner kb) {
		System.out.println("Adding Jet to the hangar");
		System.out.println("Which kind of Jet would you like to add :");
		System.out.println("1. CargoCarrier\n2. Fighter Jet\n3. BASIC ole jet");
		int choice = kb.nextInt();
		if (choice == 1) {
			CargoPlane b = new CargoPlane();
			bay.addJet(jetAddSet(b, kb));
		} else if (choice == 2) {
			Jets b = new FighterJet();
			bay.addJet(jetAddSet(b, kb));
		} else if (choice == 3) {
			JetsImpl b = new JetsImpl();
			bay.addJet(jetAddSet(b, kb));
		} else {

		}

	}

	private static void printBay(AirField bay) {
		for (Jets jet : bay.getJetsList()) {
			System.out.println(jet.toString());
		}
	}

	private static void fillAirfield(AirField bay) {
		try (BufferedReader br = new BufferedReader(new FileReader("jets.txt"))) {
			String line;

			while ((line = br.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts[0].equals("CargoPlane")) {
					String model = parts[1];
					double speed = Double.parseDouble(parts[2].trim());
					int range = Integer.parseInt(parts[3].trim());
					long price = Long.parseLong(parts[4].trim());
					boolean childField = Boolean.parseBoolean(parts[5].trim());
					CargoPlane a = new CargoPlane(model, speed, range, price, childField);
					bay.addJet(a);
				}
				if (parts[0].equals("FighterJet")) {
					String model = parts[1];
					double speed = Double.parseDouble(parts[2].trim());
					int range = Integer.parseInt(parts[3].trim());
					long price = Long.parseLong(parts[4].trim());
					boolean childField = Boolean.parseBoolean(parts[5].trim());
					FighterJet a = new FighterJet(model, speed, range, price, childField);
					bay.addJet(a);
				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
