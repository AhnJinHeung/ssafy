<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<div id="map" style="max-width:1200px;height:500px;"></div>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=eb94e0a165fada25939d9bf736b9992f"></script>
<script>
	$(function() {
		$.ajax({
			url : "${root}/house/marker",
			data : {
				"dong" : "${dong}"
			},
			type : "POST",
			dataType : "json",
			success : function(data) {
				var lat = "${position.lat}";
				var lng = "${position.lng}";
				
				if (!lat) lat = 37.5915245479787;
				if (!lng) lng = 126.9768010428442;
				
				var container = document.getElementById('map');
				var options = {
					center: new kakao.maps.LatLng(lat, lng),
					level: 6
				};

				var map = new kakao.maps.Map(container, options);
				
				$.each(data, function(index, item) {
					var markerPosition  = new kakao.maps.LatLng(item.lat, item.lng); 
					
				    // 마커를 생성합니다
				    var marker = new kakao.maps.Marker({
				        map: map, // 마커를 표시할 지도
				        position: markerPosition, // 마커를 표시할 위치
				        title : item.aptName, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
				    });
				    marker.setMap(map);
				});
			}
		});
	})
</script>