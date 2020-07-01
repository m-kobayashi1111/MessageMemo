function copy() {
    window.print();
}

//15件以上の時に表示する処理
window.onload = function(){
	if(table.rows.length > 15){
	division.style.overflowY = "scroll";
	division.style.height = 500 + "px";	
	
	}
}
