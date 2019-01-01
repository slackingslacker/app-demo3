/**
 * 
 */
APP = function(){
	function loadDoc(method, url, callback) {
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = callback
		xhttp.open(method, url, true);
		xhttp.send();
	}

	
	getProductDetails = function() {
		loadDoc("GET", "/product?name="+this.text, setProductDetails)
	}
	
	var tags = document.getElementsByName('detailLink');
	for(tag in tags) {
		tags[tag].onclick = getProductDetails;
	}
	
	setProductDetails = function(){
		document.getElementById("productDetail").innerHTML = this.responseText;
	}
}();

