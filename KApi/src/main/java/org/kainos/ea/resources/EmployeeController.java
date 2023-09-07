package org.kainos.ea.resources;

import io.swagger.annotations.Api;
import org.kainos.ea.api.EmployeeService;
import org.kainos.ea.cli.Employee;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

@Api("Engineering Academy Dropwizard Product API")
@Path("/api")
public class EmployeeController {
    private EmployeeService employeeService = new EmployeeService();

    @POST
    @Path("/employees/delivery")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createDeliveryEmployee(Employee employee) {
        return Response.ok(employeeService.createDeliveryEmployee(employee)).build();
    }
    @PUT
    @Path("/employees/delivery/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateDeliveryEmployee(@PathParam("id") int id, Employee employee) {
        employeeService.updateDeliveryEmployee(id);
        return Response.ok().build();
    }

    @GET
    @Path("/employees/delivery/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDeliveryEmployeeById(@PathParam("id") int id) {
        return Response.ok(employeeService.getEmployeeById(id)).build();
    }

    @GET
    @Path("/employees/delivery")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDeliveryEmployees() {
        return Response.ok(employeeService.getAllDeliveryEmployees()).build();
    }

    @DELETE
    @Path("/employees/delivery/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteDeliveryEmployee(@PathParam("id") int id) {
        employeeService.deleteEmployee(id);
        return Response.ok().build();
    }
//    @PUT
//    @Path("/projects/{id}/delivery")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response assignDeliveryEmployee(@PathParam("id") int id, Employee employee) {
//        employeeService.createDeliveryEmployee(id)
//        return Response.ok().build();
//    }
}
