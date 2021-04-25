import java.util.Scanner;

public class OthelloGame {
	static CellType[][] board = new CellType[10][10];
	int width;
	int height;
	
	OthelloGame() {
		board = new CellType[height][width];
	}

	public static void main(String[] args) {
		for(int i=0 ; i<board.length ; i++) {
			for(int j=0 ; j<board[i].length ; j++) {
				board[i][j] = CellType.NONE;
			}
		}
		
		board[4][4] = CellType.WHITE;
		board[4][5] = CellType.BLACK;
		board[5][4] = CellType.BLACK;
		board[5][5] = CellType.WHITE;
	    
	    //보드 그리기
	    System.out.println("  0 1 2 3 4 5 6 7 8 9");
	    System.out.print(0);
	    System.out.print(" ");
	    for(int i=0 ; i<10 ; i++) {
	    	for(int j=0 ; j<10 ; j++) {
	    		if(board[i][j] == CellType.NONE) {
	    			System.out.print(". ");
	    		}
	    		
	    		else if(board[i][j] == CellType.BLACK) {
	    			System.out.print("X ");
	    		}
	    		else if(board[i][j] == CellType.WHITE) {
	    			System.out.print("O ");
	    		}
	    	}
	    	System.out.println();
	    	if (i ==9) continue;
	    	System.out.print(i+1);
	    	System.out.print(" ");
	    }
	    
	    //원하는 위치에 돌 놓기
	    boolean black_turn = true;
		int BLACK_score = 0;
		int WHITE_score = 0;
		int NONE_score = 0;
		
	    while(true) {
	    	boolean change = false;
	    	//만약 보드가 다 채워지면 GAME이 끝난다.
	    	for(int i=0 ; i<10 ; i++) {
    			for(int j=0 ; j<10 ; j++) {
    				if(board[i][j] == CellType.NONE) {
    					NONE_score = NONE_score + 1;
    				}
    			}
	    	}
	    	if(NONE_score == 0) {
	    		System.out.println("GAME OVER");
	    		for(int i=0 ; i<10 ; i++) {
	    			for(int j=0 ; j<10 ; j++) {
	    				if(board[i][j] == CellType.BLACK) {
	    					BLACK_score = BLACK_score + 1;
	    				}
	    				else if(board[i][j] == CellType.WHITE) {
	    					WHITE_score = WHITE_score + 1;
	    				}
	    			}
	    		}
	    		System.out.println("BLACK SCORE : " + BLACK_score);
	    		System.out.println("WHITE SCORE : " + WHITE_score);
	    		if(BLACK_score > WHITE_score) {
	    			System.out.println("BLACK WIN!");
	    		}
	    		else if(BLACK_score < WHITE_score) {
	    			System.out.println("WHITE WIN!");
	    		}
	    		else if(BLACK_score == WHITE_score) {
	    			System.out.println("TIE");
	    		}
	    		break;
	    	}
	    	
	    	//cell 입력
	    	Scanner location = new Scanner(System.in);
	    	if(black_turn) {
	    		System.out.println("X_turn");
	    	}
	    	else {
	    		System.out.println("O_turn");
	    	}
	    	System.out.print("height 값을 입력하세요 : ");
	    	int location_H = location.nextInt();
	    	System.out.print("width 값을 입력하세요 : ");
	    	int location_W = location.nextInt();
	    	System.out.println();
	    	
	    	if(location_H <= -1 | location_W <= -1) {
	    		System.out.println("GAME OVER");
	    		for(int i=0 ; i<10 ; i++) {
	    			for(int j=0 ; j<10 ; j++) {
	    				if(board[i][j] == CellType.BLACK) {
	    					BLACK_score = BLACK_score + 1;
	    				}
	    				else if(board[i][j] == CellType.WHITE) {
	    					WHITE_score = WHITE_score + 1;
	    				}
	    			}
	    		}
	    		System.out.println("BLACK SCORE : " + BLACK_score);
	    		System.out.println("WHITE SCORE : " + WHITE_score);
	    		if(BLACK_score > WHITE_score) {
	    			System.out.println("BLACK WIN!");
	    		}
	    		else if(BLACK_score < WHITE_score) {
	    			System.out.println("WHITE WIN!");
	    		}
	    		else if(BLACK_score == WHITE_score) {
	    			System.out.println("TIE");
	    		}
	    		break;
	    	}
	    	
	    	if(board[location_H][location_W] == CellType.NONE) {
	    		
	    		//BLACK turn
	    		if(black_turn) {
	    			board[location_H][location_W] = CellType.BLACK;
	    			
	    			//8방향 확인
	    			//왼쪽 위
	    			if(location_H != 0 & location_W != 0) {
	    				if(board[location_H-1][location_W-1] == CellType.WHITE) {
	    					for(int i=1 ; ; i++) {
	    						if(location_H-1-i < 0 & location_W-1-i < 0) break;
	    						if(board[location_H-1-i][location_W-1-i] == CellType.NONE) break;
	    						else if(board[location_H-1-i][location_W-1-i] == CellType.WHITE) continue;
	    						else if(board[location_H-1-i][location_W-1-i] == CellType.BLACK) {
	    							for(int j=1 ; j<=i ; j++) {
	    								board[location_H-1-i+j][location_W-1-i+j] = CellType.BLACK;
	    								change = true;
	    							}break;
	    						}
	    					}
	    				}
	    			}
	    			
	    			
	    			//왼쪽
	    			if(location_W != 0) {
	    				if(board[location_H][location_W-1] == CellType.WHITE) {
	    					for(int i=1 ; ; i++) {
	    						if(location_W-1-i < 0) break;
	    						if(board[location_H][location_W-1-i] == CellType.NONE) break;
	    						else if(board[location_H][location_W-1-i] == CellType.WHITE) continue;
	    						else if(board[location_H][location_W-1-i] == CellType.BLACK) {
	    							for(int j=1 ; j<=i ; j++) {
	    								board[location_H][location_W-1-i+j] = CellType.BLACK;
	    								change = true;
	    							}break;
	    						}
	    					}
	    				}
	    			}
	    			
	    			
	    			//왼쪽 아래
	    			if(location_H != 9 & location_W != 0) {
	    				if(board[location_H+1][location_W-1] == CellType.WHITE) {
	    					for(int i=1 ; ; i++) {
	    						if(location_H+1+i > 9) break;
	    						if(board[location_H+1+i][location_W-1-i] == CellType.NONE) break;
	    						else if(board[location_H+1+i][location_W-1-i] == CellType.WHITE) continue;
	    						else if(board[location_H+1+i][location_W-1-i] == CellType.BLACK) {
	    							for(int j=1 ; j<=i ; j++) {
	    								board[location_H+1+i-j][location_W-1-i+j] =CellType.BLACK;
	    								change = true;
	    							}break;
	    						}
	    					}
	    				}
	    			}
	    			
	    			
	    			//위쪽
	    			if(location_H != 0) {
	    				if(board[location_H-1][location_W] == CellType.WHITE) {
	    					for(int i=1 ; ; i++) {
	    						if(location_H-1-i < 0) break;
	    						if(board[location_H-1-i][location_W] == CellType.NONE) break;
	    						else if(board[location_H-1-i][location_W] == CellType.WHITE) continue;
	    						else if(board[location_H-1-i][location_W] == CellType.BLACK) {
	    							for(int j=1 ; j<=i ; j++) {
	    								board[location_H-1-i+j][location_W] = CellType.BLACK;
	    								change = true;
	    							}break;
	    						}
	    					}
	    				}
	    			}
	    			
	    			
	    			//아래쪽
	    			if(location_H != 9) {
	    				if(board[location_H+1][location_W] == CellType.WHITE) {
	    					for(int i=1 ; ; i++) {
	    						if(location_H+1+i > 9) break;
	    						if(board[location_H+1+i][location_W] == CellType.NONE) break;
	    						else if(board[location_H+1+i][location_W] == CellType.WHITE) continue;
	    						else if(board[location_H+1+i][location_W] == CellType.BLACK) {
	    							for(int j=1 ; j<=i ; j++) {
	    								board[location_H+1+i-j][location_W] = CellType.BLACK;
	    								change = true;
	    							}break;
	    						}
	    					}
	    				}
	    			}
	    			
	    			
	    			//오른쪽 위
	    			if(location_H != 0 & location_W != 9) {
	    				if(board[location_H-1][location_W+1] == CellType.WHITE) {
	    					for(int i=1 ; ; i++) {
	    						if(location_H-1-i < 0 | location_W+1+i > 9) break; 
	    						if(board[location_H-1-i][location_W+1+i] == CellType.NONE) break;
	    						else if(board[location_H-1-i][location_W+1+i] == CellType.WHITE) continue;
	    						else if(board[location_H-1-i][location_W+1+i] == CellType.BLACK) {
	    							for(int j=1 ; j<=i ; j++) {
	    								board[location_H-1-i+j][location_W+1+i-j] = CellType.BLACK;
	    								change = true;
	    							}break;
	    						}
	    					}
	    				}
	    			}
	    			
	    			
	    			//오른쪽
	    			if(location_W != 9) {
	    				if(board[location_H][location_W+1] == CellType.WHITE) {
	    					for(int i=1 ; ; i++) {
	    						if(location_W+1+i > 9) break;
	    						if(board[location_H][location_W+1+i] == CellType.NONE) break;
	    						else if(board[location_H][location_W+1+i] == CellType.WHITE) continue;
	    						else if(board[location_H][location_W+1+i] == CellType.BLACK) {
	    							for(int j=1 ; j<=i ; j++) {
	    								board[location_H][location_W+1+i-j] = CellType.BLACK;
	    								change = true;
	    							}break;
	    						}
	    					}
	    				}
	    			}
	    			
	    			
	    			//오른쪽 아래
	    			if(location_H != 9 & location_W != 9) {
	    				if(board[location_H+1][location_W+1] == CellType.WHITE) {
	    					for(int i=1 ; ; i++) {
	    						if(location_H+1+i > 9 | location_W+1+i > 9) break;
	    						if(board[location_H+1+i][location_W+1+i] == CellType.NONE) break;
	    						else if(board[location_H+1+i][location_W+1+i] == CellType.WHITE) continue;
	    						else if(board[location_H+1+i][location_W+1+i] == CellType.BLACK) {
	    							for(int j=1 ; j<=i ; j++) {
	    								board[location_H+1+i-j][location_W+1+i-j] = CellType.BLACK;
	    								change = true;
	    							}break;
	    						}
	    					}
	    				}
	    			
	    			}
	    			
	    			if(change == false) {
	    				board[location_H][location_W] = CellType.NONE;
	    				System.out.println("이곳에 돌을 놓을 수 없습니다.");
	    				continue;
	    			}
	    			
	    		}
	    			
	    		
	    		
	    		//WHITE turn
	    		else {
	    			board[location_H][location_W] = CellType.WHITE;
	    			
	    			//8방향 확인
	    			//왼쪽 위
	    			if(location_H != 0 & location_W != 0) {
	    				if(board[location_H-1][location_W-1] == CellType.BLACK) {
	    					for(int i=1 ; ; i++) {
	    						if(location_H-1-i <0 | location_W-1-i < 0) break;
	    						if(board[location_H-1-i][location_W-1-i] == CellType.NONE) break;
	    						else if(board[location_H-1-i][location_W-1-i] == CellType.BLACK) continue;
	    						else if(board[location_H-1-i][location_W-1-i] == CellType.WHITE) {
	    							for(int j=1 ; j<=i ; j++) {
	    								board[location_H-1-i+j][location_W-1-i+j] = CellType.WHITE;
	    								change = true;
	    							}break;
	    						}
	    					}
	    				}
	    			}
	    			
	    			
	    			//왼쪽
	    			if(location_W != 0) {
	    				if(board[location_H][location_W-1] == CellType.BLACK) {
	    					for(int i=1 ; ; i++) {
	    						if(location_W-1-i < 0) break;
	    						if(board[location_H][location_W-1-i] == CellType.NONE) break;
	    						else if(board[location_H][location_W-1-i] == CellType.BLACK) continue;
	    						else if(board[location_H][location_W-1-i] == CellType.WHITE) {
	    							for(int j=1 ; j<=i ; j++) {
	    								board[location_H][location_W-1-i+j] = CellType.WHITE;
	    								change = true;
	    							}break;
	    						}
	    					}
	    				}
	    			}
	    			
	    			
	    			//왼쪽 아래
	    			if(location_H != 9 & location_W != 0) {
	    				if(board[location_H+1][location_W-1] == CellType.BLACK) {
	    					for(int i=1 ; ; i++) {
	    						if(location_H+1+i > 9 | location_W-1-i < 0) break;
	    						if(board[location_H+1+i][location_W-1-i] == CellType.NONE) break;
	    						else if(board[location_H+1+i][location_W-1-i] == CellType.BLACK) continue;
	    						else if(board[location_H+1+i][location_W-1-i] == CellType.WHITE) {
	    							for(int j=1 ; j<=i ; j++) {
	    								board[location_H+1+i-j][location_W-1-i+j] =CellType.WHITE;
	    								change = true;
	    							}break;
	    						}
	    					}
	    				}
	    			}
	    			
	    			
	    			//위쪽
	    			if(location_H != 0) {
	    				if(board[location_H-1][location_W] == CellType.BLACK) {
	    					for(int i=1 ; ; i++) {
	    						if(location_H-1-i < 0) break;
	    						if(board[location_H-1-i][location_W] == CellType.NONE) break;
	    						else if(board[location_H-1-i][location_W] == CellType.BLACK) continue;
	    						else if(board[location_H-1-i][location_W] == CellType.WHITE) {
	    							for(int j=1 ; j<=i ; j++) {
	    								board[location_H-1-i+j][location_W] = CellType.WHITE;
	    								change = true;
	    							}break;
	    						}
	    					}
	    				}
	    			}
	    			
	    			
	    			//아래쪽
	    			if(location_H != 9) {
	    				if(board[location_H+1][location_W] == CellType.BLACK) {
	    					for(int i=1 ; ; i++) {
	    						if(location_H+1+i > 9) break;
	    						if(board[location_H+1+i][location_W] == CellType.NONE) break;
	    						else if(board[location_H+1+i][location_W] == CellType.BLACK) continue;
	    						else if(board[location_H+1+i][location_W] == CellType.WHITE) {
	    							for(int j=1 ; j<=i ; j++) {
	    								board[location_H+1+i-j][location_W] = CellType.WHITE;
	    								change = true;
	    							}break;
	    						}
	    					}
	    				}
	    			}
	    			
	    			
	    			//오른쪽 위
	    			if(location_H != 0 & location_W != 9) {
	    				if(board[location_H-1][location_W+1] == CellType.BLACK) {
	    					for(int i=1 ; ; i++) {
	    						if(location_H-1-i < 0 | location_W+1+i > 9) break;
	    						if(board[location_H-1-i][location_W+1+i] == CellType.NONE) break;
	    						else if(board[location_H-1-i][location_W+1+i] == CellType.BLACK) continue;
	    						else if(board[location_H-1-i][location_W+1+i] == CellType.WHITE) {
	    							for(int j=1 ; j<=i ; j++) {
	    								board[location_H-1-i+j][location_W+1+i-j] = CellType.WHITE;
	    								change = true;
	    							}break;
	    						}
	    					}
	    				}
	    			}
	    			
	    			
	    			//오른쪽
	    			if(location_W != 9) {
	    				if(board[location_H][location_W+1] == CellType.BLACK) {
	    					for(int i=1 ; ; i++) {
	    						if(location_W+1+i > 9) break;
	    						if(board[location_H][location_W+1+i] == CellType.NONE) break;
	    						else if(board[location_H][location_W+1+i] == CellType.BLACK) continue;
	    						else if(board[location_H][location_W+1+i] == CellType.WHITE) {
	    							for(int j=1 ; j<=i ; j++) {
	    								board[location_H][location_W+1+i-j] = CellType.WHITE;
	    								change = true;
	    							}break;
	    						}
	    					}
	    				}
	    			}
	    			
	    			
	    			//오른쪽 아래
	    			if(location_H != 9 & location_W != 9) {
	    				if(board[location_H+1][location_W+1] == CellType.BLACK) {
	    					for(int i=1 ; ; i++) {
	    						if(location_H+1+i > 9 | location_W+1+i >9) break;
	    						if(board[location_H+1+i][location_W+1+i] == CellType.NONE) break;
	    						else if(board[location_H+1+i][location_W+1+i] == CellType.BLACK) continue;
	    						else if(board[location_H+1+i][location_W+1+i] == CellType.WHITE) {
	    							for(int j=1 ; j<=i ; j++) {
	    								board[location_H+1+i-j][location_W+1+i-j] = CellType.WHITE;
	    								change = true;
	    							}break;
	    						}
	    					}
	    				}
	    			}
	    			
	    			if(change == false) {
	    				board[location_H][location_W] = CellType.NONE;
	    				System.out.println("이곳에 돌을 놓을 수 없습니다.");
	    				continue;
	    			}
	    			
	    		}
	    		black_turn = !black_turn;
	    		
	    		//보드 그리기
	    	    System.out.println("  0 1 2 3 4 5 6 7 8 9");
	    	    System.out.print(0);
	    	    System.out.print(" ");
	    	    for(int i=0 ; i<10 ; i++) {
	    	    	for(int j=0 ; j<10 ; j++) {
	    	    		if(board[i][j] == CellType.NONE) {
	    	    			System.out.print(". ");
	    	    		}
	    	    		
	    	    		else if(board[i][j] == CellType.BLACK) {
	    	    			System.out.print("X ");
	    	    		}
	    	    		else if(board[i][j] == CellType.WHITE) {
	    	    			System.out.print("O ");
	    	    		}
	    	    	}
	    	    	System.out.println();
	    	    	if (i ==9) continue;
	    	    	System.out.print(i+1);
	    	    	System.out.print(" ");
	    	    }
	    		
	    	}
	    	
	    	else {
	    		System.out.println("이미 다른 돌이 있습니다.");
	    		System.out.println();
	    	}

	    }
		
	}
}


