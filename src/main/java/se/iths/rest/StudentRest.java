package se.iths.rest;

import se.iths.entity.Student;
import se.iths.exceptions.StudentNotFoundException;
import se.iths.service.StudentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("student")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentRest {

    @Inject
    StudentService studentService;

    @Path("add")
    @POST
    public Response createStudent(Student student) {
        studentService.createStudent(student);
        return Response.ok(student).build();
    }

    @Path("getAll")
    @GET
    public Response getAllStudents() {
        List<Student> studenter = studentService.getAllStudents();
        return Response.ok(studenter).build();
    }

    @Path("getByID/{id}")
    @GET
    public Response getStudentByID(@PathParam("id") Long id) {
        Student aStudent = studentService.findStudentById(id);
        if (aStudent != null){
            return Response.ok(studentService.findStudentById(id)).build();
    }else{
        throw new StudentNotFoundException("Student with id " + id + " not found");
    }

}


    @Path("delete/{id}")
    @DELETE
    public Response deleteItem(@PathParam("id") Long id) {
        Student aStudent = studentService.findStudentById(id);
        if (aStudent != null) {
            studentService.deleteStudent(id);
            return Response.ok(aStudent).entity("Student with ID " + id + " deleted.").build();
        } else {
            throw new StudentNotFoundException("Student does not exist, and can not be deleted");
        }
    }

    @Path("getByLastName/{name}")
    @GET
    public Response getByLastName(@PathParam("name") String name) {
        List<Student> students = studentService.getByLastName(name);
        return Response.ok(students).build();
}




}
