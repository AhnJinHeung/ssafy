<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Happy House</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" />
    <link rel="stylesheet" href ="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  </head>
  <body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	
    <div class="container">
        <div style="height: 60px;"></div>
        <!-- 중앙 contents start -->
        <div class="row">
            <!-- 중앙 center contents start -->
            <div class="col-md-12">
                <!-- 지도 Section Start  -->
                <div class="container">
                <%@ include file="/WEB-INF/views/include/map.jsp"%>
				</div>
                <!-- 프로그래밍 Section End  -->
                <!-- 에세이 Section Start  -->
                
                <!-- 에세이 Section End  -->
                <div class="row mt-5">
                    <!-- 인기글 Article Start  -->
                    <div class="col-md-6">
                        <h4>[ 주택 관련 기사 ]</h4>
                        <table class="table table-hover">
                            <thead class="thead-dark">
                                <tr>
                                    <th class="title">제목</th>
                                    <th>작성자</th>
                                    <th>조회수</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>‘은행’과 ‘보험사’의 주택담보대출 조건</td>
                                    <td>이주녕</td>
                                    <td>12</td>
                                </tr>
                                <tr>
                                    <td>12.16 대책 후 ‘매수·매도자 모두 일단 관망세’</td>
                                    <td>조밍기</td>
                                    <td>98</td>
                                </tr>
                                <tr>
                                    <td>구미시, 낙동강 변 국가3산단에 민간공원 조성</td>
                                    <td>류해면</td>
                                    <td>856</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <!-- 인기글 Article End  -->
                    <!-- 최신글 Article Start  -->
                    <div class="col-md-6">
                    <h4>[ 오늘의 뉴스 ]</h4>
                        <table class="table table-hover">
                            <thead class="thead-dark">
                                <tr>
                                    <th class="title">제목</th>
                                    <th>작성자</th>
                                    <th>조회수</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>KB국민은행, ‘디지털헌금바구니’ 출시</td>
                                    <td>안싸피</td>
                                    <td>122</td>
                                </tr>
                                <tr>
                                    <td>제6회 INAK사회공헌대상 프레스클럽부문 수상</td>
                                    <td>하싸피</td>
                                    <td>948</td>
                                </tr>
                                <tr>
                                    <td>삼성전자, 한샘과 공동사업 강화 위한 업무협약 체결</td>
                                    <td>김싸피</td>
                                    <td>86</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <!-- 최신글 Article End  -->
                </div>
            </div>
            <!-- 중앙 center contents end -->
            
        </div>
        <div style="height: 40px;"></div>
        <!-- 중앙 contents end -->
	</div>
    <!-- 하단 Footer Start  -->
    <%@ include file="/WEB-INF/views/include/footer.jsp" %>
    <!-- 하단 Footer End  -->
  </body>
</html>