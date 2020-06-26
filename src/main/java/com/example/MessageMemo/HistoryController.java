package com.example.MessageMemo;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;   

@Controller 
public class HistoryController {
	@RequestMapping("/msgmemo/history")
    public String history(Model model) {
		

		// データ一覧画面を表示
		return "history.html";
        
    }

}