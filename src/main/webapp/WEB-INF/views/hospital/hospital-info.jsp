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
  }
  .main_name{
    font-size: 25px;
    height:65%;
    text-align: center;
  }

	.body_section{
	background-color: rgb(240, 234, 213);
    height: 4500px;
    position:relative;
	}
  .main2{
    height: 3000px;   /* seach높이조절 */
    width: 1300px;
    position: absolute;
    left:50%;
    transform: translate(-50%,0%);
    
  }
h1{
font-family: 'SBAggroL';
}

.equipment{
margin: 5px 5px 5px 0px;
color: inherit;
font-size:20px;
font-family: 'SBAggroL';
line-height:2.2; /* 줄간격 */
}
p{
font-family: 'SBAggroL';
line-height:2.2;  /* 줄간격 */
}
.col1{
font-size:18px;
font-family: 'SBAggroL';
color: inherit;
 text-decoration: none; /* a태그 밑줄 없앰*/
 display: block;
 margin: 5px 0 25px 50px;
}
.col{
float: left;
}

.equipTitle{
margin: 35px 20px 5px 10px;
color: inherit;
font-size:22px;
border:thick;
font-family: 'SBAggroL';

}

a{
target:_blank;
}
</style>



</head>
<body>
  <section >
    <div class="name_section">
      <div class="main1">
      </div>
    </div>
    <div class="body_section">
        <div class="main2">
        
        <h1>동물병원의 정의</h1>
        <p class="sec" style="font-size: 21px;  display: contents;">
        사람을 제외한 동물의 치료를 목적으로 하는 병원. 보통은 동물병원이라는 명칭을 사용하지만 먼 과거 개업한 점포나 일부 도서지역에서는 ‘가축병원’이라는 이름을 사용하는 경우도 더러 있다.
        </p><br><br><br><br>
        
        
        
          <h1>동물병원의 종류</h1>
          <div style="position:relative;">
<div class="col"><a href="https://vmth.snu.ac.kr/" ><img src="${contextPath}/resources/img/co1.jpg" style="width:200px; height:100px; margin-right: 30px;"></a><a href="https://vmth.snu.ac.kr/" class="col1">서울대학교</a></div>
<div class="col"><a href="http://vmth.kangwon.ac.kr/" ><img src="${contextPath}/resources/img/co2.jpg" style="width:200px; height:100px; margin-right: 30px;"></a><a href="https://vmth.snu.ac.kr/" class="col1">강원대학교</a></div>
<div class="col"><a href="http://gamc.gnu.ac.kr/" ><img src="${contextPath}/resources/img/co3.jpg" style="width:200px; height:100px; margin-right: 30px;"></a><a href="https://vmth.snu.ac.kr/" class="col1">경상대학교</a></div>
<div class="col"><a href="https://cnuvmth.jnu.ac.kr/" ><img src="${contextPath}/resources/img/co4.jpg" style="width:200px; height:100px; margin-right: 30px;"></a><a href="https://vmth.snu.ac.kr/" class="col1">전남대학교</a></div>
<div class="col"><a href="http://knu.refercenter.co.kr/" ><img src="${contextPath}/resources/img/co5.jpg" style="width:200px; height:100px; margin-right: 30px;"></a><a href="https://vmth.snu.ac.kr/" class="col1">경북대학교</a></div>
<div class="col"><a href="https://cnuah.cnu.ac.kr" ><img src="${contextPath}/resources/img/co6.jpg" style="width:200px; height:100px; margin-right: 30px;"></a><a href="https://vmth.snu.ac.kr/" class="col1">충남대학교</a></div>
<div class="col"><a href="http://vmth.konkuk.ac.kr" ><img src="${contextPath}/resources/img/co7.jpg" style="width:200px; height:100px; margin-right: 30px;"></a><a href="https://vmth.snu.ac.kr/" class="col1">건국대학교</a></div>
<div class="col"><a href="https://jamc.jbnu.ac.kr/" ><img src="${contextPath}/resources/img/co8.jpg" style="width:200px; height:100px; margin-right: 30px;"></a><a href="https://vmth.snu.ac.kr/" class="col1">전북대학교</a></div>
<div class="col"><a href="https://vethospital.jejunu.ac.kr/" ><img src="${contextPath}/resources/img/co9.jpg" style="width:200px; height:100px; margin-right: 30px;"></a><a href="https://vmth.snu.ac.kr/" class="col1">제주대학교</a></div>
<div class="col"><a href="https://www.cbuanimal.co.kr/" ><img src="${contextPath}/resources/img/co10.jpg" style="width:200px; height:100px; margin-right: 30px;"></a><a href="https://vmth.snu.ac.kr/" class="col1">충북대학교</a></div>
</div>
         <p class="sec"  style="font-size: 21px; display: inline-block;">
  사람과 마찬가지도 동물병원에도 1차, 2차, 3차 병원이 있습니다.  동물병원은 사람병원과 다르게 법으로 나누어져있진 않습니다.
