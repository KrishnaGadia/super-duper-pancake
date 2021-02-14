package com.squadstack;

public class Car {
	String carnumber;
	int age;
	int slot;

	public Car(String carnumber, int age, int slot) {
		super();
		this.carnumber = carnumber;
		this.age = age;
		this.slot = slot;
	}

	public String getCarnumber() {
		return carnumber;
	}

	public int getAge() {
		return age;
	}

	public int getSlot() {
		return slot;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((carnumber == null) ? 0 : carnumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (age != other.age)
			return false;
		if (carnumber == null) {
			if (other.carnumber != null)
				return false;
		} else if (!carnumber.equals(other.carnumber))
			return false;
		return true;
	}

}
