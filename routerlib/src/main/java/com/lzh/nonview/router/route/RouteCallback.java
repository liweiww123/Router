package com.lzh.nonview.router.route;

import android.content.Context;
import android.net.Uri;

import com.lzh.nonview.router.Router;
import com.lzh.nonview.router.exception.NotFoundException;

/**
 * Callback of router
 * Created by lzh on 16/9/5.
 */
public interface RouteCallback {

    /**
     * Whether or not be interrupted when open activity by uri
     * @param uri uri the uri to open
     * @param context context
     * @param extras some extras data for route,
     *               sometimes is null when you not use
     *               {@link Router#getActivityRoute()}  to set some extras data
     * @return true if should be intercepted
     */
    boolean interceptOpen(Uri uri, Context context,ActivityRouteBundleExtras extras);

    /**
     * There are two types of not found exception:<br>
     *     <i>route rule</i> not found<br>
     *     <i>activity</i> not found
     * @param uri uri the uri to open
     * @param e e
     */
    void notFound(Uri uri, NotFoundException e);

    /**
     * A callback method to notice that you had open a activity by route
     * @param uri the uri to open
     * @param clzName the activity class name that had opened
     */
    void onOpenSuccess(Uri uri,String clzName);

    /**
     * A callback method to notice that you occurs some exception.<br>
     *     exclude <i>not found</i> exception
     * @param uri the uri to open
     * @param e the exception
     */
    void onOpenFailed(Uri uri,Exception e);
}
