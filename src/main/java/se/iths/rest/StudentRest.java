package se.iths.rest;

import se.iths.entity.Student;
import se.iths.service.StudentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("item")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentRest {

    @Inject
    StudentService studentService;

    @Path("postStudent")
    @POST
    public Response createStudent(Student student){
        studentService.createStudent(student);
        return Response.ok(student).build();
    }

    @Path("getAllStudents")
    @GET
    public Response getAllStudents(){
        List<Student> studenter = studentService.getAllStudents();
        return Response.ok(studenter).build();
    }

    @Path("getStudentByID/{id}")
    @GET
    public Response getStudentByID(@PathParam("id") Long id){
        return Response.ok(studentService.findStudentById(id)).build();
    }

    @Path("deleteStudent/{id}")
    @DELETE
    public Response deleteItem(@PathParam("id") Long id) {
        Student aStudent = studentService.findStudentById(id);
        if (aStudent != null) {
            studentService.deleteStudent(id);
            return Response.ok(aStudent).entity("Student with ID " + id + " deleted.").build();
        } else {
            return Response.noContent().build();
        }
    }

    @Path("getByLastName/{name}")
    @GET
    public Response getByLastName(@PathParam("name") String name) {
        List<Student> studenter = StudentService.getByLastName(name);
        return Response.ok(studenter).build();
}




}
