package ph.edu.upm.agila.themeanproject.database;

import java.util.UUID;

public class Food
{
	private UUID mId;
	private int mCategory;
	private String mName;
	private int mImageId;
	private String mTrivia;

	public Food()
	{
		this(UUID.randomUUID());
	}

	public Food(UUID id)
	{
		mId = id;
	}

	public Food(int category, String name, int imageId, String trivia)
	{
		mCategory = category;
		mName = name;
		mImageId = imageId;
		mTrivia = trivia;
	}

	public UUID getId()
	{
		return mId;
	}

	public int getCategory()
	{
		return mCategory;
	}

	public void setCategory(int category)
	{
		mCategory = category;
	}

	public String getName()
	{
		return mName;
	}

	public void setName(String name)
	{
		mName = name;
	}

	public int getImageId()
	{
		return mImageId;
	}

	public void setImageId(int imageId)
	{
		mImageId = imageId;
	}

	public String getTrivia()
	{
		return mTrivia;
	}

	public void setTrivia(String trivia)
	{
		mTrivia = trivia;
	}
}

