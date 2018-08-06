package taxi.nicecode.com.base.kit.core

import android.content.Context
import android.net.ConnectivityManager
import android.net.Uri
import android.os.Build
import android.text.TextUtils

import junit.framework.Assert

import java.util.regex.Pattern

/**
 * Created by User on 04.03.2017.
 */

object NetKit {


    class Request {
        var isRequest: Boolean = false
        var url: String? = null
    }

    fun toCurrectURL(url: String): String {
        var url2 = encode(url)
        url2 = findHttpRegExp(url2)
        return url2
    }


    fun isOnline(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cm.activeNetworkInfo
        return netInfo != null && netInfo.isConnected
    }


    /**
     *
     */
    fun findRequestIfHave(url: String): Request {
        val charsPattern = Pattern.compile("(\\.)+")
        val charsPattern2 = Pattern.compile("([\\s]+)")
        val matcher = charsPattern.matcher(url)
        val matcher2 = charsPattern2.matcher(url.trim { it <= ' ' })

        val req = Request()
        req.isRequest = true

        if (matcher.find()) {
            req.isRequest = false
            //requestMyVideos
            if (matcher2.find()) {
                req.isRequest = true
            }
        }



        if (req.isRequest) {
            req.url = encode("https://www.google.ru/search?ie=UTF-8&q=" + url)
        } else {

            if( url.substring(0, "https://".length).equals( "https://")){
                req.url = encode(url)
            }else{
                req.url = encode("https://" + url)
            }
        }
        return req
    }


    fun encode(uriString: String): String {
        if (TextUtils.isEmpty(uriString)) {
            Assert.fail("Uri string cannot be empty!")
            return uriString
        }
        // getQueryParameterNames is not exist then cannot iterate on queries
        if (Build.VERSION.SDK_INT < 11) {
            return uriString
        }
        // Check if uri has valid characters
        // See https://tools.ietf.org/html/rfc3986
        val allowedUrlCharacters = Pattern.compile("([A-Za-z0-9_.~:/?\\#\\[\\]@!$&'()*+,;" + "=-]|%[0-9a-fA-F]{2})+")
        val matcher = allowedUrlCharacters.matcher(uriString)
        var validUri: String? = null
        if (matcher.find()) {
            validUri = matcher.group()
        }
        if (TextUtils.isEmpty(validUri) || uriString.length == validUri!!.length) {
            return uriString
        }

        // The uriString is not encoded. Then recreate the uri and encode it this time
        val uri = Uri.parse(uriString)
        val uriBuilder = Uri.Builder()
                .scheme(uri.scheme)
                .authority(uri.authority)
        for (path in uri.pathSegments) {
            uriBuilder.appendPath(path)
        }
        for (key in uri.queryParameterNames) {
            uriBuilder.appendQueryParameter(key, uri.getQueryParameter(key))
        }
        return uriBuilder.build().toString()
    }

    fun findHttpRegExp(uriString: String): String {
        val allowedUrlCharacters = Pattern.compile("(^(http|https)://)+")
        val matcher = allowedUrlCharacters.matcher(uriString)
        var validUri = uriString
        if (!matcher.find()) {
            validUri = "https://" + uriString
        }

        return validUri
    }


}
