package kr.co.board.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.board.model.vo.Board;
import kr.co.board.model.vo.File;

@Repository
public class BoardDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	//private JdbcTemplate jdbcTemplate;
	public int insertBoard(Board b) {
		int result = sqlSession.insert("board.insertBoard",b);
		return result;
//		String query = "insert into board "
//				+ "values(board_seq.nextval,?,?,?,to_char(sysdate,'yyyy-mm-dd'))";
//		Object[] params = {b.getBoardTitle(),b.getBoardWriter(),b.getBoardContent()};
//		int result = jdbcTemplate.update(query,params);
//		return result;
	}

	public int selectBoardNo() {
		int result = sqlSession.selectOne("board.selectBoardNo");
		return result;
//		String query = "select max(board_no) from board";
//		int boardNo = jdbcTemplate.queryForObject(query, int.class);
//		return boardNo;
	}

	public int insertFile(File f) {
		return sqlSession.insert("board.insertFile",f);
//		String query = "insert into file_tbl values(file_seq.nextval,?,?,?)";
//		Object[] params = {f.getFilename(),f.getFilepath(),f.getBoardNo()};
//		int result = jdbcTemplate.update(query,params);
//		return result;
	}
	public ArrayList<Board> boardList() {
		List<Board> list = sqlSession.selectList("board.boardList");
		return (ArrayList<Board>)list;
//		String query = "select * from board order by 1 desc";
//		List list = jdbcTemplate.query(query, new BoardRowMapper());
//		return list;
	}	

	public Board selectOneBoard(int boardNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("board.selectOneBoard",boardNo);
	}
}
