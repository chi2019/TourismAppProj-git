package com.example.chanakya.tourismappproj;



import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


public class Login extends Fragment {

    Button login;
    EditText username,password;
    CheckBox remember;
    SharedPreferences sharedPreferences;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_fragment,container,false);
        login =(Button) view.findViewById(R.id.loginbutton);
        username =(EditText) view.findViewById(R.id.userid);
        password =(EditText) view.findViewById(R.id.password);
        remember = (CheckBox) view.findViewById(R.id.checkBoxToRemember);
        sharedPreferences = getActivity().getSharedPreferences("myfile", Context.MODE_PRIVATE);
        username.setText(sharedPreferences.getString("user", "Enter User Name"));
        password.setText(sharedPreferences.getString("password",""));
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(remember.isChecked()) {
                    String usernameofuser = username.getText().toString();
                    String passwordprovided = password.getText().toString();
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    editor.putString("user", usernameofuser);
                    editor.putString("password", passwordprovided);
                    editor.commit();
                    // Intent intent = new Intent(getActivity(), LoginScreen.class);
                    //getActivity().startActivity(intent);
                    Toast.makeText(getActivity(),"Details are saved", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(getActivity(),"Details are not saved saved", Toast.LENGTH_SHORT).show();
                    // Intent intent = new Intent(getActivity(), LoginScreen.class);
                    //getActivity().startActivity(intent);
                }
            }
        });
        Button register = (Button) view.findViewById(R.id.registerbutton);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment  = new Register();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.loginpage,fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}
