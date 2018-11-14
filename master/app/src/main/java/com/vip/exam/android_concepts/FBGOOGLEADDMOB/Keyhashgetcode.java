package com.vip.exam.android_concepts.FBGOOGLEADDMOB;/*
package com.facebook_google_login;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Base64;
import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

*/
/**
 * Created by vipin on 20/7/18.
 *//*


public class Keyhashgetcode {

    void key() {

     try

    {
        PackageInfo info = getPackageManager().getPackageInfo(
                "com.example.benedict.facebook",
                PackageManager.GET_SIGNATURES);
        for (Signature signature : info.signatures) {
            MessageDigest md = MessageDigest.getInstance("SHA");
            md.update(signature.toByteArray());
            Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
        }
    } catch(
    PackageManager.NameNotFoundException e)

    {

    } catch(
    NoSuchAlgorithmException e)

}


    }
}
*/
