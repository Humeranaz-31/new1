package com.demo.story.dto;

import java.util.List;

import com.demo.story.entity.Admin;



public class AdminDTO {

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
		return "AdminDTO [phoneNo=" + phoneNo + ", name=" + name + ", age=" + age + ", gender=" + gender
				 + ", password=" + password + ", address=" + address
				 + "]";
	}

		// Converts Entity into DTO
		public static AdminDTO valueOf(Admin admin) {
			AdminDTO adminDTO = new AdminDTO();
			adminDTO.setAge(admin.getAge());
			adminDTO.setGender(admin.getGender());
			adminDTO.setName(admin.getName());
			adminDTO.setPhoneNo(admin.getPhoneNo());
			adminDTO.setAddress(admin.getAddress());
		    return adminDTO;
		}

		// Converts DTO into Entity
		public Admin createEntity() {
			Admin admin = new Admin();
			admin.setAge(this.getAge());
			admin.setGender(this.getGender());
			admin.setName(this.getName());
			admin.setPhoneNo(this.getPhoneNo());
			admin.setAddress(this.getAddress());
			admin.setPassword(this.getPassword());
			return admin;
		}


}
