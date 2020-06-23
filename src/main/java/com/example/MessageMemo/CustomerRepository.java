//パッケージ宣言（クラスやインターフェイスをグループ化するためのしくみ）
package com.example.MessageMemo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//customerの保管場所
@Repository
//ここでは、エンティティのクラスとエンティティIDのクラス、 CustomerEntity と String を指定します。
public interface CustomerRepository extends CrudRepository<Customer, String> {
	
}
