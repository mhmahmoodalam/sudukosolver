package com.ex.suduko.board;

import com.ex.sudoku.exception.ErrorCode;
import com.ex.sudoku.exception.SudukoException;

public class SudukoBoard {
	
	  
	private int[][] board;
	
	private int boardSize;
	
	private int minValue;
	private int maxValue;
	private int subSectionSize;
	
    /**
     * Board construtor
     * @param board
     *        suduko board array
     * @param maxValue
     *        max value a suduko can have
     * @param subSectionSize
     *        size of subsection
     * @throws SudukoException 
     *         if max value and subsection is not valid
     */
    public SudukoBoard(int[][] board,int maxValue, int subSectionSize) throws SudukoException {
    	this.board=board;
    	this.boardSize=board.length;
    	this.minValue=1;
    	if(maxValue > board.length) {
    		throw new SudukoException(ErrorCode.ERROR_VALUE_ABOVE_BOUND.getErrorMessage(),ErrorCode.ERROR_VALUE_ABOVE_BOUND.getErrorCode());
    	}
    	this.maxValue=maxValue;
    	if(subSectionSize!= Math.sqrt(board.length)) {
    		throw  new SudukoException(ErrorCode.ERROR_SUBSECTION_SIZE_INVALID.getErrorMessage(), ErrorCode.ERROR_SUBSECTION_SIZE_INVALID.getErrorCode());
    	}
    	this.subSectionSize=subSectionSize;
    }
    
	/**
	 * @return int[][] board
	 */
	public int[][] getBoard() {
		return board;
	}

	/**
	 * @return int boardSize
	 */
	public int getBoardSize() {
		return boardSize;
	}

	/**
	 * @return int minValue
	 */
	public int getMinValue() {
		return minValue;
	}
	
	/**
	 * @return int maxvalue
	 */
	public int getMaxValue() {
		return maxValue;
	}

	
	/**
	 * @return int subsection size
	 */
	public int getSubSectionSize() {
		return subSectionSize;
	}

	/**
	 * method to print the board
	 * @param board
	 *        array of board value
	 */
	public void printBoard(int[][] board) {
    	System.out.println();
        System.out.println("----------------------");
        for (int row = 0; row < this.boardSize; row++) 
        {
        	for (int column = 0; column < this.boardSize; column++) 
            {
            	System.out.print(board[row][column] + " ");
                if(column!=0&&(column+1)%subSectionSize==0 )
                {
                    System.out.print("| ");
                }
            }
            if(row!=0 && (row+1)%subSectionSize==0)
            {
                System.out.println();
                System.out.print("----------------------");
            }
            System.out.println();
        	
        }
        
    }


}
