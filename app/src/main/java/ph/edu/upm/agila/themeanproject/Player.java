package ph.edu.upm.agila.themeanproject;

public class Player
{
	private int mScore = 0;
	private int mLives = 3;
	private boolean mIsAlive = true;

	public void decreaseLives()
	{
		--mLives;
		if (mLives == 0)
		{
			mIsAlive = false;
		}
	}

	public int getScore()
	{
		return mScore;
	}

	public void increaseScore()
	{
		++mScore;
	}

	public boolean isAlive()
	{
		return mIsAlive;
	}
}
