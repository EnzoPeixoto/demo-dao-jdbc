package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        List<Department> list = new ArrayList<>();

         System.out.println("=== TEST 1: department findById ===");
        Department department = departmentDao.findById(3);
        System.out.println(department);

        System.out.println("\n=== TEST 2: department findAll ===");
        list = departmentDao.findAll();
        for (Department obj: list){
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 3: department insert ===");
        department = new Department(null, "Music");
        departmentDao.insert(department);
        System.out.println("Inserted! New id = " + department.getId());

        System.out.println("\n=== TEST 4: department update ===");
        department = departmentDao.findById(6);
        department.setName("Math");
        departmentDao.update(department);
        System.out.println("Update completed");

        System.out.println("\n=== TEST 5: department delete ===");
        System.out.print("Enter id for delete test: ");
        int id = sc.nextInt();

        departmentDao.deleteById(id);
        System.out.println("Delete completed");

        sc.close();
    }
}
