//システム日付の表示ok
function setDate(){
    let today=new Date();

    let nowYear = today.getFullYear();
    let nowMonth = today.getMonth()+1;
    let nowDay = today.getDate();

    document.getElementById("today_year").value = nowYear;
    document.getElementById("today_month").value = nowMonth;
    document.getElementById("today_day").value = nowDay;
}

//システム時間の表示ok
function setTime(){
	let today = new Date();
	let hour = today.getHours();
	let minutes = today.getMinutes(); 

	document.getElementById("hour").value = hour;
	document.getElementById("minutes").value = minutes;
	
	//13時以降の時間を1～12時にする
	 if (hour > 12) {
	        document.getElementById("hour").value = hour -12;
	    } else if (hour == 0) {
	        document.getElementById("hour").value = 12;
	    } else {
	        document.getElementById("hour").value = hour;
	    }
	//0~11時のAMボタン、12~23時のPMボタンのラジオチェック条件
	 if(hour >= 0 && hour < 12){
		 document.getElementById("AM").checked = true;
	 }else if(hour > 11 && hour < 24){
		 document.getElementById("PM").checked = true; 
	 }
	 
	
	
}


//印刷ボタン押下時に印刷ok
function copy() {
    window.print();
}

//テキストボックスを読み取り専用に、伝言あり～のチェックのみ使えるようにok
function checkMemo(){
	let c = document.getElementById("memo")
	let d = document.getElementById("check3")
	if(d.checked == true){
		c.readOnly = false;
	}else{
		c.readOnly = true;
		c.value = "";
		
	}
	
}




//チェックボックスの一つを選択した際に、他をボタンを非活性にするok
function checkbox(){
	document.forms['form'].elements["check1"].onclick = ckbox1;
	document.forms['form'].elements["check2"].onclick = ckbox2;
	document.forms['form'].elements["check3"].onclick = ckbox3;
}

function ckbox1(){
	document.forms['form'].elements["check2"].checked = false;
	document.forms['form'].elements["check3"].checked = false;
	checkMemo();
	
}

function ckbox2(){
	document.forms['form'].elements["check1"].checked  = false;
	document.forms['form'].elements["check3"].checked  = false;
	checkMemo();
	
}

function ckbox3(){
	document.forms['form'].elements["check1"].checked  = false;
	document.forms['form'].elements["check2"].checked  = false;
	checkMemo();
	
}

window.addEventListener('DOMContentLoaded',checkbox,false);



//条件付き必須チェック
//1.チェックボックスの必須チェック
//2.「伝言あります」のチェック時のみ、メモを必須に
function checkForm(){
	let chk = 0;
	if(document.form1.check1.checked == false && document.form1.check2.checked == false && document.form1.check3.checked == false ){
		chk = 1;
		document.getElementById('notice-input-text-1').style.display = "block"; // 【対応のいずれかにチェックしてください。】を表示
	}else{
		document.getElementById('notice-input-text-1').style.display = "none"; // 【対応のいずれかにチェックしてください。】を非表示
	}

	if(document.form1.check3.checked == true && document.form1.memo.value == ""){
		chk = 1;
		document.getElementById('notice-input-text-2').style.display = "block"; // 【伝言がある場合は内容をメモに記入してください】表示
	}else{
		document.getElementById('notice-input-text-2').style.display = "none"; // 【伝言がある場合は内容をメモに記入してください】を非表示
	}
	
	if(chk){
        return false;
    }else{
        return true;
    }
	
}

//必須項目が未記入の時に登録ボタンを押すと、「〇〇さんが登録しました」の文字が消える処理
function register() {
	document.getElementById("msg").innerHTML="";
}









