package Objects;

public class MyPoint 
{
	public int x;
	public int y;
	
	MyPoint(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	MyPoint(MyPoint p)
	{
		x = p.x;
		y = p.y;
	}

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
}
