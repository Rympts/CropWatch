package com.example.cropwatch;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomePage extends AppCompatActivity {

    private LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_page);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        container = findViewById(R.id.main);
        findViewById(R.id.addButton).setOnClickListener(v -> addNewContainer());
    }

    private void addNewContainer() {
        LinearLayout newContainer = new LinearLayout(this);
        newContainer.setOrientation(LinearLayout.HORIZONTAL);
        newContainer.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        EditText newEditText = new EditText(this);
        newEditText.setHint("Enter text here");
        newEditText.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1));

        ImageButton editButton = new ImageButton(this);
        editButton.setImageResource(android.R.drawable.ic_menu_edit);
        editButton.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        editButton.setEnabled(false);

        ImageButton deleteButton = new ImageButton(this);
        deleteButton.setImageResource(android.R.drawable.ic_menu_delete);
        deleteButton.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        newContainer.addView(newEditText);
        newContainer.addView(editButton);
        newContainer.addView(deleteButton);
        container.addView(newContainer);

        editButton.setOnClickListener(v -> {
            newEditText.setEnabled(true);
            editButton.setEnabled(false);
        });

        deleteButton.setOnClickListener(v -> container.removeView(newContainer));

        newEditText.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE || (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN)) {
                newEditText.setEnabled(false    );
                editButton.setEnabled(true);
                return true;
            }
            return false;
        });
    }
}