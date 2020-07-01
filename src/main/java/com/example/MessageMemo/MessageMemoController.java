package com.example.MessageMemo;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;   


//import com.example.MysqlAccess.Customer;
@Controller 
public class MessageMemoController {
	
	
	@Autowired	
	private CustomerRepository customerRepository;
	
	@Autowired	
	private EmployeeRepository employeeRepository;
	
	@Autowired	
	private MessageRepository messageRepository;
	
	@Autowired
	private MessageRepository rep;
	
	@Autowired	
	private HistoryRepository historyRepository;
	
	
	
	//msgmemo/inputForm(inputForm.htmlが呼ばれた時の処理)
	@RequestMapping("/msgmemo/inputForm")
    public String inputForm(Model model) {
		// m_customerテーブルの全データを取得
		Iterable<Customer> customerList = customerRepository.findAll();
		// M_EMPLOYEEテーブルの全データを取得
		Iterable<Employee> employeeList = employeeRepository.findAll();
				
		// モデルに属性追加
		model.addAttribute("customerlist",customerList);
		// モデルに属性追加
		model.addAttribute("employeelist",employeeList);

		// データ一覧画面を表示
		return "inputForm.html";
        
    }
	
	
	//msgmemo/history(history.htmlが呼ばれた時の処理)
	@GetMapping(path="/msgmemo/history")
	public String history(Model model) {
		// M_CUSTOMERテーブルの全データを取得
		ArrayList<History> historyList = historyRepository.histories();
		
		// モデルに属性追加
		model.addAttribute("historylist",historyList);

		// データ一覧画面を表示
		return "history.html";
		
	}
	
	//POSTの処理を行うプログラムの入り口。統合の役割を果たし、新しいデータを登録する
	//伝言メモ登録処理
	@PostMapping(path="/msgmemo/inputForm")
		
	
	//メソッドに@ResponseBodyを付けると戻り値で直接レスポンスのコンテンツを返す事ができる。
	//メソッドの引数に@RequestParamアノテーションを付けることで、HTTPリクエストのパラメーター（URLの末尾の「?」以降のやつ）を受け取ることが出来る。
	//HTMLにないものを@RequestParamに書かない(m_id)
	//クライアント（webページ）からリクエスト（入力）されたパラメータを表示
	public String addNewMessage(	 Model model
									,@RequestParam String to_name //宛先者氏名
									,@RequestParam String receiver_cd //受電者コード
									,@RequestParam String today_year //年
									,@RequestParam String today_month //月
									,@RequestParam String today_day //日
									,@RequestParam String radio //AMPM
									,@RequestParam String hour //時
									,@RequestParam String minutes //分
									,@RequestParam String customer_cd //顧客コード
									,@RequestParam String sender //発信者
									,@RequestParam String message_cd //メッセージコード
									,@RequestParam String memo //メモ
									) {
			
		//messageaddDataインスタンスの作成
		Message messageAddData = new Message();
	            
	            
	    //m_idが0の時に初期値を1、それ以外は1足していく処理
		int cnt = rep.countT_message();
		int m_id;
	    if(cnt == 0) {
	    	m_id = 1;
	   	}else{
	   		m_id = cnt + 1;
		}
	   
	    //PMの時に+12時に、PM12時の時に0時にする。
	    int hours = Integer.parseInt(hour);
	 
		 if (radio.equals("PM") && hours < 12) { //String型は==が使えないため、equalsで表す。
		        hours = hours + 12;
		    } else if (radio.equals("PM") && hours == 12) {
		       hours = 0;
		    } 
		 
		//年月日と日時をString型からDate型を経由してTimestamp型に変換する
        try{
        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm"); //SimpleDateFormatクラスを生成こういう形（フォーマット）で書きますよ
            String str= today_year + "-" + today_month + "-" + today_day + " "  + hours + ":" + minutes; //変数strに年月日日時を代入
            Date dTime = sdf.parse(str); //Date型に変換
            Timestamp receiv_time = new Timestamp(dTime.getTime()); //Timestamp型に変換
   

			//setAllメソッドを取得
			messageAddData.setAll(m_id,to_name,receiver_cd,receiv_time,customer_cd,sender,message_cd,memo);
			
			
			
			//timestampインスタンスの生成
			Timestamp timestamp = new Timestamp(System.currentTimeMillis()); //このメソッドはミリ秒単位の精度で現在時刻を知らせる。
				
			//それぞれのメソッドを呼び出し、作成日時をシステム日付にする。
			messageAddData.setCreate_date(timestamp);
			messageAddData.setCreate_user("springuser");
			messageAddData.setUpdate_date(timestamp);
			messageAddData.setUpdate_user("springuser");
			
				
			//保管場所のcmessagerRepositpryにmessageAddDataを保存
			//save = 登録
			messageRepository.save(messageAddData);
			
	
        } catch (ParseException e){
        	e.printStackTrace();
            model.addAttribute("msg", "登録できませんでした。");
        }
        
     
        Iterable<Customer> customerList = customerRepository.findAll();
     	Iterable<Employee> employeeList = employeeRepository.findAll();
     				
     	model.addAttribute("customerlist",customerList);
     	model.addAttribute("employeelist",employeeList);

        
     	model.addAttribute("msg", to_name + "さん宛てのメッセージを登録しました。");
		return "inputForm.html";
	}
	

}