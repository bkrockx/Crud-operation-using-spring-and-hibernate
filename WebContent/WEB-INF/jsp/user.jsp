<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>  
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
 <head>  
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
  <title>Spring</title>  
 </head>  
 <body>  
  <h2>Add User Data</h2>  
  <form:form method="POST"  modelAttribute="user" action="/SpringHibernate1/addUser">  
      <table>
      <tr>
      	<td><form:label path="id"></form:label></td>
      	<td><form:input path="id" type="hidden" value="${user.id}" readonly="true"/></td>     
      </tr>    
       <tr>  
           <td><form:label path="name">Name:</form:label></td>  
           <td><form:input path="name" value="${user.name}"/></td>  
       </tr>  
       <tr>  
           <td><form:label path="department">Department:</form:label></td>  
           <td><form:input path="department" value="${user.department}"/></td>  
       </tr>           
       <tr>  
           <td><form:label path="password">Password:</form:label></td>  
           <td><form:input path="password" value="${user.password}"/></td>  
       </tr>  
          <tr>  
         <td colspan="2"><input type="submit" value="Submit"/></td>  
        </tr>  
   </table>   
  </form:form>  
    
   
  <h2>List users</h2>  
 <table align="left" border="1">  
  <tr>  
   <th>ID</th>  
   <th>Name</th>  
   <th>Department</th>  
   <th>Password</th>  
   <th>Actions on Row</th>  
  </tr>  
  
  <c:forEach items="${userList}" var="user1">  
   <tr>  
    <td><c:out value="${user1.id}"/></td>  
    <td><c:out value="${user1.name}"/></td>  
    <td><c:out value="${user1.department}"/></td>  
    <td><c:out value="${user1.password}"/></td>    
    <td align="center"><a href="edit/${user1.id}">Edit</a> | <a href="delete/${user1.id}">Delete</a></td>  
   </tr>  
  </c:forEach>  
 </table>  
  
 </body>  
</html>  