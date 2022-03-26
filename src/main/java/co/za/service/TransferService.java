package co.za.service;

import co.za.dto.AddressDto;
import co.za.dto.StudentDto;
import co.za.entity.Address;
import co.za.entity.Student;

public class TransferService {

    public static Student transferStudent(StudentDto studentDto){
        Student student = new Student();
        student.setEmail(studentDto.getEmail());
        student.setName(studentDto.getName());
        student.setSurname(studentDto.getSurname());
        student.setIdNumber(studentDto.getIdNumber());
        student.setPhoneNumber(studentDto.getPhoneNumber());
        student.setBirthday(studentDto.getBirthday());
        student.setDeleted(false);
        student.setGender(studentDto.getGender());
        student.setPassword(studentDto.getPassword());
        student.setAddress(transferAddress(studentDto.getAddress()));
        return student;
    }

    public static Address transferAddress(AddressDto addressDto){
        Address address = new Address();
        address.setStreetName(addressDto.getStreetName());
        address.setZipCode(addressDto.getZipCode());
        address.setCountry(addressDto.getCountry());
        address.setCity(addressDto.getCity());
        address.setBuildingNumber(addressDto.getBuildingNumber());
        return  address;
    }
}
