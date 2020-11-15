
<%@include file = "/WEB-INF/views/template/header.jsp" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link rel = "stylesheet" href = "/css/style.css">
<link rel = "stylesheet" href = "/css/style.css">
<script src="/js/main.js"></script>
<meta charset="ISO-8859-1">
<title>See All USERS!!!</title>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.css"> 
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.js"></script>

</head>
<body>
	<table id="dtOrderExample" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
  <thead>
    <tr>
      <th class="th-sm">UserId</th>
      <th class="th-sm">username</th>
      <th class="th-sm">role</th>
      <th class="th-sm">First Name</th>
      <th class="th-sm">Middle Name</th>
      <th class="th-sm">Last Name</th>
      <th class="th-sm">House Number</th>
      <th class="th-sm">Street Name</th>
      <th class="th-sm">City</th>
      <th class="th-sm">Pincode</th>
      <th class="th-sm">Adhar</th>
      <th class="th-sm">Category</th>
      <th class="th-sm">Blood</th>
      <th class="th-sm">Gender</th>
      <th class="th-sm">Registration Date</th>
      <th class="th-sm">Student Id</th>
      <th class="th-sm">Leaves Taken</th>
      <th class="th-sm">Fees Due</th>
      
    </tr>
  </thead>
  <tbody>
    <tr>
       <c:forEach var = "student" items = "${allUsers }" >
		  		<tr>
		  			<th scope = "row"> 1</th>
		  			<td>${student.user.userId}</td><td>${student.user.username}</td><td>${student.user.role}</td>
		  			<td>${student.user.firstName}</td><td>${student.user.middleName}</td>
		  			<td>${student.user.lastName}</td><td>${student.user.houseNumber}</td>
		  			<td>${student.user.streetName}</td>
		  			<td>${student.user.city}</td><td>${student.user.pincode}</td>
		  			<td>${student.user.adharNumber}</td>
		  			<td>${student.user.category}</td><td>${student.user.bloodGroup}</td>
		  			<td>${student.user.gender}</td>
		  			<td>${student.user.registrationDate}</td>
		  			<td>${student.studentId}</td>
		  			<td>${student.leavesTaken}</td>
		  			<td>${student.feesDue}</td>
		  			<td><div class="btn-group">
						  <button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						    Update
						  </button>
						  <div class="dropdown-menu">
						    <a class="dropdown-item" href="${currentUrl}/${student.user.userId}/updateGenInfo">Update General Information</a>
						    <a class="dropdown-item" href="${currentUrl}/${student.user.userId}/updateSpecInfo">Update user specific information</a>
<!-- 						    <div class="dropdown-divider"></div> -->
<!-- 						    <a class="dropdown-item" href="#">Separated link</a> -->
						  </div>
						</div>
					</td>
		  			
		  			<td><div class="btn-group">
						  <button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						    Classes
						  </button>
						  <div class="dropdown-menu">
						    <a class="dropdown-item" href="${currentUrl}/${student.user.userId}/classesOfStudent">See classes of student</a>
						    <a class="dropdown-item" href="${currentUrl}/${student.user.userId}/addToClass">Add student to a class</a>
						  </div>
						</div>
					</td>
					
					<td><div class="btn-group">
						  <button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						    Responsibility
						  </button>
						  <div class="dropdown-menu">
						    <a class="dropdown-item" href="${currentUrl}/${student.user.userId}/viewResponsibility">View Responsibilities</a>
						    <a class="dropdown-item" href="${currentUrl}/${student.user.userId}/addResponsibility">Give new responsibility</a>
						  </div>
						</div>
					</td>
		  			<td><form action = "/student/${student.user.username }/viewFeedback" method = "get">
		  					<button class="btn btn-success" type = "submit">view feedbacks</button>
		  				</form></td>
	  				<td><div class="btn-group">
					  <button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					    Achievement
					  </button>
					  <div class="dropdown-menu">
					    <a class="dropdown-item" href="${currentUrl}/${student.user.userId}/viewAchievement">view Achievements</a>
					    <a class="dropdown-item" href="${currentUrl}/${student.user.userId}/giveAchievement">Give  Achievement</a>
					  </div>
					</div>
					</td>
					<td><div class="btn-group">
					  <button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					    Participation
					  </button>
					  <div class="dropdown-menu">
					    <a class="dropdown-item" href="${currentUrl}/${student.user.userId}/viewParticipation">view Participations</a>
					    <a class="dropdown-item" href="${currentUrl}/${student.user.userId}/giveParticipation">Give  Participation</a>
					  </div>
					</div>
					</td>
					<td><div class="btn-group">
						  <button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						    Guardian
						  </button>
						  <div class="dropdown-menu">
						    <a class="dropdown-item" href="${currentUrl}/${student.user.userId}/guardiansOfStudent">See guardians of student</a>
						    <a class="dropdown-item" href="${currentUrl}/${student.user.userId}/addGuardian">Add guardian of student</a>
						  </div>
						</div>
					</td>
