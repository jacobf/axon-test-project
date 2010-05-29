<html>
<%@ page import="axon.Sample" %>
<body>
<h2>Hello Axon!</h2>
<%
  Sample sample = new Sample();

%>

<%= sample.printIt() %>
</body>
</html>
