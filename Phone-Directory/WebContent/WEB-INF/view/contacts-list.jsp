<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>

<title>Staring....</title>

<link type="text/css"
      rel="stylesheet"
      href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

</body>

   <div id="wrapper">
   <div id="header">
    <h2>Contacts Manager</h2>
   </div>
</div>


<div id="container">
  <div id="content">
  
  <input type="button" value="AddContacts" 
    onclick="window.location.href='showFormForAdd'; return false"
    class="add-button"/>
    
   
   <form:form action="search" method="GET" >
        Search contact(name) : <input type="text" name="theSearchName"/>
        
        <input type="submit" value="Search" class="add-button" />
        
    </form:form>  
    
   <form:form action="search1" method="GET" >
        Search contact(number) : <input type="text" name="theSearchNumber"/>
        
        <input type="submit" value="Search" class="add-button" />
        
    </form:form>      
           
    
   <table>
   <tr>
   
   <th>First Name</th>
   <th>Last Name</th>
   <th>Phone Number</th>
   <th>Action</th>
   </tr>
   
   <c:forEach var="tempContacts" items="${contacts}">
   
    <c:url var="updateLink" value="/directory/showFormForUpdate">
   <c:param name="contactsId" value="${tempContacts.id}" />
   </c:url>
   
   <c:url var="deleteLink" value="/directory/delete">
   <c:param name="contactsId" value="${tempContacts.id}" />
   
   </c:url> 
   
   <tr>
      <td>${tempContacts.firstName}</td>
       <td>${tempContacts.lastName}</td>
        <td>${tempContacts.phoneNumber}</td>
        
        <td>
        
        <a href="${updateLink}">Update</a> 
        |
        <a href="${deleteLink}"
        onclick="if(!(confirm('are you sure?'))) return false">Delete</a>
        
        </td>
        
   </tr>
   
   </c:forEach>
   </table>
   
   </div>
   </div>


</html>