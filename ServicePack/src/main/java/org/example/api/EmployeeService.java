package org.example.api;

import java.util.List;

public class EmployeeService {
        private EmployeeDao employeeDao = new EmployeeDao();

        public List<Employee> getAllEmployees() {
            List<Employee> employeeList = employeeDao.getAllEmployees();

            return employeeList;
        }

        public List<Employee> getAllDeliveryEmployees() {
            List<Employee> deliveryEmployeeList = employeeDao.getAllDeliveryEmployees();

            return deliveryEmployeeList;
        }

        public List<Employee> getAllSalesEmployees() {
            List<Employee> salesEmployeeList = employeeDao.getAllSalesEmployees();

            return salesEmployeeList;
        }

        public Employee getEmployeeById(int id) {
            Employee employee = employeeDao.getEmployeeById(id);

            return employee;
        }

        public DeliveryEmployee getDeliveryEmployeeById(int id) {
            DeliveryEmployee deliveryEmployee = employeeDao.getDeliveryEmployeeById(id);

            return deliveryEmployee;
        }

        public SalesEmployee getSalesEmployeeById(int id) {
            SalesEmployee salesEmployee = employeeDao.getSalesEmployeeById(id);

            return salesEmployee;
        }

        public void updateEmployee(int id) {
            Employee employeeToUpdate = employeeDao.getEmployeeById(id);

        }

        public void updateDeliveryEmployee(int id) {
            DeliveryEmployee deliveryEmployeeToUpdate = employeeDao.getEmployeeById(id);

        }

        public void updateSalesEmployee(int id) {
            SalesEmployee salesEmployeeToUpdate = employeeDao.getEmployeeById(id);

        }

        public void deleteEmployee(int id) {
            Employee employeeToDelete = employeeDao.getEmployeeById(id);

        }

        public int createDeliveryEmployee(Employee deliveryEmployee) {
            int id = employeeDao.createDeliveryEmployee(deliveryEmployee);

            return id;
        }

        public int createSalesEmployee(Employee salesEmployee) {
            int id = employeeDao.createSalesEmployee(salesEmployee);

            return id;
        }

}
