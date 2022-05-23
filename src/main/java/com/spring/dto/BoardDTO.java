package com.spring.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class BoardDTO {
	// 자유 게시판 start
	private String user_name;
	private int board_bno;
	private String board_title;
	private String board_content;
	private String board_writer;
	private Date board_regDate;
	private int board_viewCnt;
	private int board_like;
	
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getBoard_bno() {
		return board_bno;
	}
	public void setBoard_bno(int board_bno) {
		this.board_bno = board_bno;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public String getBoard_writer() {
		return board_writer;
	}
	public void setBoard_writer(String board_writer) {
		this.board_writer = board_writer;
	}
	public Date getBoard_regDate() {
		return board_regDate;
	}
	public void setBoard_regDate(Date board_regDate) {
		this.board_regDate = board_regDate;
	}
	public int getBoard_viewCnt() {
		return board_viewCnt;
	}
	public void setBoard_viewCnt(int board_viewCnt) {
		this.board_viewCnt = board_viewCnt;
	}
	public int getBoard_like() {
		return board_like;
	}
	public void setBoard_like(int board_like) {
		this.board_like = board_like;
	}
	// 자유 게시판 end
	
	//------------------------------------------------
	//여행 후기 게시판 start
	private int review_bno;
	private String review_title;
	private String review_content;
	private String review_writer;
	private int review_viewCnt;
	private int review_like;
	private Date review_regDate;
	
	public int getReview_bno() {
		return review_bno;
	}
	public void setReview_bno(int review_bno) {
		this.review_bno = review_bno;
	}
	public String getReview_title() {
		return review_title;
	}
	public void setReview_title(String review_title) {
		this.review_title = review_title;
	}
	public String getReview_content() {
		return review_content;
	}
	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}
	public String getReview_writer() {
		return review_writer;
	}
	public void setReview_writer(String review_writer) {
		this.review_writer = review_writer;
	}
	public int getReview_viewCnt() {
		return review_viewCnt;
	}
	public void setReview_viewCnt(int review_viewCnt) {
		this.review_viewCnt = review_viewCnt;
	}
	public int getReview_like() {
		return review_like;
	}
	public void setReview_like(int review_like) {
		this.review_like = review_like;
	}
	public Date getReview_regDate() {
		return review_regDate;
	}
	public void setReview_regDate(Date review_regDate) {
		this.review_regDate = review_regDate;
	}
	//여행 후기 게시판 end
	
	//------------------------------------------------
	// 패키지 설계 게시판 start
	private int board_want_bno;
	private String board_want_title;
	private String board_want_destination;
	private String board_want_content;
	private String board_want_writer;
	private int board_want_people;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date board_want_start;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date board_want_end;
	
	private int board_want_viewCnt;
	private int board_want_like;
	private Date board_want_regDate;

	public int getBoard_want_bno() {
		return board_want_bno;
	}
	public void setBoard_want_bno(int board_want_bno) {
		this.board_want_bno = board_want_bno;
	}
	public String getBoard_want_title() {
		return board_want_title;
	}
	public void setBoard_want_title(String board_want_title) {
		this.board_want_title = board_want_title;
	}
	public String getBoard_want_destination() {
		return board_want_destination;
	}
	public void setBoard_want_destination(String board_want_destination) {
		this.board_want_destination = board_want_destination;
	}
	public String getBoard_want_content() {
		return board_want_content;
	}
	public void setBoard_want_content(String board_want_content) {
		this.board_want_content = board_want_content;
	}
	public String getBoard_want_writer() {
		return board_want_writer;
	}
	public void setBoard_want_writer(String board_want_writer) {
		this.board_want_writer = board_want_writer;
	}
	public int getBoard_want_people() {
		return board_want_people;
	}
	public void setBoard_want_people(int board_want_people) {
		this.board_want_people = board_want_people;
	}
	
	public Date getBoard_want_start() {
		return board_want_start;
	}
	public void setBoard_want_start(Date board_want_start) {
		this.board_want_start = board_want_start;
	}
	public Date getBoard_want_end() {
		return board_want_end;
	}
	public void setBoard_want_end(Date board_want_end) {
		this.board_want_end = board_want_end;
	}
	public int getBoard_want_viewCnt() {
		return board_want_viewCnt;
	}
	public void setBoard_want_viewCnt(int board_want_viewCnt) {
		this.board_want_viewCnt = board_want_viewCnt;
	}
	public int getBoard_want_like() {
		return board_want_like;
	}
	public void setBoard_want_like(int board_want_like) {
		this.board_want_like = board_want_like;
	}
	public Date getBoard_want_regDate() {
		return board_want_regDate;
	}
	public void setBoard_want_regDate(Date board_want_regDate) {
		this.board_want_regDate = board_want_regDate;
	}
	// 패키지 설계 게시판 end
	
	//------------------------------------------------
	// 여행사 입찰 게시판 start
	private int com_regiNum;
	private int suggest_bno;
	private String suggest_writer;
	private String suggest_title;
	private String suggest_content;
	private int suggest_price;
	private String suggest_guide;
	private String suggest_air;
	private int suggest_like;
	private int suggest_viewCnt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date suggest_regDate;

	public int getCom_regiNum() {
		return com_regiNum;
	}
	public void setCom_regiNum(int com_regiNum) {
		this.com_regiNum = com_regiNum;
	}
	public int getSuggest_bno() {
		return suggest_bno;
	}
	public void setSuggest_bno(int suggest_bno) {
		this.suggest_bno = suggest_bno;
	}
	public String getSuggest_writer() {
		return suggest_writer;
	}
	public void setSuggest_writer(String suggest_writer) {
		this.suggest_writer = suggest_writer;
	}
	public String getSuggest_title() {
		return suggest_title;
	}
	public void setSuggest_title(String suggest_title) {
		this.suggest_title = suggest_title;
	}
	public String getSuggest_content() {
		return suggest_content;
	}
	public void setSuggest_content(String suggest_content) {
		this.suggest_content = suggest_content;
	}
	public int getSuggest_price() {
		return suggest_price;
	}
	public void setSuggest_price(int suggest_price) {
		this.suggest_price = suggest_price;
	}
	public String getSuggest_guide() {
		return suggest_guide;
	}
	public void setSuggest_guide(String suggest_guide) {
		this.suggest_guide = suggest_guide;
	}
	public String getSuggest_air() {
		return suggest_air;
	}
	public void setSuggest_air(String suggest_air) {
		this.suggest_air = suggest_air;
	}
	public int getSuggest_like() {
		return suggest_like;
	}
	public void setSuggest_like(int suggest_like) {
		this.suggest_like = suggest_like;
	}
	public int getSuggest_viewCnt() {
		return suggest_viewCnt;
	}
	public void setSuggest_viewCnt(int suggest_viewCnt) {
		this.suggest_viewCnt = suggest_viewCnt;
	}
	public Date getSuggest_regDate() {
		return suggest_regDate;
	}
	public void setSuggest_regDate(Date suggest_regDate) {
		this.suggest_regDate = suggest_regDate;
	}
	// 여행사 입찰 게시판 end
	
	//------------------------------------------------
	// 패키지 판매 게시판 start
	private int sell_bno;
	private String sell_writer;
	private String sell_title;
	private String sell_content;
	private String sell_destination;
	private Date sell_start;
	private Date sell_end;
	private int sell_price;
	private int sell_people;
	private String sell_guide;
	private String sell_air;
	private int sell_viewCnt;
	private int sell_like;
	private Date sell_regDate;

	public int getSell_bno() {
		return sell_bno;
	}
	public void setSell_bno(int sell_bno) {
		this.sell_bno = sell_bno;
	}
	public String getSell_writer() {
		return sell_writer;
	}
	public void setSell_writer(String sell_writer) {
		this.sell_writer = sell_writer;
	}
	public String getSell_title() {
		return sell_title;
	}
	public void setSell_title(String sell_title) {
		this.sell_title = sell_title;
	}
	public String getSell_content() {
		return sell_content;
	}
	public void setSell_content(String sell_content) {
		this.sell_content = sell_content;
	}
	public String getSell_destination() {
		return sell_destination;
	}
	public void setSell_destination(String sell_destination) {
		this.sell_destination = sell_destination;
	}
	public Date getSell_start() {
		return sell_start;
	}
	public void setSell_start(Date sell_start) {
		this.sell_start = sell_start;
	}
	public Date getSell_end() {
		return sell_end;
	}
	public void setSell_end(Date sell_end) {
		this.sell_end = sell_end;
	}
	public int getSell_price() {
		return sell_price;
	}
	public void setSell_price(int sell_price) {
		this.sell_price = sell_price;
	}
	public int getSell_people() {
		return sell_people;
	}
	public void setSell_people(int sell_people) {
		this.sell_people = sell_people;
	}
	public String getSell_guide() {
		return sell_guide;
	}
	public void setSell_guide(String sell_guide) {
		this.sell_guide = sell_guide;
	}
	public String getSell_air() {
		return sell_air;
	}
	public void setSell_air(String sell_air) {
		this.sell_air = sell_air;
	}
	public int getSell_viewCnt() {
		return sell_viewCnt;
	}
	public void setSell_viewCnt(int sell_viewCnt) {
		this.sell_viewCnt = sell_viewCnt;
	}
	public int getSell_like() {
		return sell_like;
	}
	public void setSell_like(int sell_like) {
		this.sell_like = sell_like;
	}
	public Date getSell_regDate() {
		return sell_regDate;
	}
	public void setSell_regDate(Date sell_regDate) {
		this.sell_regDate = sell_regDate;
	}
	// 패키지 판매 게시판 end
}
