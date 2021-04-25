import java.util.Scanner;

public class Othello {
	static CellType[][] board = new CellType[10][10];
	int width;
	int height;
	
	Othello() {
		board = new CellType[height][width];
	}

	public static void main(String[] args) {
		for(int i=0 ; i<board.length ; i++) {
			for(int j=0 ; j<board[i].length ; j++) {
				board[i][j] = CellType.NONE;
			}
		}
		
		//BLACK 3��
		int BLACK_number = 0;
		do {
			int H = (int)(Math.random() * 10);
			int W = (int)(Math.random() * 10);
			if (board[H][W] == CellType.NONE) {
				board[H][W] = CellType.BLACK;
				BLACK_number += 1;
			}
		} while(BLACK_number < 3);
		
		//WHITE 3��
	    int WHITE_number = 0;  
	    do {
	    	int H = (int)(Math.random()*10);
	    	int W = (int)(Math.random()*10);
	    	if (board[H][W] == CellType.NONE) {
	    		board[H][W] = CellType.WHITE;
	    		WHITE_number += 1;
	    	}
	    } while(WHITE_number < 3);
	    
	    //���� �׸���
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
	    
	    //���ϴ� ��ġ�� �� ����
	    boolean black_turn = true;
	    while(true) {
	    	
	    	Scanner location = new Scanner(System.in);
	    	if(black_turn) {
	    		System.out.println("Black_turn");
	    	}
	    	else {
	    		System.out.println("White_turn");
	    	}
	    	System.out.print("height ���� �Է��ϼ��� : ");
	    	int location_H = location.nextInt();
	    	System.out.print("width ���� �Է��ϼ��� : ");
	    	int location_W = location.nextInt();
	    	
	    	if(location_H <= -1 | location_W <= -1) {
	    		System.out.println("GAME OVER");
	    		break;
	    	}
	    	
	    	if(board[location_H][location_W] == CellType.NONE) {
	    		
	    		//BLACK turn
	    		if(black_turn) {
	    			board[location_H][location_W] = CellType.BLACK;
	    			
	    			//8���� Ȯ��
	    			//���� ��
	    			if(location_H != 0 & location_W != 0) {
	    				if(board[location_H-1][location_W-1] == CellType.WHITE) {
	    					for(int i=1 ; ; i++) {
	    						if(location_H-1-i < 0 & location_W-1-i < 0) break;
	    						if(board[location_H-1-i][location_W-1-i] == CellType.NONE) break;
	    						else if(board[location_H-1-i][location_W-1-i] == CellType.WHITE) continue;
	    						else if(board[location_H-1-i][location_W-1-i] == CellType.BLACK) {
	    							for(int j=1 ; j<=i ; j++) {
	    								board[location_H-1-i+j][location_W-1-i+j] = CellType.BLACK;
	    							}break;
	    						}
	    					}
	    				}
	    			}
	    			
	    			
	    			//����
	    			if(location_W != 0) {
	    				if(board[location_H][location_W-1] == CellType.WHITE) {
	    					for(int i=1 ; ; i++) {
	    						if(location_W-1-i < 0) break;
	    						if(board[location_H][location_W-1-i] == CellType.NONE) break;
	    						else if(board[location_H][location_W-1-i] == CellType.WHITE) continue;
	    						else if(board[location_H][location_W-1-i] == CellType.BLACK) {
	    							for(int j=1 ; j<=i ; j++) {
	    								board[location_H][location_W-1-i+j] = CellType.BLACK;
	    							}break;
	    						}
	    					}
	    				}
	    			}
	    			
	    			
	    			//���� �Ʒ�
	    			if(location_H != 9 & location_W != 0) {
	    				if(board[location_H+1][location_W-1] == CellType.WHITE) {
	    					for(int i=1 ; ; i++) {
	    						if(location_H+1+i > 9) break;
	    						if(board[location_H+1+i][location_W-1-i] == CellType.NONE) break;
	    						else if(board[location_H+1+i][location_W-1-i] == CellType.WHITE) continue;
	    						else if(board[location_H+1+i][location_W-1-i] == CellType.BLACK) {
	    							for(int j=1 ; j<=i ; j++) {
	    								board[location_H+1+i-j][location_W-1-i+j] =CellType.BLACK;
	    							}break;
	    						}
	    					}
	    				}
	    			}
	    			
	    			
	    			//����
	    			if(location_H != 0) {
	    				if(board[location_H-1][location_W] == CellType.WHITE) {
	    					for(int i=1 ; ; i++) {
	    						if(location_H-1-i < 0) break;
	    						if(board[location_H-1-i][location_W] == CellType.NONE) break;
	    						else if(board[location_H-1-i][location_W] == CellType.WHITE) continue;
	    						else if(board[location_H-1-i][location_W] == CellType.BLACK) {
	    							for(int j=1 ; j<=i ; j++) {
	    								board[location_H-1-i+j][location_W] = CellType.BLACK;
	    							}break;
	    						}
	    					}
	    				}
	    			}
	    			
	    			
	    			//�Ʒ���
	    			if(location_H != 9) {
	    				if(board[location_H+1][location_W] == CellType.WHITE) {
	    					for(int i=1 ; ; i++) {
	    						if(location_H+1+i > 9) break;
	    						if(board[location_H+1+i][location_W] == CellType.NONE) break;
	    						else if(board[location_H+1+i][location_W] == CellType.WHITE) continue;
	    						else if(board[location_H+1+i][location_W] == CellType.BLACK) {
	    							for(int j=1 ; j<=i ; j++) {
	    								board[location_H+1+i-j][location_W] = CellType.BLACK;
	    							}break;
	    						}
	    					}
	    				}
	    			}
	    			
	    			
	    			//������ ��
	    			if(location_H != 0 & location_W != 9) {
	    				if(board[location_H-1][location_W+1] == CellType.WHITE) {
	    					for(int i=1 ; ; i++) {
	    						if(location_H-1-i < 0 | location_W+1+i > 9) break; 
	    						if(board[location_H-1-i][location_W+1+i] == CellType.NONE) break;
	    						else if(board[location_H-1-i][location_W+1+i] == CellType.WHITE) continue;
	    						else if(board[location_H-1-i][location_W+1+i] == CellType.BLACK) {
	    							for(int j=1 ; j<=i ; j++) {
	    								board[location_H-1-i+j][location_W+1+i-j] = CellType.BLACK;
	    							}break;
	    						}
	    					}
	    				}
	    			}
	    			
	    			
	    			//������
	    			if(location_W != 9) {
	    				if(board[location_H][location_W+1] == CellType.WHITE) {
	    					for(int i=1 ; ; i++) {
	    						if(location_W+1+i > 9) break;
	    						if(board[location_H][location_W+1+i] == CellType.NONE) break;
	    						else if(board[location_H][location_W+1+i] == CellType.WHITE) continue;
	    						else if(board[location_H][location_W+1+i] == CellType.BLACK) {
	    							for(int j=1 ; j<=i ; j++) {
	    								board[location_H][location_W+1+i-j] = CellType.BLACK;
	    							}break;
	    						}
	    					}
	    				}
	    			}
	    			
	    			
	    			//������ �Ʒ�
	    			if(location_H != 9 & location_W != 9) {
	    				if(board[location_H+1][location_W+1] == CellType.WHITE) {
	    					for(int i=1 ; ; i++) {
	    						if(location_H+1+i > 9 | location_W+1+i > 9) break;
	    						if(board[location_H+1+i][location_W+1+i] == CellType.NONE) break;
	    						else if(board[location_H+1+i][location_W+1+i] == CellType.WHITE) continue;
	    						else if(board[location_H+1+i][location_W+1+i] == CellType.BLACK) {
	    							for(int j=1 ; j<=i ; j++) {
	    								board[location_H+1+i-j][location_W+1+i-j] = CellType.BLACK;
	    							}break;
	    						}
	    					}
	    				}
	    			
	    			}
	    			
	    		}
	    			
	    		
	    		
	    		//WHITE turn
	    		else {
	    			board[location_H][location_W] = CellType.WHITE;
	    			
	    			//8���� Ȯ��
	    			//���� ��
	    			if(location_H != 0 & location_W != 0) {
	    				if(board[location_H-1][location_W-1] == CellType.BLACK) {
	    					for(int i=1 ; ; i++) {
	    						if(location_H-1-i <0 | location_W-1-i < 0) break;
	    						if(board[location_H-1-i][location_W-1-i] == CellType.NONE) break;
	    						else if(board[location_H-1-i][location_W-1-i] == CellType.BLACK) continue;
	    						else if(board[location_H-1-i][location_W-1-i] == CellType.WHITE) {
	    							for(int j=1 ; j<=i ; j++) {
	    								board[location_H-1-i+j][location_W-1-i+j] = CellType.WHITE;
	    							}break;
	    						}
	    					}
	    				}
	    			}
	    			
	    			
	    			//����
	    			if(location_W != 0) {
	    				if(board[location_H][location_W-1] == CellType.BLACK) {
	    					for(int i=1 ; ; i++) {
	    						if(location_W-1-i < 0) break;
	    						if(board[location_H][location_W-1-i] == CellType.NONE) break;
	    						else if(board[location_H][location_W-1-i] == CellType.BLACK) continue;
	    						else if(board[location_H][location_W-1-i] == CellType.WHITE) {
	    							for(int j=1 ; j<=i ; j++) {
	    								board[location_H][location_W-1-i+j] = CellType.WHITE;
	    							}break;
	    						}
	    					}
	    				}
	    			}
	    			
	    			
	    			//���� �Ʒ�
	    			if(location_H != 9 & location_W != 0) {
	    				if(board[location_H+1][location_W-1] == CellType.BLACK) {
	    					for(int i=1 ; ; i++) {
	    						if(location_H+1+i > 9 | location_W-1-i < 0) break;
	    						if(board[location_H+1+i][location_W-1-i] == CellType.NONE) break;
	    						else if(board[location_H+1+i][location_W-1-i] == CellType.BLACK) continue;
	    						else if(board[location_H+1+i][location_W-1-i] == CellType.WHITE) {
	    							for(int j=1 ; j<=i ; j++) {
	    								board[location_H+1+i-j][location_W-1-i+j] =CellType.WHITE;
	    							}break;
	    						}
	    					}
	    				}
	    			}
	    			
	    			
	    			//����
	    			if(location_H != 0) {
	    				if(board[location_H-1][location_W] == CellType.BLACK) {
	    					for(int i=1 ; ; i++) {
	    						if(location_H-1-i < 0) break;
	    						if(board[location_H-1-i][location_W] == CellType.NONE) break;
	    						else if(board[location_H-1-i][location_W] == CellType.BLACK) continue;
	    						else if(board[location_H-1-i][location_W] == CellType.WHITE) {
	    							for(int j=1 ; j<=i ; j++) {
	    								board[location_H-1-i+j][location_W] = CellType.WHITE;
	    							}break;
	    						}
	    					}
	    				}
	    			}
	    			
	    			
	    			//�Ʒ���
	    			if(location_H != 9) {
	    				if(board[location_H+1][location_W] == CellType.BLACK) {
	    					for(int i=1 ; ; i++) {
	    						if(location_H+1+i > 9) break;
	    						if(board[location_H+1+i][location_W] == CellType.NONE) break;
	    						else if(board[location_H+1+i][location_W] == CellType.BLACK) continue;
	    						else if(board[location_H+1+i][location_W] == CellType.WHITE) {
	    							for(int j=1 ; j<=i ; j++) {
	    								board[location_H+1+i-j][location_W] = CellType.WHITE;
	    							}break;
	    						}
	    					}
	    				}
	    			}
	    			
	    			
	    			//������ ��
	    			if(location_H != 0 & location_W != 9) {
	    				if(board[location_H-1][location_W+1] == CellType.BLACK) {
	    					for(int i=1 ; ; i++) {
	    						if(location_H-1-i < 0 | location_W+1+i > 9) break;
	    						if(board[location_H-1-i][location_W+1+i] == CellType.NONE) break;
	    						else if(board[location_H-1-i][location_W+1+i] == CellType.BLACK) continue;
	    						else if(board[location_H-1-i][location_W+1+i] == CellType.WHITE) {
	    							for(int j=1 ; j<=i ; j++) {
	    								board[location_H-1-i+j][location_W+1+i-j] = CellType.WHITE;
	    							}break;
	    						}
	    					}
	    				}
	    			}
	    			
	    			
	    			//������
	    			if(location_W != 9) {
	    				if(board[location_H][location_W+1] == CellType.BLACK) {
	    					for(int i=1 ; ; i++) {
	    						if(location_W+1+i > 9) break;
	    						if(board[location_H][location_W+1+i] == CellType.NONE) break;
	    						else if(board[location_H][location_W+1+i] == CellType.BLACK) continue;
	    						else if(board[location_H][location_W+1+i] == CellType.WHITE) {
	    							for(int j=1 ; j<=i ; j++) {
	    								board[location_H][location_W+1+i-j] = CellType.WHITE;
	    							}break;
	    						}
	    					}
	    				}
	    			}
	    			
	    			
	    			//������ �Ʒ�
	    			if(location_H != 9 & location_W != 9) {
	    				if(board[location_H+1][location_W+1] == CellType.BLACK) {
	    					for(int i=1 ; ; i++) {
	    						if(location_H+1+i > 9 | location_W+1+i >9) break;
	    						if(board[location_H+1+i][location_W+1+i] == CellType.NONE) break;
	    						else if(board[location_H+1+i][location_W+1+i] == CellType.BLACK) continue;
	    						else if(board[location_H+1+i][location_W+1+i] == CellType.WHITE) {
	    							for(int j=1 ; j<=i ; j++) {
	    								board[location_H+1+i-j][location_W+1+i-j] = CellType.WHITE;
	    							}break;
	    						}
	    					}
	    				}
	    			}
	    			
	    		}
	    		black_turn = !black_turn;
	    		
	    		//���� �׸���
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
	    		System.out.println("�̹� �ٸ� ���� �ֽ��ϴ�.");
	    		System.out.println();
	    	}

	    }
		
	}
}



