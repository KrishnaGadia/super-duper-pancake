package com.squadstack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CommandProcessor {

	static ParkingLot parkingLot;

	public static void main(String[] args) {

		String filename;
		if (args.length == 0) {
			System.out.println("Please enter file name");
			Scanner sc = new Scanner(System.in);
			filename = sc.next();
			sc.close();
		} else {
			filename = args[0];
		}

		Scanner sc = null;
		try {
			File input = new File(filename);
			sc = new Scanner(input);

			while (sc.hasNextLine()) {
				process(sc.nextLine());
			}

		} catch (FileNotFoundException f) {
			System.out.println("File " + filename + " not found, please try again");
		} finally {
			sc.close();
		}

	}

	private static void process(String line) {
		String[] words = line.split(" ");
		String plate;
		int age;
		int slot;
		List<Car> cars;
		try {
			switch (words[0]) {
			case "Create_parking_lot":
				int capacity = Integer.parseInt(words[1]);
				parkingLot = new ParkingLot(capacity);
				System.out.println("Created parking of " + capacity + " slots");
				break;
			case "Park":
				plate = words[1];
				age = Integer.parseInt(words[3]);
				slot = parkingLot.addCar(plate, age);
				if (slot != 0) {
					System.out.println("Car with vehicle registration number \"" + plate
							+ "\" has been parked at slot number " + slot);
				} else {
					System.out.println("ERROR: Parking Lot is Full");
				}
				break;
			case "Slot_numbers_for_driver_of_age":
				age = Integer.parseInt(words[1]);

				cars = parkingLot.getCarsFromAge(age);
				parkingLot.printSlotNumbers(cars);
				break;
			case "Slot_number_for_car_with_number":
				plate = words[1];
				System.out.println(parkingLot.getSlotNo(plate));
				break;

			case "Leave":
				slot = Integer.parseInt(words[1]);
				Car car = parkingLot.removeCar(slot);
				System.out.println("Slot number " + slot + " vacated, the car with vehicle registration number \""
						+ car.getCarnumber() + "\" left the space, the driver of the car was of age " + car.age);
				break;

			case "Vehicle_registration_number_for_driver_of_age":
				age = Integer.parseInt(words[1]);
				cars = parkingLot.getCarsFromAge(age);
				parkingLot.printRegistration(cars);
				break;

			default:
				System.out.println("Wrong Command : " + line);
			}
		} catch (NumberFormatException nfe) {
			System.out.println("Was expecting a number in the command : " + line);
		}
	}
}
