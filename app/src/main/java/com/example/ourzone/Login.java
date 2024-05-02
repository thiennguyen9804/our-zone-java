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

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        signupStyle();
    }

    protected void signupStyle() {
        TextView signupTextView = findViewById(R.id.signupTextView);

        String signupText = (String) signupTextView.getText();
        SpannableString spannableString = new SpannableString(signupText);
        ClickableSpan clickableSpan = new ClickableSpan() {

            @Override
            public void onClick(@NonNull View widget) {
//                startActivity(new Intent(Login.this, Signup.class));
                finish();
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
        spannableString.setSpan(foregroundColorSpan, signupText.indexOf("Sign up"), signupText.indexOf("Sign up") + 7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(boldSpan, signupText.indexOf("Sign up"), signupText.indexOf("Sign up") + 7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(clickableSpan, signupText.indexOf("Sign up"), signupText.indexOf("Sign up") + 7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        signupTextView.setText(spannableString);
        signupTextView.setMovementMethod(LinkMovementMethod.getInstance());
        signupTextView.setHighlightColor(Color.TRANSPARENT);

    }
}