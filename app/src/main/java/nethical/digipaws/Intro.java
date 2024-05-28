package nethical.digipaws;

import android.os.Bundle;
import android.text.Html;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.text.HtmlCompat;
import androidx.fragment.app.Fragment;
import com.github.appintro.AppIntro;
import com.github.appintro.AppIntroFragment;
import com.github.appintro.AppIntroPageTransformerType;
import nethical.digipaws.R;
import nethical.digipaws.fragments.SettingsFragment;
import nethical.digipaws.fragments.intro.ChooseDelay;
import nethical.digipaws.fragments.intro.ChooseMode;
import nethical.digipaws.fragments.intro.ChooseViewBlockers;


public class Intro extends AppIntro{
	
	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
        
		addSlide(AppIntroFragment.createInstance(getString(R.string.welcome),
		HtmlCompat.fromHtml(getString(R.string.app_desc),Html.FROM_HTML_MODE_COMPACT),
		R.drawable.paws,
		R.color.md_theme_dark_background
		));
		
		addSlide(AppIntroFragment.createInstance(
		getString(R.string.easy_mode),
		HtmlCompat.fromHtml(getString(R.string.easy_mode_desc),Html.FROM_HTML_MODE_LEGACY),
		R.drawable.intro_easy,
		R.color.md_theme_dark_background
		));
		
		addSlide(AppIntroFragment.createInstance(
		getString(R.string.adventure_mode),
		HtmlCompat.fromHtml(getString(R.string.adventure_mode_desc),Html.FROM_HTML_MODE_LEGACY),
		R.drawable.intro_explore,
		R.color.md_theme_dark_background
		));
		
		addSlide(AppIntroFragment.createInstance(
		getString(R.string.hard_mode),
		HtmlCompat.fromHtml(getString(R.string.hard_mode_desc),Html.FROM_HTML_MODE_LEGACY),
		R.drawable.intro_hard,
		R.color.md_theme_dark_background
		));
        
        addSlide(new ChooseMode());
        addSlide(new ChooseViewBlockers());
        addSlide(new ChooseDelay());
        
        
        
		setTransformer(AppIntroPageTransformerType.Flow.INSTANCE);
	
		showStatusBar(true);
	    setWizardMode(true);
		
		//Enable immersive mode (no status and nav bar)
		setImmersiveMode();
		
		//Enable/disable page indicators
		setIndicatorEnabled(true);
		
		//Dhow/hide ALL buttons
		//setButtonsEnabled(true);
		
		// Enable Vibration
		setVibrate(true);
	}
	
	@Override
	protected void onSkipPressed(Fragment currentFragment) {
		super.onSkipPressed(currentFragment);
		finish();
	}
	
	@Override
	protected void onDonePressed(Fragment currentFragment) {
		super.onDonePressed(currentFragment);
		finish();
	}
}