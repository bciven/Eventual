package com.social.eventual.policy;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RetryPolicy;

/**
 * Created by Behrad on 2016-06-01.
 */
public class NetworkPolicyProvider {
     public static RetryPolicy RetryPolicyProvider(){
         int socketTimeout = 60000;//30 seconds
         RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
         return policy;
     }
}
