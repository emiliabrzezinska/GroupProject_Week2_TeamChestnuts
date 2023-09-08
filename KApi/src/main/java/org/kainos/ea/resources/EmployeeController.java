package org.kainos.ea.resources;

import io.swagger.annotations.Api;
import org.kainos.ea.api.EmployeeService;
import org.kainos.ea.cli.DeliveryEmployeeRequest;
import org.kainos.ea.cli.Employee;
import org.kainos.ea.cli.EmployeeRequest;
import org.kainos.ea.client.*;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

@Api("Engineering Academy Dropwizard Product API")
@Path("/api")
public class EmployeeController {
    private EmployeeService employeeService = new EmployeeService();


//    @POST
//    @Path("/employees/delivery")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response createDeliveryEmployee(Employee employee) {
//        return Response.ok(employeeService.cre
//    }

    @PUT
    @Path("/employees/delivery/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateDeliveryEmployee(@PathParam("id") int id, EmployeeRequest employee) throws FailedToUpdateEmployeeException {
        try {
            employeeService.updateEmployee(id, employee);
            return Response.ok().build();
        } catch (FailedToUpdateEmployeeException e) {
            System.err.println(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/employees/delivery/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDeliveryEmployeeById(@PathParam("id") int id) throws FailedToGetEmployeeByIdException {
        try {
            employeeService.getEmployeeById(id);
            return Response.ok().build();
        } catch (FailedToGetEmployeeByIdException e) {
            System.err.println(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/employees/delivery")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDeliveryEmployees() throws FailedToGetDeliveryEmployeeListException {
        return Response.ok(employeeService.getAllDeliveryEmployees()).build();
    }

    @DELETE
    @Path("/employees/delivery/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteDeliveryEmployee(@PathParam("id") int id) throws FailedToDeleteEmployeeException {
        employeeService.deleteEmployee(id);
        return Response.ok().build();
    }

//    @PUT
//    @Path("/projects/{id}/delivery")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response assignDeliveryEmployee(@PathParam("id") int id, Employee employee) {
//        employeeService.(id);
//        return Response.ok().build();
//    }
}