<%@page import="org.com.design.DesignDTO"%>
<%@page import="java.util.List"%>
<%@page import="org.com.design.DesignDAO"%>
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
// DesignDTO dto = new DesignDTO(0, "강교수", "디자인철학", "test", "textcontent", "asd1234", null, 0, 0, 0, 0);
DesignDTO dto = new DesignDTO("강교수", "디자인철학", "test", "textcontent", "asd1234");
designDao.insert(dto);
%>

<%
// delete 테스트
//DesignDTO dto = new DesignDTO(3);
//designDao.delete(dto);
%>

<%
//DesignDTO dto = new DesignDTO(1, "제목 수정", "내용 수정 테스트");
//designDao.update(dto);
%>

<%
//List<DesignDTO> list = designDao.selectAll();
//out.println(list);
%>

<%
//DesignDTO design = designDao.selectOne(new DesignDTO(3));
//out.println(design);
%>

</body>
</html>