<!-- 					Contact details -->
					<td><div class="btn-group">
					  <button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					    Contact details
					  </button>
					  <div class="dropdown-menu">
					    <a class="dropdown-item" href="${currentUrl}/${student.user.userId}/viewPhoneNumbers">view Phone numbers</a>
					    <a class="dropdown-item" href="${currentUrl}/${student.user.userId}/viewEmails">view Emails</a>
					    <form action = "${currentUrl}/${student.user.userId}/addPhoneNumber" method = "post">
				  			<div class="form-group">
							    <label for="">Contact Number</label>
					   			<input type="text" class="form-control" placeholder="enter first name"
					   			name = "phoneNumber">
						  	</div>
		  					<button class="btn btn-success" type = "submit">Add this number</button>
		  				</form>
		  				 <form action = "${currentUrl}/${student.user.userId}/addEmail" method = "post">
				  			<div class="form-group">
							    <label for="">Email Address</label>
					   			<input type="text" class="form-control" placeholder="enter first name"
					   			name = "email">
						  	</div>
		  					<button class="btn btn-success" type = "submit">Add this email address</button>
		  				</form>
					  </div>
					</div>
					</td>
					<td><div class="btn-group">
						  <button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						    Transaction
						  </button>
						  <div class="dropdown-menu">
						    <a class="dropdown-item" href="${currentUrl}/${student.user.userId}/addTransaction">Add a transaction</a>
						    <a class="dropdown-item" href="${currentUrl}/${student.user.userId}/seeTransaction">See transactions</a>
						  </div>
						</div>
					</td>
		  		</tr>
		  </c:forEach>
    </tr>
    <tr>
      <td>Garrett Winters</td>
      <td>Accountant</td>
      <td>Tokyo</td>
      <td>63</td>
      <td>2011/07/25</td>
      <td>$170,750</td>
    </tr>
    <tr>
      <td>Ashton Cox</td>
      <td>Junior Technical Author</td>
      <td>San Francisco</td>
      <td>66</td>
      <td>2009/01/12</td>
      <td>$86,000</td>
    </tr>
    
    <tr>
      <td>Jenette Caldwell</td>
      <td>Development Lead</td>
      <td>New York</td>
      <td>30</td>
      <td>2011/09/03</td>
      <td>$345,000</td>
    </tr>
    <tr>
      <td>Yuri Berry</td>
      <td>Chief Marketing Officer (CMO)</td>
      <td>New York</td>
      <td>40</td>
      <td>2009/06/25</td>
      <td>$675,000</td>
    </tr>
    <tr>
      <td>Caesar Vance</td>
      <td>Pre-Sales Support</td>
      <td>New York</td>
      <td>21</td>
      <td>2011/12/12</td>
      <td>$106,450</td>
    </tr>
    <tr>
      <td>Shad Decker</td>
      <td>Regional Director</td>
      <td>Edinburgh</td>
      <td>51</td>
      <td>2008/11/13</td>
      <td>$183,000</td>
    </tr>
    <tr>
      <td>Michael Bruce</td>
      <td>Javascript Developer</td>
      <td>Singapore</td>
      <td>29</td>
      <td>2011/06/27</td>
      <td>$183,000</td>
    </tr>
    <tr>
      <td>Donna Snider</td>
      <td>Customer Support</td>
      <td>New York</td>
      <td>27</td>
      <td>2011/01/25</td>
      <td>$112,000</td>
    </tr>
  </tbody>
  <tfoot>
    <tr>
      <th>Name
      </th>
      <th>Position
      </th>
      <th>Office
      </th>
      <th>Age
      </th>
      <th>Start date
      </th>
      <th>Salary
      </th>
    </tr>
  </tfoot>
</table>
</body>
</html>