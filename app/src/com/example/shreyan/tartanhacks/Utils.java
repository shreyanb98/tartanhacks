//
// Copyright (c) Microsoft. All rights reserved.
// Licensed under the MIT license.
//
// Microsoft Cognitive Services (formerly Project Oxford): https://www.microsoft.com/cognitive-services
//
// Microsoft Cognitive Services Text Analytics Android repository on GitHub:
// https://github.com/Microsoft/Cognitive-TextAnalytics-Android
//
// Copyright (c) Microsoft Corporation
// All rights reserved.
//
// MIT License:
// Permission is hereby granted, free of charge, to any person obtaining
// a copy of this software and associated documentation files (the
// "Software"), to deal in the Software without restriction, including
// without limitation the rights to use, copy, modify, merge, publish,
// distribute, sublicense, and/or sell copies of the Software, and to
// permit persons to whom the Software is furnished to do so, subject to
// the following conditions:
//
// The above copyright notice and this permission notice shall be
// included in all copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED ""AS IS"", WITHOUT WARRANTY OF ANY KIND,
// EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
// MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
// NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
// LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
// OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
// WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
//
package com.example.shreyan.tartanhacks;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.TextInputEditText;
import android.widget.Toast;

public class Utils {

    public static boolean hasText(Context context, TextInputEditText editText) {

        String text = editText.getText().toString().trim();
        if (text.isEmpty()) {
            editText.requestFocus();
            editText.setError(context.getString(R.string.edittext_error));
        }

        return !text.isEmpty();
    }

    public static boolean hasApiKey(Context context, String key) {
        if (key.isEmpty()) {
            Toast.makeText(context, context.getString(R.string.need_API_key), Toast.LENGTH_SHORT).show();
        }

        return !key.isEmpty();
    }

    public static String getAPiKey(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String keyFromPrefs = sharedPreferences.getString(KeyActivity.API_KEY, "");
        String keyFromStringsFile = context.getString(R.string.subscription_key);
        String apiKey = "";
        if (!keyFromPrefs.isEmpty()) {
            // Use the api key from SharedPreferences if there is any
            apiKey = keyFromPrefs;
        } else {
            // Otherwise use the api key from Strings.xml
            apiKey = keyFromStringsFile;
        }

        return apiKey;
    }
}
