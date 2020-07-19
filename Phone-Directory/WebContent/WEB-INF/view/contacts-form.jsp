<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>


<html>

<head>

<title>Save Contacts</title>

<style>

 .error {color:red}

</style>

<link type="text/css"
      rel="stylesheet"
      href="${pageContext.request.contextPath}/resources/css/style.css" />
      
      
      <link type="text/css"
      rel="stylesheet"
      href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
      

</head>

<body>

<div id="wrapper">
   <div id="header">
    <h2>Contacts Manager</h2>
   </div>
</div>

<div id="container">

  <h3> Save Contacts</h3> 
  
  <form:form action="saveContacts" modelAttribute="contacts" method="POST">
  
  <!-- need to associate with the customer id -->
  <form:hidden path="id" />
  
  <table>
  <tbody>
  <tr>
   
   
   <td><label>First Name:</label></td>
   <td>
   <form:input path="firstName" />
   </td>
   
  </tr>
  
   <tr>
   
   
   <td><label>Last Name:</label></td>
   <td><form:input path="lastName" />
  </td>
   
  </tr>
  
  
   <tr>
   
   
   <td><label>Phone Number:</label></td>
   <td><form:input path="phoneNumber" />
   </td>
   
  </tr>
  
   <tr>
   
   
   <td><label></label></td>
   <td><input type="submit" value="Save" class="save"/></td>
   
  </tr>
  
  
  </tbody>
  
  
  </table>
  
  </form:form>
  
  <div style="clear; both;"></div>
  
  <p>
   <a href="${pageContext.request.contextPath}/directory/list">Back to list</a>
  </p>
  </div>

</body>



</html>