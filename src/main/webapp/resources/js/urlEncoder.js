let urlEncoder = paramObj =>{
	
	let arr =[];
	
	for(key in paramObj){
		let param = key + '=' + encodeURIComponent(paramObj[key]); //인코딩하기위해서 js만듬
		arr.push(param); 
	}
	//a=b, 가=나, t=q 요청파라미터가 배열안에 이렇게 있는데, join때리면 배열내용을 &로연결함 a=b&가=나&t=q
	return arr.join('&');
	
}