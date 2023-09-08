package org.kainos.ea.api;


import org.kainos.ea.client.*;

import java.sql.SQLException;

import org.kainos.ea.cli.DeliveryEmployee;
import org.kainos.ea.cli.Employee;
import org.kainos.ea.cli.SalesEmployee;


import java.util.List;

public class EmployeeService {

    private EmployeeDao employeeDao = new EmployeeDao();

    public int createDeliveryEmployee(EmployeeRequest employee) throws FailedToCreateDeliveryEmployeeException {
        try {
            int id = employeeDao.createEmployee(employee);
            if (id == -1) {
                throw new FailedToCreateDeliveryEmployeeException();
            }
            return id;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new FailedToCreateDeliveryEmployeeException();
        }
    }

    public int createSalesEmployee(SalesEmployeeRequest employee) throws FailedToCreateSalesEmployeeException {
        try {
            int id = employeeDao.createEmployee(employee);
            if (id == -1) {
                throw new FailedToCreateSalesEmployeeException();
            }
            return id;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new FailedToCreateSalesEmployeeException();
        }
    }

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

    public void updateDeliveryEmployee(int employeeId, EmployeeRequest employee) throws FailedToUpdateDeliveryEmployeeException {
        try {
            Employee deliveryEmployeeToUpdate = employeeDao.getEmployeeById(employeeId);

            if (deliveryEmployeeToUpdate == null) {
                throw new EmployeeDoesNotExistException();
            }

            employeeDao.updateDeliveryEmployee(employeeId, employee);
        } catch (SQLException | EmployeeDoesNotExistException e) {
            System.err.println(e.getMessage());
            throw new FailedToUpdateDeliveryEmployeeException();
        }

    }

    public void updateSalesEmployee(int employeeId, EmployeeRequest employee) throws FailedToUpdateSalesEmployeeException {
        try {
            Employee salesEmployeeToUpdate = employeeDao.getEmployeeById(employeeId);

            if (salesEmployeeToUpdate == null) {
                throw new EmployeeDoesNotExistException();
            }

            employeeDao.updateSalesEmployee(employeeId, employee);
        } catch (SQLException | EmployeeDoesNotExistException e) {
            System.err.println(e.getMessage());
            throw new FailedToUpdateSalesEmployeeException();
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