package com.tokbox.android.accpack.screensharing.config;


public class OpenTokSession {

    public String session_id;

    public OpenTokSession(String session_id) {
        this.session_id = session_id;
    }

    public String getSessionId() {
        return this.session_id;
    }
}
