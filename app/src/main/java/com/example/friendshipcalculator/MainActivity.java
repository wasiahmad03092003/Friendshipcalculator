package com.example.friendshipcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private EditText yourNameEditText;
    private EditText friendNameEditText;
    private Button calculateButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        yourNameEditText = findViewById(R.id.yourNameEditText);
        friendNameEditText = findViewById(R.id.friendNameEditText);
        calculateButton = findViewById(R.id.calculateButton);
        resultTextView = findViewById(R.id.resultTextView);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateFriendship();
            }
        });
    }

    private void calculateFriendship() {
        String yourName = yourNameEditText.getText().toString();
        String friendName = friendNameEditText.getText().toString();

        if (!yourName.isEmpty() && !friendName.isEmpty()) {
            int friendshipScore = generateRandomFriendshipScore();
            String resultMessage = yourName + " and " + friendName + " are " + friendshipScore + "% friends!";
            resultTextView.setText(resultMessage);
        } else {
            resultTextView.setText("Please enter both names.");
        }
    }

    private int generateRandomFriendshipScore() {
        Random random = new Random();
        return random.nextInt(101); // Generates a random number between 0 and 100
    }
}
