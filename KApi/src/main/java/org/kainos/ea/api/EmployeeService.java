package org.kainos.ea.api;

import org.kainos.ea.client.*;

import java.sql.SQLException;
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

        public List<Employee> getAllDeliveryEmployees () throws FailedToGetDeliveryEmployeeListException {
            try {
                List<Employee> deliveryEmployeeList = employeeDao.getAllDeliveryEmployees();

                return deliveryEmployeeList;
            } catch (SQLException e) {
                System.err.println(e.getMessage());

                throw new FailedToGetDeliveryEmployeeListException();
            }
        }

        public List<Employee> getAllSalesEmployees () throws FailedToGetSalesEmployeeListException {
            try {
                List<Employee> salesEmployeeList = employeeDao.getAllSalesEmployees();

                return salesEmployeeList;
            } catch (SQLException e) {
                System.err.println(e.getMessage());

                throw new FailedToGetSalesEmployeeListException();
            }

            public Employee getEmployeeById ( int employeeId) throws FailedToGetEmployeeByIdException {
                try {
                    Employee employee = employeeDao.getEmployeeById(id);

                    if (employee == null) {
                        throw new FailedToGetEmployeeByIdException();
                    }

                    return employee;
                } catch (SQLException e) {
                    System.err.println(e.getMessage());

                    throw new FailedToGetEmployeeByIdException();
                }

                public DeliveryEmployee getDeliveryEmployeeById ( int deliveryEmployeeId)
                FailedToGetDeliveryEmployeeByIdException {
                    try {
                        DeliveryEmployee deliveryEmployee = employeeDao.getDeliveryEmployeeById(id);

                        if (deliveryEmployee == null) {
                            throw new FailedToGetDeliveryEmployeeByIdException();
                        }

                        return deliveryEmployee;
                    } catch (SQLException e) {
                        System.err.println(e.getMessage());

                        throw new FailedToGetDeliveryEmployeeByIdException();
                    }

                    public SalesEmployee getSalesEmployeeById ( int salesEmployeeId) throws
                    FailedToGetSalesEmployeeByIdException {
                        try {
                            SalesEmployee salesEmployee = employeeDao.getSalesEmployeeById(id);

                            if (salesEmployee == null) {
                                throw new FailedToGetSalesEmployeeByIdException();
                            }

                            return salesEmployee;
                        } catch (FailedToGetSalesEmployeeByIdException e) {
                            throw new RuntimeException(e);
                        }

                        public void updateEmployee ( int employeeId, EmployeeRequest employee) throws
                        FailedToUpdateEmployeeException {
                            try {
                                Employee employeeToUpdate = employeeDao.getEmployeeById(id);

                                if (employeeToUpdate == null) {
                                    throw new EmployeeDoesNotExistException();
                                }

                                employeeDao.updateEmployee(id, employee);
                            } catch (SQLException e) {
                                System.err.println(e.getMessage());

                                throw new FailedToUpdateEmployeeException();
                            }

                        }
//NOT NEEDED
//    public void updateDeliveryEmployee(int id) {
//        DeliveryEmployee deliveryEmployeeToUpdate = employeeDao.getEmployeeById(id);
//
//    }
//
//    public void updateSalesEmployee(int id) {
//        SalesEmployee salesEmployeeToUpdate = employeeDao.getEmployeeById(id);
//
//    }
//NOT NEEDED
                        public void deleteEmployee ( int id) throws FailedToDeleteEmployeeException {
                            try {
                                Employee employeeToDelete = employeeDao.getEmployeeById(id);

                                if (employeeToDelete == null) ;
                                {
                                    throw new FailedToDeleteEmployeeException();
                                }
                                employeeDao.updateEmployee(id, employee);
                            } catch (SQLException e) {
                                System.err.println(e.getMessage());

                                throw new FailedToDeleteEmployeeException();
                            }

                        }
//NOT NEEDED
//                        public int createDeliveryEmployee (Employee deliveryEmployee){
//                            int id = employeeDao.createDeliveryEmployee(deliveryEmployee);
//
//                            return id;
//                        }
//
//                        public int createSalesEmployee (Employee salesEmployee){
//                            int id = employeeDao.createSalesEmployee(salesEmployee);
//
//                            return id;
//        NOTNEEDED
                        }

                    }
                }
            }
        }
    }
}