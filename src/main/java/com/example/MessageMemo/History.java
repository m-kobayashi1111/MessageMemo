package com.example.MessageMemo;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity

public class History {
	
	//主キー（PRIMARYKEY）
		@Id
		
		//フィールドに対応するカラムを指定する
		//columnDefinition(カラムの定義　= 文字数4文字)
		private int m_id;
		private Timestamp receiv_time;
		private String to_name;
		private String c_name;
		private String sender;
		private String message_cd;
		private String e_name;
		
		//privateに隠蔽されたフィールドの値を外部から取得するためのメソッド
		public int getM_id() {
			return m_id;
		}
		
		//privateに隠蔽されたフィールドの値を外部から変更するためのメソッド
		public void setM_id(int m_id) {
			this.m_id = m_id;
		}
		
		public String getReceiv_time() {
		
			SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy/MM/dd/HH:mm");
			String receiv_time = simpledateformat.format(this.receiv_time);
			return receiv_time;
		}
		public void setReceiver_time(Timestamp receiv_time) {
			this.receiv_time = receiv_time;
		}	
		
		public String getTo_name() {
			return to_name;
		}
		public void setTo_name(String to_name) {
			this.to_name = to_name;
		}
		
		public String getC_name() {
			return c_name;
		}
		public void setC_name(String c_name) {
			this.c_name = c_name;
		}
		
		public String getSender() { 
			return sender;
		}
		public void setSender(String sender) { 
			this.sender = sender;
		}
		
		public String getMessage_cd() {
			if(message_cd.equals("1")){
				setMessage_cd("もう一度お電話します") ;
			}else if(message_cd.equals("2")){
			    setMessage_cd("折り返しお電話します");
			}else{
			    setMessage_cd("伝言あります");
			}
			return message_cd;
		}
		
		public void setMessage_cd(String message_cd) { 
			this.message_cd = message_cd;
		}
		
		public String getE_name() {
			return e_name;
		}
		public void setE_name(String e_name) {
			this.e_name = e_name;
		}	
		
}
