package com.twilio.contextualcommunicationsdemo.Data;

import com.twilio.contextualcommunicationsdemo.DTO.Entry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mplacona on 08/02/2016.
 */
public class DataProvider {

    public static List<Entry> getEntries() {
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry("Visit us online", "www.mywebsite.com"));
        entries.add(new Entry("Call us on 0800 123456789", ""));
        entries.add(new Entry("Call us from abroad", "+44 123456789"));
        entries.add(new Entry("Chat with us", ""));
        entries.add(new Entry("Video Call", ""));
        return entries;
    }
}
