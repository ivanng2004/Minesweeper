import java.util.*;

public class BombSquare extends GameSquare
{
	private boolean thisSquareHasBomb = false;
	public static final int MINE_PROBABILITY = 10;
	private int number=0;
	public BombSquare(int x, int y, GameBoard board)
	{
		super(x, y, "images/blank.png", board);

		Random r = new Random();
		
		thisSquareHasBomb = (r.nextInt(MINE_PROBABILITY)== 0);
	}
	
	public void getBombSquare(){
		if(this.thisSquareHasBomb) {
			this.setImage("images/bomb.png");
		}
	}

	public void surroundBombSquares(){
		BombSquare s;
		//search surrounding squares
		for (int j = this.yLocation - 1; j <= this.yLocation + 2; j++) {
			for (int i = this.xLocation - 1; i <= this.xLocation + 2; i++) {
				if (board.getSquareAt(i,j)!= null && (i!=this.xLocation && j!=this.yLocation)) {
					s = (BombSquare) board.getSquareAt(i,j);
					if(s.thisSquareHasBomb) this.number++;
				}
			}
		}	
	}
	/**
		public void expandEmptySpace(){

		}
	*/

	public void clicked()
	{
		//Set random bombs on a game board
		getBombSquare();
		if(!this.thisSquareHasBomb){
			this.surroundBombSquares();
			switch (this.number) {
				case 1:
					this.setImage("images/1.png");
				case 2:
					this.setImage("images/2.png");
				case 3:
					this.setImage("images/3.png");
				case 4:
					this.setImage("images/4.png");
				case 5:
					this.setImage("images/5.png");
				case 6:
					this.setImage("images/6.png");
				case 7:
					this.setImage("images/7.png");
				case 8:
					this.setImage("images/8.png");
				case 0:
					this.setImage("images/0.png");
					//expandEmptySpace();
			}
			number=0;
		}
		


	}
}
