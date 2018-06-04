package com.ex.suduko.rules;

/*
 * Sudko Board rule interface
 */
public interface SudukoBoardRule {

	/**
	 * method to check the row constraint for a suduko board
	 * @param board 
	 * 		  array of board values
	 * @param row 
	 * 		  row for which constraint has to be checked
	 * @return boolean
	 */
	boolean rowConstraint(int[][] board, int row);
	
	/**
	 * method to check the column constraint for a suduko board
	 * @param board 
	 * 		  array of board values
	 * @param column 
	 * 		  column for which constraint has to be checked
	 * @return boolean
	 */
	boolean columnConstraint(int[][] board, int column);
	
	/**
	 * method to check the sub section constraint (3*3)
	 * @param board
	 * 		  array of board values
	 * @param row  
	 * 		  row for which constraint has to be checked
	 * @param column 
	 * 		  column for which constraint has to be checked
	 * @param subsectionSize
	 *        size of sub section 3*3 default
	 * @return boolean
	 */
	boolean subsectionConstraint(int[][] board, int row, int column,int subsectionSize) ;
	
	/**
	 * method to check the suduko constraint for row, column and sub section after each value is set
	 * @param board
	 * 		  array of board values
	 * @param row  
	 * 		  row for which constraint has to be checked
	 * @param column 
	 * 		  column for which constraint has to be checked
	 * @param subsectionSize
	 *        size of sub section 3*3 default
	 * @return boolean
	 */
	boolean isValid(int[][] board, int row, int column, int subsectionSize);
	
	/**
	 * @param board
	 * 		  array of board values
	 * @param row  
	 * 		  row for which constraint has to be checked
	 * @param constraint
	 *        array to store if value is set or not
	 * @param column 
	 * 		  column for which constraint has to be checked
	 * @return boolean
	 */
	boolean checkConstraint(int[][] board, int row, boolean[] constraint, int column);
}
