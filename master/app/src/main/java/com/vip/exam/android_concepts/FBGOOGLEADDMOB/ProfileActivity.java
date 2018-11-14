package com.vip.exam.android_concepts.FBGOOGLEADDMOB;/*
package com.facebook_google_login;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textName, textEmail;

    GoogleApiClient googleSignout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


*/
/** Google login time firebase to login and create an app
 *  then download .JSON file and add to project.
 *  and firebase settings to ENABLE THE email login...
 *//*


        GoogleSignInOptions gslogo = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();


        googleSignout = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, new GoogleApiClient.OnConnectionFailedListener() {
                    @Override
                    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
                        Log.e("error","gcm-logut");
                    }
                })
                .addApi(Auth.GOOGLE_SIGN_IN_API,gslogo)
                .build();


        Intent intent = getIntent();
        String Profile = intent.getStringExtra("Profile");
        String useremail = intent.getStringExtra("useremail");
        String useridtoken = intent.getStringExtra("userid");

        Log.e("Jsondata", Profile);

        imageView = (ImageView) findViewById(R.id.imageView);
        textName = (TextView) findViewById(R.id.textViewName);
        textEmail = (TextView) findViewById(R.id.textViewEmail);


        Glide.with(this)
                .load(Profile)
                .into(imageView);

        textName.setText(useridtoken);//user.getDisplayName());
        textEmail.setText(useremail);//user.getEmail());

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Auth.GoogleSignInApi.signOut(googleSignout).setResultCallback(
                        new ResultCallback<Status>() {
                            @Override
                            public void onResult(Status status) {
                                gotoast(status);
                            }
                        });
            }
        });

    }

    private void gotoast(Status status) {
        Toast.makeText(this, "Gcm-logout"+status, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onPause() {
        super.onPause();
        googleSignout.stopAutoManage(this);
        googleSignout.disconnect();
    }

    @Override
    protected void onStart() {
        super.onStart();
        googleSignout.connect();
    }

}
*/
