package com.pat0007.notetaking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Button btnAdd;
    Context applicationContext;
    EditText textContent;
    LinearLayout noteView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        applicationContext = this;
        btnAdd = findViewById(R.id.btnAdd);
        textContent = findViewById(R.id.textContent);
        noteView = findViewById(R.id.noteView);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final LinearLayout note = new LinearLayout(applicationContext);
                EditText newNote = new EditText(applicationContext);
                note.setOrientation(LinearLayout.VERTICAL);

                newNote.setLayoutParams(new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                newNote.setGravity(Gravity.CENTER);
                newNote.setText(textContent.getText());
                note.addView(newNote);
                noteView.addView(note);

                Button btnDelete = new Button(applicationContext);
                btnDelete.setText("Delete");
                note.addView(btnDelete);

                btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        noteView.removeView(note);
                    }
                });

                textContent.setText("");
            }
        });
    }
}
