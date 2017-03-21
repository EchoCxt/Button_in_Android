package com.example.zxdn.updatelab2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


/**
 * Created by zxdn on 2016/10/10.
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button= (Button) findViewById(R.id.login);
        Button register= (Button) findViewById(R.id.reg);
        final View rootview= (View)findViewById(R.id.rootview);
        final RadioGroup radio= (RadioGroup) findViewById(R.id.id0);
        final RadioButton stu= (RadioButton) findViewById(R.id.id1);
        final RadioButton tea= (RadioButton) findViewById(R.id.id2);
        final RadioButton team= (RadioButton) findViewById(R.id.id3);
        final RadioButton mana= (RadioButton) findViewById(R.id.id4);

        final TextInputLayout user= (TextInputLayout) findViewById(R.id.username);
        final TextInputLayout pass= (TextInputLayout) findViewById(R.id.pass);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(user.getEditText().getText().toString()) ) {
                    user.setErrorEnabled(true);
                    user.setError("用户名不能为空");
                    if (!TextUtils.isEmpty(pass.getEditText().getText().toString()))
                        pass.setErrorEnabled(false);
                }
                else if (TextUtils.isEmpty(pass.getEditText().getText().toString()) ) {
                    pass.setErrorEnabled(true);
                    pass.setError("密码不能为空");
                    if (!TextUtils.isEmpty(user.getEditText().getText().toString()))
                        user.setErrorEnabled(false);
                }
               else  if (TextUtils.equals(user.getEditText().getText().toString(),"Android") && TextUtils.equals(pass.getEditText().getText().toString(),"123456")) {
                    Snackbar.make(view,"登录成功",Snackbar.LENGTH_SHORT)
                            .setAction("按钮", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                   Toast.makeText(MainActivity.this, "Snackbar的按钮被点击",Toast.LENGTH_SHORT).show();
                                }
                            })
                            .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                            .setDuration(1000)
                            .show();
                    user.setErrorEnabled(false);
                    pass.setErrorEnabled(false);
                } else {
                    Snackbar.make(view,"登录失败",Snackbar.LENGTH_SHORT)
                            .setAction("按钮", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Toast.makeText(MainActivity.this, "Snackbar的按钮被点击",Toast.LENGTH_SHORT).show();
                                }
                            })
                            .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                            .setDuration(1000)
                            .show();
                    user.setErrorEnabled(false);
                    pass.setErrorEnabled(false);
                }
            }
        });
        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                String name= "";
                if (i== stu.getId()) {
                    name="学生";
                }
                if (i== tea.getId()) {
                    name="教师";
                }
                if (i== team.getId()) {
                    name="社团";

                }
                if (i== mana.getId()) {
                    name="管理者";
                }
                Snackbar.make(rootview,name+"身份被选中",Snackbar.LENGTH_SHORT)
                        .setAction("按钮", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(MainActivity.this, "Snackbar的按钮被点击",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                        .setDuration(1000)
                        .show();
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = "";
                if (radio.getCheckedRadioButtonId()==stu.getId()) {
                    str ="学生";
                }
                if (radio.getCheckedRadioButtonId()== tea.getId()) {
                    str = "教师";
                }
                if (radio.getCheckedRadioButtonId()== team.getId()) {
                    str = "社团";
                }
                if (radio.getCheckedRadioButtonId()== mana.getId()) {
                    str = "管理者";
                }
                Snackbar.make(rootview,str+"身份注册功能尚未开启",Snackbar.LENGTH_SHORT)
                        .setAction("按钮", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(MainActivity.this, "Snackbar的按钮被点击",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                        .setDuration(1000)
                        .show();
            }
        });
    }

}