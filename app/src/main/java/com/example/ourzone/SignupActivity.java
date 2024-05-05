package com.example.ourzone;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        termsStyle();
        loginStyle();
    }

    protected void termsStyle() {
        TextView termsTextView = findViewById(R.id.termsTextView);

        String terms = (String) termsTextView.getText();
        SpannableString spannableString = new SpannableString(terms);

        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.rgb(58,90,64));
        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(Color.rgb(58,90,64));
        StyleSpan boldSpan = new StyleSpan(Typeface.BOLD);
        StyleSpan boldSpan2 = new StyleSpan(Typeface.BOLD);
        spannableString.setSpan(foregroundColorSpan, terms.indexOf("Terms of Service"), terms.indexOf("Terms of Service") + 16, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(boldSpan, terms.indexOf("Terms of Service"), terms.indexOf("Terms of Service") + 16, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(boldSpan2, terms.indexOf("Privacy Policy"), terms.indexOf("Privacy Policy") + 14, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(foregroundColorSpan2, terms.indexOf("Privacy Policy"), terms.indexOf("Privacy Policy") + 14, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        termsTextView.setText(spannableString);
    }

    protected void loginStyle() {
        TextView loginTextView = findViewById(R.id.loginTextView);

        String loginText = (String) loginTextView.getText();
        SpannableString spannableString = new SpannableString(loginText);
        ClickableSpan clickableSpan = new ClickableSpan() {

            @Override
            public void onClick(@NonNull View widget) {
                startActivity(new Intent(SignupActivity.this, LoginActivity.class));
            }
            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
                ds.setColor(Color.rgb(58,90,64));
            }
        };

        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.rgb(58,90,64));
        StyleSpan boldSpan = new StyleSpan(Typeface.BOLD);
        spannableString.setSpan(foregroundColorSpan, loginText.indexOf("Login"), loginText.indexOf("Login") + 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(boldSpan, loginText.indexOf("Login"), loginText.indexOf("Login") + 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(clickableSpan, loginText.indexOf("Login"), loginText.indexOf("Login") + 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        loginTextView.setText(spannableString);
        loginTextView.setMovementMethod(LinkMovementMethod.getInstance());
        loginTextView.setHighlightColor(Color.TRANSPARENT);

    }
}