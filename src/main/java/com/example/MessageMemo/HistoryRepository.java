package com.example.MessageMemo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.ArrayList;

@Repository
//ここでは、エンティティのクラスとエンティティIDのクラス、HistoryEntity と String を指定します。
public interface HistoryRepository extends CrudRepository<History, String> {
	@Query(value ="SELECT T_MESSAGE.M_ID AS m_id"
			+ " ,T_MESSAGE.RECEIV_TIME AS receiv_time"
			+ " ,T_MESSAGE.TO_NAME AS to_name"
			+ " ,M_CUSTOMER.C_NAME AS c_name"
			+ " ,T_MESSAGE.SENDER AS sender"
			+ " ,T_MESSAGE.MESSAGE_CD AS message_cd"
			+ " ,M_EMPLOYEE.E_NAME AS e_name"
			+ " FROM T_MESSAGE"
			+ " LEFT JOIN M_CUSTOMER"
			+ " ON T_MESSAGE.CUSTMER_CD = M_CUSTOMER.C_CD"
			+ " INNER JOIN M_EMPLOYEE"
			+ " ON T_MESSAGE.RECEIVER_CD = M_EMPLOYEE.E_NUM;"
			,nativeQuery=true)
	ArrayList<History> histories(); //件数は整数型のためint

}