보통 1차 동물병원은 일반적인 개인병원을 이야기하는 것이고 2차는 전문동물병원,3차는 수의학과를 가지고 있는 대학교에서 운영하는 병원을 이야기합니다.
현재 우리나라에는 20군데의 전문동물병원과 10군데의 대학동물병원이 있습니다.
개인병원으로 이루어진 곳에서는 대부분 X-ray까지는 가능하나 MRI, CT, 초음파시설이 구비 되어있지 않습니다.
대부분의 종합병원은 주사마취가 아닌 호흡마취를 하고, 세세한 부분까지 알아봐야 하는 큰 수술을 하는 경우가 많기 때문에 장비 또한 개인병원과는 차이가 많이 납니다.
일반적인 감기나 중성화, 예방접종의 경우에는 개인병원에서도 접수가 가능하고 파보장염 같은 치명상을 줄 수 있는 범위내에서는 종합병원을 권장합니다.</p><br><br><br><br>
       
        
         <h1>동물병원의 검사 장비</h1><br>
         <div >
	          <img src="${contextPath}/resources/img/xray.jpg" style="width:auto; height:280px; margin-left:30px">
	          <img src="${contextPath}/resources/img/xray4.jpg" style="width:auto; height:280px;"><br>
	           <div class="equipTitle">방사선검사 . Radiography</div><br>
	           <div class="equipment">
	           
X-ray는 환자의 질병이 무엇인지 Screening 하는데 있어서 아주 간단하고 기본이 되며 비침습적이면서도 많은 정보를 제공해주는 훌륭한 영상장비입니다.
방사선 검사는 심장병이나 폐종양과 같은 흉강내 질환, 복강실질관련 대부분의 질환(종양∙이물∙담도계 등), 골절∙디스크와 같은 근골격계 질환, 신장결석∙자궁축농증과 같은 비뇨∙생식기계 질환, 그 외 호르몬∙이비인후과∙치과 등 가장 많은 질환을 Rule-in/out하는데 있어 첫번째로 사용되고 있습니다.
이와 같이, X-ray 촬영만으로도 다양한 질환들에 대해 어느 정도 감별 진단목록을 내릴 수 있다는 장점을 갖고 있으며, 헬릭스는 Digital X-ray장비를 구비하여 이와 같은 진단과정을 진행하고 있습니다.
	           
	           </div><br><br><br><br>
	          <img src="${contextPath}/resources/img/wave1.png" style="width:auto; height:280px; margin-left:30px">
	          <img src="${contextPath}/resources/img/wave2.jpg"style="width:auto; height:280px;"><br>
	          <div class="equipTitle">초음파 . Echocardiography</div><br>
	          <div class="equipment">
