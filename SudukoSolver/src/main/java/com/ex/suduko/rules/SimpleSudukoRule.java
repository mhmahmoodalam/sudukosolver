package com.ex.suduko.rules;

import java.util.stream.IntStream;

import com.ex.utility.logging.Logger;

import com.ex.suduko.solver.SudukoSolver;

public class SimpleSudukoRule implements SudukoBoardRule{

	static Logger logger= Logger.getLogger(SimpleSudukoRule.class);
	@Override
	public boolean rowConstraint(int[][] board, int row) {
		logger.debug("checking row constraint:"+row);
		boolean[] constraint = new boolean[board.length];
        return IntStream.range(0, board.length)
        		 .allMatch(column -> checkConstraint(board, row, constraint, column));
	}

	@Override
	public boolean columnConstraint(int[][] board, int column) {
		logger.debug("checking column constraint:"+column);
		boolean[] constraint = new boolean[board.length];
        return IntStream.range(0, board.length)
          .allMatch(row -> checkConstraint(board, row, constraint, column));
	}

	@Override
	public boolean subsectionConstraint(int[][] board, int row, int column,int subsectionSize) {
		logger.debug("checking subsection constraint- row:"+row+" column:"+column+"subsectionsize:"+subsectionSize);
		boolean[] constraint = new boolean[board.length];
        int subsectionRowStart = (row / subsectionSize) * subsectionSize;
        int subsectionRowEnd = subsectionRowStart + subsectionSize;
        logger.debug("Subsection row start at:"+subsectionRowStart+" end at:"+subsectionRowEnd);
        int subsectionColumnStart = (column / subsectionSize) * subsectionSize;
        int subsectionColumnEnd = subsectionColumnStart + subsectionSize;
        logger.debug("Subsection column start at:"+subsectionColumnStart+" end at:"+subsectionColumnEnd);

        for (int r = subsectionRowStart; r < subsectionRowEnd; r++) {
            for (int c = subsectionColumnStart; c < subsectionColumnEnd; c++) {
            	  if (!checkConstraint(board, r, constraint, c)) return false;
            }
        }
        return true;
	}

	@Override
	public boolean isValid(int[][] board, int row, int column,int subsequenceSize) {
		 return rowConstraint(board, row) &&
		          columnConstraint(board, column) &&
		          subsectionConstraint(board, row, column,subsequenceSize);
	}

	@Override
	public boolean checkConstraint(int[][] board, int row, boolean[] constraint, int column) {
		logger.debug("checkContraint caled for row:"+row+" column:"+column);
		if (board[row][column] != SudukoSolver.NO_VALUE) {
			logger.debug("board[row][column] value ="+ board[row][column]);
			logger.debug("constraint[board[row][column] - 1] value="+constraint[board[row][column] - 1]);
            if (!constraint[board[row][column] - 1]) {
                constraint[board[row][column] - 1] = true;
            } else {
            	logger.debug("returning false");
                return false;
            }
        }
		logger.debug("returning true");
        return true;
	}

}
