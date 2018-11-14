package com.vip.exam.android_concepts.Exam.utilities;

import android.content.Context;
import android.widget.EditText;

import com.example.vipin.kotlindemo.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by vipin on 7/3/17.
 */

public class ValidationClass {


    public static boolean validateUserEmail(EditText editText, Context forgetPasswordActivity) {
        String emailid = editText.getText().toString().trim();

        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (editText.getText().length() == 0 || emailid.isEmpty()) {
            editText.setError("error");
            return false;
        } else if (!emailid.matches(emailPattern)) {
            editText.setError(forgetPasswordActivity.getResources().getString(R.string.forget_text_empty));
            return false;
        } else {
            return true;
        }
    }

    public static boolean validatePassword(EditText editText) {

        String passwrd = editText.getText().toString().trim();

        Pattern letter = Pattern.compile("[a-zA-z]");
        Pattern digit = Pattern.compile("[0-9]");
        Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");

        Matcher hasLetter = letter.matcher(passwrd);
        Matcher hasDigit = digit.matcher(passwrd);
        Matcher hasSpecial = special.matcher(passwrd);

        if (passwrd.contains(" ") || passwrd.isEmpty() || passwrd.length()< 9 || passwrd.length()>= 15) {
            return false;
        } else if (!(hasLetter.find())) {
            return false;
        }
        else if (!(hasDigit.find())) {
            return false;
        }
        else if (!(hasSpecial.find())) {
            return false;
        }else {
            return true;
        }
    }

    public static boolean validateUserText(EditText editText) {

        String username = editText.getText().toString().trim();

        if (username.isEmpty() || username.length()<=0){

            return false;
        } else {
            return true;
        }
    }


    public static boolean validateMobileNumber(String mobile) {

        if (mobile.contains(" ") || mobile.isEmpty() || mobile.length() < 9 || mobile.length() > 9){

            return false;
        } else {
            return true;
        }
    }

    public static  boolean inputValidation(EditText user, EditText paswrd) {
        boolean value=false;
        if(validateUserText(user)){
            if(validatePassword(paswrd)){
                value=true;
            }
            else{
                paswrd.setError("Please provide the password.");
                value=false;
            }
        }
        else{
            user.setError("Please provide a valid email.");
            value=false;
        }
        return value;
    }

}