최근 반려동물의 수가 급격히 늘어나고 보호자의 환자에 대한 관리수준이 높아지면서, 선천성 심장병 뿐만 아니라 노령성 심질환으로 내원하는 반려동물의 수가 폭발적으로 증가하고 있습니다. 또한 1살령 미만의 어린 환자들에서도 선천성 심장기형 등으로 수술적 치료를 요하는 경우도 있습니다.
이 모든 경우 심장초음파는 심장내부의 모습과 주변 대혈관 등의 형태학적∙혈액학적 변화양상을 정확하게 보여주는 영상장비로써, 헬릭스는 이를 통해 원활하고 빠른 진단으로 내∙외과적 처치가 이루어질 수 있도록 노력하고 있습니다.
	          
	          </div><br><br><br><br>
	          <img src="${contextPath}/resources/img/mri1.jpg" style="width:auto; height:280px; margin-left:30px">
	          <img src="${contextPath}/resources/img/mri2.png" style="width:auto; height:280px;"><br>
	          <div class="equipTitle">MRI . Magnetic Resonance Imaging</div><br>
	          <div class="equipment">
	          MRI는 뇌수두증이나 뇌종양∙육아종성 & 괴사성수막뇌염∙두경접합부 질환 등 두개내 질환, 디스크탈출∙척수질환 및 병변, 척추골절 그리고, 건파열이나 관절문제 등 근골격계 질환의 평가에 있어서 매우 유용한 영상장비입니다. 최근에는 디스크수술이나 오존치료, 고압산소, Diode laser 등 척추질환에 대한 외∙내과적 치료가 활발히 진행되고 있고, 두개내 종양의 Radiation therapy 등의 시도 또한 이루어지는 추세입니다. 따라서 MRI의 적극적인 활용을 통해 조기진단 후, 다양한 치료방법을 모색하는 것은 무엇보다 중요하다고 할 수 있습니다.
본원에는 국내에서는 최고 사양이라 할 수 있는 1.5Tesla 장비를 보유하고 있으며, 영상자체의 질을 높일 뿐만 아니라 좀 더 세부적인 감별진단을 내려 내∙외과적 치료가 가능할 수 있도록 최선의 노력을 다하고 있습니다.</div><br><br><br>
	          <img src="${contextPath}/resources/img/ct1.jpg" style="width:auto; height:300px; margin-left:30px">
	          <img src="${contextPath}/resources/img/ct2.jpg" style="width:auto; height:300px;">
	          <img src="${contextPath}/resources/img/ct3.png" style="width:auto; height:300px;">
	             <div class="equipTitle">CT . Computed Tomography</div><br>
	          <div class="equipment">
	          CT는 X-ray에서 보이는 영상을 3차원적으로, 또한 보다 입체적으로 볼 수 있도록 구현해주는 월등한 영상장비로써 매우 짧은 촬영시간에 비해 보다 많은 정보를 제공해주는 장점이 있습니다.
무엇보다 폐의 전이성 nodule 등 방사선상에 보이지 않는 5mm이하의 매우 작은 구조물도 구현되며, 흉∙복강∙피부 등의 종양절제시 수술범위의 결정, 복강내 혈관기형, 심장내 혈관기형 등의 평가에 유용합니다. 특히 골절, 골종양 등 뼈 관련 질환의 평가에 있어서는 무엇보다 가장 좋은 장비라고 할 수 있습니다.
본원에서는 국내최고 사양인 160 slice CT 를 보유하고 있으며, 보다 적은 선량으로 가장 좋은 영상을 획득할 뿐만 아니라 이를 통해 정확한 진단과 치료로 이어질 수 있도록 만전을 기하고 있습니다. 
	          </div>
          </div><br><br><br><br>
          
          
        
          <h1>동물병원마다 가격이 천차만별인 이유</h1>
          <p class="sec" style="font-size: 21px;  display: contents;">
  보호자들이 병원 선택에 있어 어려움을 겪는 부분 중 하나는 병원마다의 가격편차입니다. 
예전에는 동물진료비도 정해진 가격이 있었지만, 
부당한 공동행위 등의 정비에 관한 법률(카르텔일괄정리법)개정에 의해 법률이 폐지되었습니다.
그로인해 현재 서비스 질을 높이고 소비자의 선택을 넓히기 위해서 수의사법이 시행중입니다. 
  또한 반려동물 평균수명은 배로 연장되었고 질병이 다양화 되면서 사용하는 약물의 종류도 많아졌기 때문에 
동물병원 입장에서는 진료비를 맞추려 해도 어려운 상황입니다.
          </p>  <br><br><br><br><br><br>
          
          
          </div>
        </div>

        

  </section>


</body>
</html>