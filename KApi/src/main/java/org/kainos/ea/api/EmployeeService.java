package org.kainos.ea.api;


import org.kainos.ea.client.*;

import java.sql.SQLException;

import org.kainos.ea.cli.DeliveryEmployee;
import org.kainos.ea.cli.Employee;
import org.kainos.ea.cli.SalesEmployee;


import java.util.List;

public class EmployeeService {

    private EmployeeDao employeeDao = new EmployeeDao();

    public List<Employee> getAllEmployees() throws FailedToGetEmployeeListException {
        try {
            List<Employee> employeeList = employeeDao.getAllEmployees();

            return employeeList;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToGetEmployeeListException();
        }
    }

    public List<Employee> getAllDeliveryEmployees() throws FailedToGetDeliveryEmployeeListException {
        try {
            List<Employee> deliveryEmployeeList = employeeDao.getAllDeliveryEmployees();

            return deliveryEmployeeList;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToGetDeliveryEmployeeListException();
        }
    }

    public List<Employee> getAllSalesEmployees() throws FailedToGetSalesEmployeeListException {
        try {
            List<Employee> salesEmployeeList = employeeDao.getAllSalesEmployees();

            return salesEmployeeList;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToGetSalesEmployeeListException();
        }
    }

    public Employee getEmployeeById(int employeeId) throws FailedToGetEmployeeByIdException {
        try {
            Employee employee = employeeDao.getEmployeeById(employeeId);

            if (employee == null) {
                throw new FailedToGetEmployeeByIdException();
            }

            return employee;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToGetEmployeeByIdException();
        }
    }

    public DeliveryEmployee getDeliveryEmployeeById(int deliveryEmployeeId) throws FailedToGetDeliveryEmployeeByIdException {
        try {
            DeliveryEmployee deliveryEmployee = employeeDao.getDeliveryEmployeeById(deliveryEmployeeId);

            if (deliveryEmployee == null) {
                throw new FailedToGetDeliveryEmployeeByIdException();
            }

            return deliveryEmployee;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToGetDeliveryEmployeeByIdException();
        }
    }

    public SalesEmployee getSalesEmployeeById(int salesEmployeeId) throws FailedToGetSalesEmployeeByIdException {
        try {
            SalesEmployee salesEmployee = employeeDao.getSalesEmployeeById(salesEmployeeId);

            if (salesEmployee == null) {
                throw new FailedToGetSalesEmployeeByIdException();
            }

            return salesEmployee;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new FailedToGetSalesEmployeeByIdException();
        }
    }

    public void updateEmployee(int employeeId, EmployeeRequest employee) throws FailedToUpdateEmployeeException {
        try {
            Employee employeeToUpdate = employeeDao.getEmployeeById(employeeId);

            if (employeeToUpdate == null) {
                throw new EmployeeDoesNotExistException();
            }

            employeeDao.updateEmployee(employeeId, employee);
        } catch (SQLException | EmployeeDoesNotExistException e) {
            System.err.println(e.getMessage());
            throw new FailedToUpdateEmployeeException();
        }

    }

    public void deleteEmployee(int employeeId) throws FailedToDeleteEmployeeException {
        try {
            Employee employeeToDelete = employeeDao.getEmployeeById(employeeId);

            if (employeeToDelete == null) ;
            {
                throw new FailedToDeleteEmployeeException();
            }
            employeeDao.deleteEmployee(employeeId);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new FailedToDeleteEmployeeException();
        }

    }
}