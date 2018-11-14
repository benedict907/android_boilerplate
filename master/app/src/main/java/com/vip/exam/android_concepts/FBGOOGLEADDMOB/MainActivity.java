package com.vip.exam.android_concepts.FBGOOGLEADDMOB;/*
package com.facebook_google_login;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {
    // for fb...!
    private LoginButton loginButton;
    private CallbackManager callbackManager;

    Button logfbbtn, gmailbtn, logout;
    // for google..!

    //a constant for detecting the login intent result
    private static final int RC_SIGN_IN = 234;
    //creating a GoogleSignInClient object
    GoogleSignInClient mGoogleSignInClient;
    GoogleApiClient mGoogleApiClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

*/
/**
 *  refferal links
 *   https://developers.facebook.com/apps/1477770592368985/fb-login/quickstart/
 *   https://developers.facebook.com/docs/facebook-login/android/
 *
 * **//*



        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);

        setContentView(R.layout.activity_main);



      */
/*  logfbbtn = findViewById(R.id.loginbtn);
        gmailbtn = findViewById(R.id.loginbtngamil);*//*

        logout = findViewById(R.id.logout);

        */
/** for google*//*



        //Then we need a GoogleSignInOptions object
        //And we need to build it as below
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        //Then we will get the GoogleSignInClient object from GoogleSignIn class
        // mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .enableAutoManage(this,
                            new GoogleApiClient.OnConnectionFailedListener() {
                                @Override
                                public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

                                }
                            })
                    .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                    .build();

        }

        //Now we will attach a click listener to the sign_in_button
        //and inside onClick() method we are calling the signIn() method that will open
        //google sign in intent
        findViewById(R.id.sign_in_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });

       */
/* // this use to custom button to set gmail login
        gmailbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });
*//*

        */
/** for fb **//*


        callbackManager = CallbackManager.Factory.create();

        loginButton = (LoginButton) findViewById(R.id.login_button);

 */
/* // this use to custom button to set facebbok login
   logfbbtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        loginButton.performClick(); // layout hide Loginbutton ID is this
    }
});
*//*



        loginButton.setReadPermissions("email");

      */
/*  // Set the initial permissions to request from the user while logging in
        mLoginButton.setReadPermissions(Arrays.asList"email", "user_posts"));*//*


       */
/* // If using in a fragment
        loginButton.setFragment(this);*//*


        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                Log.e("fb ", "-access token : " + loginResult.getAccessToken());
                Log.e("fb ", "-access token inner : " + loginResult.getAccessToken().getToken());
                Log.e("fb ", "- user id : " + loginResult.getAccessToken().getUserId());
                Log.e("fb ", "- application id : " + loginResult.getAccessToken().getApplicationId());

                getUserDetails(loginResult);
            }

            @Override
            public void onCancel() {
                Log.e("fb ", "- cancelled : ");
            }

            @Override
            public void onError(FacebookException e) {
                Log.e("fb ", "- error : " + e);
            }
        });


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Logoutcall();



            }
        });
    }


    private void KEYHASG_GET() {

        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.facebook_google_login",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {


        }
    }

    //this method is called on click
    private void signIn() {


        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);

        startActivityForResult(signInIntent, RC_SIGN_IN);

    }

    protected void getUserDetails(LoginResult loginResult) {
        GraphRequest data_request = GraphRequest.newMeRequest(
                loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(
                            JSONObject json_object,
                            GraphResponse response) {
                        Intent intent = new Intent(MainActivity.this, UserProfile.class);
                        intent.putExtra("userProfile", json_object.toString());
                        startActivity(intent);
                    }

                });
        Bundle permission_param = new Bundle();
        permission_param.putString("fields", "id,name,email,picture.width(250).height(250)");
        data_request.setParameters(permission_param);
        data_request.executeAsync();

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent();

        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);

            Log.e("data", "-" + result);

            if (result.isSuccess()) {
                // Signed in successfully, show authenticated UI.
                GoogleSignInAccount acct = result.getSignInAccount();
                String personPhotoUrl = acct.getPhotoUrl().toString();

                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                intent.putExtra("Profile", personPhotoUrl);
                intent.putExtra("useremail", result.getSignInAccount().getEmail().toString());
                intent.putExtra("userid", result.getSignInAccount().getDisplayName().toString());
                startActivity(intent);

            }
        } else {
            callbackManager.onActivityResult(requestCode, resultCode, data);
        }

    }


    protected void onResume() {
        super.onResume();

        KEYHASG_GET();
        // Logs 'install' and 'app activate' App Events.
        AppEventsLogger.activateApp(this);
    }



    private void Logoutcall() {

        Toast.makeText(this, "logout", Toast.LENGTH_SHORT).show();
      */
/*  if (AppSession.getInstance().getIsFaceBookUser())*//*
 // fb login time session variable set then base logout

        // fb logout
        LoginManager.getInstance().logOut();

     */
/*   // gmail logout ==same page this code will fine ather wise Profile activity code use
           if (mGoogleApiClient.isConnected())
            Auth.GoogleSignInApi.signOut(mGoogleApiClient);*//*


    }


    @Override
    public void onPause() {
        super.onPause();
        // Logs 'app deactivate' App Event.
        AppEventsLogger.deactivateApp(this);

    }


}
*/
