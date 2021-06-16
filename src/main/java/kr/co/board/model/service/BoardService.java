package kr.co.board.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.board.model.dao.BoardDao;
import kr.co.board.model.vo.Board;
import kr.co.board.model.vo.File;

@Service
public class BoardService {
	@Autowired
	private BoardDao dao;
	@Transactional
	public int insertBoard(Board b, ArrayList<File> fileList) {
		//파일은 board_no가 필요하기때문에 board테이블에 insert하는것이 먼저
		int result1 = dao.insertBoard(b);
		int result = 0;
		if(result1>0) {
			int boardNo = dao.selectBoardNo();
			for(File f : fileList) {
				f.setBoardNo(boardNo);
				result += dao.insertFile(f);
			}
		}else {
			return -1;
		}
		return result;
	}
	public ArrayList<Board> boardList() {		
		return dao.boardList();
	}
	public Board selectOneBoard(int boardNo) {
		return dao.selectOneBoard(boardNo);
	}
	
}
