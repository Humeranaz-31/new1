package com.demo.story.dto;

import java.util.List;

import com.demo.story.entity.Contributor;


public class ContributorDTO {

	long phoneNo;
	String name;
	int age;
	char gender;
	String password;
	String address;
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}


	@Override
	public String toString() {
		return "CustomerDTO [phoneNo=" + phoneNo + ", name=" + name + ", age=" + age + ", gender=" + gender
				 + ", password=" + password + ", address=" + address
				 + "]";
	}

		// Converts Entity into DTO
		public static ContributorDTO valueOf(Contributor cust) {
			ContributorDTO custDTO = new ContributorDTO();
			custDTO.setAge(cust.getAge());
			custDTO.setGender(cust.getGender());
			custDTO.setName(cust.getName());
			custDTO.setPhoneNo(cust.getPhoneNo());
			custDTO.setAddress(cust.getAddress());
		    return custDTO;
		}

		// Converts DTO into Entity
		public Contributor createEntity() {
			Contributor cust = new Contributor();
			cust.setAge(this.getAge());
			cust.setGender(this.getGender());
			cust.setName(this.getName());
			cust.setPhoneNo(this.getPhoneNo());
			cust.setAddress(this.getAddress());
			cust.setPassword(this.getPassword());
			return cust;
		}


}
