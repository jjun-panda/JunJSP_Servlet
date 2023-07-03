<%@page import="org.com.model.DesignDTO"%>
<%@page import="java.util.List"%>
<%@page import="org.com.model.DesignDAO"%>
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
DesignDAO designDao = new DesignDAO();
%>

<%
// insert 테스트
DesignDTO dto = new DesignDTO("김포샵", "디자인일반", "디자인은 무엇인가?", "디자인역사부터 공부해보자!", "abc1234");
designDao.insert(dto);
out.println(dto);
%>

<%
// delete 테스트
//DesignDTO dto = new DesignDTO(4);
//designDao.delete(dto);
//out.println(dto);
%>

<%
// DesignDTO dto = new DesignDTO(2, "디자인미학","test2", "tset2222");
// designDao.update(dto);
%>

<%
//List<DesignDTO> list = designDao.selectAll();
//out.println(list);
%>

<%
// DesignDTO design = designDao.selectOne(new DesignDTO(2));
// out.println(design);
%>

</body>
</html>