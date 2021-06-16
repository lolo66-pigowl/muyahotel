package kr.co.board.model.vo;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Board {
	private int boardNo;
	private String boardTitle;
	private String boardWriter;
	private String boardContent;
	private String boardDate;
	private ArrayList<File> fileList;
}
