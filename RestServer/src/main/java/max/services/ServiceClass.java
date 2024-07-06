package max.services;

import java.util.Date;

import max.bean.Customer;
import max.dao.DatabaseOperations;
import max.dto.CustomerDto;
import max.utils.AgeUtility;

import max.utils.RandomNumberUtility;

public class ServiceClass {
	DatabaseOperations operations = new DatabaseOperations();

	public int ageFinder(String dob) {
		return AgeUtility.getAge(dob);
	}

	public String isEligible(Customer customer) {
		int realAge = ageFinder(customer.getDob());

		if (realAge >= 18) {
			if (!existingUserOrNot(customer)) {
				int insertResult = insertData(customer);
				if (insertResult > 0) {
					return "Data Inserted Successfully";
				} else {
					return "Failed to Insert Data";
				}
			} else {
				return "You are Already Registered with this addhar card " + customer.getAadhar();
			}
		} else {
			return "You are not Eligible to Register because your age is " + realAge;
		}
	}

	public boolean existingUserOrNot(Customer customer) {
		return operations.userExistOrNot(customer.getAadhar());
	}

	public int insertData(Customer customer) {
		CustomerDto dto = new CustomerDto();
		dto.setAadhar(customer.getAadhar());
		dto.setAddress(customer.getAddress());
		dto.setDate(String.valueOf(new Date()));
		dto.setDob(customer.getDob());
		dto.setId(RandomNumberUtility.getNumber());
		dto.setName(customer.getName());
		dto.setAge(ageFinder(customer.getDob()));
		return operations.insert(dto);
	}
}
