package com.psl.utils;

import java.util.List;
import java.util.Map;

import com.psl.bean.BuisnessUnit;
import com.psl.bean.Employee;
import com.psl.bean.MyPassionChallenge;
import com.psl.bean.Student;

public interface MPCUtil {
List<Student> populateData(String fileName);
void validateStudentList(List<Student> studList);
List<MyPassionChallenge> readDatafromDB();
void findResult(List<MyPassionChallenge> mpcList);
MyPassionChallenge getTopper(List<MyPassionChallenge> mpcList);
List<Employee> createListOfEmployee(List<MyPassionChallenge> mpcList);
void allocateBU(List<Employee> empList);
Map<BuisnessUnit,List<Employee>> getMapByBU(List<Employee> empList); 
}
