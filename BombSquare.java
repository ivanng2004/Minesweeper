import java.util.*;

public class BombSquare extends GameSquare
{
	private boolean thisSquareHasBomb = false;
	public static final int MINE_PROBABILITY = 10;
	private int number=0;
	private BombSquare[][] s;
	public BombSquare(int x, int y, GameBoard board)
	{
		super(x, y, "images/blank.png", board);

		Random r = new Random();
		thisSquareHasBomb = (r.nextInt(MINE_PROBABILITY) == 0);
	}
	public void surroundBombSquares(int xLocation,int yLocation){
		for(int j=0;j<board.getHeight();j++){
			for(int i=0;i< board.getWidth();i++){
				s[i][j] = (BombSquare) board.getSquareAt(i,j);
			}
		}
		//search surrounding squares
		if(!this.thisSquareHasBomb) {
			for (int j = this.yLocation - 1; j <= j + 2; j++) {
				if(j<0)j++;
				else if(j>= board.getHeight()) j--;
				for (int i = this.xLocation - 1; i <= i + 2; i++) {
					if(i<0)i++;
					else if(i>= board.getWidth())i--;
					if (board.getSquareAt(i, j) != null) {
						s[i][j] = (BombSquare) board.getSquareAt(i,j);
						if(s[i][j].thisSquareHasBomb==true) this.number++;
					}
				}
			}
		}
	}
	public void clicked()
	{
		//Set random bombs on a game board
		if(this.thisSquareHasBomb) {this.setImage("images/bomb.png");}
		else {
			//surroundBombSquares(this.xLocation,this.yLocation);
			switch (this.number) {
				case 1:
					board.getSquareAt(this.xLocation, this.yLocation).setImage("images/1.png");
				case 2:
					board.getSquareAt(this.xLocation, this.yLocation).setImage("images/2.png");
				case 3:
					board.getSquareAt(this.xLocation, this.yLocation).setImage("images/3.png");
				case 4:
					board.getSquareAt(this.xLocation, this.yLocation).setImage("images/4.png");
				case 5:
					board.getSquareAt(this.xLocation, this.yLocation).setImage("images/5.png");
				case 6:
					board.getSquareAt(this.xLocation, this.yLocation).setImage("images/6.png");
				case 7:
					board.getSquareAt(this.xLocation, this.yLocation).setImage("images/7.png");
				case 8:
					board.getSquareAt(this.xLocation, this.yLocation).setImage("images/8.png");
			}
		}


	}
}
