function handleOnChange(e) {
	const text = e.options[e.selectedIndex].text;
	if (text.isNaN){
		text = "모든 장르";
	}
	console.log(e.options);

	document.getElementById('result').innerText = text;
	document.getElementById('result').style.fontFamily = "Gugi";
}

function toggleMenu(){
	if(document.getElementById("content-box-1").style.left == "0px") {
		document.getElementById("content-box-1").style.left = "0px"
	}
	setTimeout(function(){
		if(document.getElementById("content-box-2").style.left == "0px") {
			document.getElementById("content-box-2").style.left = "0px"
		}
		setTimeout(function(){
			if(document.getElementById("content-box-3").style.left == "0px") {
				document.getElementById("content-box-3").style.left = "0px"
			}
			setTimeout(function(){
				if(document.getElementById("content-box-4").style.left == "0px") {
					document.getElementById("content-box-4").style.left = "0px"
				}
			}, 100);
		}, 100);
	}, 100);
}