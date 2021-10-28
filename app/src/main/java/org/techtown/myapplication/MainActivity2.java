package org.techtown.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private EditText mTodoEditText;
    private TextView mResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        mTodoEditText = findViewById(R.id.todo_edit);
        mResultTextView = findViewById(R.id.result_text);

        final AppDataBase db = Room.databaseBuilder(this,AppDataBase.class,"todo-db")
                .allowMainThreadQueries()//MainThread에서도 db조작가능한데 실무에선 백그라운드에서 사용할것.
                .build();

        mResultTextView.setText(getData(db));

        findViewById(R.id.add_button).setOnClickListener(view -> {
            db.todoDao().insert(new Todo(mTodoEditText.getText().toString()));
            mResultTextView.setText(getData(db));
        });



    }

    //db에서 데이터 가지고옴.
    private String getData(AppDataBase db){
        return db.todoDao().getAll().toString();
    }
}