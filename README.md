# student-management-system
Starting project | Java EE assignment | JU19 | ITHS
_________________________________________________________
### NEW 
POST http://localhost:8080/se.iths/api/v1/student/add
Content-Type: application/json

{
	"firstName": "Måns",
	"lastName": "fritzner",
	"email": "mans@mail.se",
	"phoneNumber": "123"
}
__________________________________________________________

### GET ALL
GET http://localhost:8080/se.iths/api/v1/student/getAll

__________________________________________________________

### DELETE
DELETE http://localhost:8080/se.iths/api/v1/student/delete/{id}

__________________________________________________________

### GET BY LASTNAME
GET http://localhost:8080/se.iths/api/v1/student/getByLastName/{lastname}

__________________________________________________________

### GET BY ID
GET http://localhost:8080/se.iths/api/v1/student/getByID/{id}

__________________________________________________________
