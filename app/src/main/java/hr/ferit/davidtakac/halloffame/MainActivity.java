package hr.ferit.davidtakac.halloffame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView ivPerson1;
    private ImageView ivPerson2;
    private ImageView ivPerson3;

    private Button btnInspiration;

    private EditText etDesc;
    private Button btnSaveDesc;

    private RadioGroup rgPersonPick;

    private TextView tvDescPerson1;
    private TextView tvDescPerson2;
    private TextView tvDescPerson3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();
        initImageClickListeners();
        initButtonClickListeners();
        initRadioGroup();
    }

    private void bindViews() {
        ivPerson1 = findViewById(R.id.iv_main_person1);
        ivPerson2 = findViewById(R.id.iv_main_person2);
        ivPerson3 = findViewById(R.id.iv_main_person3);

        btnInspiration = findViewById(R.id.btn_main_inspiration);

        etDesc = findViewById(R.id.et_main_editdesc);
        btnSaveDesc = findViewById(R.id.btn_main_savedesc);

        rgPersonPick = findViewById(R.id.rg_main_persons);

        tvDescPerson1 = findViewById(R.id.tv_main_person1desc);
        tvDescPerson2 = findViewById(R.id.tv_main_person2desc);
        tvDescPerson3 = findViewById(R.id.tv_main_person3desc);
    }

    private void initImageClickListeners() {
        ivPerson1.setOnClickListener(getImageOnClickListener());
        ivPerson2.setOnClickListener(getImageOnClickListener());
        ivPerson3.setOnClickListener(getImageOnClickListener());
    }

    private View.OnClickListener getImageOnClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setVisibility(View.INVISIBLE);
            }
        };
    }

    private void initButtonClickListeners(){
        btnInspiration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] facts = getResources().getStringArray(R.array.random_facts);
                String randomFact = facts[new Random().nextInt(facts.length)];

                Toast.makeText(MainActivity.this, randomFact, Toast.LENGTH_SHORT).show();

            }
        });

        btnSaveDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editDescOfSelectedPerson();
            }
        });
    }

    private void editDescOfSelectedPerson() {
        // TODO: 11/20/18 add empty input check
        String newDesc = etDesc.getText().toString();
        switch (rgPersonPick.getCheckedRadioButtonId()){
            case R.id.rb_main_person1: tvDescPerson1.setText(newDesc); break;
            case R.id.rb_main_person2: tvDescPerson2.setText(newDesc); break;
            case R.id.rb_main_person3: tvDescPerson3.setText(newDesc); break;
        }
    }

    private void initRadioGroup(){
        rgPersonPick.check(R.id.rb_main_person1);
    }
}
