package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		//Program2 - feito para testar o Department
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao DepartmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("====== TEST 1: department findById ======");
		Department department = DepartmentDao.findById(1);
		System.out.println(department);


		System.out.println("\n====== TEST 2: department findAll ======");
		List<Department> list = DepartmentDao.findAll();

		for (Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n====== TEST 3: department insert ======");
		Department newDepartment = new Department(null, "Music");
		DepartmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());
		
		
		System.out.println("\n====== TEST 4: department update ======");
		Department dep = DepartmentDao.findById(1);
		dep.setName("food");
		DepartmentDao.update(dep);
		System.out.println("Update completed");
		
		System.out.println("\n====== TEST 5: department delete ======");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		DepartmentDao.deleteById(id);
		System.out.println("Delete completed!\n");
		
		sc.close();
	}
}