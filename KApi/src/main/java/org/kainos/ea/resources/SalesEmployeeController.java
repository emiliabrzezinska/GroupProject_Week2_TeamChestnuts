package org.kainos.ea.resources;
import io.swagger.annotations.Api;
import org.kainos.ea.api.EmployeeService;
import org.kainos.ea.cli.Employee;
import org.kainos.ea.cli.SalesEmployeeRequest;
import org.kainos.ea.client.FailedToAssignDeliveryEmployeeException;
import org.kainos.ea.client.FailedToGetSalesEmployeeByIdException;
import org.kainos.ea.client.FailedToGetSalesEmployeeListException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Api("Engineering Academy Dropwizard Product API")
@Path("/api")
public class SalesEmployeeController {
    private SalesEmployeeService salesEmployeeService = new SalesEmployeeService();

/*8 create*/
    @POST
    @Path("employees/sales")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createSalesEmployee(SalesEmployee salesEmployee) {
        try {
            return Response.ok(salesEmployeeService.createSalesEmployee(salesEmployee)).build();
        } catch (FailedToCreateSalesEmployeeExeption e) {
            System.err.println(e.getMessage());
            return Response.serverError().build();
        }
    }


/*9 update*/
    @PUT
    @Path("/employees/sales/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateSalesEmployeeById(@PathParam("id") int id) {
        try {
            salesEmployeeService.updateSalesEmployeeById(id);
            return Response.ok().build();
        } catch (FailedToUpdateSalesEmployeeExeption e) {
            System.err.println(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

/*10 view*/
    @GET
    @Path("/employees/sales/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSalesEmployeeById(@PathParam("id") int id) {
        try {
            return Response.ok(salesEmployeeService.getSalesEmployeeById(id).build());
        } catch (FailedToGetSalesEmployeeByIdException e) {
            System.err.println(e.getMessage());
            return Response.serverError().build();
        }
    }

/*11 view*/
    @GET
    @Path("/employees/sales")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSalesEmployee(salesEmployeeSErvice salesEmployee) {
        try {
            return Response.ok(salesEmployee.getSalesEmployee().build());
        } catch (FailedToGetSalesEmployeeListException e) {
            System.err.println(e.getMessage());
            return Response.serverError().build();
        }
    }


/*12 del*/
@DELETE
@Path("/employees/sales/{id}")
@Produces(MediaType.APPLICATION_JSON)
    public Response deleteSalesEmployee(@PathParam("id") int id) {
        try {
            salesEmployeeService.deleteSalesEmployees(id);
            return Response.ok().build();
        }catch (FailedToDeleteSalesEmployeeExeption e ){
            System.err.println(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }

        }
}

