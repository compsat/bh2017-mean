package ph.edu.upm.agila.themeanproject;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import ph.edu.upm.agila.themeanproject.database.Food;
import ph.edu.upm.agila.themeanproject.database.FoodCategory;
import ph.edu.upm.agila.themeanproject.database.FoodLab;

import java.util.Collections;
import java.util.Random;

public class PlayActivity extends Activity
{
	private final int HIGHEST_SCORE = 20;

	private ImageButton mFoodButton;
	private ImageButton mGoButton;
	private ImageButton mGrowButton;
	private ImageButton mGlowButton;
	private ImageButton mTrashCan;
	private ImageView mScoreView;

	private PopupWindow mPopupWindow;

	private FoodLab mFoodLab = FoodLab.getInstance();
	private int mCurrentQuestion = -1;
	private Food mCurrentFood;

	private Player mPlayer = new Player();

	private MediaPlayer mCorrectSfx;
	private MediaPlayer mIncorrectSfx;

	private LinearLayout mLinearLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play);

		long seed = System.nanoTime();
		Collections.shuffle(mFoodLab.getFoods(), new Random(seed));

		mLinearLayout = (LinearLayout)findViewById(R.id.activity_play);

		mCorrectSfx = MediaPlayer.create(this, R.raw.correct_sfx);
		mIncorrectSfx = MediaPlayer.create(this, R.raw.incorrect_sfx);

		mFoodLab = FoodLab.getInstance();

		initWidgets();
		startGame();
	}

	private void initWidgets()
	{
		mFoodButton = (ImageButton)findViewById(R.id.food_in_question);

		mGoButton = (ImageButton)findViewById(R.id.go_button);
		mGrowButton = (ImageButton)findViewById(R.id.grow_button);
		mGlowButton = (ImageButton)findViewById(R.id.glow_button);
		mTrashCan = (ImageButton)findViewById(R.id.trash_can);

		mScoreView = (ImageView)findViewById(R.id.score_view);

		mFoodButton.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				Toast.makeText(PlayActivity.this, mCurrentFood.getTrivia(), Toast.LENGTH_LONG).show();
			}
		});

		mGoButton.setOnClickListener(new CategoryButtonOnClickListener(FoodCategory.GO));
		mGrowButton.setOnClickListener(new CategoryButtonOnClickListener(FoodCategory.GROW));
		mGlowButton.setOnClickListener(new CategoryButtonOnClickListener(FoodCategory.GLOW));
		mTrashCan.setOnClickListener(new CategoryButtonOnClickListener(FoodCategory.JUNK));
	}

	private void startGame()
	{
		setScoreDrawable(mScoreView);
		updateQuestion();
	}

	private void updateQuestion()
	{
		++mCurrentQuestion;
		mCurrentFood= mFoodLab.getFood(mCurrentQuestion);
		mFoodButton.setImageResource(mCurrentFood.getImageId());
		mFoodButton.setBackground(null);
	}

	private void checkAnswer(int foodCategory)
	{
		if (foodCategory == mCurrentFood.getCategory())
		{
			// FIXME: No sound plays when correct answer is selected too quickly.
			mCorrectSfx.start();
			if (!mCorrectSfx.isLooping())
			{
				mPlayer.increaseScore();
				if (mPlayer.getScore() == HIGHEST_SCORE)
				{
					setContentView(R.layout.activity_end_game);
					setFinalScore();
					return;
				}
				updateQuestion();
				setScoreDrawable(mScoreView);
			}
		}
		else
		{
			mIncorrectSfx.start();
			mPlayer.decreaseLives();
			if (!mPlayer.isAlive())
			{
				setContentView(R.layout.activity_end_game);
				setFinalScore();
			}
		}
	}

	private int[] score_drawables = { R.drawable.zero, R.drawable.one, R.drawable.two, R.drawable.three,
			R.drawable.four, R.drawable.five, R.drawable.six, R.drawable.seven,
			R.drawable.eight, R.drawable.nine, R.drawable.ten, R.drawable.eleven,
			R.drawable.twelve, R.drawable.thirteen, R.drawable.fourteen, R.drawable.fifteen,
			R.drawable.sixteen, R.drawable.seventeen, R.drawable.eighteen, R.drawable.nineteen,
			R.drawable.twenty};

	private void setScoreDrawable(ImageView view)
	{
		view.setImageResource(score_drawables[mPlayer.getScore()]);
	}

	private void setFinalScore()
	{
		ImageView scoreImageView = (ImageView)findViewById(R.id.score_image_view);
		setScoreDrawable(scoreImageView);
	}

	@Override
	protected void onDestroy()
	{
		super.onDestroy();
		mCorrectSfx.release();
		mIncorrectSfx.release();
	}

	private class CategoryButtonOnClickListener implements View.OnClickListener
	{
		private int mFoodCategory;

		public CategoryButtonOnClickListener(int foodCategory)
		{
			mFoodCategory = foodCategory;
		}

		@Override
		public void onClick(View view)
		{
			checkAnswer(mFoodCategory);
		}
	}
}
