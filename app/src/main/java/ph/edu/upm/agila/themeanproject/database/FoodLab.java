package ph.edu.upm.agila.themeanproject.database;

import ph.edu.upm.agila.themeanproject.R;

import java.util.ArrayList;
import java.util.List;

public class FoodLab
{
	private static FoodLab sInstance;
	private List<Food> mFoods = new ArrayList<Food>();

	public static FoodLab getInstance()
	{
		if (sInstance == null)
		{
			sInstance = new FoodLab();
		}
		return sInstance;
	}

	private FoodLab()
	{
		for (int i = 0; i < 20; ++i)
		{
			Food food = new Food();
			mFoods.add(food);
		}

//		GLOW
		mFoods.get(0).setName("Apple");
		mFoods.get(0).setCategory(FoodCategory.GLOW);
		mFoods.get(0).setImageId(R.drawable.apple);
		mFoods.get(0).setTrivia("Apples are a good source of vitamin C and high in fiber.");

		mFoods.get(1).setName("Blueberry");
		mFoods.get(1).setCategory(FoodCategory.GLOW);
		mFoods.get(1).setImageId(R.drawable.blueberry);
		mFoods.get(1).setTrivia("Blueberry is blue sweet fruit that is high in antioxidant which makes healing faster.");

		mFoods.get(2).setName("Banana");
		mFoods.get(2).setCategory(FoodCategory.GLOW);
		mFoods.get(2).setImageId(R.drawable.banana);
		mFoods.get(2).setTrivia("Banana is eaten by athletes to quickly regain energy due to its high starch content.");

		mFoods.get(3).setName("Avocado");
		mFoods.get(3).setCategory(FoodCategory.GLOW);
		mFoods.get(3).setImageId(R.drawable.avocado);
		mFoods.get(3).setTrivia("Avocado is a sweet green fruit used in guacamole.");

		mFoods.get(4).setName("Ampalaya");
		mFoods.get(4).setCategory(FoodCategory.GLOW);
		mFoods.get(4).setImageId(R.drawable.ampalaya);
		mFoods.get(4).setTrivia("Ampalaya is a bitter vegetables full of nutrients.");

//		JUNK FOODS
		mFoods.get(5).setName("Bacon");
		mFoods.get(5).setCategory(FoodCategory.JUNK);
		mFoods.get(5).setImageId(R.drawable.bacon);
		mFoods.get(5).setTrivia("Bacon is made from pork fat and highly processed.");

		mFoods.get(6).setName("Candy");
		mFoods.get(6).setCategory(FoodCategory.JUNK);
		mFoods.get(6).setImageId(R.drawable.candy);
		mFoods.get(6).setTrivia("Candy is made of completely sugar.");

		mFoods.get(7).setName("Chicken Nuggets");
		mFoods.get(7).setCategory(FoodCategory.JUNK);
		mFoods.get(7).setImageId(R.drawable.chicken_nuggets);
		mFoods.get(7).setTrivia("Nuggets is highly processed chicken meat.");

		mFoods.get(8).setName("Chocolate");
		mFoods.get(8).setCategory(FoodCategory.JUNK);
		mFoods.get(8).setImageId(R.drawable.chocolate);
		mFoods.get(8).setTrivia("Chocolate is a sweet made from cocoa beans and contains a lot of sugar.");

		mFoods.get(9).setName("Doughnut");
		mFoods.get(9).setCategory(FoodCategory.JUNK);
		mFoods.get(9).setImageId(R.drawable.doughnut);
		mFoods.get(9).setTrivia("Doughtnut is deep fried bread topped with sugar.");

//		GLOW FOODS
		mFoods.get(10).setName("Bread");
		mFoods.get(10).setCategory(FoodCategory.GO);
		mFoods.get(10).setImageId(R.drawable.bread);
		mFoods.get(10).setTrivia("Bread is an essential staple food made from dough.");

		mFoods.get(11).setName("Cereal");
		mFoods.get(11).setCategory(FoodCategory.GO);
		mFoods.get(11).setImageId(R.drawable.cereal);
		mFoods.get(11).setTrivia("Cereral is eaten as first meal of the day.");

		mFoods.get(12).setName("Crackers");
		mFoods.get(12).setCategory(FoodCategory.GO);
		mFoods.get(12).setImageId(R.drawable.crackers);
		mFoods.get(12).setTrivia("Crackers are made from wheat and are topped with spread.");

		mFoods.get(13).setName("Noodles");
		mFoods.get(13).setCategory(FoodCategory.GO);
		mFoods.get(13).setImageId(R.drawable.noodles);
		mFoods.get(13).setTrivia("Noodles are long strings made from dough and usually eaten with soup.");

		mFoods.get(14).setName("Cheese");
		mFoods.get(14).setCategory(FoodCategory.GO);
		mFoods.get(14).setImageId(R.drawable.cheese);
		mFoods.get(14).setTrivia("Cheese is made from milk and high in fat.");

//		GROW FOODS
		mFoods.get(15).setName("Beef");
		mFoods.get(15).setCategory(FoodCategory.GROW);
		mFoods.get(15).setImageId(R.drawable.beef);
		mFoods.get(15).setTrivia("Beef is one of the three eaten land animals and is necessary for growth.");

		mFoods.get(16).setName("Chicken");
		mFoods.get(16).setCategory(FoodCategory.GROW);
		mFoods.get(16).setImageId(R.drawable.chicken);
		mFoods.get(16).setTrivia("Chicken is one of the three eaten land animals and is necessary for growth.");

		mFoods.get(17).setName("Crab");
		mFoods.get(17).setCategory(FoodCategory.GROW);
		mFoods.get(17).setImageId(R.drawable.crab);
		mFoods.get(17).setTrivia("Crab is seafood necessary for growth.");

		mFoods.get(18).setName("Egg");
		mFoods.get(18).setCategory(FoodCategory.GROW);
		mFoods.get(18).setImageId(R.drawable.egg);
		mFoods.get(18).setTrivia("Egg comes from chicken and is necessary for growth.");

		mFoods.get(19).setName("Pork");
		mFoods.get(19).setCategory(FoodCategory.GROW);
		mFoods.get(19).setImageId(R.drawable.pork);
		mFoods.get(19).setTrivia("Pork is one of the three eaten land animals and is necessary for growth.");
	}

	public void add(Food food)
	{
		mFoods.add(food);
	}

	public List<Food> getFoods()
	{
		return mFoods;
	}

	public Food getFood(int index)
	{
		return mFoods.get(index);
	}
}
