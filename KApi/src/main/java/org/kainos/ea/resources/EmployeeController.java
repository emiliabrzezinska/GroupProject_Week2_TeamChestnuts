package org.kainos.ea.resources;

import io.swagger.annotations.Api;
import org.kainos.ea.api.EmployeeService;
import org.kainos.ea.api.ProjectService;
import org.kainos.ea.cli.DeliveryEmployeeRequest;
import org.kainos.ea.cli.Employee;
import org.kainos.ea.cli.EmployeeRequest;
import org.kainos.ea.client.*;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Api("Engineering Academy Dropwizard Product API")
@Path("/api")
public class EmployeeController {
    private EmployeeService employeeService = new EmployeeService();
    private ProjectService projectService = new ProjectService();

    @POST
    @Path("/employees/delivery")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createDeliveryEmployee(DeliveryEmployeeRequest employee) throws FailedToCreateDeliveryEmployeeException {
        try {
            return Response.ok(employeeService.createDeliveryEmployee(employee)).build();
        } catch (FailedToCreateDeliveryEmployeeException e) {
            System.err.println(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/employees/delivery/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateDeliveryEmployee(@PathParam("id") int id, DeliveryEmployeeRequest employee) throws FailedToUpdateEmployeeException {
        try {
            employeeService.updateDeliveryEmployee(id, employee);
            return Response.ok().build();
        } catch (FailedToUpdateDeliveryEmployeeException e) {
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
        try {
            return Response.ok(employeeService.getAllDeliveryEmployees()).build();
        } catch (FailedToGetDeliveryEmployeeListException e) {
            System.err.println(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/employees/delivery/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteDeliveryEmployee(@PathParam("id") int id) throws FailedToDeleteEmployeeException {
        try {
            employeeService.deleteEmployee(id);
            return Response.ok().build();
        } catch (FailedToDeleteEmployeeException e) {
            System.err.println(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/projects/{id}/delivery")
    @Produces(MediaType.APPLICATION_JSON)
    public Response assignDeliveryEmployee(@PathParam("id") int employeeId, int projectId, DeliveryEmployeeRequest employee, List<Integer> projectIdList) throws FailedToUpdateDeliveryEmployeeException, FailedToAssignDeliveryEmployeeException, FailedToGetDeliveryEmployeeException {
        try {
            employeeService.updateDeliveryEmployee(employeeId, employee);
            projectService.assignDeliveryEmployees(projectIdList, projectId);
            return Response.ok().build();
        } catch (FailedToUpdateDeliveryEmployeeException e) {
            System.err.println(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}