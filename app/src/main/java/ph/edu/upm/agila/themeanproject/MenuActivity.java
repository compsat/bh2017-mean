package ph.edu.upm.agila.themeanproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MenuActivity extends Activity
{
	private ImageButton playGame;
	private ImageButton tutorial;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);

		playGame = (ImageButton)findViewById(R.id.play_game_button);
		tutorial = (ImageButton)findViewById(R.id.tutorial_button);

		playGame.setOnClickListener(new MenuButtonOnClickListener(MenuActivity.this, PlayActivity.class));
		tutorial.setOnClickListener(new MenuButtonOnClickListener(MenuActivity.this, TutorialActivity.class));
	}

	private class MenuButtonOnClickListener implements View.OnClickListener
	{
		private Intent mIntent;

		public MenuButtonOnClickListener(Context packageContext, Class cls)
		{
			mIntent = new Intent(packageContext, cls);
		}

		@Override
		public void onClick(View view)
		{
			startActivity(mIntent);
		}
	}
}
