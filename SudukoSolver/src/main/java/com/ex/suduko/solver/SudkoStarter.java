package com.ex.suduko.solver;


import com.ex.utility.logging.Logger;

import com.ex.sudoku.exception.SudukoException;
import com.ex.suduko.board.SudukoBoard;
import com.ex.suduko.rules.SimpleSudukoRule;

public class SudkoStarter {

	static Logger logger= Logger.getLogger(SudkoStarter.class);
  	    
  	    private static int[][] hardestProblemBoard = {
  	          { 8, 0, 0, 0, 0, 0, 0, 0, 0 },
           	  { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
  	    	  { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
  	    	  { 0, 5, 0, 0, 0, 7, 0, 0, 0 },
  	    	  { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
  	    	  { 0, 0, 0, 1, 0, 0, 0, 3, 0 },
  	    	  { 0, 0, 1, 0, 0, 0, 0, 6, 8 },
  	    	  { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
  	    	  { 0, 9, 0, 0, 0, 0, 4, 0, 0 } 
  	     };
  	 
  	    public static void main(String[] args) {
  	    	logger.info("Starting Main Method");
  	    	
  	    	try {
  	    	SudukoSolver sudukoSolver=new SudukoSolver();
  	    	sudukoSolver.setSudukoBoard(new SudukoBoard(hardestProblemBoard, 9, 3));
  	    	sudukoSolver.setSudukoBoardRule(new SimpleSudukoRule());
  	    	logger.info("Starting solve() Method");
  	    	sudukoSolver.solve();
  	    	logger.info("FInished solve() Method");
  	    	}catch(SudukoException se) {
  	    		logger.error(se.getErrorCode()+":"+se.getMessage(),se);
  	    	}catch(Exception ex) {
  	    		logger.error(ex.getMessage(),ex);
  	    	}
  	    }
}
