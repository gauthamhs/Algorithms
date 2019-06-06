package algorithms.datastructures.design.parkinglot;

 enum VehicleType {
	  CAR, TRUCK, ELECTRIC, VAN, MOTORBIKE
	}

	 enum ParkingSpotType {
	  HANDICAPPED, COMPACT, LARGE, MOTORBIKE, ELECTRIC
	}

	 enum AccountStatus {
	  ACTIVE, BLOCKED, BANNED, COMPROMISED, ARCHIVED, UNKNOWN
	}

	 enum ParkingTicketStatus {
	  ACTIVE, PAID, LOST
	}

	 class Address {
	  private String streetAddress;
	  private String city;
	  private String state;
	  private String zipCode;
	  private String country;
	}

	 class Person {
	  private String name;
	  private Address address;
	  private String email;
	  private String phone;
	}
