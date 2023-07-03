<%@page import="org.com.model.DesignDTO"%>
<%@page import="java.util.List"%>
<%@page import="org.com.model.DesignDAO_JDBC"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
DesignDAO_JDBC designDao = new DesignDAO_JDBC();
%>

<%
// insert 테스트
 DesignDTO dto = new DesignDTO("강교수","디자인철학","test", "tset", "cd1234");
 designDao.insert(dto);
%>

<%
// delete 테스트
// DesignDTO dto = new DesignDTO(3);
// designDao.delete(dto);
%>

<%
// DesignDTO dto = new DesignDTO(2, "디자인철학","test", "tset");
// designDao.update(dto);
%>

<%
// List<DesignDTO> list = designDao.selectAll();
// out.println(list);
%>

<%
// DesignDTO design = designDao.selectOne(new DesignDTO(3));
// out.println(design);
%>

</body>
</html>