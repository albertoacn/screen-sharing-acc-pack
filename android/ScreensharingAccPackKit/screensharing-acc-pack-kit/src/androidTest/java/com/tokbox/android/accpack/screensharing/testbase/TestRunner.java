package com.tokbox.android.accpack.screensharing.testbase;


import android.os.Bundle;

import com.tokbox.android.accpack.screensharing.config.APIConfig;
import com.tokbox.android.accpack.screensharing.config.OpenTokSDK;
import com.tokbox.android.accpack.screensharing.config.OpenTokSession;
import com.zutubi.android.junitreport.JUnitReportTestRunner;

import java.util.HashMap;


public class TestRunner extends JUnitReportTestRunner {
    private final String FLAG_API_KEY = "api_key";
    private final String FLAG_API_SECRET = "api_secret";
    private final String FLAG_API_URL = "api_url";
    private final String FLAG_API_SESSION_ID = "api_session_id";
    private final String FLAG_API_TOKEN = "api_token";

    @Override
    public void onCreate(Bundle arguments) {

        APIConfig.API_KEY = arguments.getString(FLAG_API_KEY, APIConfig.API_KEY);
        APIConfig.API_SECRET = arguments.getString(FLAG_API_SECRET, APIConfig.API_SECRET);
        APIConfig.API_URL = arguments.getString(FLAG_API_URL, APIConfig.API_URL);
        APIConfig.SESSION_ID = arguments.getString(FLAG_API_SESSION_ID, APIConfig.SESSION_ID);
        APIConfig.TOKEN = arguments.getString(FLAG_API_TOKEN, APIConfig.TOKEN);

        try {
            OpenTokSDK openTokSDK = null;
            if (APIConfig.SESSION_ID == "") {
                openTokSDK = new OpenTokSDK(Integer.parseInt(APIConfig.API_KEY), APIConfig.API_SECRET);
                APIConfig.SESSION_ID = openTokSDK.create_session("127.0.0.1", new HashMap<String, String>()).getSessionId();
            }
            if (APIConfig.TOKEN == "") {
                openTokSDK = openTokSDK != null ? openTokSDK : new OpenTokSDK(Integer.parseInt(APIConfig.API_KEY), APIConfig.API_SECRET);
                APIConfig.TOKEN = openTokSDK.generate_token(APIConfig.SESSION_ID);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        super.onCreate(arguments);
    }
}