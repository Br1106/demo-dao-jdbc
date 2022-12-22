package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("\n=== TEST 1: department findById==");
		Department dep = departmentDao.findById(1);
		System.out.println(dep);
		
		System.out.println("\n=== TEST 2: department findAll==");
		List<Department> list = new ArrayList<>();
		list = departmentDao.findAll();
		list.forEach(System.out::println);
	
		System.out.println("\n=== TEST 3: department Insert ====");
		Department newDep = new Department(null, "Music");
		departmentDao.insert(newDep);
		System.out.println("Inserted! New id = " + newDep.getId());
		
		System.out.println("\n=== TEST 4: department Update ====");
		dep = departmentDao.findById(1);
		dep.setName("Video Games");
		departmentDao.update(dep);
		System.out.println("Updated completled");
		
		System.out.println("\n=== TEST 5: department DELETE ====");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deletById(id);
		System.out.println("Delete completed");
		
		sc.close();
	}

}
