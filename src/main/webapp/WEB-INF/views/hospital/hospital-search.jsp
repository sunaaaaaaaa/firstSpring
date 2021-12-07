<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script type="text/javascript" src="${contextPath}/resources/js/jquery.js"></script>
<script type="text/javascript" src="${contextPath}/resources/js/hospital_adress.js"></script>
 <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel='stylesheet' href="${contextPath}/resources/css/all.css">
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/proj4js/1.1.0/proj4js-combined.min.js"></script>

<style type="text/css">

/* 폰트 어그로 */
@font-face {
    font-family: 'SBAggroB';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2108@1.1/SBAggroB.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}

@font-face {
    font-family: 'SBAggroL';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2108@1.1/SBAggroL.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}

@font-face {
    font-family: 'SBAggroM';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2108@1.1/SBAggroM.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}

/* google noto sans */

@font-face {
font-family: 'NotoKrL';
font-style: normal;
font-weight: 100;
src: local('Noto Sans Light'), local('NotoSans-Light'), url(/fonts/NotoSans-Light.eot);
src: url(/fonts/NotoSans-Light.eot?#iefix) format('embedded-opentype'),
url(/fonts/NotoSans-Light.woff2) format('woff2'),
url(/fonts/NotoSans-Light.woff) format('woff');;
}
@font-face {
font-family: 'NotoKrR';
font-style: normal;
font-weight: 300;
src: local('Noto Sans Regular'), local('NotoSans-Regular'), url(/fonts/NotoSans-Regular.eot);
src: url(/fonts/NotoSans-Regular.eot?#iefix) format('embedded-opentype'),
url(/fonts/NotoSans-Regular.woff2) format('woff2'),
url(/fonts/NotoSans-Regular.woff) format('woff');
}
@font-face {
font-family: 'NotoKrM';
font-style: normal;
font-weight: 500;
src: local('Noto Sans Medium'), local('NotoSans-Medium'), url(/fonts/NotoSans-Medium.eot);
src: url(/fonts/NotoSans-Medium.eot?#iefix) format('embedded-opentype'),
url(/fonts/NotoSans-Medium.woff2) format('woff2'),
url(/fonts/NotoSans-Medium.woff) format('woff');
}
@font-face {
font-family: 'NotoKrB';
font-style: normal;
font-weight: 700;
src: local('Noto Sans Bold'), local('NotoSans-Bold'), url(/fonts/NotoSans-Bold.eot);
src: url(/fonts/NotoSans-Bold.eot?#iefix) format('embedded-opentype'),
url(/fonts/NotoSans-Bold.woff2) format('woff2'),
url(/fonts/NotoSans-Bold.woff) format('woff');
}



	.name_section{
	background-color: rgb(240, 234, 213);
    height: 150px;
	}
  .main1{
    height: 50px;
    margin: 0px 0px 0px 0px; 
  }
  .main_name{
    font-size: 25px;
    height:65%;
    text-align: center;
    font-family: 'SBAggroL';
  }
	.body_section{
	background-color: rgb(240, 234, 213);
    height: 2500px;
    position:relative;
	}
  .main2{
    height: 200px;   /* seach높이조절 */
    width: 1000px;
    position: absolute;
    left:50%;
    transform: translate(-50%,-30%);
    font-family: 'SBAggroL';
    
  }
  .search{
    height:150px;
  }
  .search1{
    transform: translate(33%,0);
  }
  .checkbox{
    margin-top: 20px;
    font-size: 20px;
    text-align: center;
  }
  .nameMarker{
 	margin-top: 20px;
    font-size: 20px;
    text-align: right;
  }
  .radio{
    display: inline;
  }
  .main3{
    height: 750px;
    position: absolute;
  left:50%;
  transform: translate(-50%,10%);
  font-family: 'SBAggroB';
  }
  #main_map{
    width:1000px;
    height:700px;
    border:3px solid white;
  }
  .main4{
    height: 1300px;
    position: absolute;
  	left:50%;
  	transform: translate(-50%,66%);
  	font-family: 'SBAggroL';
  }
  .resultBlock{
  	display: flex;
  	padding: 30px; 
  	width:1360px;
  	height:400px;
  }
  .resultText{
  	margin-left:20px;
  	padding:30px;
  	width:910px;
    border:3px solid white;
    overflow:auto; 
        -ms-overflow-style: none; /* IE and Edge */
    scrollbar-width: none; /* Firefox */
  }
.resultText::-webkit-scrollbar {
 width: 8px;
}
.resultText::-webkit-scrollbar-thumb {
    background-color: white; /*스크롤바의 색상*/
}



/* 주소 */
  .bo_w_select1{
    width: 100px; /* 가로 사이즈 */
    padding: 10px; /* 내부여백 */
    padding-left: 12px;
    border: 1px solid #ddd;
    background-size: 30px; /* 화살표 크기 */
    border-radius: 4px;
    box-sizing: border-box;
    -webkit-appearance: none;
    -moz-appearance: none;
    appearance: none;
    font-size: 15px;
    color: #000;
    outline:none;
    	font-family: 'SBAggroL';
}
.bo_w_select1:hover {border: 1px solid #aaa;} /* 마우스오버 */

.bo_w_select2{
    width: 100px; /* 가로 사이즈 */
    padding: 10px; /* 내부여백 */
    padding-left: 12px;
    border: 1px solid #ddd;
    background-size: 30px; /* 화살표 크기 */
    border-radius: 4px;
    box-sizing: border-box;
    -webkit-appearance: none;
    -moz-appearance: none;
    appearance: none;
    font-size: 15px;
    color: #000;
    outline:none;
    	font-family: 'SBAggroL';
}
.bo_w_select2:hover {border: 1px solid #aaa;} /* 마우스오버 */

.myGeo{
  width: 100px; /* 가로 사이즈 */
    padding: 10px; /* 내부여백 */
    padding-left: 12px;
    border: 1px solid #ddd;
    background-color: white;
    border-radius: 4px;
    box-sizing: border-box;
    -webkit-appearance: none;
    -moz-appearance: none;
    appearance: none;
    font-size: 15px;
    color: #000;
    outline:none;
    margin-left: 700px;
    	font-family: 'SBAggroL';
}
.myGeo:hover {border: 1px solid #aaa;} /* 마우스오버 */







</style>



</head>
<body>
  <section >
    <div class="name_section">
      <div class="main1">
        <div class="main_name" >병원/편의시설 검색</div>
      </div>
    </div>
    <div class="body_section">
        <div class="main2">
          <div class="search">
          <div class="checkbox">
                <label><input type="checkbox" class="hos" name="facility" value="동물병원" id="hospitalCheck" checked>동물병원</label>
                <span class="radio">
                  <label><input type="radio" class="hos" name="optionsRadios" id="optionsRadios1" value="1차" checked>1차병원</label>
                  <label><input type="radio" class="hos" name="optionsRadios" id="optionsRadios2" value="2차">전문·대학병원  </label>    
                </span>
                <label><input id="phar" type="checkbox" name="facility" value="약국" checked>약국</label>
                <br>
                <label><input id="sal"  type="checkbox" name="facility" value="미용" checked>미용</label>
                <label><input id="hotel" type="checkbox" name="facility" value="호텔" checked>호텔</label>
                <label><input id="cafe" type="checkbox" name="facility" value="카페" checked>카페</label>
                <label><input id="buy" type="checkbox" name="facility" value="분양" checked>분양</label>                
                <label><input id="tax" type="checkbox" name="facility" value="펫택시" checked>펫택시</label>
                <label><input id="toy" type="checkbox" name="facility" value="애견용품점" checked>애견용품</label>
                
              </div>
              <div class="search1">
	              <div class="col-xs-4">
	                <input type="text" class="form-control" placeholder="시설이름을 입력하세요" name="NameInput">
	              </div>
	              <div class="btn-group" role="group" aria-label="...">
	                <button class="btn btn-lg" id="searchSubmit" style="background-color: white; border: white;">
	                    <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
	                </button>
              		</div>
            </div>

          </div>
        </div>
        <div class="main3">
       		<select name="sido1" id="sido1" class="bo_w_select1"></select>
            <select name="gugun1" id="gugun1" class="bo_w_select2" ></select>
            <span class="myGeo" >현재위치</span>
            <div id="main_map"></div>
           	  <div class="nameMarker">
                <label>동물병원<img src="/resources/img/map-pin-red2.png" style="width:32px; height:38px"/></label>
                <label>약국<img src="/resources/img/map-pin-green.png"/></label>
                <label>편의시설<img src="/resources/img/map-pin-pink.png"/></label>
              </div>
        </div>
        <div class="main4">
            <div class="search_result">
            <br>
            <br>
           <div class="resultContainer">
	           <section class="resultBlock" >
	           		<img src="/resources/img/my2.png">
	           		<div class="resultText" style=" height:340px">
	           			<ul class="resultLists" id="hosUL">
	           			</ul>
	           		</div>
	           </section>
	           <section class="resultBlock">
	           		<img src="/resources/img/my3.png">
	           		<div class="resultText" style=" height:340px">
	           			<ul class="resultLists" id="pharUL">
	           			</ul>
	           		</div>
	           </section>
	           <section class="resultBlock">
	           		<img src="/resources/img/my1.png" >
	           		<div class="resultText" style="height:340px" >
	           			<ul class="resultLists" id="toyUL">
	           			</ul>
	           		</div>
	           </section>
           </div>

            <nav>
              <div class="paging" >
				</div>
            </nav>

          </div>
      </div>
    </div>


  </section>

<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=90boxxyo8d&submodules=geocoder"></script>
<script type="text/javascript">

//좌표변환
Proj4js.defs["EPSG:2097"] ="+proj=tmerc +lat_0=38 +lon_0=127.0028902777778 +k=1 +x_0=200000 +y_0=500000 +ellps=bessel +units=m +no_defs +towgs84=-115.80,474.99,674.11,1.16,-2.31,-1.63,6.43";
Proj4js.defs["EPSG:5174"] ="+proj=longlat +ellps=WGS84 +datum=WGS84 +no_defs";
var tm = new Proj4js.Proj("EPSG:2097");
var wgs84 = new Proj4js.Proj("EPSG:5174");



var nowGeo = null;
var marker =null;
var markers = [];
var infoWindow =null;
var infoWindows = [];


//지도
var mapBounds = null;
  var map = null;
    navigator.geolocation.getCurrentPosition((position) => {
      map = new naver.maps.Map('main_map', {
        useStyleMap: true,
        center : new naver.maps.LatLng(position.coords.latitude, position.coords.longitude),
          zoom: 14,
          zoomControl: true
        });
      myGEO(new naver.maps.LatLng(position.coords.latitude, position.coords.longitude));
      

  //바운더리값으로 불러오기
  naver.maps.Event.addListener(map, 'bounds_changed', function(){
	  mapBounds = map.getBounds();
  	var southWest = mapBounds.getSW(),
  	northEast = mapBounds.getNE();
  	var sLat = southWest.lat(),
  	sLng = southWest.lng(),
  	nLat = northEast.lat(),
  	nLng = northEast.lng();
  	
  	console.dir('southWest.lat() : '+sLat+' , southWest.lng() : '+sLng);
  	console.dir('northEast.lat() : '+nLat+' , northEast.lng() : '+nLng);
  	
  	var coodSWBefore = new Proj4js.Point(sLat,southWest.lng());
  	var coodNEBefore = new Proj4js.Point(northEast.lat(),northEast.lng());
  	
  	var coodSW = Proj4js.transform(wgs84,tm,coodSWBefore);
  	var coodNE = Proj4js.transform(wgs84,tm,coodNEBefore);
  	
  	var sWPoint = new naver.maps.Point(coodSW.y, coodSW.x);
  	var nEPoint = new naver.maps.Point(coodNE.y, coodNE.x);
  	
  	console.dir('변환 southWest : '+sWPoint);
  	console.dir('변환 northEast : '+nEPoint);
  });



    //좌표변환2
    var myGeoCenter = map.getCenter();
    console.dir('센터 : '+myGeoCenter.toString());
    cent = new Proj4js.Point(myGeoCenter.x,myGeoCenter.y);
    p2 = Proj4js.transform(wgs84,tm,cent);
    serachPoint3 = new naver.maps.LatLng(p2.y, p2.x);
    console.dir('좌푠볗환 :' + serachPoint3);
      
      
      
    });
 // https://docs.oracle.com/cd/E11882_01/appdev.112/e11830/sdo_objload.htm#SPATL579
 
//현재위치
$(".myGeo").on("click", function(e) {
    e.preventDefault();
  	//테이블비우기
	$('#hosUL > li').remove();
	$('#pharUL > li').remove();
	$('#toyUL > li').remove();
	//마커지우기
  	for(var i = 0; i < markers.length; i++){
  		markers[i].setMap(null);
  		infoWindows[i].close();
  	}
   	markers =[];
   	infoWindows = [];
    navigator.geolocation.getCurrentPosition((position) => {
      myGEO(new naver.maps.LatLng(position.coords.latitude, position.coords.longitude));
      map.setCenter(new naver.maps.LatLng(position.coords.latitude, position.coords.longitude));
      map.setZoom(16);
  });
});



function myGEO(nowGeo){
	naver.maps.Service.reverseGeocode({
    coords: nowGeo,
    orders: [
      naver.maps.Service.OrderType.ADDR,
      naver.maps.Service.OrderType.ROAD_ADDR
    ].join(',')
  }, function(status, response) {
	  
    if (status === naver.maps.Service.Status.ERROR) {
      return alert('ReverseGeocode Error, Please check latlng');
    }
    var address = response.v2.address;
    //주소짜름
	var addSplit = address.jibunAddress !== '' ? address.jibunAddress.split(' ',2) : address.roadAddress.split(' ',2);
	var stringAdd = addSplit[0] +' '+ addSplit[1];
	var dataAdd = {"stringAdd":stringAdd};
	
	$.ajax({
		type:'get',
		url:'/hospital/localSearch',
		data: dataAdd ,
		success: function(obj){
			
		   href ='/hospital/search';
		   navigator.geolocation.getCurrentPosition((position) => {
			   //거리순 테이블 정렬
            	var my = new naver.maps.LatLng(position.coords.latitude, position.coords.longitude);
            	$.each(obj, function(index,el){
            		
		            var pa = new Proj4js.Point(el.indexX,el.indexY);
		            p = Proj4js.transform(tm,wgs84,pa);
				    serachPoint2 = new naver.maps.LatLng(p.y, p.x); 
				    
				   var lele= (map.getPrimitiveProjection().getDistance(my,serachPoint2)) * 0.001;
				    lele = lele.toFixed(2);
				    obj[index].lele=lele;
            	});
            	obj.sort(function(a,b){
            		return a.lele-b.lele;
            	})
            	
			    
			$.each(obj, function(index,el){
				//좌표변환
	            pa = new Proj4js.Point(el.indexX,el.indexY);
	            p = Proj4js.transform(tm,wgs84,pa);
			    serachPoint2 = new naver.maps.LatLng(p.y, p.x); 
			    
			    //마커
			    urlimg = el.lindJobGbnNm=='동물병원'?'${contextPath}/resources/img/map-pin-red2.png' :  el.lindJobGbnNm=='동물약국'? '${contextPath}/resources/img/map-pin-green.png' : '${contextPath}/resources/img/map-pin-pink.png';
			     marker = new naver.maps.Marker({
				        map: map,
				        position: serachPoint2,
				        title: el.bplcNm,
				        job:el.lindJobGbnNm,
				        prcb:el.lindPrcbGbnNm,
				        icon: {
				            url: urlimg,
				            size: new naver.maps.Size(50,52),
				        	origin: new naver.maps.Point(0,0),
				        	anchor: new naver.maps.Point(25,26)					        
				            },
				        zIndex: 100
				    });
			    //주소짜름
				addSplit = el.siteWhlAddr != null ? el.siteWhlAddr.split(' ',2) : el.rdnWhlAddr.split(' ',2);

				 //인포창
			     infoWindow = new naver.maps.InfoWindow({
			        content:'<div class="iw_inner" style="padding:16px"><div style="font-weight: 1000;font-size: 20px">'+el.bplcNm+'</div><div style="color:#999;font-weight: 500;font-size: 18px">'+el.lindJobGbnNm+'</div><span style="color:#999;font-weight: 500;font-size: 15px">'+addSplit[0]+" "+addSplit[1]+'</span><br><a style="color:#3c83dc;font-weight: 800" href="/hospital/detail?locationIdx='+el.locationIdx+'">자세히</a></div>',
			        borderColor: "#F6E3CE",
			        backgroundColor: "#FFFFFF",
			        borderWidth: 3
			     });
			    
			    //거리km변환
			    lele= (map.getPrimitiveProjection().getDistance(my,serachPoint2)) * 0.001;
			    lele = lele.toFixed(2);
			    
			    nullPrcb = null;
			    if(el.lindJobGbnNm=='동물병원'){
			    	if(el.lindPrcbGbnNm == '전문동물병원'|| el.lindPrcbGbnNm == '대학동물병원'){
			    		return;
			    	}else{
			    		nullPrcb = '';
			    	}
			    }else if(el.lindJobGbnNm=='동물약국'){
			    	nullPrcb = '';
			    }

				if(el.lindJobGbnNm=='동물병원'){
					$('#hosUL').append("<li style='display: flex; padding:10px;'><span style='font-size: 22px;width: 30%;color:#3c83dc;font-weight: 800'>"+el.bplcNm+"</span><span style='text-align: center;font-size: 22px;width: 15%;color:#999;font-weight: 500;'>"+nullPrcb+"</span><span style='text-align: center;font-size: 22px;width: 35%;color:#999;font-weight: 500;'>"+addSplit[0]+" "+addSplit[1]+"</span><span style='font-size: 22px;width: 15%;color:#999;font-weight: 500;'>"+lele+" km </span><button type='button' class='btn btn-info' style='width: 10%;' onclick=\"location.href='/hospital/detail?locationIdx="+el.locationIdx+"'\">자세히</button></li>");
				}else if(el.lindJobGbnNm=='동물약국'){
					$('#pharUL').append("<li style='display: flex; padding:10px;'><span style='font-size: 22px;width: 30%;color:#3c83dc;font-weight: 800'>"+el.bplcNm+"</span><span style='text-align: center;font-size: 22px;width: 15%;color:#999;font-weight: 500;'>"+nullPrcb+"</span><span style='text-align: center;font-size: 22px;width: 35%;color:#999;font-weight: 500;'>"+addSplit[0]+" "+addSplit[1]+"</span><span style='font-size: 22px;width: 15%;color:#999;font-weight: 500;'>"+lele+" km </span><button type='button' class='btn btn-info' style='width: 10%;' onclick=\"location.href='/hospital/detail?locationIdx="+el.locationIdx+"'\">자세히</button></li>");
				}else if(el.lindJobGbnNm=='편의시설'){
					$('#toyUL').append("<li style='display: flex; padding:10px;'><span style='font-size: 22px;width: 30%;color:#3c83dc;font-weight: 800'>"+el.bplcNm+"</span><span style='text-align: center;font-size: 22px;width: 15%;color:#999;font-weight: 500; overflow:hidden;display:-webkit-box;  -webkit-line-clamp:1;'>"+el.lindPrcbGbnNm+"</span><span style='text-align: center;font-size: 22px;width: 35%;color:#999;font-weight: 500;'>"+addSplit[0]+" "+addSplit[1]+"</span><span style='font-size: 22px;width: 15%;color:#999;font-weight: 500;'>"+lele+" km </span><button type='button' class='btn btn-info' style='width: 10%;' onclick=\"location.href='/hospital/detail?locationIdx="+el.locationIdx+"'\">자세히</button></li>");
				}
			  //마커생성
				 markers.push(marker);
				 infoWindows.push(infoWindow);
				 
		  });

			

            	$('.hos').on("click", function(e){
            		for (var i=0, ii=markers.length; i<ii; i++) {
            			if(markers[i].job=='동물병원'){
            				if(markers[i].prcb=='전문동물병원' || markers[i].prcb=='대학동물병원'){
            					if($('input:radio[id="optionsRadios2"]').is(":checked") == true){ 
	            					markers[i].setMap(map);
			               		}else { 
		            				markers[i].setMap(null);
			               		}
            				}else if(markers[i].prcb=='없음'){
            					if($('input:radio[id="optionsRadios1"]').is(":checked") == true){ 
            						
	            					markers[i].setMap(map);
			               		}else { 
		            				markers[i].setMap(null);
			               		}
            				}
            			}
            		}
            	});
            	
            	$('#phar').on("click", function(e){
            		for (var i=0, ii=markers.length; i<ii; i++) {
            			if(markers[i].job=='동물약국'){
	            			if($('input:checkbox[id="phar"]').is(":checked") == true){ 
	            					markers[i].setMap(map);
		               		}else { 
	            					markers[i].setMap(null);
		               		}
            			}
            		}
            	});
            	
            		$('#sal').on("click", function(e){
                		for (var i=0, ii=markers.length; i<ii; i++) {
	                			if(markers[i].prcb.indexOf('미용')!= -1 ){
	    	            			if($('input:checkbox[id="sal"]').is(":checked") == true){ 
	    	            					markers[i].setMap(map);
	    		               		}else { 
	    	            					markers[i].setMap(null);
	    		               		}
	                			}
                		}
                	});
    				$('#hotel').on("click", function(e){
                		for (var i=0, ii=markers.length; i<ii; i++) {
                				if(markers[i].prcb.indexOf('호텔')!= -1){
        	            			if($('input:checkbox[id="hotel"]').is(":checked") == true){ 
        	            					markers[i].setMap(map);
        		               		}else { 
        	            					markers[i].setMap(null);
        		               		}
                			}
                			
                		}
                	});
    				
    				$('#cafe').on("click", function(e){
                		for (var i=0, ii=markers.length; i<ii; i++) {
	                			if(markers[i].prcb.indexOf('애견카페')!= -1 ){
	    	            			if($('input:checkbox[id="cafe"]').is(":checked") == true){ 
	    	            					markers[i].setMap(map);
	    		               		}else { 
	    	            					markers[i].setMap(null);
	    		               		}
                			}
                		}
                	});
    				$('#buy').on("click", function(e){
                		for (var i=0, ii=markers.length; i<ii; i++) {
	                			if(markers[i].prcb.indexOf('분양')!= -1){
	    	            			if($('input:checkbox[id="buy"]').is(":checked") == true){ 
	    	            					markers[i].setMap(map);
	    		               		}else { 
	    	            					markers[i].setMap(null);
	    		               		}
                			}
                		}
                	});
    				$('#tax').on("click", function(e){
                		for (var i=0, ii=markers.length; i<ii; i++) {
		               			if(markers[i].prcb.indexOf('펫택시')!= -1 ){
		   	            			if($('input:checkbox[id="tax"]').is(":checked") == true){ 
		   	            					markers[i].setMap(map);
		   		               		}else { 
		   	            					markers[i].setMap(null);
		   		               		}
		               			
                			}
                		}
                	});
    				$('#toy').on("click", function(e){
                		for (var i=0, ii=markers.length; i<ii; i++) {
                				if(markers[i].prcb.indexOf('애견용품')!= -1){
        	            			if($('input:checkbox[id="toy"]').is(":checked") == true){ 
        	            					markers[i].setMap(map);
        		               		}else { 
        	            					markers[i].setMap(null);
        		               		}
                    			}
                		}
                	});
    				
            	
	           for (var i=0, ii=markers.length; i<ii; i++) {
	               naver.maps.Event.addListener(markers[i], 'click', getClickHandler(i));
	           }
           	//움직임이 있으면 마커 update
				 naver.maps.Event.addListener(map, 'idle', function() {
				 	updateMarkers(map, markers);
				 });
		  });

	},
	eroor : function(){
		alert('error!');
	}
});
}
  )};
//보이는지도영역만 마커
  function updateMarkers(map, markers) {
     mapBounds = map.getBounds();
      var marker, position;

      for (var i = 0; i < markers.length; i++) {
          marker = markers[i]
          position = marker.getPosition();
          if (mapBounds.hasLatLng(position)) {
              showMarker(map, marker);
          } else {
              hideMarker(map, marker);
          }
      }
  }
  function showMarker(map, marker) {
      if (marker.getMap()) return;
      
      if(marker.prcb.indexOf('미용')!= -1 ){
		if($('input:checkbox[id="sal"]').is(":checked") == true){ 
      		 marker.setMap(map);
		}
      }else if(marker.prcb.indexOf('호텔')!= -1 ){
    	  if($('input:checkbox[id="hotel"]').is(":checked") == true){ 
       		 marker.setMap(map);
 		}
      }else if(marker.prcb.indexOf('애견카페')!= -1 ){
    	  if($('input:checkbox[id="cafe"]').is(":checked") == true){ 
       		 marker.setMap(map);
 		}
      }else if(marker.prcb.indexOf('분양')!= -1 ){
    	  if($('input:checkbox[id="buy"]').is(":checked") == true){ 
       		 marker.setMap(map);
 		}
      }else if(marker.prcb.indexOf('택시')!= -1 ){
    	  if($('input:checkbox[id="tax"]').is(":checked") == true){ 
       		 marker.setMap(map);
 		}
      }else if(marker.prcb.indexOf('애견용품')!= -1 ){
    	  if($('input:checkbox[id="toy"]').is(":checked") == true){ 
       		 marker.setMap(map);
 		}
      }else if(marker.job.indexOf('약국')!= -1 ){
    	  if($('input:checkbox[id="phar"]').is(":checked") == true){ 
       		 marker.setMap(map);
 		}
      }if(marker.job=='동물병원'){
			if(marker.prcb=='전문동물병원' || marker.prcb=='대학동물병원'){
				if($('input:radio[id="optionsRadios2"]').is(":checked") == true){ 
					marker.setMap(map);
           		}
			}else if(marker.prcb=='없음'){
				if($('input:radio[id="optionsRadios1"]').is(":checked") == true){ 
					
					marker.setMap(map);
           		}
			}
		}
  }
  function hideMarker(map, marker) {
      if (!marker.getMap()) return;
      if(marker.prcb.indexOf('미용')!= -1 ){
  		if($('input:checkbox[id="sal"]').is(":checked") == true){ 
        		 marker.setMap(null);
  		}
        }else if(marker.prcb.indexOf('호텔')!= -1 ){
      	  if($('input:checkbox[id="hotel"]').is(":checked") == true){ 
         		 marker.setMap(null);
   		}
        }else if(marker.prcb.indexOf('애견카페')!= -1 ){
      	  if($('input:checkbox[id="cafe"]').is(":checked") == true){ 
         		 marker.setMap(null);
   		}
        }else if(marker.prcb.indexOf('분양')!= -1 ){
      	  if($('input:checkbox[id="buy"]').is(":checked") == true){ 
         		 marker.setMap(null);
   		}
        }else if(marker.prcb.indexOf('택시')!= -1 ){
      	  if($('input:checkbox[id="tax"]').is(":checked") == true){ 
         		 marker.setMap(null);
   		}
        }else if(marker.prcb.indexOf('애견용품')!= -1 ){
      	  if($('input:checkbox[id="toy"]').is(":checked") == true){ 
         		 marker.setMap(null);
   		}
        }else if(marker.job.indexOf('약국')!= -1 ){
      	  if($('input:checkbox[id="phar"]').is(":checked") == true){ 
         		 marker.setMap(null);
   		}
        }if(marker.job=='동물병원'){
  			if(marker.prcb=='전문동물병원' || marker.prcb=='대학동물병원'){
  				if($('input:radio[id="optionsRadios2"]').is(":checked") == true){ 
  					marker.setMap(null);
             		}
  			}else if(marker.prcb=='없음'){
  				if($('input:radio[id="optionsRadios1"]').is(":checked") == true){ 
  					
  					marker.setMap(null);
             		}
  			}
  		}
  }

  
  

//지역별
  function searchAddressToCoordinate(address) {
      naver.maps.Service.geocode({
        useStyleMap: true,
       query: address
        }, function(status, response) {
            if (status === naver.maps.Service.Status.ERROR) {
              if (!address) {
                return alert('Geocode Error, Please check address');
              }
              return alert('Geocode Error, address:' + address);
            }
            var item = response.v2.addresses[0], //주소 검색결과
                point = new naver.maps.Point(item.x, item.y); //위도경도
            myGEO(point);
            map.setCenter(point); //지도에 position 맞춰줌
            map.setZoom(14);
          	
        });
    }

$("#gugun1").on("click", function(e){
  if($("#gugun1").val()!="구/군 선택"){
    e.preventDefault();
  	//테이블비우기
	$('#hosUL > li').remove();
	$('#pharUL > li').remove();
	$('#toyUL > li').remove();
  	//마커지우기
	for(var i = 0; i < markers.length; i++){
		markers[i].setMap(null);
		infoWindows[i].close();
	}
  	markers =[];
  	infoWindows = [];
  	//시구청 pocus
    let address =addMap.get($("#sido1").val()+$("#gugun1").val());
    searchAddressToCoordinate(address);
    }
  })
    
  
//검색
$("#searchSubmit").on("click", function(e){
	
	var nameinput = $("input[name='NameInput']").val();
	
	if(!nameinput || nameinput.length<2){
		alert("두글자이상 입력해주세요")
		return;
	}
	var postData = {"nameinput":nameinput};

	$.ajax({
		type:'get',
		url:'/hospital/nameSearch?query='+nameinput,
		data: postData ,
		success: function(obj){
			href ='/hospital/search';

			if(obj.length==0){
				alert("검색결과가 없습니다!");
				return;
			}
		  	//테이블비우기
			$('#hosUL > li').remove();
			$('#pharUL > li').remove();
			$('#toyUL > li').remove();
			 //마커지우기
		 	 for(var i = 0; i < markers.length; i++){
		 		markers[i].setMap(null);
		 		infoWindows[i].close();
		 	 }
		  	  markers =[];
		  	  infoWindows = [];
			//스크롤
            window.scrollBy( 0, 1000 ); 
            navigator.geolocation.getCurrentPosition((position) => {
            	 //거리순 테이블 정렬
            	var my = new naver.maps.LatLng(position.coords.latitude, position.coords.longitude);
            	$.each(obj, function(index,el){
		            var pa = new Proj4js.Point(el.indexX,el.indexY);
		            p = Proj4js.transform(tm,wgs84,pa);
				    serachPoint2 = new naver.maps.LatLng(p.y, p.x); 
				   var lele= (map.getPrimitiveProjection().getDistance(my,serachPoint2)) * 0.001;
				    lele = lele.toFixed(2);
				    obj[index].lele=lele;
            	});
            	obj.sort(function(a,b){
            		return a.lele-b.lele;
            	})
				$.each(obj, function(index,el){
					//좌표변환
		            var pa = new Proj4js.Point(el.indexX,el.indexY);
		            p = Proj4js.transform(tm,wgs84,pa);
				    serachPoint2 = new naver.maps.LatLng(p.y, p.x); 
				    //마커
    			    urlimg = el.lindJobGbnNm=='동물병원'?'${contextPath}/resources/img/map-pin-red2.png' :  el.lindJobGbnNm=='동물약국'? '${contextPath}/resources/img/map-pin-green.png' : '${contextPath}/resources/img/map-pin-pink.png';
    			    marker = new naver.maps.Marker({
				        map: map,
				        position: serachPoint2,
				        title: el.bplcNm,
				        job:el.lindJobGbnNm,
				        prcb:el.lindPrcbGbnNm,
				        icon: {
				            url: urlimg,
				            size: new naver.maps.Size(50,52),
				        	origin: new naver.maps.Point(0,0),
				        	anchor: new naver.maps.Point(25,26)					        
				            },
				        zIndex: 100
				    });
				    //주소짜름
					var addSplit = el.siteWhlAddr != null ? el.siteWhlAddr.split(' ',2) : el.rdnWhlAddr.split(' ',2);
					 //인포창
				     infoWindow = new naver.maps.InfoWindow({
				        content:'<div class="iw_inner" style="padding:16px"><div style="font-weight: 1000;font-size: 20px">'+el.bplcNm+'</div><div style="color:#999;font-weight: 500;font-size: 18px">'+el.lindJobGbnNm+'</div><span style="color:#999;font-weight: 500;font-size: 15px">'+addSplit[0]+" "+addSplit[1]+'</span><br><a style="color:#3c83dc;font-weight: 800" href="/hospital/detail?locationIdx='+el.locationIdx+'">자세히</a></div>',
				        borderColor: "#F6E3CE",
				        backgroundColor: "#FFFFFF",
				        borderWidth: 3,
				        job:el.lindJobGbnNm
				     });
				    
				    //거리km변환
				    var lele= (map.getPrimitiveProjection().getDistance(my,serachPoint2)) * 0.001;
				    lele = lele.toFixed(2);
				    
				    nullPrcb = null;
				    if(el.lindJobGbnNm=='동물병원'){
				    	if(el.lindPrcbGbnNm == '전문동물병원'|| el.lindPrcbGbnNm == '대학동물병원'){
				    		return;
				    	}else{
				    		nullPrcb = '';
				    	}
				    }else if(el.lindJobGbnNm=='동물약국'){
				    	nullPrcb = '';
				    }
					if(el.lindJobGbnNm=='동물병원'){
						$('#hosUL').append("<li style='display: flex; padding:10px;'><span style='font-size: 22px;width: 30%;color:#3c83dc;font-weight: 800'>"+el.bplcNm+"</span><span style='text-align: center;font-size: 22px;width: 15%;color:#999;font-weight: 500;'>"+nullPrcb+"</span><span style='text-align: center;font-size: 22px;width: 35%;color:#999;font-weight: 500;'>"+addSplit[0]+" "+addSplit[1]+"</span><span style='font-size: 22px;width: 15%;color:#999;font-weight: 500;'>"+lele+" km </span><button type='button' class='btn btn-info' style='width: 10%;' onclick=\"location.href='/hospital/detail?locationIdx="+el.locationIdx+"'\">자세히</button></li>");
					}else if(el.lindJobGbnNm=='동물약국'){
						$('#pharUL').append("<li style='display: flex; padding:10px;'><span style='font-size: 22px;width: 30%;color:#3c83dc;font-weight: 800'>"+el.bplcNm+"</span><span style='text-align: center;font-size: 22px;width: 15%;color:#999;font-weight: 500;'>"+nullPrcb+"</span><span style='text-align: center;font-size: 22px;width: 35%;color:#999;font-weight: 500;'>"+addSplit[0]+" "+addSplit[1]+"</span><span style='font-size: 22px;width: 15%;color:#999;font-weight: 500;'>"+lele+" km </span><button type='button' class='btn btn-info' style='width: 10%;' onclick=\"location.href='/hospital/detail?locationIdx="+el.locationIdx+"'\">자세히</button></li>");
					}else if(el.lindJobGbnNm=='편의시설'){
						$('#toyUL').append("<li style='display: flex; padding:10px;'><span style='font-size: 22px;width: 30%;color:#3c83dc;font-weight: 800'>"+el.bplcNm+"</span><span style='text-align: center;font-size: 22px;width: 15%;color:#999;font-weight: 500; overflow:hidden;display:-webkit-box;  -webkit-line-clamp:1;'>"+el.lindPrcbGbnNm+"</span><span style='text-align: center;font-size: 22px;width: 35%;color:#999;font-weight: 500;'>"+addSplit[0]+" "+addSplit[1]+"</span><span style='font-size: 22px;width: 15%;color:#999;font-weight: 500;'>"+lele+" km </span><button type='button' class='btn btn-info' style='width: 10%;' onclick=\"location.href='/hospital/detail?locationIdx="+el.locationIdx+"'\">자세히</button></li>");
					}
					
					//첫번째 검색결과 pocus
				    if(index==0){
				    	map.setCenter(serachPoint2);
				    	infoWindow.open(map, marker.getPosition());
				    	map.setZoom(10);
				    }
				  //마커생성
					 markers.push(marker);
					 infoWindows.push(infoWindow);
					 
					
				});
				
            	

            	$('.hos').on("click", function(e){
            		for (var i=0, ii=markers.length; i<ii; i++) {
            			if(markers[i].job=='동물병원'){
            				if(markers[i].prcb=='전문동물병원' || markers[i].prcb=='대학동물병원'){
            					if($('input:radio[id="optionsRadios2"]').is(":checked") == true){ 
	            					markers[i].setMap(map);
			               		}else { 
		            				markers[i].setMap(null);
			               		}
            				}else if(markers[i].prcb=='없음'){
            					if($('input:radio[id="optionsRadios1"]').is(":checked") == true){ 
            						
	            					markers[i].setMap(map);
			               		}else { 
		            				markers[i].setMap(null);
			               		}
            				}
            			}
            		}
            	});
            	
            	$('#phar').on("click", function(e){
            		for (var i=0, ii=markers.length; i<ii; i++) {
            			if(markers[i].job=='동물약국'){
	            			if($('input:checkbox[id="phar"]').is(":checked") == true){ 
	            					markers[i].setMap(map);
		               		}else { 
	            					markers[i].setMap(null);
		               		}
            			}
            		}
            	});
            	
            		$('#sal').on("click", function(e){
                		for (var i=0, ii=markers.length; i<ii; i++) {
	                			if(markers[i].prcb.indexOf('미용')!= -1 ){
	    	            			if($('input:checkbox[id="sal"]').is(":checked") == true){ 
	    	            					markers[i].setMap(map);
	    		               		}else { 
	    	            					markers[i].setMap(null);
	    		               		}
	                			}
                		}
                	});
    				$('#hotel').on("click", function(e){
                		for (var i=0, ii=markers.length; i<ii; i++) {
                				if(markers[i].prcb.indexOf('호텔')!= -1){
        	            			if($('input:checkbox[id="hotel"]').is(":checked") == true){ 
        	            					markers[i].setMap(map);
        		               		}else { 
        	            					markers[i].setMap(null);
        		               		}
                			}
                			
                		}
                	});
    				
    				$('#cafe').on("click", function(e){
                		for (var i=0, ii=markers.length; i<ii; i++) {
	                			if(markers[i].prcb.indexOf('애견카페')!= -1 ){
	    	            			if($('input:checkbox[id="cafe"]').is(":checked") == true){ 
	    	            					markers[i].setMap(map);
	    		               		}else { 
	    	            					markers[i].setMap(null);
	    		               		}
                			}
                		}
                	});
    				$('#buy').on("click", function(e){
                		for (var i=0, ii=markers.length; i<ii; i++) {
	                			if(markers[i].prcb.indexOf('분양')!= -1){
	    	            			if($('input:checkbox[id="buy"]').is(":checked") == true){ 
	    	            					markers[i].setMap(map);
	    		               		}else { 
	    	            					markers[i].setMap(null);
	    		               		}
                			}
                		}
                	});
    				$('#tax').on("click", function(e){
                		for (var i=0, ii=markers.length; i<ii; i++) {
		               			if(markers[i].prcb.indexOf('펫택시')!= -1 ){
		   	            			if($('input:checkbox[id="tax"]').is(":checked") == true){ 
		   	            					markers[i].setMap(map);
		   		               		}else { 
		   	            					markers[i].setMap(null);
		   		               		}
		               			
                			}
                		}
                	});
    				$('#toy').on("click", function(e){
                		for (var i=0, ii=markers.length; i<ii; i++) {
                				if(markers[i].prcb.indexOf('애견용품')!= -1){
        	            			if($('input:checkbox[id="toy"]').is(":checked") == true){ 
        	            					markers[i].setMap(map);
        		               		}else { 
        	            					markers[i].setMap(null);
        		               		}
                    			}
                		}
                	});
            	
            
		           for (var i=0 ; i<markers.length; i++) {
		               naver.maps.Event.addListener(markers[i], 'click', getClickHandler(i));
		           }
		           
		       		//움직임이 있으면 마커 update
					 naver.maps.Event.addListener(map, 'idle', function() {
					 					    updateMarkers(map, markers);
					 });
			  });
		},
		eroor : function(){
			alert('error!');
		}
	});

})


//마커 클릭시 info창 띄어줌
 function getClickHandler(seq) {
     return function(e) {
         var marker = markers[seq],
             infoWindow = infoWindows[seq];

         if (infoWindow.getMap()) {
             infoWindow.close();
             console.dir("닫습니다..");
         } else {
          infoWindow.open(map, marker);
          console.dir("엽니다..");
         }
     }
 }


//체크박스
let radio1 = document.getElementById("optionsRadios1");
let radio2 = document.getElementById("optionsRadios2");
let hospital1 = document.getElementById("hospitalCheck");
let flg = false;
//체크박스(동물병원) 체크했을때 radio 체크해줌 
hospital1.addEventListener('click', e => {
	let flg = true;
	
	if(!(radio1.checked||radio2.checked)){
    flg =false;
    radio1.checked=true;
  }
  
  if(flg){
    radio1.checked=false;
    radio2.checked=false;
  }

});
//radio체크했을때 체크박스(동물병원) 체크
radio1.addEventListener('click', e => {
  hospital1.checked=true;
  let flg = false;
});
radio2.addEventListener('click', e => {
  hospital1.checked=true;
  let flg = false;
});


</script>
</body>
</html>