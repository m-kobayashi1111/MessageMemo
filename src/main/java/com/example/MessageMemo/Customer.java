package com.example.MessageMemo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


//業務データを保持するためのクラスを作成する(Entityクラス)
@Entity

//データベースのテーブルをJavaで作る
//このクラスはデータベースのこのテーブルに対応しているという意味
@Table(name="M_CUSTOMER")
public class Customer {
	
	//主キー（PRIMARYKEY）
	@Id
	
	//フィールドに対応するカラムを指定する
	//columnDefinition(カラムの定義　= 文字数4文字)
	@Column(name="C_CD" ,columnDefinition = "VARCHAR(4)")
	private String c_num;
	
	//必須項目のため、nullable = falseが必要。
	//PRIMARYKEYのc_numはnullableを書いていなくても@Idで必須項目になっている
	@Column(name="C_NAME" ,nullable = false ,columnDefinition = "VARCHAR(100)")
	private String c_name;
	
	@Column(name="ADDRESS" ,columnDefinition = "VARCHAR(256)")
	private String address;
	
	@Column(name="TEL",columnDefinition = "VARCHAR(11)") //カラムの定義、文字数11文字
	private String tel;
	
	@Column(name="UPDATE_DATE" ,columnDefinition = "datetime")
	private Timestamp update_date;

	@Column(name="UPDATE_USER" ,columnDefinition = "VARCHAR(40)")
	private String update_user;

	@Column(name="CREATE_DATE" ,columnDefinition = "datetime")
	private Timestamp create_date;

	@Column(name="CREATE_USER" ,columnDefinition = "VARCHAR(40)")
	private String create_user;
	
	//privateに隠蔽されたフィールドの値を外部から取得するためのメソッド
	public String getC_num() {
		return c_num;
	}
	
	//privateに隠蔽されたフィールドの値を外部から変更するためのメソッド
	public void setC_num(String c_num) {
		this.c_num = c_num;
	}
	
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}	
	public String getTel() { 
		return tel;
	}
	public void setTel(String tel) { 
		this.tel = tel;
	}

	//setAllメソッド、一括で呼び出しが可能
	public void setAll(  String c_num
						,String c_name
						,String address
						,String tel
						) {
		this.c_num = c_num;
		this.c_name = c_name;
		this.address = address;
		this.tel = tel;
		
	}
	
	
	//Timestampで作った日時をcreate_dateに返す
	public Timestamp getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}
	
	//登録したユーザーを返す
	public String getCreate_user() {
		return create_user;
	}
	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}
	
	//アップデートした日付を返す
	public Timestamp getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Timestamp update_date) {
		this.update_date = update_date;
	}
	
	//アップデートしたユーザーを返す
	public String getUpdate_user() {
		return update_user;
	}
	public void setUpdate_user(String update_user) {
		this.update_user = update_user;
	}

}

