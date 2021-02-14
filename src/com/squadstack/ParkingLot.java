package com.squadstack;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingLot {
	int capacity;
	boolean isTaken[];
	List<Car> occupied;

	public ParkingLot(int capacity) {
		this.capacity = capacity;
		isTaken = new boolean[capacity];
		occupied = new ArrayList<>(capacity);
	}

	public int addCar(String plate, int age) {
		for (int i = 0; i < capacity; i++) {
			if (!isTaken[i]) {
				occupied.add(i, new Car(plate, age, i+1));
				isTaken[i] = true;
				return i + 1;
			}
		}
		return 0;
	}

	public int getSlotNo(String plate) {
		for (Car c : occupied) {
			if (c != null && c.getCarnumber().equals(plate)) {
				return c.getSlot();
			}
		}
		return 0;
	}

	public Car removeCar(int slot) {
		Car c = occupied.get(slot - 1);
		occupied.remove(slot - 1);
		isTaken[slot - 1] = false;
		return c;
	}

	public List<Car> getCarsFromAge(int age) {
		return occupied.stream().filter(x -> x.getAge() == age).collect(Collectors.toList());

	}

	public void printRegistration(List<Car> cars) {
		print(cars.stream().map(Car::getCarnumber).collect(Collectors.toList()));

	}

	public void printSlotNumbers(List<Car> cars) {

		print(cars.stream().map(Car::getSlot).collect(Collectors.toList()));

	}
	

	private void print(List<Object> collect) {
		// TODO Auto-generated method stub
		for(int i=0;i<collect.size();i++) {
			Object o = collect.get(i);
			System.out.print(o);
			if(i!=collect.size()-1) {
				System.out.print(",");
			}
		}
		System.out.println();
	}
}
